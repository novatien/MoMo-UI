package com.notin.momotest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notin.momotest.R
import com.notin.momotest.model.ItemMenu
import kotlinx.android.synthetic.main.item_menu_layout.view.*

class CustomMenuAdapter(context: Context, listMenu:ArrayList<ItemMenu>): RecyclerView.Adapter<CustomMenuAdapter.MyView>(){
    var context = context
    var listMenu = listMenu
    class MyView(view: View): RecyclerView.ViewHolder(view){
        var imgItemMenu = view.findViewById<ImageView>(R.id.imgItemMenu)
        var txtNameItemMenu = view.findViewById<TextView>(R.id.txtNameItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemView.imgItemMenu.setImageResource(listMenu[position].idImage)
        holder.itemView.txtNameItem.text = listMenu[position].name
    }

    override fun getItemCount(): Int {
         return listMenu.size
    }
}