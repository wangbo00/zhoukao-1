package wangbo.bawei.com.my20171229.utils;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public interface OnNetListener<T> {
    //成功回调
    public void onSuccess(T t);

    //失败回调
    public void onFailure(Exception e);
}
