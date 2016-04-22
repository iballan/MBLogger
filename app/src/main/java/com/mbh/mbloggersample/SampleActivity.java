package com.mbh.mbloggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mbh.mblogger.MBLogger;

public class SampleActivity extends AppCompatActivity {

    MBLogger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        logger = new MBLogger.Builder()
                .setTag(this)
                .createLogger();

        logger.info("OnCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logger.info("OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.info("OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            throw new Exception("This is a test exception");
        }catch (Exception e){
            logger.error(e);
        }
    }
}
