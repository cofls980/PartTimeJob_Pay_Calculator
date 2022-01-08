package org.project.alba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentCalculate fragmentCal;
    FragmentHome fragmentHome;
    FragmentMore fragmentMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentCal = new FragmentCalculate();
        fragmentHome = new FragmentHome();
        fragmentMore = new FragmentMore();

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentCal).commit();//container 위치에 fragmentCal을 불러옴

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.calculator:
                        Toast.makeText(getApplicationContext(), "계산기 탭 선택", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentCal).commit();

                        return true;
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "홈 탭 선택", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();

                        return true;
                    case R.id.more:
                        Toast.makeText(getApplicationContext(), "더보기 탭 선택", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMore).commit();

                        return true;
                }
                return false;
            }
        });
    }
}