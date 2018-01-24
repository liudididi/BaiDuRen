package fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.AddServeActivity;
import com.example.login_demo.CharacterActivity;
import com.example.login_demo.HelpActivity;
import com.example.login_demo.MainActivity;
import com.example.login_demo.MyApp;
import com.example.login_demo.MySchoolActivity;
import com.example.login_demo.PresonMessageActivity;
import com.example.login_demo.R;
import com.example.login_demo.SetTingActivity;
import com.example.login_demo.SuggestActivity;
import com.meg7.widget.CustomShapeImageView;

import base.Basefragment;
import untils.SPUtils;

/**
 * Created by 祝文 on 2018/1/19.
 */

public class My_Fragment extends Basefragment implements View.OnClickListener {

    private TextView my_login;
    private CustomShapeImageView my_icon;
    private RelativeLayout my_school,my_major,my_washtable,my_character,my_gradetable
                            ,my_help,my_addserve,my_suggest;
    private TextView tv_myschool;
    private ImageView my_setting;
    private String token;
    private Intent intent;
    private Boolean checLogin;

    @Override
    public int getLayoutid() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView() {
        init();
        initOnClick();
    }

    private void initOnClick() {
        my_login.setOnClickListener(this);
        my_icon.setOnClickListener(this);
        my_school.setOnClickListener(this);
        my_major.setOnClickListener(this);
        my_washtable.setOnClickListener(this);
        my_character.setOnClickListener(this);
        my_gradetable.setOnClickListener(this);

        my_help.setOnClickListener(this);
        my_addserve.setOnClickListener(this);
        my_suggest.setOnClickListener(this);
        my_setting.setOnClickListener(this);

    }

    private void init() {
        my_login = view.findViewById(R.id.my_login);
        my_icon = view.findViewById(R.id.my_icon);
        my_school = view.findViewById(R.id.my_school);
        //我的专业
        my_major = view.findViewById(R.id.my_major);
        //性格测试
        my_character = view.findViewById(R.id.my_character);
        //我的成绩表
        my_gradetable = view.findViewById(R.id.my_gradetable);

        //我的志愿表
        my_washtable = view.findViewById(R.id.my_washtable);



        //我的帮助
        my_help = view.findViewById(R.id.my_help);

        //购买增值
        my_addserve = view.findViewById(R.id.my_addserve);
        //建议
        my_suggest = view.findViewById(R.id.my_suggest);

        my_setting = view.findViewById(R.id.my_setting);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_login:
                    intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                break;
            case R.id.my_school:
                 checLogin= checLogin();
                if(checLogin ==true){
                    intent=new Intent(getActivity(), MySchoolActivity.class);
                    startActivity(intent);
                }

                break;
            case R.id.my_icon:
                checLogin = checLogin();
                if(checLogin ==true){
                    intent=new Intent(getActivity(), PresonMessageActivity.class);
                    startActivity(intent);
                }

                break;
            case R.id.my_major:
                checLogin = checLogin();
                if(checLogin ==true){
                    Toast.makeText(getActivity(), "我收藏专业", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.my_washtable:
                checLogin = checLogin();
                if(checLogin ==true){
                    Toast.makeText(getActivity(), "我的志愿表", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.my_character:
                checLogin = checLogin();
                if(checLogin ==true){
                    intent=new Intent(getActivity(), CharacterActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.my_gradetable:
                checLogin = checLogin();
                if(checLogin ==true){
                    Toast.makeText(getActivity(), "我的成绩单", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_help:
                getContext().startActivity(new Intent(getContext(), HelpActivity.class));
                break;
            case R.id.my_addserve:
                getContext().startActivity(new Intent(getContext(), AddServeActivity.class));
                break;
            case R.id.my_suggest:
                getContext().startActivity(new Intent(getContext(), SuggestActivity.class));
                break;
            case R.id.my_setting:
                 intent=new Intent(getActivity(), SetTingActivity.class);
                 startActivity(intent);
                break;

        }
    }

    private Boolean checLogin() {
       if(token.length()<4){
           new AlertDialog.Builder(getActivity())
                   .setTitle("提示")
                   .setMessage("该功能需要登录后才能使用")
                   .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           intent=new Intent(getActivity(),MainActivity.class);
                           startActivity(intent);
                       }
                   })
                   .setNegativeButton("取消", null)
                   .show();
           return  false;
         }else {
           return true;
       }
    }

    @Override
    public void onResume() {
        super.onResume();
        token = (String) SPUtils.get(MyApp.context, "token", "");
    }
}
