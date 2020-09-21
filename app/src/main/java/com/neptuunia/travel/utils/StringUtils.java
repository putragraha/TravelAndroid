package com.neptuunia.travel.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TextUtils, v 0.0.1 21/09/20 23.21 by Putra Nugraha
 */
public class StringUtils {

    private StringUtils() {
        // Prevent instantiation
    }

    public static SpannableString getSpannableText(
        String spannedText,
        String formatText,
        Consumer<View> consumer
    ) {
        SpannableString spannableText = new SpannableString(String.format(formatText, spannedText));
        int startIndex = spannableText.length() - spannedText.length();
        spannableText.setSpan(new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                consumer.accept(widget);
            }
        }, startIndex, spannableText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableText;
    }
}
