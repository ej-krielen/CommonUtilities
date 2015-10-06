package com.selflearning.ejk.commonutilities.ui.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Builders for simple Dialogs
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class Dialogs {


    /**
     * Simple dialog with no methods on its button
     *
     * @param activity          calling activity
     * @param title             Title of the dialog
     * @param message           Message of the dialog
     * @param positiveButton    String for positiveButton
     * @param hasPositiveButton pass false if you don't want a button at all
     * @param canCancel         pass false if you want to force the user to use the button(s) to dismiss the dialog
     */
    public static void simpleDialog(Activity activity, String title, String message, String positiveButton, boolean hasPositiveButton, boolean canCancel) {
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
    }
}
