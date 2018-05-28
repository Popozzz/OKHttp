package okHttp;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class MyOkHttpException<T> {

    private int ecode;
    private T emsg;
    public MyOkHttpException(int ecode,T emsg)
    {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode(){
        return ecode;
    }

    public  T getEmsg(){
        return emsg;
    }
}
