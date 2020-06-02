package co.id.panritamaccule.features

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.panritamaccule.R
import co.id.panritamaccule.adapter.AdapterLevel
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity() {

    private val mAdapter by lazy { AdapterLevel() }
    private val sharedPref by lazy { this.getPreferences(Context.MODE_PRIVATE) }
    private val infoSound by lazy { MediaPlayer.create(this, R.raw.info) }
    private val backSound by lazy { MediaPlayer.create(this, R.raw.back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        Handler().postDelayed({
            if (sharedPref.getBoolean("status", false) == false) {
                tampilkanDialogInfo()
            }
        },1000)

        val data = mutableListOf<String>()
        data.add("Level 1")
        data.add("Level 2")
        data.add("Level 3")

        recyclerview_level.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@LevelActivity)
            adapter = mAdapter.also { it.setAdapter(data) }
        }
    }

    private fun tampilkanDialogInfo() {
        infoSound.start()
        Dialog(this).run {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            setContentView(R.layout.view_dialog_info)
            val buttonMulai = findViewById<Button>(R.id.button_mulai)
            val buttonBatal = findViewById<Button>(R.id.button_batal)
            buttonMulai.setOnClickListener {
                startActivity(Intent(this@LevelActivity, LontaraActivity::class.java))
                dismiss()
                //simpan sudah dibaca
                with(sharedPref.edit()) {
                    putBoolean("status", true)
                    apply()
                }
            }
            buttonBatal.setOnClickListener {
                infoSound.stop()
                dismiss()
            }
            show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        backSound.start()
    }

}
