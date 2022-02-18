package android.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class AdditionService extends Service {
    public AdditionService() {
    }

    IBinder iBinder = new LocalBinder();

    public int add(int a, int b){
        return a+b;
    }

    public String  getLocation(){
        return "current location";
    }

    public int getScore(){
        return 3;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    class LocalBinder extends Binder {

        AdditionService getService(){
            return AdditionService.this;
        }
    }
}