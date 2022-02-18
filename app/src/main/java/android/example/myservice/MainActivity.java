package android.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                break;
        }
    }
}