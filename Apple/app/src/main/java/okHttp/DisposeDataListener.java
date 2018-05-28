package okHttp;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public interface DisposeDataListener {
    //请求成功回调事件处理
    public void MyCallSuccess(String response);

    //请求失败事件回调处理
    public  void MyCallFailure(Object reasonObj);
}
