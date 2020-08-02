package com.neptuunia.travel.loginuser;

import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginUserBinding;
import com.neptuunia.travel.homeuser.HomeUserActivity;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginUserActivity extends BaseActivity {

    @Inject
    ActivityLoginUserBinding activityLoginUserBinding;

    @Override
    public View getView() {
        return activityLoginUserBinding.getRoot();
    }

    @Override
    public void setup() {
        setupRegisterTextView();
        setupButtonLogin();
    }

    private void setupButtonLogin() {
        activityLoginUserBinding.btnLogin.setOnClickListener(view ->
            startActivity(HomeUserActivity.class)
        );
    }

    private void setupRegisterTextView() {
        activityLoginUserBinding.tvRegisterLabel.setText(getRegisterSpannableText());
        activityLoginUserBinding.tvRegisterLabel.setMovementMethod(LinkMovementMethod.getInstance());
        activityLoginUserBinding.tvRegisterLabel.setHighlightColor(Color.TRANSPARENT);
    }

    private SpannableString getRegisterSpannableText() {
        String registerHere = getString(R.string.register_here);
        SpannableString registerSpannableText = new SpannableString(
            String.format(getString(R.string.have_no_account), registerHere)
        );
        int startIndex = registerSpannableText.length() - registerHere.length();

        registerSpannableText.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // TODO Move to User Register
            }
        }, startIndex, registerSpannableText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return registerSpannableText;
    }
}
