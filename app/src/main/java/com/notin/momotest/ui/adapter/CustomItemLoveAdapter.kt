package com.notin.momotest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notin.momotest.R
import com.notin.momotest.model.ItemLove
import kotlinx.android.synthetic.main.dialog_base_layout.view.*
import kotlinx.android.synthetic.main.item_menu_can_love.view.*

class CustomItemLoveAdapter(context: Context, listMenu:ArrayList<ItemLove>): RecyclerView.Adapter<CustomItemLoveAdapter.MyView>(){
    var context = context
    var listMenu = listMenu
    class MyView(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_can_love, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val itemLove = listMenu[position]
        holder.itemView.imgItemLove.setImageResource(itemLove.idImage)
        holder.itemView.txtItemTitle.text = itemLove.title
        holder.itemView.txtItemTime.text = itemLove.time
    }

    override fun getItemCount(): Int {
         return listMenu.size
    }
}