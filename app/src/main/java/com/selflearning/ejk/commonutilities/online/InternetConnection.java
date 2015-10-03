package com.selflearning.ejk.commonutilities.online;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Methods to check for internet connection
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class InternetConnection {

    /**
     * This method requires the caller to hold the permission {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param activity calling activity
     * @return NetworkInfo of the active network
     */
    private static NetworkInfo getActiveNetwork(Activity activity){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * @return Check to see if the device is connected to internet (true/false)
     */
    public static boolean isConnectedOnline(Activity activity) {
        return getActiveNetwork(activity) != null && getActiveNetwork(activity).isConnectedOrConnecting();
    }

     /**
     * @param activity calling activity
     * @return name of the type of network
     */
    public static String checkNetworkType(Activity activity) {
        return getActiveNetwork(activity).getTypeName();
    }
}
