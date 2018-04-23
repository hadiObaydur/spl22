package com.example.iit.androidnewsappspl2;

import android.os.Bundle;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout;
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("News Sources"));
        tabLayout.addTab(tabLayout.newTab().setText("BBC-News"));
        tabLayout.addTab(tabLayout.newTab().setText("ABC-News"));
        tabLayout.addTab(tabLayout.newTab().setText("BlogerNews"));
        tabLayout.addTab(tabLayout.newTab().setText("US Top News"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 6"));
       // tabLayout.addTab(tabLayout.newTab().setText("Tab 5"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        //Toast.makeText(this,"tab  "+tabLayout.getTabCount(),Toast.LENGTH_LONG).show();

        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
       // adapter.notifyDataSetChanged();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}