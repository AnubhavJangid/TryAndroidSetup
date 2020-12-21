package com.example.originalmarines.adapter.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.originalmarines.R
import com.example.originalmarines.modal.HomeBannerModal
import com.example.originalmarines.util.loadImage
import java.util.*

class HomeCategoriesAdapter(private val homeBannerModal: ArrayList<HomeBannerModal>, private val context: Context) : PagerAdapter()
{

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = LayoutInflater.from(context)
        val layout: View = layoutInflater.inflate(R.layout.layout_home_category, container, false)

        val obj: HomeBannerModal = homeBannerModal[position]
        val bannerImage = layout.findViewById(R.id.ivBannerImage) as ImageView

        //bannerImage.loadImage(homeBannerModal[position].banner_image.toString(), R.drawable.ic_image_place_holder)

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