package com.mbh.mbloggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mbh.mblogger.MBLogger;

public class MainActivity extends AppCompatActivity {

    MBLogger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = new MBLogger.Builder().setTag(this)
                .setMainTag("MB-")
                .setIsOnlyInDebug(false)
                .createLogger();

        logger.debug("OnCreate Finished");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.info("Resume");
        try{
            // There is no error here, but to show the error logging
            Toast.makeText(MainActivity.this, "Just normal toast", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            //logger.error(e);
            logger.error("Toast Error Prefix",e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        logger.debug("OnPause called");
    }
}
