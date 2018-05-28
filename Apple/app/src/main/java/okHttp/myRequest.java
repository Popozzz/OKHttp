package okHttp;

import android.util.Log;
import android.widget.Toast;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class myRequest
{
    public static Request initPostRequest(String url, RequestParams params) {


            return onPostRequest(url,params,null);
    }

    public static Request onPostRequest(String url,RequestParams requestParams,RequestParams headers)
    {
        FormBody.Builder myFormBody = new FormBody.Builder();
        if(requestParams != null)
        {
            for(Map.Entry<String,String> entry : requestParams.urls.entrySet())
            {
                myFormBody.add(entry.getKey(),entry.getValue());
            }
        }

        Headers.Builder myHeader = new Headers.Builder();
        if(headers != null)
        {
            for(Map.Entry<String,String> entry : headers.urls.entrySet())
            {
                myHeader.add(entry.getKey(),entry.getValue());
            }
        }

        //3.请求
        FormBody formBody = myFormBody.build();
        Headers header = myHeader.build();
        //4.传入对象
        Request request = new Request.Builder().url(url).post(formBody).headers(header).build();

        return request;
    }

    //创建get请求的request对象
    public static Request initGetRequest(String url,RequestParams params)
    {
        return onGetRequest(url,params,null);
    }

    //
    public static Request onGetRequest(String url,RequestParams requestParams,RequestParams headers)
    {
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if(requestParams != null)
        {
            for(Map.Entry<String,String> entry : requestParams.urls.entrySet())
            {
                //对url进行拼接
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        //添加请求头
        Headers.Builder myHeader = new Headers.Builder();
        if(headers != null)
        {
            for(Map.Entry<String,String> entry : headers.urls.entrySet())
            {
                myHeader.add(entry.getKey(),entry.getValue());
            }
        }

        //3.提交
        Headers header = myHeader.build();
        //4.传入对象
        Request request = new Request.Builder().url(stringBuilder.substring(0,stringBuilder.length()-1)).get().headers(header).build();
        return request;
    }
}
