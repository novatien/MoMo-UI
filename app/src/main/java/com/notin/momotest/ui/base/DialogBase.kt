package com.notin.momotest.ui.base

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import com.notin.momotest.R
import kotlinx.android.synthetic.main.dialog_base_layout.*

class DialogBase:Dialog {
    constructor(context:Context):super(context){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setContentView(R.layout.dialog_base_layout)
        this.setCanceledOnTouchOutside(false)
        this.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }
    fun setInfo(title:String, content:String){
        this.txtTitle.text = title
        this.txtContent.text = content
    }
}