package untils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.login_demo.R;

/**
 * Created by 祝文 on 2018/2/6.
 */

public class HistogramGrade extends View {
    int MAX = 150;//矩形显示的最大值
    int MAX2 = 100;//矩形显示的最大值
    int corner = 0; //矩形的角度。 设置为0 则没有角度。
    int data = 0;//显示的数
    int tempData = 0; //初始数据
    int textPadding = 5; //字体与矩形图的距离
    public  Paint mPaint;
    int mColor;
    Context mContext;
    private float realH;


    //构造函数
    public HistogramGrade(Context context) {
        super(context);
        mContext = context;
    }

    public HistogramGrade(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    public HistogramGrade(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initPaint();
    }

    //画笔方法
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mColor = mContext.getResources().getColor(R.color.colorAccent);
        mPaint.setColor(mColor);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (data == 0) {
            mPaint.setTextSize(getWidth() / 2);
            RectF oval3 = new RectF(0, getHeight() - DensityUtils.dp2px(mContext, 20), getWidth(), getHeight());// 设置个新的长方形
            canvas.drawRoundRect(oval3, DensityUtils.dp2px(mContext, corner), DensityUtils.dp2px(mContext, corner), mPaint);

            canvas.drawText("0",
                    getWidth() * 0.5f - mPaint.measureText("0") * 0.5f,
                    getHeight() - DensityUtils.dp2px(mContext, 20) - 2 * DensityUtils.dp2px(mContext, textPadding),
                    mPaint);
            return;
        }

        //防止数值很大的的时候，动画时间过长
        int step = (int) (data / 100 + 1.0);

        if (tempData < data - step) {
            tempData = tempData + step;
        } else {
            tempData = data;
        }
        //画圆角矩形
        String S = tempData + ""; //如果数字后面需要加% 则在""中添加%
        //设置显示的字体
        /* Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"digital-7.ttf");
         mPaint.setTypeface(typeface);*/
//        //一个字和两,三个字的字号相同
        if (S.length() <= 3) {
            mPaint.setTextSize(25);
        }
//
        float textH = mPaint.ascent() + mPaint.descent();
        float MaxH = getHeight() - textH - 2 * DensityUtils.dp2px(mContext, textPadding);
//        //圆角矩形的实际高度
        if(MAX==150)
        {
            realH = (float) (MaxH / MAX/1.5* tempData);
        }
      else if(MAX2==100)
        {
           realH = (float) (MaxH / MAX/1.5* tempData);
        }
        RectF oval3 = new RectF(0, getHeight() - realH, getWidth(), getHeight());// 设置个新的长方形
        canvas.drawRoundRect(oval3, DensityUtils.dp2px(mContext, corner), DensityUtils.dp2px(mContext, corner), mPaint);
        //写数字
        canvas.drawText(S,
                getWidth() * 0.5f - mPaint.measureText(S) * 0.5f,
                getHeight() - realH - 2 * DensityUtils.dp2px(mContext, textPadding),
                mPaint);
        if (tempData != data) {
            postInvalidate();
        }
    }

    public void setData(int data, int MAX) {
        if(MAX==150)
        {
            this.data = data;
            this.MAX = MAX;
        }
       else if(MAX==100)
        {
            this.data = data;
            this.MAX2 = MAX;
        }
        postInvalidate();
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

}
