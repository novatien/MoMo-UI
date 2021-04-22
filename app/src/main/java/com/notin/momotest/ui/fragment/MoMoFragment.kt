package com.notin.momotest.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.notin.momotest.R
import com.notin.momotest.model.ItemLove
import com.notin.momotest.model.ItemMenu
import com.notin.momotest.ui.adapter.CustomItemLoveAdapter
import com.notin.momotest.ui.adapter.CustomMenuAdapter
import kotlinx.android.synthetic.main.fragment_momo.*


class MoMoFragment : Fragment() {
    private lateinit var listItems : ArrayList<ItemMenu>
    private lateinit var listItemOffer: ArrayList<ItemMenu>
    private lateinit var listItemService: ArrayList<ItemMenu>
    private lateinit var listItemLove: ArrayList<ItemLove>
    private lateinit var custemMenuAdapter: CustomMenuAdapter
    private lateinit var custemMenuOfferAdapter: CustomMenuAdapter
    private lateinit var custemMenuServiceAdapter: CustomMenuAdapter
    private lateinit var custemMenuLoveAdapter: CustomItemLoveAdapter
    private lateinit var collapseMenu :Menu
    private var isFinishScroll = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_momo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context as AppCompatActivity).setSupportActionBar(toolbar)
        (context as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(false)
        init()
        listener()
    }

    fun init(){
        listItems = ArrayList()
        listItems.add(ItemMenu(R.drawable.phone_recharge, "Nạp tiền điện thoại"))
        listItems.add(ItemMenu(R.drawable.transfers, "Chuyển tiền"))
        listItems.add(ItemMenu(R.drawable.buy_card_code, "Mua mã thẻ di động"))
        listItems.add(ItemMenu(R.drawable.piggy, "Heo đất MoMo"))
        listItems.add(ItemMenu(R.drawable.pay_the_bill, "Thanh toán hóa đơn"))
        listItems.add(ItemMenu(R.drawable.data34g, "Data 3G/4G"))
        listItems.add(ItemMenu(R.drawable.ticket_film, "Mua vé xem phim"))
        listItems.add(ItemMenu(R.drawable.travel, "Du lịch - Đi lại"))

        custemMenuAdapter = CustomMenuAdapter(activity as Context, listItems)
        var gridLayoutManager = GridLayoutManager(activity as Context, 4)
        rvItemMenuFavourite.layoutManager = gridLayoutManager
        rvItemMenuFavourite.adapter = custemMenuAdapter

        listItemOffer = ArrayList()
        listItemOffer.add(ItemMenu(R.drawable.vinaphone, "Trả trước\nVinaphone"))
        listItemOffer.add(ItemMenu(R.drawable.di_bo, "Đi bộ cùng\nMoMo"))
        listItemOffer.add(ItemMenu(R.drawable.gioi_thieu, "Giới thiệu\nMoMo"))
        listItemOffer.add(ItemMenu(R.drawable.thanh_toan, "Thanh toán\nLazada"))
        listItemOffer.add(ItemMenu(R.drawable.cong_duc, "Phát Tâm\nCông Đức"))
        listItemOffer.add(ItemMenu(R.drawable.tiki, "Thanh toán\nTiki"))
        listItemOffer.add(ItemMenu(R.drawable.goject, "Nạp tiền tài\nxế Gojek"))
        listItemOffer.add(ItemMenu(R.drawable.bao_hiem_xe_may, "Bảo hiểm xe\nmáy bắt buộc"))

        custemMenuOfferAdapter = CustomMenuAdapter(activity as Context, listItemOffer)
        rvItemMenuOffer.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        rvItemMenuOffer.adapter = custemMenuOfferAdapter

        listItemService = ArrayList()
        listItemService.add(ItemMenu(R.drawable.chuyen_nhan_tien, "Chuyển nhận\ntiền"))
        listItemService.add(ItemMenu(R.drawable.du_lich, "Du lịch"))
        listItemService.add(ItemMenu(R.drawable.thanh_toan_hoa_don, "Thanh toán\nhóa đơn"))
        listItemService.add(ItemMenu(R.drawable.dich_vu_lien_ket, "Dịch vụ\nliên kết"))
        listItemService.add(ItemMenu(R.drawable.tien_ich_vien_thong, "Tiện ích viễn\nthông"))
        listItemService.add(ItemMenu(R.drawable.hoat_dong_cong_dong, "Hoạt động\ncộng đồng"))
        listItemService.add(ItemMenu(R.drawable.tai_chinh_bao_hiem, "Tài chính - Bảo\nhiểm"))
        listItemService.add(ItemMenu(R.drawable.thuong_mai_dien_tu, "Thương mại\nđiện tử"))
        listItemService.add(ItemMenu(R.drawable.dich_vu_khac, "Dịch vụ khác"))
        listItemService.add(ItemMenu(R.drawable.giai_tri, "Giải trí"))
        listItemService.add(ItemMenu(R.drawable.nap_tien_doi_tac, "Nạp tiền đối\ntác"))

        custemMenuServiceAdapter = CustomMenuAdapter(activity as Context, listItemService)
        rvItemMenuService.layoutManager = GridLayoutManager(activity as Context, 2, GridLayoutManager.HORIZONTAL, false)
        rvItemMenuService.adapter = custemMenuServiceAdapter


        listItemLove = ArrayList()
        listItemLove.add(ItemLove(R.drawable.love1, "Chọn nhóm - Đi bộ - Rước quà ngon!", "Còn 3 ngày"))
        listItemLove.add(ItemLove(R.drawable.love2, "Trả lời đố vui, khui Đồng Heo Vàng 1 chỉ", "Còn 1 ngày"))
        listItemLove.add(ItemLove(R.drawable.love3, "Nhập CGVMOMO - Săn 2 vé CGV chỉ 9K/vé!", "Còn 16 giờ"))
        listItemLove.add(ItemLove(R.drawable.love4, "Nhập mã HELLOMOMO nhận quà 500.000đ", "Còn 8 ngày"))
        custemMenuLoveAdapter = CustomItemLoveAdapter(activity as Context, listItemLove)
        rvCanLove.layoutManager = GridLayoutManager(activity as Context,2, GridLayoutManager.VERTICAL, false)
        rvCanLove.adapter = custemMenuLoveAdapter


    }

    fun listener(){
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if(Math.abs(verticalOffset) == appBarLayout.totalScrollRange){
                isFinishScroll = true
                (context as Activity).invalidateOptionsMenu()
            }else{
                if(isFinishScroll){
                    (context as Activity).invalidateOptionsMenu()
                    isFinishScroll = false
                }
            }
            val delta = ((verticalOffset + appBarLayout.totalScrollRange).toFloat()/appBarLayout.totalScrollRange)
            lnMenuMain.scaleX = delta
            lnMenuMain.scaleY = delta
            lnMenuMain.alpha = delta
            txtSearch.alpha = delta

            println("9999999999tien="+delta)
//            if(kotlin.math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0){
//
//            }
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        if(collapseMenu != null &&  isFinishScroll){
            if(collapseMenu.size()>2){
                //collapseMenu.removeItem(1000)
            }else{
                collapseMenu.add(Menu.NONE, 1000, 1, "TÌM KIẾM").setIcon(R.drawable.ic_search).setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_ALWAYS)
                collapseMenu.add(Menu.NONE, 1001, 2, "NẠP TIỀN").setIcon(R.drawable.recharge).setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_ALWAYS)
                collapseMenu.add(Menu.NONE, 1002, 3, "RÚT TIỀN").setIcon(R.drawable.withdrawal).setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_ALWAYS)
                collapseMenu.add(Menu.NONE, 1003, 4, "MÃ THANH TOÁN").setIcon(R.drawable.payment_code).setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_ALWAYS)
                collapseMenu.add(Menu.NONE, 1004, 5, "QUÉT MÃ").setIcon(R.drawable.code_scan).setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_ALWAYS)
            }
        }
        super.onPrepareOptionsMenu(menu)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (context as Activity).menuInflater.inflate(R.menu.menu_main, menu)
        collapseMenu = menu
        super.onCreateOptionsMenu(menu, inflater)
    }

}