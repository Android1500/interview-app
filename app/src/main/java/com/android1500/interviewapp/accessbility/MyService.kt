package com.android1500.interviewapp.accessbility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class MyService : AccessibilityService() {
    private val TAG : String = "AccessibilityService"
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Toast.makeText(this, "WhatsApp Launched", Toast.LENGTH_LONG).show()
    }

    override fun onInterrupt() {
        Log.d(TAG,"Interrupt : something went wrong")

    }


    override fun onServiceConnected() {
        super.onServiceConnected()
        val info = AccessibilityServiceInfo()
        info.apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            packageNames = arrayOf("com.whatsapp")
            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            notificationTimeout = 100
        }
        this.serviceInfo = info
        Log.d(TAG,"ServiceConnected")
    }


}