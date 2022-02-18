package android.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static String TAG = MyService.class.getSimpleName();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "received request to----"+ intent.getExtras().getString("url"));
        return START_STICKY;  //starts or creates the service if the service is stopped or destroyed.
        //START_STICKY more info:  https://stackoverflow.com/questions/9093271/start-sticky-and-start-not-sticky
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"service destroyed");
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}