package okHttp;

import android.app.Application;
import android.telecom.Call;


import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class myOkHttp
{
    private static final int TIME_OUT = 30;
    private static OkHttpClient okHttpClient;

    //初始化okHtto的一些参数
    static{
        OkHttpClient.Builder okHttpClientBulider = new OkHttpClient.Builder();
        okHttpClientBulider.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBulider.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpClientBulider.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        okHttpClientBulider.followRedirects(true);
        okHttpClient = okHttpClientBulider.build();
    }

    public static okhttp3.Call sendRequest(Request request, Callback callback)
    {
        okhttp3.Call call = okHttpClient.newCall(request);

        call.enqueue(callback);
        return call;
    }



}
