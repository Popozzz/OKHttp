package okHttp;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class DisposeDataHandle {

    public DisposeDataListener disposeDataListener;
    public Class<?> tClass;
    public String source;
    public DisposeDataHandle(DisposeDataListener disposeDataListener)
    {
        this.disposeDataListener = disposeDataListener;
    }

    public  DisposeDataHandle(DisposeDataListener disposeDataListener,Class<?> tClass)
    {
        this.disposeDataListener = disposeDataListener;
        this.tClass = tClass;
    }
}
