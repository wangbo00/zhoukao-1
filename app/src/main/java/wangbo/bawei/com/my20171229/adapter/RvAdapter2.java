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

public class RvAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ClassBean.DataBean.DefaultGoodsListBean> list;
    private Context context;
    int TYPE_NUM = 0;
    int TYPE_TWO = 1;

    public RvAdapter2(List<ClassBean.DataBean.DefaultGoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    /**
     * 实现多条目
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0){
            return TYPE_NUM;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NUM){
            View view = View.inflate(context, R.layout.item_rc02, null);
            return new MyViewHolder1(view);
        } else if (viewType == TYPE_TWO){
            View view = View.inflate(context, R.layout.item_rc03, null);
            return new MyViewHolder2(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NUM){
            ClassBean.DataBean.DefaultGoodsListBean bean = list.get(position);
            MyViewHolder1 holder1 = (MyViewHolder1) holder;
            holder1.sdv.setImageURI(bean.getGoods_img());
        } else if (getItemViewType(position) == TYPE_TWO){
            ClassBean.DataBean.DefaultGoodsListBean bean = list.get(position);
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            holder2.sdv.setImageURI(bean.getGoods_img());
            holder2.tv.setText(bean.getGoods_name()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder1 extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        public MyViewHolder1(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.img_rc02);
        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv;
        public MyViewHolder2(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.img_rc03);
            tv=itemView.findViewById(R.id.tit03);
        }
    }
}
