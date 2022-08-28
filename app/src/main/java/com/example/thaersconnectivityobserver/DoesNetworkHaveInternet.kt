package com.example.thaersconnectivityobserver

import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

object DoesNetworkHaveInternet {

    fun execute(): Boolean {
        try {
            val url = URL("http://www.google.com")
            val urlc: HttpURLConnection = url.openConnection() as HttpURLConnection
            urlc.setRequestProperty("User-Agent", "Android Application:1")
            urlc.setRequestProperty("Connection", "close")
            urlc.setConnectTimeout(2000)
            urlc.connect()

            // http://www.w3.org/Protocols/HTTP/HTRESP.html
            if (urlc.getResponseCode() === 200 || urlc.getResponseCode() > 400) {
                // Requested site is available
                return true
            }
        } catch (ex: Exception) {
            // Error while trying to connect
            return false
        }
        return false
    }
}
