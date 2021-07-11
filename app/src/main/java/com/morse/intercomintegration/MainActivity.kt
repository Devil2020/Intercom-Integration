package com.morse.intercomintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intercom.initialize(application, "android_sdk-e96fb13e651e932ed8311b4a36a1533a469834eb", "vizfwyof")
        val registration = Registration.create().withUserId("123456")
        Intercom.client().registerIdentifiedUser(registration)
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            delay(40000)
            Intercom.client().displayMessenger()
        }
    }
}