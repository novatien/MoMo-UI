package com.notin.momotest.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.notin.momotest.R
import com.notin.momotest.model.ItemBrand
import com.notin.momotest.model.ItemMenu
import com.notin.momotest.model.ItemProduct
import com.notin.momotest.ui.adapter.CustomBrandAdapter
import com.notin.momotest.ui.adapter.CustomMenuAdapter
import com.notin.momotest.ui.adapter.CustomProductAllAdapter
import com.notin.momotest.ui.adapter.CustomSpecialOfferAdapter
import kotlinx.android.synthetic.main.fragment_endow.*
import kotlinx.android.synthetic.main.fragment_momo.*


class EndowFragment : Fragment() {

    private lateinit var listItems : ArrayList<ItemMenu>
    private lateinit var listBrands: ArrayList<ItemBrand>
    private lateinit var listProducts: ArrayList<ItemProduct>
    private lateinit var custemMenuAdapter: CustomMenuAdapter
    private lateinit var custemBrandAdapter: CustomBrandAdapter
    private lateinit var customSpecialOfferAdapter: CustomSpecialOfferAdapter
    private lateinit var customProductAllAdapter: CustomProductAllAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context as Activity).window.statusBarColor = ContextCompat.getColor(activity as Context, R.color.pink)
        init()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_endow, container, false)
    }

    fun init(){
        listItems = ArrayList()
        listItems.add(ItemMenu(R.drawable.doi_diem, "Đổi điểm"))
        listItems.add(ItemMenu(R.drawable.ca_phe, "Cà phê"))
        listItems.add(ItemMenu(R.drawable.nha_hang, "Nhà hàng"))
        listItems.add(ItemMenu(R.drawable.tra_sua, "Trà sữa"))
        listItems.add(ItemMenu(R.drawable.lam_dep, "Làm đẹp"))
        listItems.add(ItemMenu(R.drawable.giai_tri, "Giải trí"))
        listItems.add(ItemMenu(R.drawable.mua_sam, "Mua sắm"))
        listItems.add(ItemMenu(R.drawable.sieu_thi, "Siêu thị"))
        listItems.add(ItemMenu(R.drawable.cua_hang_tien_loi, "CH tiện lợi"))
        listItems.add(ItemMenu(R.drawable.xem_them, "Xem thêm"))

        custemMenuAdapter = CustomMenuAdapter(activity as Context, listItems)
        var gridLayoutManager = GridLayoutManager(activity as Context, 5)
        rvItemMenu.layoutManager = gridLayoutManager
        rvItemMenu.adapter = custemMenuAdapter

        listBrands = ArrayList()
        listBrands.add(ItemBrand(R.drawable.lotte, "Lotte Cinema", "3 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.aka, "AKA House - \nBuffet Nướng", "1 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.passio, "Passio Coffer", "1 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.shark, "Shark Market", "1 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.flower, "Flower Store", "2 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.vietnameeline, "Vietnam\nAirlines", "1 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.milano, "Milano\nPremium", "8 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.eleven, "7-Eleven", "3 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.tous, "TOUS les\nJOURS", "3 ưu đãi"))
        listBrands.add(ItemBrand(R.drawable.v_six, "V-SIXTYFOUR", "1 ưu đãi"))

        custemBrandAdapter = CustomBrandAdapter(activity as Context, listBrands)
        rvBrand.layoutManager = GridLayoutManager(activity as Context, 2, GridLayoutManager.HORIZONTAL, false)
        rvBrand.adapter = custemBrandAdapter

        listProducts = ArrayList()
        listProducts.add(ItemProduct(R.drawable.p1, "[Gas24h] Giảm 150K\n Giao Gas Tận Nhà",4.5f, 971,5000,150000,97))
        listProducts.add(ItemProduct(R.drawable.p2, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p3, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p4, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p5, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p6, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p7, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        listProducts.add(ItemProduct(R.drawable.p8, "[BE] Combo 1.200k\nCho Người Dùng ",4.8f, 396,10000,1200000,99))
        customSpecialOfferAdapter = CustomSpecialOfferAdapter(context as Activity, listProducts)
        rvSpecialOffer.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        rvSpecialOffer.adapter = customSpecialOfferAdapter

        rvSellingDeals.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        rvSellingDeals.adapter = customSpecialOfferAdapter

        customProductAllAdapter = CustomProductAllAdapter(activity as Context, listProducts)
        rvProductAll.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.VERTICAL, false)
        rvProductAll.adapter = customProductAllAdapter


    }

}