package com.vpdevs.chainworkrequestwm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.vpdevs.chainworkrequestwm.databinding.ActivityMainBinding
import com.vpdevs.chainworkrequestwm.workers.MultiplyWorker
import com.vpdevs.chainworkrequestwm.workers.SimpleAddWorker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // initialise the work manager
    private val workManager = WorkManager.getInstance(this@MainActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.progressBarStartWork.visibility = View.GONE

        binding.buttonStartWorkRequest.setOnClickListener {
            Log.d("SimpleAddWorker", "Thread : ${Thread.currentThread().name}")
            // call the work manager to begin the task by using the OneTimeWorkRequest
            val addWorker = OneTimeWorkRequestBuilder<SimpleAddWorker>().build()
            val multiWorker = OneTimeWorkRequestBuilder<MultiplyWorker>().build()
            workManager.beginWith(addWorker)
                .then(multiWorker)
                .enqueue()
        }
    }
}