package com.example.originalmarines.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.originalmarines.R
import com.example.originalmarines.adapter.viewpager.HomeBannerPagerAdapter
import com.example.originalmarines.adapter.viewpager.HomeCategoriesAdapter
import com.example.originalmarines.adapter.viewpager.ProductPagerAdapter
import com.example.originalmarines.adapter.viewpager.ShopLooksPagerAdapter
import com.example.originalmarines.base.BaseFragment
import com.example.originalmarines.modal.HomeBannerModal
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by Anubhav Jangid
 */
class HomeFragment : BaseFragment() {

    private var homeBannerPagerAdapter : HomeBannerPagerAdapter? = null
    private var homeCategoriesAdapter : HomeCategoriesAdapter? = null
    private var homeProductAdapter : ProductPagerAdapter? = null
    private var shopByLooksAdapter : ShopLooksPagerAdapter? = null
    private var homeBannerList : ArrayList<HomeBannerModal>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUiViews()

        tvPromo.setOnClickListener {
            val promoFragment = PromoFragment()
            replaceFragment(promoFragment)
        }

    }

    private fun bindUiViews(){
        setViewPagerBanner()
        setViewPagerCategories()
        setViewPagerProduct()
        setViewPagerLooks()
    }

    private fun setViewPagerBanner(){
        homeBannerList = ArrayList()
        setViewPagerData()
        homeBannerPagerAdapter = HomeBannerPagerAdapter(homeBannerList!!, activity!!)
        viewPagerBanner.adapter = homeBannerPagerAdapter
        viewPagerBanner.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    private fun setViewPagerCategories(){
        homeBannerList = ArrayList()
        setViewPagerData()
        homeCategoriesAdapter = HomeCategoriesAdapter(homeBannerList!!, activity!!)
        viewPagerCategories.adapter = homeCategoriesAdapter
        tabLayoutViewPager.setupWithViewPager(viewPagerCategories)
        viewPagerCategories.addOnPageChangeListener(viewPagerPageChangeListener)
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

    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                // your logic here
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // your logic here
            }

            override fun onPageSelected(position: Int) {
                // your logic here
            }
        }

    private fun setViewPagerProduct(){
        homeBannerList = ArrayList()
        setViewPagerData()
        homeProductAdapter = ProductPagerAdapter(homeBannerList!!, activity!!)
        viewPagerProducts.adapter = homeProductAdapter
        tabLayoutViewPagerProd.setupWithViewPager(viewPagerProducts)
        viewPagerProducts.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    private fun setViewPagerLooks(){
        homeBannerList = ArrayList()
        setViewPagerData()
        shopByLooksAdapter = ShopLooksPagerAdapter(homeBannerList!!, activity!!)
        viewPagerLook.adapter = shopByLooksAdapter
        tabLayoutViewPagerLook.setupWithViewPager(viewPagerLook)
        viewPagerProducts.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.scrollViewFrame, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}