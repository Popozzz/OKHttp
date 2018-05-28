package okHttp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

//请求参数的封装
public class RequestParams {

    //存放url
    public ConcurrentHashMap<String,String> urls = new ConcurrentHashMap<String,String>();
    //传入Map
    public RequestParams(Map<String,String> source)
    {
        if(source != null)
        {
            //把source put到urls中
            for(Map.Entry<String,String> entry : source.entrySet())
            {
                put(entry.getKey(),entry.getValue());
            }
        }
    }

    //put键值给urls
    public void put(String key,String value)
    {
        if(key != null && value != null)
        {
            urls.put(key,value);
        }
    }

    //如果没有传入参数则集合为null
    public RequestParams()
    {
        this((Map<String,String>) null);
    }

    //传入参数为单一键值对
    public RequestParams(final String key,final String value)
    {
        this(new HashMap<String, String>()
        {
            {
                put(key,value);
            }
        }
        );
    }

    //判断是否有参数
    public boolean hashParams(){
        if(urls.size()>0)
        {
            return true;
        }
        else
            return false;
    }
}
