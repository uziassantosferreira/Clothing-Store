package com.uziassantosferreira.store.components

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import com.uziassantosferreira.store.R

class ImageDetailView(context: Context) : RelativeLayout(context) {

    init {
        View.inflate(context, R.layout.view_image_detail, this)
    }
}
