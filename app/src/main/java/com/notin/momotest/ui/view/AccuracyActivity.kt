package com.notin.momotest.ui.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.app.NotificationCompat
import com.notin.momotest.R
import com.notin.momotest.ui.base.DialogBase
import com.notin.momotest.ui.base.DialogLoad
import kotlinx.android.synthetic.main.activity_accuracy.*
import kotlinx.android.synthetic.main.dialog_base_layout.*
import kotlin.random.Random

class AccuracyActivity : AppCompatActivity() {
    private var code = 0
    private var timeSend = 0
    private var numberEnter = 3
    private lateinit var dialogLoad: DialogLoad
    private  lateinit var dialogBase: DialogBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accuracy)
        sendCode()
        init()
        listener()
    }
    fun init(){
        dialogLoad = DialogLoad(this)
        dialogBase = DialogBase(this)
    }
    fun sendCode(){
        if(timer != null){
            timer.cancel()
        }
        txtOTP.setTextColor(Color.parseColor("#E6D5DB"))
        txtConfirmTime.visibility = View.VISIBLE

        numberEnter = 3
        code = Random.nextInt(100000, 1000000)
        timeSend = Random.nextInt(50,55)
        timer.start()
    }

    val timer  = object:CountDownTimer(60000,1000){
        override fun onTick(millisUntilFinished: Long) {
            var time = (millisUntilFinished/1000).toInt()
            txtConfirmTime.text = "(00:$time)"
            if(time == timeSend){
                showNotificationVeritification()
                edtVerificationCodes.setText(code.toString())
            }
        }

        override fun onFinish() {
            txtOTP.setTextColor(Color.WHITE)
            txtConfirmTime.visibility = View.GONE
            txtOTP.setOnClickListener {
                dialogBase.setInfo("GỬI LẠI OTP", "Nếu bạn chưa nhận được mã OTP. Bạn có muốn nhận lại mã OTP không?")
                dialogBase.show()
                dialogBase.btnYes.setOnClickListener {
                    sendCode()
                    dialogBase.dismiss()
                }
                dialogBase.btnCancel.setOnClickListener {
                    dialogBase.dismiss()
                }
            }
        }

    }

    fun listener(){
        btnContinue.setOnClickListener {
            var codeVertification = edtVerificationCodes.text.toString().trim()
            if(codeVertification==""){
                showToastEnterCode("Vui lòng nhập mã xác thực")
            }else{
                dialogLoad.show()
                val handler = Handler().postDelayed({
                    if(code.toString() == codeVertification){
                        val intent = Intent(this, RegisterActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }else{
                        numberEnter--
                        if(numberEnter == 0){
                            edtVerificationCodes.setText("")
                            txtToast.visibility = View.GONE
                            dialogBase.setInfo("GỬI LẠI OTP","Bạn đã nhập sai mã OTP quá 3 lần. Bạn muốn nhận lại mã không?")
                            dialogBase.btnCancel.visibility = View.GONE
                            dialogBase.show()
                            dialogBase.btnYes.setOnClickListener {
                                sendCode()
                                dialogBase.dismiss()
                            }
                        }else{
                            showToastEnterCode("Mã xác thực không chính xác bạn còn $numberEnter lần thử.")
                        }
                    }
                    dialogLoad.dismiss()
                },1000)
            }


        }

        btnClearText.setOnClickListener {
            edtVerificationCodes.setText("")
        }

        edtVerificationCodes.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s!!.isNotEmpty()){
                    btnClearText.visibility = View.VISIBLE
                    txtToast.visibility = View.GONE
                }else{
                    btnClearText.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
    fun showToastEnterCode(content: String){
        txtToast.visibility = View.VISIBLE
        txtToast.text = content
    }


    fun showNotificationVeritification(){
         val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
         val CHANNEL_ID = "VERITIFICATION_01"
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChanel = NotificationChannel(CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChanel)

        }

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
        notificationBuilder.setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle("MoMo")
                .setContentText("$code la ma xac thuc OTP dang ky MoMo. De tranh bi mat tien, tuyet doi KHONG chia se ma nay voi bat ky ai.")
        notificationManager.notify(1, notificationBuilder.build())
    }
}