package com.selflearning.ejk.commonutilities.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

import com.selflearning.ejk.commonutilities.R;

/**
 * Standard intents
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 6-10-2015
 */
public final class StandardIntents {

    /**
     * Goes to the phone's default call number screen with the number filled in
     *
     * @param context context from where the method was callded
     * @param number  telephone number to call
     */
    public static void startPhoneActivity(Context context, String number) {
        if (!TextUtils.isEmpty(number)) {
            String url = "tel:" + number.trim();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

}
