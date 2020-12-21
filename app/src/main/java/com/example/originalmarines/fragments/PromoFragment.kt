package com.example.originalmarines.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.originalmarines.R
import com.example.originalmarines.adapter.viewpager.HomeCategoriesAdapter
import com.example.originalmarines.modal.HomeBannerModal
import kotlinx.android.synthetic.main.fragment_promo.*

/**
 * Created by Anubhav Jangid
 */
class PromoFragment : Fragment() {

    private var homeBannerList : ArrayList<HomeBannerModal>? = null
    private var homeCategoriesAdapter : HomeCategoriesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUiViews()
    }

    private fun bindUiViews(){
        setViewPagerPromo()
        ivClose.setOnClickListener {

        }
    }

    private fun setViewPagerPromo(){
        homeBannerList = ArrayList()
        setViewPagerData()
        homeCategoriesAdapter = HomeCategoriesAdapter(homeBannerList!!, activity!!)
        viewPagerPromo.adapter = homeCategoriesAdapter
        tabLayoutViewPagerPromo.setupWithViewPager(viewPagerPromo)
    }

    private fun setViewPagerData(){
        val homeBannerModal = HomeBannerModal()
        homeBannerModal.banner_id = 1
        homeBannerModal.banner_name = "Name"
        homeBannerModal.banner_image = "https://www.originalmarines.com/media/wysiwyg/HP-BANNER/xmas-2020-banner-widget-BA1.jpg"
        homeBannerList?.add(homeBannerModal)
        homeBannerModal.banner_id = 1
        homeBannerModal.banner_name = "Name"
        homeBannerModal.banner_image = "https://www.originalmarines.com/media/wysiwyg/HP-BANNER/xmas-2020-banner-widget-BA1.jpg"
        homeBannerList?.add(homeBannerModal)
        homeBannerModal.banner_id = 1
        homeBannerModal.banner_name = "Name"
        homeBannerModal.banner_image = "https://www.originalmarines.com/media/wysiwyg/HP-BANNER/xmas-2020-banner-widget-BA1.jpg"
        homeBannerList?.add(homeBannerModal)
        homeBannerModal.banner_id = 1
        homeBannerModal.banner_name = "Name"
        homeBannerModal.banner_image = "https://www.originalmarines.com/media/wysiwyg/HP-BANNER/xmas-2020-banner-widget-BA1.jpg"
        homeBannerList?.add(homeBannerModal)
    }
}