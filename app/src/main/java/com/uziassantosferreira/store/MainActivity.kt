package com.uziassantosferreira.store

import android.os.Bundle
import android.widget.Button as ButtonAndroid
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.action.Navigate
import br.com.zup.beagle.android.action.Route
import br.com.zup.beagle.android.components.Button
import br.com.zup.beagle.android.components.Image
import br.com.zup.beagle.android.components.PathType
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.components.layout.NavigationBar
import br.com.zup.beagle.android.components.layout.Screen
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.*
import com.uziassantosferreira.store.beagle.widgets.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ButtonAndroid>(R.id.buttonBeagle).setOnClickListener {
            startActivity(
                BeagleActivity.newIntent(
                    this, screen = provideDetailScreen()
                )
            )
        }
    }

    private fun provideDetailScreen() = Screen(
        navigationBar = navBar(),
        child = screenWidgets()
    )

    private fun navBar(): NavigationBar {
        return NavigationBar(
            title = "Title",
            styleId = "customNavigation",
            showBackButton = true
        )
    }

    private fun screenWidgets(): Widget {
        return Container(
            children = listOf(
                outfitImage(),
                outfitColors(),
                outfitSize(),
                submitButton()
            )
        ).applyStyle(
            Style(
                flex = Flex(
                    grow = 1.0,
                    justifyContent = JustifyContent.SPACE_BETWEEN
                ),
                padding = EdgeValue(
                    left = 30.unitReal(),
                    right = 30.unitReal(),
                    bottom = 30.unitReal()
                )
            )
        )
    }

    private fun submitButton(): Button {
        return Button(
            text = "Add to cart",
            styleId = "customButton",
            onPress = listOf(Navigate.PushView(Route.Remote("/detail")))
        )
    }

    private fun outfitSize(): Widget {
        return SizeSelector(
            listOf(SizeType.XS, SizeType.S, SizeType.M, SizeType.L, SizeType.XL)
        ).applyStyle(
            Style(
                margin = EdgeValue(bottom = 10.unitReal())
            )
        )
    }

    private fun outfitColors(): Widget {
        return ColorSelector(
            colors = listOf(
                "#ECECED",
                "#D7D8DA",
                "#394657",
                "#B38B6D"
            )
        ).applyStyle(
            Style(
                margin = EdgeValue(top = 10.unitReal())
            )
        )
    }

    private fun outfitImage(): Widget {
        return Container(
            children = listOf(
                Image(
                    PathType.Local("shirt"),
                    ImageContentMode.CENTER
                ),
                ImageDetail(value = "$23.99", image = ImageType.RED_HEART)
                    .applyStyle(
                        Style(
                            cornerRadius = CornerRadius(20.0),
                            padding = EdgeValue(bottom = 5.unitReal()),
                            margin = EdgeValue(horizontal = 10.unitReal()),
                            positionType = PositionType.ABSOLUTE
                        )
                    )
            )
        ).applyStyle(
            Style(
                flex = Flex(
                    justifyContent = JustifyContent.FLEX_END
                ),
                margin = EdgeValue(
                    left = 18.unitReal(),
                    right = 18.unitReal()
                ),
                size = Size(
                    height = 65.unitPercent()
                )
            )
        )
    }
}
