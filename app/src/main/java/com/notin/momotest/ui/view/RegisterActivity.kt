package com.notin.momotest.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.notin.momotest.R
import com.notin.momotest.data.ManagerData
import kotlinx.android.synthetic.main.activity_accuracy.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.btnContinue
import kotlinx.android.synthetic.main.activity_register.txtToast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        listener()
    }

    fun listener(){
        btnContinue.setOnClickListener {
            var pass1 = edtPassword.text.toString().trim()
            var pass2 = edtPasswordAgain.text.toString().trim()
            if(pass1=="" || pass2 == ""){
               showToastEnterPass("Vui lòng không để trống!")
            }else{
                if(!checkNumberPassword(pass1) || !checkNumberPassword(pass2)){
                    showToastEnterPass("Mật khẩu có 6 chữ số. Vui lòng nhập đúng!")
                }else{
                    if(pass1 != pass2){
                        showToastEnterPass("Mật khẩu không khớp")
                    }else{
                        ManagerData(this).addUser(pass1)
                        val intent = Intent(this, AddInfoActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    fun checkNumberPassword(input: String):Boolean{
        val pattern = "\\d{6}"
        return Pattern.matches(pattern, input)
    }
    fun showToastEnterPass(content: String){
        txtToast.visibility = View.VISIBLE
        txtToast.text = content
    }
}