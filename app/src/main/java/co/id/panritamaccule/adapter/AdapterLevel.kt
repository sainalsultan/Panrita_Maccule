package co.id.panritamaccule.adapter

import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.panritamaccule.DaftarSoalActivity
import co.id.panritamaccule.R
import co.id.panritamaccule.SoalActivity
import co.id.panritamaccule.features.LevelActivity
import co.id.panritamaccule.utils.buttonClickSound
import kotlinx.android.synthetic.main.item_level.view.*

/**
 * Created by Sainal Sultan on 5/31/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class AdapterLevel : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list : MutableList<String> = mutableListOf()

    fun setAdapter(list: MutableList<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_level,parent,false).also {
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

                marginStart = resources.getDimensionPixelSize(R.dimen.marginLayout)
                marginEnd = resources.getDimensionPixelSize(R.dimen.marginLayout)

                if (position == list.size - 1) {
                    marginBottom = resources.getDimensionPixelSize(R.dimen.marginLayout)
                } else {
                    marginBottom = resources.getDimensionPixelSize(R.dimen.marginSpace)
                }

                if (position == 0) {
                    marginTop = resources.getDimensionPixelSize(R.dimen.marginLayout)
                    imageview_kunci.visibility = View.GONE
                } else {
                    marginTop = 0
                }

                (this.layoutParams as RecyclerView.LayoutParams).also {
                    it.marginStart = marginStart
                    it.marginEnd = marginEnd
                    it.topMargin = marginTop
                    it.bottomMargin = marginBottom
                }

                textview_level.text = list.get(position)

                setOnClickListener {
                    context.buttonClickSound()
                    context.startActivity(
                        Intent(context,
                            DaftarSoalActivity::class.java).run {
                            putExtra("level",list.get(position))
                        })
                }
            }
        }
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
}