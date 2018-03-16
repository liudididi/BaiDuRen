package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.panpf.swsv.CircularLayout;
import me.panpf.swsv.SpiderWebScoreView;
import untils.ZhiMaScoreViewXQ;

public class XQcsActivity extends BaseActivity {

    @BindView(R.id.xqguihua_iv_back)
    ImageView xqguihuaIvBack;
    @BindView(R.id.rl_xqzhexian)
    RelativeLayout rlXqzhexian;

    @Override
    public int getId() {
        return R.layout.activity_xqcs;
    }

    @Override
    public void InIt() {

        SpiderWebScoreView spiderWebScoreView1 = (SpiderWebScoreView) findViewById(R.id.spiderWeb_mainActivity_1);
        CircularLayout circularLayout1 = (CircularLayout) findViewById(R.id.layout_mainActivity_circular1);

        Score[] scores = new Score[]{
                new Score(11.0f),
                new Score(18.0f),
                new Score(9.0f),
                new Score(7.0f),
                new Score(5.0f),
                new Score(5.0f),
        };
        setup(spiderWebScoreView1, circularLayout1, scores);
        rlXqzhexian.removeAllViews();
       ZhiMaScoreViewXQ zhiMaScoreViewXQ = new ZhiMaScoreViewXQ(this);
       List<Integer> listfen=new ArrayList<>();
            listfen.add(11);
            listfen.add(18);
            listfen.add(9);
            listfen.add(7);
            listfen.add(5);
            listfen.add(5);
        zhiMaScoreViewXQ.setlistfen(listfen);
        zhiMaScoreViewXQ.setMaxScore(30);
        zhiMaScoreViewXQ.setMinScore(0);
        rlXqzhexian.addView(zhiMaScoreViewXQ);

    }

    private void setup(SpiderWebScoreView spiderWebScoreView, CircularLayout circularLayout, Score... scores) {
        float[] scoreArray = new float[scores.length];
        for (int w = 0; w < scores.length; w++) {
            scoreArray[w] = scores[w].score;
        }
        spiderWebScoreView.setScores(30f, scoreArray);

        circularLayout.removeAllViews();
        List<String> list = new ArrayList<>();
        list.add("A艺术类");
        list.add("S社会");
        list.add("E企业");
        list.add("C常规");
        list.add("R实际");
        list.add("I研究");
        for (int i = 0; i < list.size(); i++) {
            TextView scoreTextView = new TextView(this);
            scoreTextView.setTextColor(Color.BLACK);
            scoreTextView.setText(list.get(i));
            circularLayout.addView(scoreTextView);
        }

    }



    @OnClick(R.id.xqguihua_iv_back)
    public void onViewClicked() {
        finish();
    }

    private static class Score {
        private float score;


        private Score(float score) {
            this.score = score;
        }
    }
}
