package com.wx.architecture.code.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.wx.architecture.R

class ShowUIDialog : AppCompatDialog {

    lateinit var txt_loading_text: TextView

    constructor (context: Context) : super(context, R.style.Loading) {
        setContentView(R.layout.layout_loading)
        window?.run {
            txt_loading_text = findViewById(R.id.txt_loading_text)
            attributes.gravity = Gravity.CENTER
        }
    }

    fun show(showText: String) {
        txt_loading_text?.apply {
            if (showText.isNotEmpty()) {
                text = showText
                visibility = View.VISIBLE
            } else {
                visibility = View.GONE
            }
        }
        if (!isShowing()) {
            show()
        }
    }
}