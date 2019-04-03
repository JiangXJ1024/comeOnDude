package com.example.mycome0;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private TextView mTextMessage;
    private BlankFragment1 Fragment1;
    private BlankFragment2 Fragment2;
    private BlankFragment3 Fragment3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    if (Fragment1 == null) {
                        Fragment1 = new BlankFragment1();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, Fragment1).commitAllowingStateLoss();

                    return true;
                case R.id.navigation_dashboard:
                    // mTextMessage.setText(R.string.title_dashboard);
                    if (Fragment2 == null) {
                        Fragment2 = new BlankFragment2();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, Fragment2).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    if (Fragment3 == null) {
                        Fragment3 = new BlankFragment3();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, Fragment3).commitAllowingStateLoss();
                        return true;
                    }
                    return false;
            }
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//       navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //实例化Fragment1
        Fragment1=new BlankFragment1();
        //Fragment1把添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,Fragment1).commitAllowingStateLoss();
    }

}
