package com.neptuunia.travel.loginuser;

import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginUserBinding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginUserActivity, v 0.0.1 19/07/20 08.16 by Putra Nugraha
 */
public class LoginUserActivity extends BaseActivity {

    private ActivityLoginUserBinding activityLoginUserBinding;

    public static void startActivity(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, LoginUserActivity.class);
        sourceActivity.startActivity(intent);
    }

    @Override
    public View getView() {
        activityLoginUserBinding = ActivityLoginUserBinding.inflate(getLayoutInflater());
        return activityLoginUserBinding.getRoot();
    }

    @Override
    public void setup() {
        setupRegisterTextView();
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
                // TODO Move to User Home
            }
        }, startIndex, registerSpannableText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return registerSpannableText;
    }
}
