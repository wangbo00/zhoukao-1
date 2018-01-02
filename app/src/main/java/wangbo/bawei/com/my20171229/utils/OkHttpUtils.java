package wangbo.bawei.com.my20171229.utils;

import okhttp3.OkHttpClient;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public class OkHttpUtils {
    public static OkHttpClient client;
    public static OkHttpClient getHttpUtil() {
        if (client == null) {
            synchronized (OkHttpUtils.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }
}
