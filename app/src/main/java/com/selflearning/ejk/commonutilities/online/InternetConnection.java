package com.selflearning.ejk.commonutilities.online;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.selflearning.ejk.commonutilities.AppExtension;

/**
 * Methods to check for internet connection
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class InternetConnection {

    private static final String TAG = "InternetConnection";
    private AppExtension mApp;

    private static InternetConnection sInstance = null;

    public static synchronized InternetConnection getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new InternetConnection(context);
        }

        return sInstance;
    }

    protected InternetConnection(Context context) {
        mApp = (AppExtension) context.getApplicationContext();
    }

    /**
     * This method requires the caller to hold the permission {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param activity calling activity
     * @return NetworkInfo of the active network
     */
    private NetworkInfo getActiveNetwork(Activity activity){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * @return Check to see if the device is connected to internet (true/false)
     */
    public boolean isConnectedOnline(Activity activity) {
        return getActiveNetwork(activity) != null && getActiveNetwork(activity).isConnectedOrConnecting();
    }

     /**
     * @param activity calling activity
     * @return name of the type of network
     */
    public String checkNetworkType(Activity activity) {
        return getActiveNetwork(activity).getTypeName();
    }

    /**
     * This method requires an API level of 21+ (LOLLIPOP)
     *
     * @param activity calling activity
     * @return Check if the device is connected to a VPN connection (true/false)
     */
    public boolean isConnectedToVPN (Activity activity){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_VPN);
        }
        return networkInfo != null && networkInfo.isConnected();
    }

}
