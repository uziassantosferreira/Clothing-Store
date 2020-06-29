package com.uziassantosferreira.store.beagle.widgets

import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import com.uziassantosferreira.store.components.SizeSelectorView

enum class SizeType {
    XS, S, M, L, XL
}

@RegisterWidget
data class SizeSelector(
    val sizes: List<SizeType>
) : WidgetView() {

    override fun buildView(rootView: RootView) = SizeSelectorView(rootView.getContext()).apply {
        setSizes(sizes.map { it.name })
    }
}
