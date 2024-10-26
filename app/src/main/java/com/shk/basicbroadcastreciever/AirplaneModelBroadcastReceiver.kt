package com.shk.basicbroadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BasicBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(mContext: Context?, mIntent: Intent?) {
        val action: String? = mIntent?.action
        val isOn = mIntent?.getBooleanExtra("state", false)
        var mEvent = "sorry"
        if (action != null) {
            when (action) {
                Intent.ACTION_BOOT_COMPLETED -> { mEvent = "Boot completion" }
                Intent.ACTION_POWER_CONNECTED -> { mEvent = "Power Connection" }
                Intent.ACTION_POWER_DISCONNECTED -> { mEvent = "Power Connection" }
                Intent.ACTION_AIRPLANE_MODE_CHANGED -> { mEvent = "Airplane Mode" }
                Intent.ACTION_BATTERY_LOW -> { mEvent = "Battery low" }
                Intent.ACTION_BATTERY_CHANGED -> { mEvent = "Battery changed" }
                else -> {}
            }
        }
        if(isOn!!){
            Toast.makeText(mContext, "$mEvent turned on ", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(mContext, "$mEvent off", Toast.LENGTH_SHORT).show()
        }
    }
}