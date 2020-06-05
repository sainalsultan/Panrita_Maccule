package co.id.panritamaccule.utils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import co.id.panritamaccule.R
import co.id.panritamaccule.features.LontaraActivity

/**
 * Created by Sainal Sultan on 6/2/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */


fun Context.toast(message: String) {
    Toast(this).apply {
        View.inflate(this@toast, R.layout.view_toast, null).also {
            val textMessage = it.findViewById<TextView>(R.id.textview_message)
            textMessage.setText(message)
            duration = Toast.LENGTH_SHORT
            view = it
            show()
        }
    }
}

fun Context.dialog(title : String, info : String){
    val infoSound by lazy { MediaPlayer.create(this, R.raw.info) }
    infoSound.start()
    Dialog(this).run {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        setContentView(R.layout.view_dialog_info)
        val textviewInfoTitle = findViewById<TextView>(R.id.textview_info_title)
        val textviewInfo = findViewById<TextView>(R.id.textview_info)
        val buttonMulai = findViewById<Button>(R.id.button_mulai)
        val buttonBatal = findViewById<Button>(R.id.button_batal)
        textviewInfoTitle.text = title
        textviewInfo.text = info
        buttonMulai.text = "Tutup"
        buttonMulai.setOnClickListener {
            dismiss()
        }
        buttonBatal.visibility = View.GONE
        show()
    }
}

fun Context.buttonClickSound(){
    val buttonSound by lazy { MediaPlayer.create(this, R.raw.buttonclick) }
    buttonSound.start()
}