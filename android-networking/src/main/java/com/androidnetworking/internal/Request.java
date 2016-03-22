package com.androidnetworking.internal;

import android.util.Log;

import com.androidnetworking.common.Priority;

import java.util.concurrent.Future;

/**
 * Created by amitshekhar on 22/03/16.
 */
public class Request {

    private final static String TAG = Request.class.getSimpleName();
    private Priority priority;
    private String url;
    private Object tag;
    private int sequenceNumber;
    private Future<?> future;
    private RequestManager mRequestManager;

    public Request(String url, Priority priority, Object tag) {
        this.url = url;
        this.priority = priority;
        this.tag = tag;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void cancel() {
        Log.d(TAG, "cancelling request for sequenceNumber : " + sequenceNumber);
        future.cancel(true);
    }

    public boolean isCanceled() {
        return future.isCancelled();
    }

    public Future<?> getFuture() {
        return future;
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }

    public void setRequestQueue(RequestManager requestManager) {
        mRequestManager = requestManager;
    }

    public void finish(){
        if (mRequestManager != null) {
            mRequestManager.finish(this);
        }
    }
}
