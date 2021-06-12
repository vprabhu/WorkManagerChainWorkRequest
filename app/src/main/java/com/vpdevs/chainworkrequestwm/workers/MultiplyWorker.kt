package com.vpdevs.chainworkrequestwm.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.vpdevs.chainworkrequestwm.utils.OUTPUT_MULTI_WORKER
import com.vpdevs.chainworkrequestwm.utils.OUTPUT_TOTAL_ADD_WORKER
import com.vpdevs.chainworkrequestwm.utils.sleepForMultiplication

class MultiplyWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d("SimpleAddWorker", "Thread : Multiply -> ${Thread.currentThread().name}")
        // get the total from Add worker
        val addTotal = inputData.getInt(OUTPUT_TOTAL_ADD_WORKER, 0)
        // put thread to sleep for 3 secs
        sleepForMultiplication()
        val multiTotal = addTotal * 1256;
        return if (multiTotal > 0) {
            val grandTotal = workDataOf(OUTPUT_MULTI_WORKER to multiTotal)
            Log.d("SimpleAddWorker", "Grand Total : $multiTotal.")
            Result.success(grandTotal)
        } else {
            Result.failure()
        }
    }

}