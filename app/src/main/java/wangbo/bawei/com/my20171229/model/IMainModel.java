package wangbo.bawei.com.my20171229.model;

import wangbo.bawei.com.my20171229.utils.OnNetListener;
import wangbo.bawei.com.my20171229.bean.ClassBean;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public interface IMainModel {
    public void getData(OnNetListener<ClassBean> onNetListener);
}
