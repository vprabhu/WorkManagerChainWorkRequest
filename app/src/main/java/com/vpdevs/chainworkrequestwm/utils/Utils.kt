@file:JvmName("Utils")

package com.vpdevs.chainworkrequestwm.utils

import android.util.Log


fun sleepForAddition() {
    try {
        Thread.sleep(2000)
    } catch (e: InterruptedException) {
        Log.d("SimpleAddWorker", "Exception : $e")
    }
}

fun sleepForMultiplication() {
    try {
        Thread.sleep(3000)
    } catch (e: InterruptedException) {
        Log.d("SimpleAddWorker", "Exception : $e")
    }
}