package co.id.panritamaccule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.panritamaccule.R
import kotlinx.android.synthetic.main.item_jawaban.view.*


/**
 * Created by Sainal Sultan on 6/04/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class AdapterJawaban : RecyclerView.Adapter<AdapterJawaban.ViewHolder>() {

    interface setOnClickRadioButton{
        fun OnClickRadioButton(jawaban: String)
    }
    private val list: MutableList<String> = mutableListOf()
    private var lastCheckedPosition = -1
    private var mItemClickRadioButton : setOnClickRadioButton? = null

    fun setAdapter(list: MutableList<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_jawaban, parent, false).also {
            return ViewHolder(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(position, lastCheckedPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(position: Int, selectedPosition: Int) {
            if (selectedPosition == position) {
                itemView.radiobutton_jawaban.isChecked = true
            } else {
                itemView.radiobutton_jawaban.isChecked = false
            }
            itemView.radiobutton_jawaban.text = list.get(position)
            itemView.radiobutton_jawaban.setOnClickListener {
                lastCheckedPosition = adapterPosition
                notifyDataSetChanged()
                mItemClickRadioButton!!.OnClickRadioButton(list.get(position))
            }
        }
    }

    fun setItemClickRadioButton(mItemClickRadioButton : setOnClickRadioButton){
        this.mItemClickRadioButton = mItemClickRadioButton
    }
}