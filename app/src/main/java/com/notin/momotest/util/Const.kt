package com.notin.momotest.util

class Const {
    companion object{
        fun convertNumberToPrice(number: Int):String{
            val s = (String.format("%,d", number)).replace(',', '.')
            return "${s}đ"
        }
    }
}