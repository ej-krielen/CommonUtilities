package com.selflearning.ejk.commonutilities.intents;

import android.app.Activity;
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
     * @param activity calling activity
     * @param number   telephone number to call
     */
    public static void startPhoneActivity(Activity activity, String number) {
        if (!TextUtils.isEmpty(number)) {
            String url = "tel:" + number.trim();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, activity.getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Goes to the device default call number activity with the number filled in
     *
     * @param activity     calling activity
     * @param emailAddress email address to send email to
     * @param subject      subject line of the email
     */
    public static void startEmailActivity(Activity activity, String emailAddress, String subject) {
        if (!TextUtils.isEmpty(emailAddress) && !TextUtils.isEmpty(subject)) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        } else {
            Toast.makeText(activity, activity.getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Starts an activity to post a tweet, both parameters are optional
     *
     * @param activity calling activity
     * @param message  optional: standard message to send
     * @param hashtags optional: hashtag(s) to add (comma seperated)
     */
    public static void startPostToTwitterActivity(Activity activity, String message, String hashtags) {

        String twitterString = "https://twitter.com/intent/tweet?";

        if (!TextUtils.isEmpty(message)) {
            twitterString += "text=" + message;
        }
        if (!TextUtils.isEmpty(hashtags)) {
            twitterString += "&hashtags=" + hashtags;
        }
        Uri twitterUri = Uri.parse(twitterString);

        Intent intent = new Intent(Intent.ACTION_VIEW, twitterUri);
        intent.putExtra(Intent.EXTRA_TEXT, "message");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }

    }

    /**
     * Starts an activity displaying a twitter account
     *
     * @param activity    calling activity
     * @param accountName name of twitter account to go to
     */
    public static void startGoToTwitterActivity(Activity activity, String accountName) {
        if (!TextUtils.isEmpty(accountName)) {
            String twitterUrl = "twitter://user?screen_name=";
            Uri webpage = Uri.parse(twitterUrl + accountName);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        } else {
            Toast.makeText(activity, activity.getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }


}
