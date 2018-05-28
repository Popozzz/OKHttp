package com.example.administrator.apple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okHttp.Customer;
import okHttp.DisposeDataHandle;
import okHttp.DisposeDataListener;
import okHttp.MyOkHttpException;
import okHttp.RequestParams;
import okHttp.myJSONCallBack;
import okHttp.myOkHttp;
import okHttp.myRequest;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    String url;
    RequestParams params;

    EditText phone;
    EditText password;
    TextView text;
    String phoneText;
    String pass;
    Customer ob;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button landing_register = (Button) findViewById(R.id.landing_register);
        Button landing_land = (Button) findViewById(R.id.landing_land);
        phone = (EditText) findViewById(R.id.landing_editnumber);
        password = (EditText) findViewById(R.id.landing_editpasword);
        text = (TextView) findViewById(R.id.landing_rememberpassword) ;

        url="http://192.168.137.1:8080/app/android/login";
        //url = "https://www.baidu.com";
        params = new RequestParams();




        landing_register.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {



            }
        });

        landing_land.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(View v){

                phoneText = phone.getText().toString();
                pass = password.getText().toString();

                params.put("phone",phoneText);
                params.put("pass",pass);

                sendHttp();


            }
        });
    }

    @Override
    protected void  onRestart(){
        super.onRestart();
        Log.d("Landing","onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Landing","onDestory");
    }

    private void sendHttp() {

        new Thread(new Runnable() {

            @Override
            public void run() {



                myOkHttp.sendRequest(myRequest.initPostRequest(url,params), new myJSONCallBack(new DisposeDataHandle(new DisposeDataListener() {

                    @Override
                    public void MyCallSuccess(String response) {

                        response = response.trim();
                        if(response.length()<=0)
                        {
                            toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
                            text.setText(response.toString());
                            //Intent ZhuCe = new Intent(MainActivity.this, landing_failed.class);
                            //startActivity(ZhuCe);
                        }
                        else
                        {
                            //Gson gson = new Gson();//解析JSON
                            //Customer info = gson.fromJson(response.toString(),Customer.class);
                            text.setText(response.toString());
                            //toast.makeText(getApplicationContext(),info.getCustomerPhone(),Toast.LENGTH_LONG).show();

                            Intent ZhuCe = new Intent(MainActivity.this, landing_sucess.class);

                            startActivity(ZhuCe);
                        }



                    }

                    @Override
                    public void MyCallFailure(Object reasonObj) {

                        Intent ZhuCe = new Intent(MainActivity.this, landing_failed.class);
                        reasonObj = (MyOkHttpException)reasonObj;
                        text.setText(((MyOkHttpException) reasonObj).getEmsg().toString());
                        startActivity(ZhuCe);
                        toast.makeText(getApplicationContext(),"网络连接不可用",Toast.LENGTH_LONG).show();

                    }
                })));


            }
        }).start();
    }



    public  void sendOkHttoRequest(){

        new Thread(new Runnable() {

            @Override
            public void run() {


                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                //flag = true;
                okhttp3.Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(okhttp3.Call call, IOException e) {

                        Intent ZhuCe = new Intent(MainActivity.this, landing_failed.class);

                        startActivity(ZhuCe);
                    }

                    @Override
                    public void onResponse(okhttp3.Call call, Response response) throws IOException {
                        Intent ZhuCe = new Intent(MainActivity.this, landing_sucess.class);

                        startActivity(ZhuCe);
                    }
                });

            }
        }).start();
        }


}
