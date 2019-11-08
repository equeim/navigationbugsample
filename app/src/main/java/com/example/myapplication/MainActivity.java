package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, Integer.toHexString(hashCode()) + " onCreate() isTaskRoot=" + isTaskRoot() + ", intent=" + getIntent());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.nav_host));
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, Integer.toHexString(hashCode()) + " onDestroy() isTaskRoot=" + isTaskRoot());
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i(TAG, Integer.toHexString(hashCode()) + " onNewIntent() isTaskRoot=" + isTaskRoot() + ", intent=" + intent);
        super.onNewIntent(intent);
        boolean handled = Navigation.findNavController(this, R.id.nav_host).handleDeepLink(intent);
        Log.i(TAG, Integer.toHexString(hashCode()) + " onNewIntent() handled=" + handled);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host).navigateUp() || super.onSupportNavigateUp();
    }
}
