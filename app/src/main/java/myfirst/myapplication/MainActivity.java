package myfirst.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mycartutils.bean.ChildBean;
import com.bwie.mycartutils.bean.GroupBean;
import com.bwie.mycartutils.utils.CartUtils;
import com.bwie.secondsamplelibrary.TwoImageUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    //
//    @BindView(R.id.elv)
//    ExpandableListView elv;
//    @BindView(R.id.all)
//    CheckBox all;
//    @BindView(R.id.count)
//    TextView count;
//    @BindView(R.id.name)
//    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageView = (ImageView) findViewById(R.id.image);

        HttpUtils.doGet("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1", new HttpUtils.GsonObjectCallback<MyBean>() {
            @Override
            public void onUi(MyBean myBean) {
                //购物车
//                List<GroupBean> flist=new ArrayList<GroupBean>();
//                List<List<ChildBean>> slist=new ArrayList<List<ChildBean>>();
               List<MyBean.DataBean> data=myBean.getData();
//                for (int i = 0; i < data.size(); i++) {
//                    flist.add(new GroupBean(data.get(i).getTitle(),false));
//                }
//                for (int i = 0; i < data.size(); i++) {
//                    List<ChildBean> clist=new ArrayList<ChildBean>();
//                    for (int j = 0; j < data.size(); j++) {
//                        clist.add(new ChildBean(data.get(j).getUserName(),"200",data.get(j).getImg(),false,1));
//                    }
//                    slist.add(clist);
//                }
//                CartUtils.setCartData(MainActivity.this,flist,slist,elv,all,count,name);

                //二次采样
                TwoImageUtils.loadImage(data.get(0).getImg(),imageView);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
