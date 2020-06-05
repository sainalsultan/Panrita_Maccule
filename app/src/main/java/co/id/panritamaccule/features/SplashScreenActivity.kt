package co.id.panritamaccule.features

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import co.id.panritamaccule.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private val openingSound by lazy { MediaPlayer.create(this, R.raw.opening) }
    private val backSound by lazy { MediaPlayer.create(this, R.raw.back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val anim = TranslateAnimation(0F,0F,-100F,0F)
        anim.startOffset = 0
        anim.duration = 1000
        anim.fillAfter = true
        anim.interpolator = BounceInterpolator()
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {
                openingSound.start()
            }

        })
        logo.startAnimation(anim)


        Handler().postDelayed({
            startActivity(Intent(this,
                MainActivity::class.java))
            finish()
            backSound.start()
        },3000)
    }
}
