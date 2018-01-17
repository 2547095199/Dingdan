package com.example.cz.lianxiyuekao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.R;

/**
 * Created by CZ on 2018/1/15.
 */

public class CustCrom extends LinearLayout {
    private int mCount = 1;
    private Button revserse;
    private Button add;
    private EditText editText;

    public CustCrom(Context context) {
        super(context);
    }

    public CustCrom(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.item_custcrom, null, false);
        revserse = (Button) view.findViewById(R.id.revserse);
        add = (Button) view.findViewById(R.id.add);
        editText = (EditText) view.findViewById(R.id.content);
        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //减后在输入框里的数字是多少
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content);
                    //判断数量是否大于1，如果大于一的话可以减减，如果等于一的话则不再往下减了
                    if (count > 1) {
                        mCount = count - 1;
                        //输入框的数字
                        editText.setText(mCount + "");
                        if (listener != null) {
                            listener.click(mCount);
                        }
                    } else if (count == 1) {
                        Toast.makeText(context, "最小为1", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //加号点击事件
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //可以一直加下去
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content) + 1;
                    mCount = count;
                    editText.setText(count + "");
                    if (listener != null) {
                        listener.click(count);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //输入框
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        addView(view);
    }

    public CustCrom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setEditText(int num) {
        if (editText != null) {
            editText.setText(num + "");
        }
    }

    private ClickListener listener;

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public interface ClickListener {
        public void click(int count);
    }
}
