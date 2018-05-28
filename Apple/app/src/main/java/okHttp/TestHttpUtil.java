package okHttp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class TestHttpUtil {
    public static void sendOkHttoRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();

        client.newCall(request).enqueue(callback);
    }

    //返回数据，这个返回的是某个实体类，为了方便我也写在这里，你可以写在你要运行的那个程序里
    public  static void parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData,new TypeToken<List<App>>(){}.getType());
        for(App app:appList){
            Log.d("NetworkTest","id is2 " + app.getId());
            Log.d("NetworkTest","name is2 " + app.getName());
            Log.d("NetworkTest","version is2 " + app.getVersion());
        }

    }
    private void parseJSONWithJSONObject(String jsonData){
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("NetworkTest","id is " + id);
                Log.d("NetworkTest","name is " + name);
                Log.d("NetworkTest","version is " + version);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
