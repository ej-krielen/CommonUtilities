package com.selflearning.ejk.commonutilities.ui.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.selflearning.ejk.commonutilities.AppExtension;

/**
 * Builders for simple Dialogs
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class Dialogs {

    private static final String TAG = "Dialogs";
    private AppExtension mApp;

    private static Dialogs sInstance = null;

    public static synchronized Dialogs getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Dialogs(context);
        }

        return sInstance;
    }

    protected Dialogs(Context context) {
        mApp = (AppExtension) context.getApplicationContext();
    }


    /**
     * Simple dialog with no methods on its button
     *
     * @param activity          calling activity
     * @param title             Title of the dialog
     * @param message           Message of the dialog
     * @param hasPositiveButton pass false if you don't want a button at all
     * @param positiveButton    String for positiveButton
     * @param canCancel         pass false if you want to force the user to use the button(s) to dismiss the dialog
     * @return AlertDialog
     */
    public AlertDialog simpleDialog(Activity activity, String title, String message, boolean hasPositiveButton, String positiveButton, boolean canCancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message);

        if (hasPositiveButton) {

            builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
        }

        // A positive button is needed to get out of a non-cancelable dialog, so we don't allow it without having a button.
        if (hasPositiveButton && !canCancel) {
            builder.setCancelable(false);
        }

        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    /**
     * Simple Progress Dialog. Don't forget to dismiss (in onPause).
     *
     * @param activity calling activity
     * @param title    title for dialog
     * @param message  message for dialog
     * @return ProgressDialog
     */
    public ProgressDialog showProgress(Activity activity, String title, String message) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();

        return progressDialog;
    }
}
