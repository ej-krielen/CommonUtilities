package com.selflearning.ejk.commonutilities.online;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * Methods to check for internet connection
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 3-10-2015
 */
public final class InternetConnection {

    /**
     * <p>This method requires the caller to hold the permission {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @return Check to see if the device is connected to internet (true/false)
     */
    public static boolean isConnectedOnline(Activity activity) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Check what kind of connection is being used
     * <p>This method requires the caller to hold the permission {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param activity calling activity
     * @return -1 if not connected or unknown, 0 for mobile data, 1 for wifi, 2 for mobile mms, 3 for mobile supl, 4 mobile dun, 5 for mobile hipri, 6 for wimax, 7 for bluetooth, 8 for dummy, 9 for ethernet, 21 for vpn
     */
    public static int checkNetworkType(Activity activity) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_MOBILE;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_WIFI;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_MMS).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_MOBILE_MMS;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_SUPL).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_MOBILE_SUPL;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_DUN).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_MOBILE_DUN;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_HIPRI).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_MOBILE_HIPRI;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIMAX).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_WIMAX;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_BLUETOOTH;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_DUMMY).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_DUMMY;
        }
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET).isConnectedOrConnecting()) {
            return ConnectivityManager.TYPE_ETHERNET;
        }

        /* These don't seem to work */

//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_FOTA).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_MOBILE_FOTA;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_IMS).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_MOBILE_IMS;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_CBS).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_MOBILE_CBS;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI_P2P).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_WIFI_P2P;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_IA).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_MOBILE_IA;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_EMERGENCY).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_MOBILE_EMERGENCY;
//        }
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_PROXY).isConnectedOrConnecting()) {
//            return ConnectivityManager.TYPE_PROXY;
//        }


        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_VPN).isConnectedOrConnecting()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return ConnectivityManager.TYPE_VPN;
            }
        }

        return -1;
    }

}
