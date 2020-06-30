package com.uziassantosferreira.store.beagle.config

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ServerDrivenState
import com.uziassantosferreira.store.R
import kotlinx.android.synthetic.main.activity_app_beagle.*

@BeagleComponent
class AppBeagleActivity : BeagleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_beagle)
    }

    override fun getServerDrivenContainerId() =
        R.id.containerServerDriven

    override fun getToolbar(): Toolbar = toolbarServerDriven

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
        if (state is ServerDrivenState.Loading) {
            progressServerDriven.visibility = if (state.loading) View.VISIBLE else View.GONE
        } else if (state is ServerDrivenState.Error) {
            Toast.makeText(this, "Something wrong happen", Toast.LENGTH_SHORT).show()
        }
    }
}
