package com.example.rpandeyppe.demoevernotejobscheduler;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

/**
 * Created by rpandey.ppe on 11/07/17.
 */

public class DemoSyncJob extends Job{

    public static final String TAG = "job_demo_tag";

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        Log.d("JOB", "JOB RUNNING");
        scheduleJob();
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(DemoSyncJob.TAG)
                .setExecutionWindow(30_000L, 40_000L)
                .build()
                .schedule();
    }
}
