package com.example.convertisseurunites;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabBar;
    private ViewPager2 pageContainer;
    private TabsPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabBar        = findViewById(R.id.tabBar);
        pageContainer = findViewById(R.id.pageContainer);

        pagerAdapter = new TabsPagerAdapter(this);
        pageContainer.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabBar, pageContainer,
                (tab, pos) -> tab.setText(pos == 0
                        ? getString(R.string.tab_temp)
                        : getString(R.string.tab_dist))
        ).attach();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.quit_title)
                .setMessage(R.string.quit_msg)
                .setPositiveButton(R.string.quit_yes, (d, w) -> finish())
                .setNegativeButton(R.string.quit_no, null)
                .show();
    }
}