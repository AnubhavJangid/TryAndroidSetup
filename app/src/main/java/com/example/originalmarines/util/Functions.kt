package com.example.originalmarines.util

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.originalmarines.BuildConfig
import com.example.originalmarines.R
import java.text.DecimalFormat

fun debugPrint(message: String?) {
    if (BuildConfig.DEBUG) {
        Log.e("Print", message.toString())
    }
}

fun Double.formatDecimal(): String {
    return DecimalFormat("###.##").format(this)
}

fun Context.showToast(message: String?) {
    message ?: return
    Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(imageUrl: Any, placeholder: Int = R.drawable.ic_image_place_holder) {
    Glide.with(context)
            .load(imageUrl)
            .apply(RequestOptions()
                    .placeholder(placeholder)
                    .error(placeholder))
            .into(this)
}

fun View.avoidDoubleClicks() {
    val DELAY_IN_MS: Long = 900
    if (!this.isClickable) {
        return
    }
    this.isClickable = false
    this.postDelayed({ this.isClickable = true }, DELAY_IN_MS)
}

fun View.hide() {
    animate().alpha(0.0f)?.duration = 500
    visibility = View.GONE
}

fun View.visible(opacity: Float = 1.0f) {
    animate().alpha(opacity).duration = 500
    visibility = View.VISIBLE
}

fun AppCompatActivity.changeStatusBarColor(@ColorRes color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, color)
    }
}
