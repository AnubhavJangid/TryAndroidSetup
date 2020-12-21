package com.example.originalmarines.base

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.originalmarines.R

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class BaseFragmentActivity : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_splash, container, false)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity!!.finish()
                return true
            }
        }
        return true
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setTouchNClick(id: Int): View {
        val v = activity!!.findViewById<View>(id)
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
        val v = activity!!.findViewById<View>(id)
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
        (activity!!.findViewById<View>(id) as EditText).setText(text)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getEditTextText(id: Int): String {
        return (activity!!.findViewById<View>(id) as EditText).text.toString()
                .trim { it <= ' ' }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getTextViewText(id: Int): String {
        return (activity!!.findViewById<View>(id) as TextView).text.toString()
                .trim { it <= ' ' }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getButtonText(id: Int): String {
        return (activity!!.findViewById<View>(id) as Button).text.toString()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun setButtonText(id: Int, text: String?) {
        (activity!!.findViewById<View>(id) as Button).text = text
    }

    fun replaceButtoImageWith(replaceId: Int, drawable: Int) {
        (activity!!.findViewById<View>(replaceId) as Button)
                .setBackgroundResource(drawable)
    }

    fun setButtonSelected(id: Int, flag: Boolean) {
        (activity!!.findViewById<View>(id) as Button).isSelected = flag
    }

    fun isButtonSelected(id: Int): Boolean {
        return (activity!!.findViewById<View>(id) as Button).isSelected
    }

    override fun onClick(arg0: View) {
        // TODO Auto-generated method stub
    }
}