package com.selflearning.ejk.commonutilities;

import android.app.Application;

/**
 * Extension class for the Application object, mainly for storing global objects.
 *
 * @author Erik-Jan Krielen ej.krielen@euphoria-it.nl
 * @since 24-9-2015 Creation of this file
 */
public class AppExtension extends Application {

    private static final String TAG = "AppExtension";

    @Override
    public void onCreate() {
        super.onCreate();
    }

}