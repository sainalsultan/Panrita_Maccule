package co.id.panritamaccule.utils

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import co.id.panritamaccule.R

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