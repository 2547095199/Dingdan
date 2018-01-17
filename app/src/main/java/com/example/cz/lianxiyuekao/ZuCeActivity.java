package com.example.cz.lianxiyuekao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.bean.ZuCeBean;
import com.example.cz.lianxiyuekao.persenter.ZuCePersenter;
import com.example.cz.lianxiyuekao.view.ZuCeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZuCeActivity extends AppCompatActivity implements ZuCeView {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.phone2)
    EditText phone2;
    @BindView(R.id.mima2)
    EditText mima2;
    @BindView(R.id.zhuce2)
    Button zhuce2;
    ZuCePersenter persenter = new ZuCePersenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zu_ce);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui, R.id.zhuce2})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.zhuce2:
                String number = phone2.getText().toString();
                boolean judge = isMobile(number);
                if (judge == true) {
                    if (!TextUtils.isEmpty(mima2.getText().toString())) {
                        persenter.getDara(phone2.getText().toString() + "", mima2.getText().toString() + "");
                    } else {
                        Toast.makeText(ZuCeActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ZuCeActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void success(ZuCeBean bean) {
        Toast.makeText(ZuCeActivity.this, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
        if (bean.getMsg().length() == 4) {
            finish();
        }

    }

    @Override
    public void failuer(String e) {
        Toast.makeText(ZuCeActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.dfsdsds();
    }

    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、152、157(TD)、158、159、178(新)、182、184、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、170、173、177、180、181、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
