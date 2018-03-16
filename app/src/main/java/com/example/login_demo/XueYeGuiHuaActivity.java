package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import adapter.XueYeGuiHua_adapter;
import base.BaseActivity;
import bean.jobStarBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.ListViewForScrollView;

public class XueYeGuiHuaActivity extends BaseActivity {


    @BindView(R.id.guihua_iv_back)
    ImageView guihuaIvBack;
    @BindView(R.id.rl_xqcebg)
    RelativeLayout rlXqcebg;
    @BindView(R.id.rl_xgcebg)
    RelativeLayout rlXgcebg;
    @BindView(R.id.xygh_list)
    ListViewForScrollView xyghList;
    @BindView(R.id.sv)
    ScrollView sv;

    @Override
    public int getId() {
        return R.layout.activity_xue_ye_gui_hua;
    }

    @Override
    public void InIt() {
        List<jobStarBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new jobStarBean());
        }

        XueYeGuiHua_adapter xueYeGuiHua_adapter = new XueYeGuiHua_adapter(list, this);
        xyghList.setAdapter(xueYeGuiHua_adapter);
        sv.smoothScrollTo(0, 0);
    }

    @OnClick({R.id.guihua_iv_back, R.id.rl_xqcebg, R.id.rl_xgcebg, R.id.guihua_ivyiwen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guihua_iv_back:
                finish();
                break;
            case R.id.rl_xqcebg:
                intent(this, XQcsActivity.class);
                break;
            case R.id.rl_xgcebg:
                intent(this, XGcsActivity.class);
                break;
            case R.id.guihua_ivyiwen:
                intent(this, ChangQuessonActivity.class);
                break;
        }
    }



}
