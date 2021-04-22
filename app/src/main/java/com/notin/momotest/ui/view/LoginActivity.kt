package com.notin.momotest.ui.view

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import com.notin.momotest.R
import com.notin.momotest.data.ManagerData
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_submit_phone.*
import java.util.regex.Pattern

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var managerData: ManagerData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        listenter()
    }
    fun init(){
        managerData = ManagerData(this)
    }

    fun listenter(){
        edtPhoneNumber.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txtToast.visibility = View.GONE
               if(s!!.isEmpty()){
                  btnClearText.visibility = View.GONE
               }else{
                   btnClearText.visibility = View.VISIBLE
               }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        btnClearText.setOnClickListener {
            edtPhoneNumber.setText("")
        }

        btnContinue.setOnClickListener {
            var phoneNumber = edtPhoneNumber.text.toString().trim()
           if(phoneNumber==""){
               txtToast.text = resources.getString(R.string.not_enter_phone)
               txtToast.visibility = View.VISIBLE
           }else{
               if(checkPhoneNumber(phoneNumber)){
                   //phone correct
                   handlingPhoneNumber(phoneNumber)
               }else{
                   //phone incorrect
                   txtToast.text = resources.getString(R.string.phone_number_incorrect)
                   txtToast.visibility = View.VISIBLE
               }
           }
        }
    }

    fun checkPhoneNumber(phoneNumber: String):Boolean{
        var regex = "\\d{10,11}"
        return Pattern.matches(regex, phoneNumber)
    }

    fun handlingPhoneNumber(phoneNumber: String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_submit_phone)
        dialog.setCanceledOnTouchOutside(false)
     //   dialog.window!!.setLayout(WindowManager.LayoutParams., WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.txtPhoneNumber.text = phoneNumber
        dialog.show()
        dialog.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.btnCallMe.setOnClickListener {

        }
        val handler = Handler().postDelayed({
            ManagerData.phone = phoneNumber
            dialog.dismiss()
            if(managerData.checkPhoneExist(phoneNumber)){
                  val intent = Intent(this, LoginPasswordActivity::class.java)
                  startActivity(intent)
//                dialog.window!!.setBackgroundDrawableResource(R.drawable.custom_rect_white_rad_20)
//                dialog.progressBar.visibility = View.GONE
//                dialog.clToast.visibility = View.VISIBLE
            }else{

                val intent = Intent(this, AccuracyActivity::class.java)
                startActivity(intent)
            }
        },1000)

    }
}