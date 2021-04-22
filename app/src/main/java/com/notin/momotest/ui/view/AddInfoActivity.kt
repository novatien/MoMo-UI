package com.notin.momotest.ui.view

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.notin.momotest.R
import com.notin.momotest.data.ManagerData
import kotlinx.android.synthetic.main.activity_add_info.*
import java.util.regex.Pattern

class AddInfoActivity : AppCompatActivity() {
    private var isGenderMale = true
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)
        listener()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun listener(){
        btnGenderMale.setOnClickListener {
            isGenderMale = true
            changeBackgroundGender()
        }
        btnGenderFemale.setOnClickListener {
            isGenderMale = false
            changeBackgroundGender()
        }

        btnContinue.setOnClickListener {
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            if(name=="" || email == ""){
                txtToast.visibility = View.VISIBLE
                txtToast.text = " Vui lòng nhập đầy đủ thông tin!"
            }else{
                val regex = "^(.+)@(.+)$"
                if(Pattern.matches(regex, email)){
                      ManagerData(this).addInfoUser(name, email)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    txtToast.text = "Vui lòng nhập đúng định dạng email!"
                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun changeBackgroundGender(){
        if(isGenderMale){
            var drawableMale = ContextCompat.getDrawable(this, R.drawable.custom_gender_male_select)
            var drawableFemale = ContextCompat.getDrawable(this, R.drawable.custom_gender_female)
            btnGenderMale.setTextColor(Color.WHITE)
            btnGenderMale.compoundDrawables[0].setTint(Color.WHITE)
            btnGenderFemale.setTextColor(Color.BLACK)
            btnGenderFemale.compoundDrawables[0].setTint(Color.BLACK)
            btnGenderMale.background = drawableMale
            btnGenderFemale.background = drawableFemale
        }else{
            var drawableMale = ContextCompat.getDrawable(this, R.drawable.custom_gender_male)
            var drawableFemale = ContextCompat.getDrawable(this, R.drawable.custom_gender_female_select)
            btnGenderMale.setTextColor(Color.BLACK)
            btnGenderMale.compoundDrawables[0].setTint(Color.BLACK)
            btnGenderFemale.setTextColor(Color.WHITE)
            btnGenderFemale.compoundDrawables[0].setTint(Color.WHITE)
            btnGenderMale.background = drawableMale
            btnGenderFemale.background = drawableFemale
        }
    }
}