package com.notin.momotest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notin.momotest.R
import com.notin.momotest.model.ItemBrand
import com.notin.momotest.model.ItemMenu
import kotlinx.android.synthetic.main.item_menu_layout.view.*
import kotlinx.android.synthetic.main.item_outstanding_brand.view.*

class CustomBrandAdapter(context: Context, listMenu:ArrayList<ItemBrand>): RecyclerView.Adapter<CustomBrandAdapter.MyView>(){
    var context = context
    var listMenu = listMenu
    class MyView(view: View): RecyclerView.ViewHolder(view){
        var imgBrand = view.findViewById<ImageView>(R.id.imgBrand)
        var txtNameBrand = view.findViewById<TextView>(R.id.txtNameBrand)
        var txtEndow = view.findViewById<TextView>(R.id.txtEndow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_outstanding_brand, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemView.imgBrand.setImageResource(listMenu[position].idImage)
        holder.itemView.txtNameBrand.text = listMenu[position].name
        holder.itemView.txtEndow.text = listMenu[position].endow
    }

    override fun getItemCount(): Int {
         return listMenu.size
    }
}