package com.uziassantosferreira.store.components

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.children
import com.uziassantosferreira.store.R
import kotlinx.android.synthetic.main.view_color_selector.view.*
import kotlinx.android.synthetic.main.view_item.view.*

class ColorSelectorView(context: Context) : LinearLayout(context) {

    init {
        View.inflate(context, R.layout.view_color_selector, this)
    }

    fun setColors(colors: List<String>) {
        colors.forEach {
            llColor.addView(createItem(it))
        }
    }

    private fun createItem(color: String): View {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item, llColor, false)
        view.background = changeDrawableColor(color)
        view.setOnClickListener {
            removeSelected()
            view.ivItem.visibility = View.VISIBLE
        }
        return view
    }

    private fun removeSelected() {
        llColor.children.forEach {
            it.ivItem.visibility = View.GONE
        }
    }

    private fun changeDrawableColor(color: String): Drawable? {
        val drawable = AppCompatResources.getDrawable(context, R.drawable.bg_color)
        val coloredDrawable = drawable?.let { DrawableCompat.wrap(it) }
        coloredDrawable?.let { DrawableCompat.setTint(it, Color.parseColor(color)) }
        return coloredDrawable
    }
}
