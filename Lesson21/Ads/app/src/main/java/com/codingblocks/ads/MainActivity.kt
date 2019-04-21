package com.codingblocks.ads

import android.content.Intent
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adView.loadAd(
            AdRequest.Builder()
//            .addKeyword("tech")
                .build()
        )

        val rewardedVideo = RewardedAd(
            this,
            "ca-app-pub-3940256099942544/5224354917"
        )

        btnRewarded.setOnClickListener {
            rewardedVideo.loadAd(AdRequest.Builder()
//            .addKeyword("tech")
                .build(), object : RewardedAdLoadCallback() {
                override fun onRewardedAdLoaded() {
                    super.onRewardedAdLoaded()
                    rewardedVideo.show(this@MainActivity, object : RewardedAdCallback() {

                        override fun onUserEarnedReward(rewardItem: RewardItem) {
                            super.onUserEarnedReward(rewardItem)
                            Log.e("TAG", rewardItem.amount.toString())
                        }

                    })
                }
            })
        }

        val mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"

        btnInterstitial.setOnClickListener {
            mInterstitialAd.loadAd(AdRequest.Builder().build())
            startActivity(Intent(this, NewActivity::class.java))
        }

        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                mInterstitialAd.show()
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        }

    }
}


/**
 * Coordinator Layout and Toolbar
 * LiveData and ViewModel
 * Publishing to Google Play
 * Debugging with Gradle
 */
