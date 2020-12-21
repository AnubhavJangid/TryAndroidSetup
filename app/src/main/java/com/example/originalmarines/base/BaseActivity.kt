package com.example.originalmarines.base

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.originalmarines.R
import com.google.android.material.snackbar.Snackbar
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.internal.Intrinsics

open class BaseActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(arg0: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(arg0)
        //   Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_splash)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String?>?, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions!!, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String?): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission!!) == PackageManager.PERMISSION_GRANTED
    }

    fun setTouchNClick(id: Int): View {
        val v = findViewById<View>(id)
        v.setOnClickListener(this)
        return v
    }

    fun setClick(id: Int): View {
        val v = findViewById<View>(id)
        v.setOnClickListener(this)
        return v
    }

    fun setViewSelected(id: Int, flag: Boolean) {
        val v = findViewById<View>(id)
        v.isSelected = flag
    }

    fun setViewVisibility(id: Int, flag: Int) {
        val v = findViewById<View>(id)
        v.visibility = flag
    }

    fun setTransfMethodPassword(id: Int) {
        val v = findViewById<EditText>(id)
        v.transformationMethod = PasswordTransformationMethod()
    }

    fun setTransfMethodText(id: Int) {
        val v = findViewById<EditText>(id)
        v.transformationMethod = null
    }

    fun setTextViewText(id: Int, text: String?) {
        (findViewById<View>(id) as TextView).text = text
    }

    fun setEditText(id: Int, text: String?) {
        (findViewById<View>(id) as EditText).setText(text)
    }

    fun getEditTextText(id: Int): String {
        return (findViewById<View>(id) as EditText).text.toString().trim { it <= ' ' }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setCheckBox(id: Int, checkFlag: Boolean) {
        (findViewById<View>(id) as CheckBox).isChecked = checkFlag
    }

    fun getTextViewText(id: Int): String {
        return (findViewById<View>(id) as TextView).text.toString().trim { it <= ' ' }
    }

    fun getButtonText(id: Int): String {
        return (findViewById<View>(id) as Button).text.toString()
    }

    fun setButtonText(id: Int, text: String?) {
        (findViewById<View>(id) as Button).text = text
    }

    fun replaceButtoImageWith(replaceId: Int, drawable: Int) {
        (findViewById<View>(replaceId) as Button).setBackgroundResource(drawable)
    }

    fun setButtonSelected(id: Int, flag: Boolean) {
        (findViewById<View>(id) as Button).isSelected = flag
    }

    fun isButtonSelected(id: Int): Boolean {
        return (findViewById<View>(id) as Button).isSelected
    }

    override fun onClick(arg0: View) {
        // TODO Auto-generated method stub
    }

    fun startActivity(activity: Activity, targetActivity: Class<*>?, closeCurrent: Boolean, closeAll: Boolean) {
        val intent = Intent(activity, targetActivity)
        if (closeAll) {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        activity.startActivity(intent)
        if (closeCurrent) {
            activity.finish()
        }
    }

    fun makeToast(message: String) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show()
    }

    fun openFragment(fragment: Fragment?, fragmentContainerId: Int) {
        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            fragmentTransaction.replace(fragmentContainerId, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    fun slideUp(viewId: Int) {
        val view = findViewById<View>(viewId)
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(
                0F,  // fromXDelta
                0F,  // toXDelta
                view.height.toFloat(),  // fromYDelta
                0F) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(viewId: Int) {
        val view = findViewById<View>(viewId)
        view.visibility = View.GONE
        val animate = TranslateAnimation(
                0F,  // fromXDelta
                0F,  // toXDelta
                0F,  // fromYDelta
                view.height.toFloat()) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun showBottomMessage(view: View?, message: String?) {
        val snackbar = Snackbar.make(view!!, message!!, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        val currentDateTime: String
            get() {
                val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
                val date = Date()
                return dateFormat.format(date)
            }

        fun calculateCurrentDate() {
            val localCalendar = Calendar.getInstance(TimeZone.getDefault())
            val currentTime = localCalendar.time
            val currentDay = localCalendar[Calendar.DATE]
            val currentMonth = localCalendar[Calendar.MONTH] + 1
            val currentYear = localCalendar[Calendar.YEAR]
            val currentDayOfWeek = localCalendar[Calendar.DAY_OF_WEEK]
            val currentDayOfMonth = localCalendar[Calendar.DAY_OF_MONTH]
            val CurrentDayOfYear = localCalendar[Calendar.DAY_OF_YEAR]
        }

        private fun calculateCurrentDay() {
            val calendar = Calendar.getInstance()
            val day = calendar[Calendar.DAY_OF_WEEK]
            when (day) {
                Calendar.SUNDAY -> {
                }
                Calendar.MONDAY -> {
                }
                Calendar.TUESDAY -> {
                }
            }
        }

        /*    public static View avoidDoubleClicks(){

        long DELAY_IN_MS = 900;
        if (View.)

    }*/
        fun avoidDoubleClicks(`$this$avoidDoubleClicks`: View) {
            Intrinsics.checkParameterIsNotNull(`$this$avoidDoubleClicks`, "\$this\$avoidDoubleClicks")
            val DELAY_IN_MS = 900L
            if (`$this$avoidDoubleClicks`.isClickable) {
                `$this$avoidDoubleClicks`.isClickable = false
                `$this$avoidDoubleClicks`.postDelayed(Runnable { `$this$avoidDoubleClicks`.isClickable = true }, DELAY_IN_MS)
            }
        }


    }

    /*private fun checkNumberEmail(context: Context){
        val text : String = etEmailAddress.text!!.trim().toString()
        val digitsOnly = TextUtils.isDigitsOnly(text)

        if (digitsOnly) {
            if (text.isEmpty()) {
                Toast.makeText(context, "field can't be empty.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "field is int value", Toast.LENGTH_LONG).show()
            }
        }else {
            //Toast.makeText(applicationContext, "Field is string value", Toast.LENGTH_LONG).show()
        }
    }*/

    fun noInternetConnection(view: View) {

        /*After setting the adapter use the timer */
        val handler = Handler()
        val Update = Runnable {
            showBottomMessage(view, "No Internet Connection")
        }

        val timer = Timer() // This will create a new Thread

        timer.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, 500, 3000)
    }
}