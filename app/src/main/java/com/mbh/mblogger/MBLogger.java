package com.mbh.mblogger;

import android.util.Log;


/**
 * Created by MBH on 2016-02-01.
 */
public class MBLogger {

    private boolean mIsOnlyInDebug = true;
    private String TAG;
    private String MainTag = "MB-";
    private boolean IS_DEBUG;

    public MBLogger(String tag, boolean onlyOnDebugMode) {
        this.mIsOnlyInDebug = onlyOnDebugMode;
        TAG = MainTag+tag;
        IS_DEBUG = BuildConfig.DEBUG;
    }

    public MBLogger(String tag, boolean onlyOnDebugMode, String mainTag) {
        this.mIsOnlyInDebug = onlyOnDebugMode;
        this.MainTag = mainTag;
        TAG = MainTag+tag;
        IS_DEBUG = BuildConfig.DEBUG;
    }

    public MBLogger(Class className, boolean onlyOnDebugMode) {
        this(className.getSimpleName(), onlyOnDebugMode);
    }

    // region Error Logging
    public void error(String prefix, Throwable e) {
        if (shouldLog()) {
            logErr(prefix, e);
        }
    }

    public void error(Throwable e) {
        if (shouldLog()) {
            logErr("Error: ", e);
        }
    }

    public void error(String message) {
        if (shouldLog()) {
            logErr(message, null);
        }
    }
    // endregion

    // region Info Logging
    public void info(String message) {
        if (shouldLog()) {
            logInf(message);
        }
    }

    public void debug(String message) {
        if(shouldLog())
            logDe(message);
    }

    public void warning(String message) {
        if(shouldLog())
            logWarning(message);
    }
    // endregion

    // region Logging stuff goes absolutely, horribly, fully-crap wrong
    public void wtf(Throwable e) {
        if (shouldLog()) {
            logWTF("WTF: ", e);
        }
    }

    public void wtf(String prefix, Throwable e) {
        if (shouldLog()) {
            logWTF(prefix, e);
        }
    }

    public void wtf(String message) {
        if (shouldLog()) {
            logWTF(message, null);
        }
    }
    // endregion

    private void logWTF(String prefix, Throwable throwable) {
        if (throwable != null)
            Log.wtf(TAG, prefix, throwable);
        else
            Log.wtf(TAG, prefix);
    }

    private void logInf(String message) {
        Log.i(TAG, message);
    }

    private void logWarning(String message) {
        Log.w(TAG, message);
    }

    private void logErr(String prefix, Throwable throwable) {
        if (throwable != null)
            Log.e(TAG, prefix, throwable);
        else
            Log.e(TAG, prefix);
    }

    private void logDe(String message) {
        Log.d(TAG, message);
    }

    private boolean shouldLog() {
        return !mIsOnlyInDebug || mIsOnlyInDebug && IS_DEBUG;
    }

    /**
     * Builder class as outlined in the Second Edition of Joshua Bloch's
     * Effective Java that is used to build a {@link MBLogger} instance.
     */
    public static class Builder {
        private String tag = "";
        private boolean onlyOnDebugMode = true;
        private String MainTag = "MB-";

        public Builder() {

        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setMainTag(String mainTag){
            this.MainTag = mainTag;
            return this;
        }

        public Builder setTag(Class tagClass) {
            this.tag = tagClass.getSimpleName();
            return this;
        }

        public Builder setTag(Object anyObject) {
            this.tag = anyObject.getClass().getSimpleName();
            return this;
        }

        public Builder setIsOnlyInDebug(boolean isOnlyInDebug) {
            this.onlyOnDebugMode = isOnlyInDebug;
            return this;
        }

        public MBLogger createLogger() {
            return new MBLogger(tag, onlyOnDebugMode, MainTag);
        }
    }
}
