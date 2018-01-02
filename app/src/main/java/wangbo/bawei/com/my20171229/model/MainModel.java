package wangbo.bawei.com.my20171229.model;

import retrofit2.Call;
import wangbo.bawei.com.my20171229.utils.OnNetListener;
import wangbo.bawei.com.my20171229.bean.ClassBean;
import wangbo.bawei.com.my20171229.utils.RetrofitHelper;
import wangbo.bawei.com.my20171229.utils.ServerApi;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public class MainModel implements IMainModel{
    @Override
    public void getData(final OnNetListener<ClassBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        Call<ClassBean> list = serverApi.list();
        list.enqueue(new retrofit2.Callback<ClassBean>() {
            @Override
            public void onResponse(Call<ClassBean> call, retrofit2.Response<ClassBean> response) {
                onNetListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ClassBean> call, Throwable t) {
                onNetListener.onFailure((Exception) t);
            }
        });
    }
}
