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
     * Goes to the device default call number activity with the number filled in
     *
     * @param context context from where the method was called
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

    /**
     * Goes to the device default call number activity with the number filled in
     *
     * @param context context from where the method was called
     * @param emailAddress email address to send email to
     * @param subject subject line of the email
     */
    private static  void startEmailActivity(Context context, String emailAddress, String subject) {
        if (!TextUtils.isEmpty(emailAddress) && !TextUtils.isEmpty(subject)) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }


}
