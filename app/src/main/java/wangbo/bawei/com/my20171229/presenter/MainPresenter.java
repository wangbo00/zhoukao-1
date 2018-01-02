package wangbo.bawei.com.my20171229.presenter;

import wangbo.bawei.com.my20171229.utils.OnNetListener;
import wangbo.bawei.com.my20171229.bean.ClassBean;
import wangbo.bawei.com.my20171229.model.IMainModel;
import wangbo.bawei.com.my20171229.model.MainModel;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public class MainPresenter {
    IMainActivity iMainActivity;
    IMainModel iMainModel;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel = new MainModel();
    }
    public void getClassBean(){
        iMainModel.getData(new OnNetListener<ClassBean>() {
            @Override
            public void onSuccess(ClassBean classBean) {
                iMainActivity.show(classBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
