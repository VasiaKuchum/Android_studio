package com.example.levas3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.levas3.databinding.ActivityMain7Binding;

public class MainActivity7 extends AppCompatActivity {
    ActivityMain7Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain7Binding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main7);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        replaceFragment(new BlankFragment());

        binding.bottomNavigationview.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home_menu){
                replaceFragment(new BlankFragment());
            } else if (item.getItemId() == R.id.recept_menu){
                replaceFragment(new BlankFragment2());
            } else if (item.getItemId() == R.id.profile_menu) {
                replaceFragment(new BlankFragment3());
            } else if (item.getItemId() == R.id.settings_menu) {
                replaceFragment(new BlankFragment4());
            }
                return true;
        });
    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();
    }
}