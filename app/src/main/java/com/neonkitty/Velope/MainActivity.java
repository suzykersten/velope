package com.neonkitty.Velope;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                                          @Override
                                                          public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                                                              selectFragment(menuItem);
                                                              return true;
                                                          }
                                                      }
        );

        selectFragment(bottomNav.getMenu().getItem(0));

    }


    //Change the main fragment shown to the user
    private void selectFragment(MenuItem item){
        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.view_envelopes:
                fragment = new envelopeFragment();
                break;
            case R.id.view_transactions:
                fragment = new transactionsFragment();
                break;
        }

        if (fragment == null){
            throw new RuntimeException("bottom navigation item id for SelectFragment not found: Given " + (item.toString()) );
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, fragment, fragment.getTag());
        ft.commit();
    }
}
