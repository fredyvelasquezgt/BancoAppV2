package com.example.bancov2

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView

public class introductoryActivity : AppCompatActivity() {
    lateinit var fondo: ImageView
    lateinit var logo: LottieAnimationView
    lateinit var viewPager: ViewPager
    lateinit var pagerAdapter: ScreenSlidePagerAdapter



    
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)

        fondo = findViewById(R.id.img)
        logo = findViewById(R.id.lottie)

        viewPager = findViewById(R.id.pager)
        pagerAdapter = ScreenSlidePagerAdapter(getSupportFragmentManager())
        viewPager.setAdapter(pagerAdapter)
        fondo.animate().translationY(-40000f).setDuration(1000).setStartDelay(4000)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    val myintent:Intent = Intent(this@introductoryActivity, MainActivity::class.java)
                    startActivity(myintent)
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            }).start()
        logo.animate().translationY(1900f).setDuration(1000).setStartDelay(4000);


    }

    class ScreenSlidePagerAdapter:
        FragmentStatePagerAdapter {
        constructor(fm: FragmentManager) : super(fm)
        override fun getCount(): Int {
            return 0;
        }

        override fun getItem(position: Int): Fragment {
            var tab:BoardingPage = BoardingPage()
            return  tab;
        }

    }

}