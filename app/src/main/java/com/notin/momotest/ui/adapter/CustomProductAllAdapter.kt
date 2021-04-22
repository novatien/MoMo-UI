package com.notin.momotest.ui.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notin.momotest.R
import com.notin.momotest.model.ItemBrand
import com.notin.momotest.model.ItemMenu
import com.notin.momotest.model.ItemProduct
import com.notin.momotest.util.Const
import kotlinx.android.synthetic.main.item_menu_layout.view.*
import kotlinx.android.synthetic.main.item_outstanding_brand.view.*
import kotlinx.android.synthetic.main.item_product.view.*

class CustomProductAllAdapter(context: Context, listProducts:ArrayList<ItemProduct>): RecyclerView.Adapter<CustomProductAllAdapter.MyView>(){
    var context = context
    var listProducts = listProducts
    class MyView(view: View): RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product_all, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val product = listProducts[position]
        holder.itemView.imgProduct.setImageResource(product.imageId)
        holder.itemView.txtNameProduct.text = product.name
        holder.itemView.txtStarProduct.text = product.star.toString()
        holder.itemView.txtCustomerProduct.text = product.customer.toString()
        holder.itemView.txtPriceDiscountProduct.text = Const.convertNumberToPrice(product.priceDiscount)
        holder.itemView.txtUnitPriceProduct.text = Html.fromHtml("<del>"+Const.convertNumberToPrice(product.priceUnit)+"</del>")
        holder.itemView.txtDiscountProduct.text = "-${product.discount}%"
    }

    override fun getItemCount(): Int {
         return listProducts.size
    }
}