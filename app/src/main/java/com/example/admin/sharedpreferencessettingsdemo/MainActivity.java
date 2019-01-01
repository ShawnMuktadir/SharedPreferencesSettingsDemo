package com.example.admin.sharedpreferencessettingsdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutId = (LinearLayout)findViewById(R.id.linearLayoutId);

        if (loadColor() != getResources().getColor(R.color.colorPrimary)){
            linearLayoutId.setBackgroundColor(loadColor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.redColorMenu){
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.colorRed));
            storeColor(getResources().getColor(R.color.colorRed));
        }
        if (item.getItemId() == R.id.greenColorMenu){
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            storeColor(getResources().getColor(R.color.colorGreen));
        }
        if (item.getItemId() == R.id.yellowColorMenu){
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            storeColor(getResources().getColor(R.color.colorYellow));
        }
        if (item.getItemId() == R.id.blueColorMenu){
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            storeColor(getResources().getColor(R.color.colorBlue));
        }
        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor",color);
        editor.apply();
    }

    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor",Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor",getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
