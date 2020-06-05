package co.id.panritamaccule

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import co.id.panritamaccule.utils.dialog
import co.id.panritamaccule.utils.toast
import kotlinx.android.synthetic.main.activity_soal.*

class SoalActivity : AppCompatActivity(), View.OnClickListener {

    private var objectAnimator : ObjectAnimator?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        ObjectAnimator.ofInt(progressbar_time,"progress",100,0).apply {
            setDuration(30000)
            interpolator = DecelerateInterpolator()
            addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    toast("Yeah")
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }
            })
            start()
        }

        button_periksa.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_periksa->{
                dialog("Berhasil","Lanjut")
            }
        }
    }
}
