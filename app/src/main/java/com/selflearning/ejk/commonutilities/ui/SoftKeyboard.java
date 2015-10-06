package com.selflearning.ejk.commonutilities.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Methods to control the softKeyboard
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 6-10-2015
 */
public final class SoftKeyboard {

    /**
     * Hides the softKeyboard
     *
     * @param activity calling Activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            View view = activity.getCurrentFocus();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
