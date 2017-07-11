package com.example.rpandeyppe.demoevernotejobscheduler;

import android.icu.util.Calendar;
import android.util.Log;
import android.util.TimeUtils;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by rpandey.ppe on 11/07/17.
 */

public class DeviceSpaceService extends JobService {

    public static final String TAG = "DeviceSpaceService";

    @Override
    public boolean onStartJob(JobParameters job) {
        // More code goes here
        long currentTime = System.currentTimeMillis();
        Log.d("JOB", String.valueOf((currentTime - MyApplication.currentTime)/1000));
        MyApplication.currentTime = currentTime;
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}