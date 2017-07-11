package com.example.rpandeyppe.demoevernotejobscheduler;

import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by rpandey.ppe on 11/07/17.
 */

public class DemoJobCreator implements JobCreator {
    @Override
    public Job create(String tag) {
        Log.d("JOB", "JobCreater create "+tag);
        switch (tag) {
            case DemoSyncJob.TAG:
                return new DemoSyncJob();
            default:
                return null;
        }
    }

}
