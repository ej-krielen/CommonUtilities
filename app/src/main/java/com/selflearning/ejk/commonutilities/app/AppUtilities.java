package com.selflearning.ejk.commonutilities.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.selflearning.ejk.commonutilities.AppExtension;

/**
 * Methods containing to app info
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class AppUtilities {

        private static final String TAG = "AppUtilities";
        private AppExtension mApp;

        private static AppUtilities sInstance = null;

        public static synchronized AppUtilities getInstance(Context context) {
            if (sInstance == null) {
                sInstance = new AppUtilities(context);
            }

            return sInstance;
        }

        protected AppUtilities(Context context) {
            mApp = (AppExtension) context.getApplicationContext();
        }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public int getAppVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // Should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * @return Application's version name from the {@code PackageManager}.
     */
    public String getAppVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // Should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

}
