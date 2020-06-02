package co.id.panritamaccule.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import co.id.panritamaccule.R
import co.id.panritamaccule.adapter.AdapterAksaraLontara
import co.id.panritamaccule.adapter.AdapterContohDiaktrik
import co.id.panritamaccule.adapter.AdapterDiaktrik
import co.id.panritamaccule.data.source.DataAksaraLontara
import kotlinx.android.synthetic.main.activity_lontara.*

class LontaraActivity : AppCompatActivity() {

    private val mAdapter by lazy { AdapterAksaraLontara() }
    private val mAdapterDiaktrik by lazy { AdapterDiaktrik() }
    private val mAdapterContohDiaktrik by lazy { AdapterContohDiaktrik() }
    private val lontaraBugis by lazy { DataAksaraLontara()
        .lontaraBugis() }
    private val lontara by lazy { DataAksaraLontara()
        .lontara() }
    private val diaktrik by lazy { DataAksaraLontara()
        .diaktrik() }
    private val imgDiaktrik by lazy { DataAksaraLontara()
        .imgDiaktrik() }
    private val descDiaktrik by lazy { DataAksaraLontara()
        .descDiaktrik() }
    private val contohDiaktrik by lazy { DataAksaraLontara()
        .contohDiaktrik() }
    private val contohLontaraDiaktrik by lazy { DataAksaraLontara()
        .contohLontaraDiaktrik() }

    private val data = mutableListOf<String>()
    private val dataValue = mutableListOf<String>()
    private val dataDiatrik = mutableListOf<String>()
    private val dataImgDiaktrik = mutableListOf<Int>()
    private val dataDiatrikValue = mutableListOf<String>()
    private val contohData = mutableListOf<String>()
    private val contohDataValue = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lontara)

        for ((i,v) in lontara.withIndex()){
            dataValue.add(lontaraBugis[i])
            data.add(v)
        }

        for ((i,v) in descDiaktrik.withIndex()){
            dataDiatrikValue.add(diaktrik[i])
            dataImgDiaktrik.add(imgDiaktrik[i])
            dataDiatrik.add(v)
        }

        for ((i,v) in contohDiaktrik.withIndex()){
            contohDataValue.add(contohLontaraDiaktrik[i])
            contohData.add(v)
        }

        recyclerview_aksaradasar.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@LontaraActivity,5)
            adapter = mAdapter.also { it.setAdapter(data,dataValue) }
        }

        recyclerview_diaktrik.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@LontaraActivity,5)
            adapter = mAdapterDiaktrik.also { it.setAdapter(dataDiatrik,dataDiatrikValue,dataImgDiaktrik) }
        }

        recyclerview_contoh.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@LontaraActivity,6)
            adapter = mAdapterContohDiaktrik.also { it.setAdapter(contohData,contohDataValue) }
        }
    }
}
