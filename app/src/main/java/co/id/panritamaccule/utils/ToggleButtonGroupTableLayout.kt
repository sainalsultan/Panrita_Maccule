package co.id.panritamaccule.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.TableRow
import androidx.annotation.IdRes


/**
 * Created by Sainal Sultan on 6/5/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */


class ToggleButtonGroupTableLayout : TableLayout, View.OnClickListener {

    private var activeRadioButton: RadioButton? = null

    constructor(context: Context?) : super(context) {

    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {

    }

    override fun addView(
        child: View, index: Int,
        params: ViewGroup.LayoutParams
    ) {
        super.addView(child, index, params)
        setChildrenOnClickListener(child as TableRow)
    }

    override fun addView(
        child: View,
        params: ViewGroup.LayoutParams
    ) {
        super.addView(child, params)
        setChildrenOnClickListener(child as TableRow)
    }

    private fun setChildrenOnClickListener(tr: TableRow) {
        val c: Int = tr.getChildCount()
        for (i in 0 until c) {
            val v: View = tr.getChildAt(i)
            (v as? RadioButton)?.setOnClickListener(this)
        }
    }

    val checkedRadioButtonId: Int
        get() = if (activeRadioButton != null) {
            activeRadioButton!!.id
        } else -1

    companion object {
        private const val TAG = "ToggleButtonGroupTableLayout"
    }

    override fun onClick(v: View?) {
        val rb = v as RadioButton
        if (activeRadioButton != null) {
            activeRadioButton!!.isChecked = false
        }
        rb.isChecked = true
        activeRadioButton = rb
    }
}