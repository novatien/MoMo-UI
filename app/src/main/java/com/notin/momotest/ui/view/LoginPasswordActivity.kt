package com.notin.momotest.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.notin.momotest.R
import com.notin.momotest.data.ManagerData
import kotlinx.android.synthetic.main.activity_login_password.*

class LoginPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_password)

        btnContinue.setOnClickListener {
            val pass = edtPassword.text.toString().trim()
            if(pass.length<6){
                txtToast.text = "Vui lòng nhập mật khẩu gồm 6 số!"
            }else{
                val data = ManagerData(this)
                if(data.login(ManagerData.phone, pass)){
                     if(data.checkInfo()){
                         val intent = Intent(this, MainActivity::class.java)
                         startActivity(intent)
                     }else{
                         val intent = Intent(this, AddInfoActivity::class.java)
                         startActivity(intent)
                     }
                }else{
                    txtToast.text = "Mật khẩu sai!"
                }
            }
        }
    }
}