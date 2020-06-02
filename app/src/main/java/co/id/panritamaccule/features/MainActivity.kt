package co.id.panritamaccule.features

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.id.panritamaccule.PertanyaanActivity
import co.id.panritamaccule.R
import co.id.panritamaccule.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val buttonSound by lazy { MediaPlayer.create(this, R.raw.buttonclick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOnClick()
    }

    private fun buttonOnClick() {
        button_kuis.setOnClickListener(this)
        button_sinonim.setOnClickListener(this)
        button_antonim.setOnClickListener(this)
        button_lontara.setOnClickListener(this)
        button_informasi.setOnClickListener(this)
        button_kamus.setOnClickListener(this)
        button_pertanyaan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_kuis -> {
                buttonSound.start()
                startActivity(Intent(this,
                    LevelActivity::class.java).run {
                    putExtra("menu","kuis")
                })
            }
            button_sinonim -> {
                buttonSound.start()
                startActivity(Intent(this,
                    LevelActivity::class.java).run {
                    putExtra("menu","sinonim")
                })
            }
            button_antonim -> {
                buttonSound.start()
                startActivity(Intent(this,
                    LevelActivity::class.java).run {
                    putExtra("menu","anonim")
                })
            }
            button_lontara -> {
                buttonSound.start()
                startActivity(Intent(this, LontaraActivity::class.java))
            }
            button_informasi -> {
                buttonSound.start()
                startActivity(Intent(this, InformasiActivity::class.java))
            }
            button_kamus -> {
                buttonSound.start()
                toast("Kamus Bugis Belum Tersedia")
            }
            button_pertanyaan -> {
                buttonSound.start()
                startActivity(Intent(this, PertanyaanActivity::class.java))
            }
        }
    }
}
