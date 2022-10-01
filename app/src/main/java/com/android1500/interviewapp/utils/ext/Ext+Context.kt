package com.android1500.interviewapp.utils.ext

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities



fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    val capabilities = arrayOf(
        NetworkCapabilities.TRANSPORT_BLUETOOTH,
        NetworkCapabilities.TRANSPORT_CELLULAR,
        NetworkCapabilities.TRANSPORT_ETHERNET,
        NetworkCapabilities.TRANSPORT_LOWPAN,
        NetworkCapabilities.TRANSPORT_VPN,
        NetworkCapabilities.TRANSPORT_WIFI,
        NetworkCapabilities.TRANSPORT_WIFI_AWARE
    )
    return capabilities.any { networkCapabilities?.hasTransport(it) ?: false }
}
