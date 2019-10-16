package com.segamedev.bandros;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//
// Author: Fathur Radhy 
// Email: radhsyn83@gmail.com
// Created At: September 2019-09-27.
//
public class BFormInputText extends LinearLayout {

    private static final int NOT_DEFINED = -777; //random number, not - 1 because it is WHITE
    TextView tvFormName;
    EditText etFormInput;
    ImageView ivLeftButton, ivRightButton;
    String mFormName;
    String mFormHint;
    String mFormInputType;
    String mText = "";
    int mFormNameColor = NOT_DEFINED;
    int mFormHintColor = NOT_DEFINED;
    int mLeftButtonIcon = NOT_DEFINED;
    int mRightButtonIcon = NOT_DEFINED;
    int mLeftButtonIconTint = NOT_DEFINED;
    int mRightButtonIconTint = NOT_DEFINED;
    Boolean mShowLeftButton, mShowRightButton, mFormReadOnly;
    private Context mContext;

    public BFormInputText(Context context) {
        super(context);
        init(context, null);
    }

    public BFormInputText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BFormInputText(Context context,
                          AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(com.segamedev.bandros.R.layout.bandros_form_text_input, this);

        if (attrs != null) {

            TypedArray typedArray = context.obtainStyledAttributes(attrs, com.segamedev.bandros.R.styleable.BFormInputText);

            mFormName = typedArray.getString(com.segamedev.bandros.R.styleable.BFormInputText_b_formName);
            mFormHint = typedArray.getString(com.segamedev.bandros.R.styleable.BFormInputText_b_formHint);
            mFormNameColor = typedArray.getColor(com.segamedev.bandros.R.styleable.BFormInputText_b_formNameColor, getResources().getColor(com.segamedev.bandros.R.color.bandros_formname_default_color));
            mFormHintColor = typedArray.getColor(com.segamedev.bandros.R.styleable.BFormInputText_b_formHintColor, NOT_DEFINED);
            mText = typedArray.getString(com.segamedev.bandros.R.styleable.BFormInputText_text);
            mShowRightButton = typedArray.getBoolean(com.segamedev.bandros.R.styleable.BFormInputText_b_rightButtonShow, false);
            mShowLeftButton = typedArray.getBoolean(com.segamedev.bandros.R.styleable.BFormInputText_b_leftButtonShow, false);
            mLeftButtonIcon = typedArray.getResourceId(com.segamedev.bandros.R.styleable.BFormInputText_b_leftButtonIcon, com.segamedev.bandros.R.drawable.bform_default_button_icon);
            mRightButtonIcon = typedArray.getResourceId(com.segamedev.bandros.R.styleable.BFormInputText_b_rightButtonIcon, com.segamedev.bandros.R.drawable.bform_default_button_icon);
            mLeftButtonIconTint = typedArray.getColor(com.segamedev.bandros.R.styleable.BFormInputText_b_leftButtonIconTint, NOT_DEFINED);
            mRightButtonIconTint = typedArray.getColor(com.segamedev.bandros.R.styleable.BFormInputText_b_rightButtonIconTint, NOT_DEFINED);
            mFormReadOnly = typedArray.getBoolean(R.styleable.BFormInputText_b_formReadOnly, true);
            mFormInputType = typedArray.getString(R.styleable.BFormInputText_b_formInputType);

            typedArray.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //Init View
        tvFormName = this.findViewById(com.segamedev.bandros.R.id.tv_form_name);
        etFormInput = this.findViewById(com.segamedev.bandros.R.id.et_form_input);
        ivLeftButton = this.findViewById(com.segamedev.bandros.R.id.iv_button_left);
        ivRightButton = this.findViewById(com.segamedev.bandros.R.id.iv_button_right);

        //Set Form Name
        if (mFormName != null)
            tvFormName.setText(mFormName);
        else
            tvFormName.setText("Form Name");
        setFormNameColor(mFormNameColor);

        //Edittext
        setFormReadOnly(mFormReadOnly);
        //Set Form Text
        etFormInput.setText(mText);

        //Set Form Hint
        if (mFormHint != null)
            etFormInput.setHint(mFormHint);
        else
            etFormInput.setHint("Form Hint");
        setFormHintColor(mFormHintColor);

        //Set Left Button
        showLeftButton(mShowLeftButton);
        setLeftButtonIcon(mLeftButtonIcon);
        if (mLeftButtonIconTint != NOT_DEFINED) setLeftButtonIconTint(mLeftButtonIcon);

        //Set Left Button
        showRightButton(mShowRightButton);
        setRightButtonIcon(mRightButtonIcon);
        if (mRightButtonIconTint != NOT_DEFINED) setRightButtonIconTint(mRightButtonIcon);

        //Set Form Type
        if (mFormInputType == null) mFormInputType = "0";
        setInputType(mFormInputType);
    }

    public void setTextArea() {
        etFormInput.setMaxLines(3);
        etFormInput.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void setInputType(String inputType) {

        switch (inputType) {
            case "0x1":
                etFormInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case "0x2":
                etFormInput.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case "0x3":
                setTextArea();
                break;
            case "0x4":
                etFormInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            default:
                etFormInput.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                break;
        }
    }

    public void setFormNameColor(int color) {
        tvFormName.setTextColor(color);
    }

    public void setFormHintColor(int color) {
        if (mFormHintColor != NOT_DEFINED) {
            etFormInput.setHintTextColor(color);
        }
    }

    public void showLeftButton(Boolean isShow) {
        if (ivLeftButton != null) {
            if (isShow)
                ivLeftButton.setVisibility(View.VISIBLE);
            else
                ivLeftButton.setVisibility(View.GONE);
        }
    }

    public void showRightButton(Boolean isShow) {
        if (ivRightButton != null) {
            if (isShow)
                ivRightButton.setVisibility(View.VISIBLE);
            else
                ivRightButton.setVisibility(View.GONE);
        }
    }

    public void setRightButtonIcon(int image) {
        if (ivRightButton != null) {
            ivRightButton.setImageResource(image);
        }
    }

    public void setLeftButtonIcon(int image) {
        if (ivLeftButton != null) {
            ivLeftButton.setImageResource(image);
        }
    }

    public void setLeftButtonIconTint(int color) {
        if (ivLeftButton != null) {
            ivRightButton.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setFormReadOnly(Boolean isEnable) {
        etFormInput.setEnabled(isEnable);
    }

    public void setRightButtonIconTint(int color) {
        if (ivRightButton != null) {
            ivRightButton.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
    }

    public String getText() {
        return etFormInput.getText().toString();
    }

    public EditText getFormInput() {
        return etFormInput;
    }

    public TextView getFormTitle() {
        return tvFormName;
    }

    public void onLeftButtonClick(View.OnClickListener onClickListener) {
        ivLeftButton.setOnClickListener(onClickListener);
    }

    public void onRightButtonClick(View.OnClickListener onClickListener) {
        ivRightButton.setOnClickListener(onClickListener);
    }

}
