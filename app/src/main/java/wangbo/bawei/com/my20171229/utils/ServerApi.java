package wangbo.bawei.com.my20171229.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import wangbo.bawei.com.my20171229.api.API;
import wangbo.bawei.com.my20171229.bean.ClassBean;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public interface ServerApi {
    @GET(API.URL)
    Call<ClassBean> list();
}
