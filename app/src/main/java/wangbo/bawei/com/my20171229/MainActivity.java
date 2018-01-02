package wangbo.bawei.com.my20171229;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import wangbo.bawei.com.my20171229.adapter.RvAdapter1;
import wangbo.bawei.com.my20171229.adapter.RvAdapter2;
import wangbo.bawei.com.my20171229.bean.ClassBean;
import wangbo.bawei.com.my20171229.presenter.IMainActivity;
import wangbo.bawei.com.my20171229.presenter.MainPresenter;
import wangbo.bawei.com.my20171229.utils.ImageUtil;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private Banner mBar;
    private RecyclerView mRv1;
    private RecyclerView mRv2;
    List<String> imgs;
    MainPresenter mainPresenter = new MainPresenter(this);
    /**
     * 02
     */
    private TextView mTvHour;
    /**
     * 15
     */
    private TextView mTvMinute;
    /**
     * 36
     */
    private TextView mTvSecond;

    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;

    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                if (mHour<10){
                    mTvHour.setText("0"+mHour+"");
                }else {
                    mTvHour.setText("0"+mHour+"");
                }
                if (mMin<10){
                    mTvMinute.setText("0"+mMin+"");
                }else {
                    mTvMinute.setText(mMin+"");
                }
                if (mSecond<10){
                    mTvSecond.setText("0"+mSecond+"");
                }else {
                    mTvSecond.setText(mSecond+"");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter.getClassBean();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        mRv1.setLayoutManager(new GridLayoutManager(this,4));
        mRv2.setLayoutManager(new LinearLayoutManager(this));
        startRun();
    }
    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    /**
     * 倒计时计算
     */
    private void computeTime() {
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }

    @Override
    public void show(final ClassBean classBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imgs = new ArrayList<>();
                List<ClassBean.DataBean.Ad1Bean> ad1 = classBean.getData().getAd1();
                for (int i = 0; i < ad1.size(); i++) {
                    imgs.add(ad1.get(i).getImage());
                }
                mBar.setImageLoader(new ImageUtil());
                mBar.setImages(imgs);
                mBar.setDelayTime(1000);
                mBar.start();
                //拿到第一个数据
                List<ClassBean.DataBean.Ad5Bean> ad5 = classBean.getData().getAd5();
                mRv1.setAdapter(new RvAdapter1(ad5,MainActivity.this));
                //拿到第二个数据
                List<ClassBean.DataBean.DefaultGoodsListBean> beanList = classBean.getData().getDefaultGoodsList();
                mRv2.setAdapter(new RvAdapter2(beanList,MainActivity.this));
            }
        });
    }

    private void initView() {
        mBar = (Banner) findViewById(R.id.bar);
        mRv1 = (RecyclerView) findViewById(R.id.rv1);
        mRv2 = (RecyclerView) findViewById(R.id.rv2);
        mTvHour = (TextView) findViewById(R.id.tv_hour);
        mTvMinute = (TextView) findViewById(R.id.tv_minute);
        mTvSecond = (TextView) findViewById(R.id.tv_second);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter = null;
    }
}
