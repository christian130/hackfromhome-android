package com.christian130.staycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.christian130.staycode.models.SessionManagement;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SessionManagement sessionManagement = new SessionManagement();
        sessionManagement.deleteOrdersEmpty(getApplicationContext());
        try {
            if (sessionManagement.isLoggedIn(getApplicationContext())) {

               /* Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        List<UserDataDTO> lista = new SessionManagement().getUserDTO(getApplicationContext());
                        Bundle bundle = new Bundle();
                        bundle.putString("usuario", lista.get(0).getUser());
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finishAffinity();
                    }
                }, 1000);*/
            } else {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finishAffinity();
                    }
                }, 1000);
                Log.d("no signed in", "the user is not signed in...");

            }
            ;
        } catch (NullPointerException e) {
            Log.d("nightmare", Log.getStackTraceString(e));
            Toast.makeText(SplashActivity.this, e.getCause().getMessage(), Toast.LENGTH_LONG).show();

        }


    }
}
