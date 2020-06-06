package co.id.panritamaccule

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import co.id.panritamaccule.adapter.AdapterJawaban
import co.id.panritamaccule.utils.dialog
import co.id.panritamaccule.utils.toast
import kotlinx.android.synthetic.main.activity_soal.*
import kotlinx.android.synthetic.main.activity_soal.textview_level


class SoalActivity : AppCompatActivity(), View.OnClickListener {

    private val mAdapter by lazy { AdapterJawaban() }
    private var objectAnimator: ObjectAnimator? = null
    private var jawabanSoal: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        objectAnimator = ObjectAnimator.ofInt(progressbar_time, "progress", 100, 0)
        objectAnimator!!.setDuration(30000)
        objectAnimator!!.interpolator = DecelerateInterpolator()
        objectAnimator!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                toast("waktu habis")
            }

            override fun onAnimationCancel(animation: Animator?) {
                toast("batal")
            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })
        objectAnimator!!.start()
        textview_level.text = objectAnimator!!.animatedValue.toString()
        button_periksa.isEnabled = false
        if (!(button_periksa.isEnabled)) {
            button_periksa.background = resources.getDrawable(R.drawable.ui_button_default)
        }

        val data = mutableListOf<String>()
        for(i in 1..4) {
            data.add("$i")
        }

        recyclerview_jawaban.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@SoalActivity,2)
            adapter = mAdapter.also { it.setAdapter(data) }
        }

        mAdapter.setItemClickRadioButton(object : AdapterJawaban.setOnClickRadioButton{
            override fun OnClickRadioButton(jawaban: String) {
                button_periksa.isEnabled = true
                button_periksa.background = resources.getDrawable(R.drawable.ui_button_accent)
                jawabanSoal = jawaban
            }
        })

        button_periksa.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_periksa -> {
                periksaJawaban(jawabanSoal!!)
            }
        }
    }

    private fun periksaJawaban(jawaban: String) {
        dialog("Jawaban", jawaban)
    }

    override fun onBackPressed() {
        objectAnimator!!.removeAllListeners()
        objectAnimator!!.cancel()
        super.onBackPressed()
    }

}
