package com.selflearning.ejk.commonutilities.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.selflearning.ejk.commonutilities.AppExtension;

/**
 * Methods to control the softKeyboard
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 6-10-2015
 */
public final class SoftKeyboard {

    private static final String TAG = "SoftKeyboard";
    private AppExtension mApp;

    private static SoftKeyboard sInstance = null;

    public static synchronized SoftKeyboard getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SoftKeyboard(context);
        }

        return sInstance;
    }

    protected SoftKeyboard(Context context) {
        mApp = (AppExtension) context.getApplicationContext();
    }

    /**
     * Hides the softKeyboard
     *
     * @param activity calling Activity
     */
    public void hideSoftKeyboard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            View view = activity.getCurrentFocus();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
