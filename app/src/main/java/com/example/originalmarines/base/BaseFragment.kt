package com.example.originalmarines.base

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.originalmarines.R
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.jvm.internal.Intrinsics

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
abstract class BaseFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(getActivity()));
        return inflater.inflate(R.layout.activity_splash, container, false)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().finish()
                return true
            }
        }
        return true
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setTouchNClick(id: Int): View {
        val v = requireActivity().findViewById<View>(id)
        v.setOnClickListener(this)
        return v
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setClick(id: Int, rootView: View): View {
        val v = rootView.findViewById<View>(id)
        v.setOnClickListener(this)
        return v
    }

    fun setViewEnable(id: Int, flag: Boolean) {
        val v = requireActivity().findViewById<View>(id)
        v.isEnabled = flag
    }

    @SuppressLint("NewApi")
    fun setViewVisibility(id: Int, flag: Int, view: View) {
        val v = view.findViewById<View>(id)
        v.visibility = flag
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setTextViewText(id: Int, text: String?, v: View) {
        (v.findViewById<View>(id) as TextView).text = text
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setEditText(id: Int, text: String?) {
        (requireActivity().findViewById<View>(id) as EditText).setText(text)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setCheckBox(id: Int, checkFlag: Boolean) {
        (requireActivity().findViewById<View>(id) as CheckBox).isChecked = checkFlag
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getCheckBoxState(id: Int, checkBoxValue: String?): String? {
        var checkBoxValue = checkBoxValue
        if (!(requireActivity().findViewById<View>(id) as CheckBox).isChecked) {
            checkBoxValue = ""
        }
        return checkBoxValue
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getEditTextText(id: Int): String {
        return (requireActivity().findViewById<View>(id) as EditText).text.toString()
                .trim { it <= ' ' }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getTextViewText(id: Int): String {
        return (requireActivity().findViewById<View>(id) as TextView).text.toString()
                .trim { it <= ' ' }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getButtonText(id: Int): String {
        return (requireActivity().findViewById<View>(id) as Button).text.toString()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setButtonText(id: Int, text: String?) {
        (requireActivity().findViewById<View>(id) as Button).text = text
    }

    fun replaceButtonImageWith(replaceId: Int, drawable: Int) {
        (requireActivity().findViewById<View>(replaceId) as Button)
                .setBackgroundResource(drawable)
    }

    fun setButtonSelected(id: Int, flag: Boolean) {
        (requireActivity().findViewById<View>(id) as Button).isSelected = flag
    }

    fun isButtonSelected(id: Int): Boolean {
        return (requireActivity().findViewById<View>(id) as Button).isSelected
    }

    fun isCheckBoxChecked(id: Int): Boolean {
        return (requireActivity().findViewById<View>(id) as CheckBox).isChecked
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
        Toast.makeText(activity, "" + message, Toast.LENGTH_SHORT).show()
    }

    fun slideUp(view: View) {
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
    fun slideDown(view: View) {
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
        val snackbar = Snackbar.make(requireView(), message!!, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    /**
     * Could handle back press.
     * @return true if back press was handled
     */
    fun onBackPressed(): Boolean {
        return false
    }

    companion object {
        fun avoidDoubleClicks(`$this$avoidDoubleClicks`: View) {
            Intrinsics.checkParameterIsNotNull(`$this$avoidDoubleClicks`, "\$this\$avoidDoubleClicks")
            val DELAY_IN_MS = 900L
            if (`$this$avoidDoubleClicks`.isClickable) {
                `$this$avoidDoubleClicks`.isClickable = false
                `$this$avoidDoubleClicks`.postDelayed(Runnable { `$this$avoidDoubleClicks`.isClickable = true }, DELAY_IN_MS)
            }
        }
    }

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