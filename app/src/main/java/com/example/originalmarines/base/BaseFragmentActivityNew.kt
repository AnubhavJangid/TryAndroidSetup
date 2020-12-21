package com.example.originalmarines.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.originalmarines.R

class BaseFragmentActivityNew : FragmentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return true
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

    fun setViewEnable(id: Int, flag: Boolean) {
        val v = findViewById<View>(id)
        v.isEnabled = flag
    }

    fun setViewVisibility(id: Int, flag: Int) {
        val v = findViewById<View>(id)
        v.visibility = flag
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
}