package com.example.rpandeyppe.demoevernotejobscheduler;

import android.app.Application;
import android.util.Log;

import com.evernote.android.job.JobManager;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Trigger;

/**
 * Created by rpandey.ppe on 11/07/17.
 */

public class MyApplication extends Application {

    public static long currentTime = System.currentTimeMillis();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("JOB", "Myapplication create");
        JobManager.create(this).addJobCreator(new DemoJobCreator());
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        dispatcher.mustSchedule(
                dispatcher.newJobBuilder()
                        .setService(DeviceSpaceService.class)
                        .setTag(DeviceSpaceService.TAG)
                        .setRecurring(true)
                        .setTrigger(Trigger.executionWindow(5, 10))
                        .build()
        );
    }
}
