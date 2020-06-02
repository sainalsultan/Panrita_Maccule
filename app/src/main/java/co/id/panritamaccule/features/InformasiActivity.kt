package co.id.panritamaccule.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.id.panritamaccule.BuildConfig
import co.id.panritamaccule.R
import kotlinx.android.synthetic.main.activity_informasi.*

class InformasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informasi)

        textview_version.text = "Versi ${BuildConfig.VERSION_NAME}"
    }
}
