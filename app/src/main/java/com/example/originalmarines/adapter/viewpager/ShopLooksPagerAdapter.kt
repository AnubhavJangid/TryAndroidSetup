package com.example.originalmarines.adapter.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.originalmarines.R
import com.example.originalmarines.modal.HomeBannerModal
import java.util.*

class ShopLooksPagerAdapter(private val homeBannerModal: ArrayList<HomeBannerModal>, private val context: Context) : PagerAdapter()
{

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val obj: HomeBannerModal = homeBannerModal[position]
        val layoutInflater = LayoutInflater.from(context)
        val layout: View = layoutInflater.inflate(R.layout.layout_shop_by_looks, container, false)

        /*Glide.with(context)
            .load(obj.banner_image)
            .apply(RequestOptions().placeholder(R.drawable.ic_image_place_holder).error(R.drawable.ic_image_place_holder))
            .dontAnimate()
            .into(bannerImage!!)*/
        container.addView(layout)
        return layout
    }

    override fun getCount(): Int {
        return homeBannerModal.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}