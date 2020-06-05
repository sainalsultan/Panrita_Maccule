package co.id.panritamaccule.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.panritamaccule.DaftarSoalActivity
import co.id.panritamaccule.R
import co.id.panritamaccule.SoalActivity
import kotlinx.android.synthetic.main.item_soal.view.*

/**
 * Created by Sainal Sultan on 6/04/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class AdapterJumlahSoal : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list : MutableList<String> = mutableListOf()

    fun setAdapter(list: MutableList<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_soal,parent,false).also {
            return ViewHolder(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            holder.itemView.run{

                val marginStart: Int
                val marginEnd: Int
                val marginTop: Int
                val marginBottom: Int

                marginTop = resources.getDimensionPixelSize(R.dimen.marginLayout)

                if (position % 4 == 0){
//                    Log.e("pos ","$position")
                    marginStart = resources.getDimensionPixelSize(R.dimen.marginLayout)
                }else{
                    marginStart = 0
                }

                Log.e("pos ","${position}")

                (this.layoutParams as RecyclerView.LayoutParams).also {
                    it.marginStart = marginStart
                    it.marginEnd = 0
                    it.topMargin = marginTop
                    it.bottomMargin = 0
                }

                textview_level.text = list.get(position)
                setOnClickListener {
                    context.startActivity(
                        Intent(context,
                            SoalActivity::class.java).run {
                            putExtra("soal",list.get(position))
                        })
                }
            }
        }
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
}