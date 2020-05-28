package com.jv.news

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.joaquimverges.helium.core.assemble
import com.jv.news.util.VersionUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLightStatusBar()
        assemble(MainAppBlock.build(this))
    }

    private fun setLightStatusBar() {
        if (VersionUtil.isAtLeastApi(Build.VERSION_CODES.M)) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(App.context, R.color.colorPrimary)
        }
    }
}
