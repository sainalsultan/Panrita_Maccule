package co.id.panritamaccule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import co.id.panritamaccule.adapter.AdapterAksaraLontara
import co.id.panritamaccule.adapter.AdapterJumlahSoal
import co.id.panritamaccule.data.source.DataAksaraLontara
import kotlinx.android.synthetic.main.activity_daftar_soal.*

class DaftarSoalActivity : AppCompatActivity() {

    private val mAdapter by lazy { AdapterJumlahSoal() }
    private val lontaraBugis by lazy { DataAksaraLontara()
        .lontaraBugis() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_soal)

        val data = mutableListOf<String>()
        for(i in 1..16) {
            data.add("$i")
        }

        recyclerview_daftar_soal.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@DaftarSoalActivity,4)
            adapter = mAdapter.also { it.setAdapter(data) }
        }
    }
}
