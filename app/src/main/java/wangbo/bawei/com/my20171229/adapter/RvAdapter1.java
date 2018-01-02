package wangbo.bawei.com.my20171229.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wangbo.bawei.com.my20171229.R;
import wangbo.bawei.com.my20171229.bean.ClassBean;

/**
 * author:Created by Wangbo on 2017/12/30.
 */

public class RvAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ClassBean.DataBean.Ad5Bean> list;
    private Context context;

    public RvAdapter1(List<ClassBean.DataBean.Ad5Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rc01, null);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ClassBean.DataBean.Ad5Bean bean = list.get(position);
        MyViewholder holder1 = (MyViewholder) holder;
        holder1.sdv.setImageURI(bean.getImage());
        holder1.tv.setText(bean.getTitle()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewholder extends RecyclerView.ViewHolder{
        private SimpleDraweeView sdv;
        private TextView tv;
        public MyViewholder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.img_rc01);
            tv = itemView.findViewById(R.id.tit);
        }
    }
}
