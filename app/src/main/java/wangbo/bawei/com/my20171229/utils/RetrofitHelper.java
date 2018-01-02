package wangbo.bawei.com.my20171229.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wangbo.bawei.com.my20171229.api.API;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public class RetrofitHelper {
    public static OkHttpClient client;
    public static ServerApi serverApi;
    static {
        client = OkHttpUtils.getHttpUtil();
    }
    public static ServerApi getServerApi() {
        if (serverApi == null){
            synchronized (ServerApi.class){
                if (serverApi == null){
                    serverApi = OnCreatApi(ServerApi.class, API.HOST);
                }
            }
        }
        return serverApi;
    }
    public static <T> T OnCreatApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
