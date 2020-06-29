package com.uziassantosferreira.store.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.children
import com.uziassantosferreira.store.R
import kotlinx.android.synthetic.main.view_item.view.*
import kotlinx.android.synthetic.main.view_size_selector.view.*

class SizeSelectorView(context: Context) : LinearLayout(context) {

    init {
        View.inflate(context, R.layout.view_size_selector, this)
    }

    fun setSizes(sizes: List<String>) {
        sizes.forEach {
            llSize.addView(createItem(it))
        }
    }

    private fun createItem(size: String): View {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item, llSize, false)
        view.tvItem.text = size
        view.setOnClickListener {
            removeSelected()
            view.tvItem.setTextColor(getColor(R.color.colorDark))
            view.background = focusDrawableColor()
        }
        return view
    }

    private fun removeSelected() {
        llSize.children.forEach {
            it.tvItem.setTextColor(getColor(R.color.colorLightGray))
            it.background = null
        }
    }

    private fun focusDrawableColor(): Drawable? {
        val drawable = AppCompatResources.getDrawable(context, R.drawable.bg_white)
        val coloredDrawable = drawable?.let { DrawableCompat.wrap(it) }
        coloredDrawable?.let { DrawableCompat.setTint(it, getColor(R.color.colorLightGray)) }
        return coloredDrawable
    }

    private fun getColor(colorId: Int) = ResourcesCompat.getColor(resources, colorId, null)
}
