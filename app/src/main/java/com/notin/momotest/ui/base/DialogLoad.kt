package com.notin.momotest.ui.base

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.notin.momotest.R

class DialogLoad:Dialog {
    constructor(context: Context) : super(context) {
        this.setCanceledOnTouchOutside(false)
        this.setContentView(R.layout.dialog_load)
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
    }
}