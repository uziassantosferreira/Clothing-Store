package com.uziassantosferreira.store.beagle.widgets

import android.content.Context
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import com.uziassantosferreira.store.components.ImageDetailView
import kotlinx.android.synthetic.main.view_image_detail.view.*

enum class ImageType {
    RED_HEART, SHOPPING
}

@RegisterWidget
data class ImageDetail(
    val value: String,
    val image: ImageType
) : WidgetView() {

    override fun buildView(rootView: RootView) = ImageDetailView(rootView.getContext()).apply {
        tvDetail.text = value
        getImageResourceByImageType(context)?.let {
            ivDetail.setImageResource(it)
        }
    }

    private fun getImageResourceByImageType(context: Context): Int? {
        val resourceId = context.resources.getIdentifier(
            "ic_${image.name}",
            "drawable",
            context.packageName
        )
        return if (resourceId != 0) {
            resourceId
        } else {
            null
        }
    }
}
