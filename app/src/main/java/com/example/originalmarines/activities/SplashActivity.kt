package com.example.originalmarines.activities

import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import com.example.originalmarines.MainActivity
import com.example.originalmarines.R
import com.example.originalmarines.base.BaseActivity

class SplashActivity : BaseActivity() {

    private val SPLASH_TIME_OUT = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)


        //hashFromSHA1("F3:BF:C1:86:0A:E6:FD:20:2F:E0:97:19:AD:17:52:B8:96:9E:E5:9D");
        Handler().postDelayed({
            startActivity(this@SplashActivity, MainActivity::class.java, true, true)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, SPLASH_TIME_OUT.toLong())
    }

    // Generate key hash for facebook.
    private fun hashFromSHA1(sha1: String) {
        val arr = sha1.split(":").toTypedArray()
        val byteArr = ByteArray(arr.size)
        for (i in arr.indices) {
            byteArr[i] = Integer.decode("0x" + arr[i]).toByte()
        }
        Log.e("hash : ", Base64.encodeToString(byteArr, Base64.NO_WRAP))
    }
}