package com.uziassantosferreira.store

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.components.layout.Screen
import br.com.zup.beagle.android.view.BeagleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonBeagle).setOnClickListener {
            startActivity(BeagleActivity.newIntent(this, null))
        }
    }
}