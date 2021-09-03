package com.example.actividades;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.actividades.ui.main.SectionsPagerAdapter;
import com.example.actividades.databinding.ActivityMainBinding;

public class MostrarServicio extends AppCompatActivity {

    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        textView3 = findViewById(R.id.textView3);

        textView3.setMovementMethod(new ScrollingMovementMethod());
    }
}