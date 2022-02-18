package android.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void serviceHandler(View view) {
        Intent sIntent = new Intent(MainActivity.this, MyService.class);

        switch (view.getId()){
            case R.id.btnStart:
                sIntent.putExtra("url","http:downloadurl.com");
                startService(sIntent);
                break;
            case R.id.btnStop:
                stopService(sIntent);

            case R.id.btnBind:
                Intent bIntent = new Intent(MainActivity.this, AdditionService.class);
                bindService(bIntent,serviceConnection,BIND_AUTO_CREATE);
                break;
        }
    }
    AdditionService additionService;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AdditionService.LocalBinder localBinder = (AdditionService.LocalBinder) iBinder;
            additionService = localBinder.getService();
            int score = additionService.getScore();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}