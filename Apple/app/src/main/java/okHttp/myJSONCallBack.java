package okHttp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.framed.FrameReader;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class myJSONCallBack implements Callback {

    protected  final String ERROR_MSG = "emsg";
    protected  final String EMPTY_MSG = "";

    protected  final int NETWORK_ERROR = -1;//网络异常
    protected  final int JSON_ERROR = -1;//JSON异常
    protected  final int OTHER_ERROR = -1;//其他异常
    DisposeDataListener disposeDataListener;
    Class<?> tClass;
    Handler handler;

    public myJSONCallBack(DisposeDataHandle handle)
    {
        this.disposeDataListener = handle.disposeDataListener;
        this.tClass = handle.tClass;

        this.handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void onFailure(Call call, final IOException e)
    {
        //失败请求回调
        handler.post(new Runnable() {
            @Override
            public void run() {
                //post到主线程操作
                disposeDataListener.MyCallFailure(new MyOkHttpException<IOException>(NETWORK_ERROR,e));
            }
        });
    }


    @Override
    public void onResponse(Call call, Response response) throws IOException
    {
        //拿到服务端给我们的数据
        final  String result = response.body().string();

        //数据请求成功
        handler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }



    public void handleResponse(String result)
    {

        if(TextUtils.isEmpty(result))
        {

            //数据为空，请求失败
            disposeDataListener.MyCallFailure(new MyOkHttpException<String>(NETWORK_ERROR,EMPTY_MSG));
        }
        //开始对JSON进行解析
        try{
            //JSONObject jsonObject = new JSONObject();
            //jsonObject = new JSONObject(result);
            //if(tClass==null)
            //{
                disposeDataListener.MyCallSuccess(result);
            //}
            /*else
            {
                //Gson gson = new Gson();
                //Customer info = gson.fromJson(jsonObject.toString(),Customer.class);
                //JSONObject info = new JSONObject();
                //info = new JSONObject(result);
                result = result.trim();
                if(result.length()>=0)
                {
                    disposeDataListener.MyCallSuccess(result);
                }
                else
                {
                    disposeDataListener.MyCallFailure(new MyOkHttpException<String>(JSON_ERROR,ERROR_MSG));

                }
            }*/
        }catch(Exception e)
        {

            disposeDataListener.MyCallFailure(new MyOkHttpException<String>(OTHER_ERROR,ERROR_MSG));;
            e.printStackTrace();
        }
    }
}
