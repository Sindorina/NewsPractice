package com.smartpoint.marquee.newspractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.smartpoint.marquee.newspractice.fragment.NewsMainFragment;
import com.smartpoint.marquee.newspractice.fragment.PictureMainFragment;
import com.smartpoint.marquee.newspractice.fragment.TopLineMainFragment;
import com.smartpoint.marquee.newspractice.fragment.VideoMainFragment;
import com.smartpoint.marquee.newspractice.widget.helper.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawer_layout;
    private BottomNavigationView bottom_navigation;
    private int before = -1;//上一次点击位置
    private Fragment[] fragments = new Fragment[4];
    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        toolbar = findViewById(R.id.toolBar);
        bottom_navigation  = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_news:
                        showFragment(FRAGMENT_NEWS);
                        break;
                    case R.id.action_photo:
                        showFragment(FRAGMENT_PHOTO);
                        break;
                    case R.id.action_video:
                        showFragment(FRAGMENT_VIDEO);
                        break;
                    case R.id.action_media:
                        showFragment(FRAGMENT_MEDIA);
                        break;
                }
                return true;
            }
        });
        showFragment(FRAGMENT_NEWS);
        setSupportActionBar(toolbar);
        drawer_layout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void showFragment(int current){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (before!=-1){
            ft.hide(fragments[before]);
        }
        switch (current){
            case FRAGMENT_NEWS://新闻
                toolbar.setTitle(R.string.title_news);
                if (fragments[current]==null){
                    fragments[current] = new NewsMainFragment();
                    ft.add(R.id.frame_container,fragments[current]);
                }else {
                    ft.show(fragments[current]);
                }
                break;
            case FRAGMENT_PHOTO://图片
                toolbar.setTitle(R.string.title_photo);
                if (fragments[current]==null){
                    fragments[current] = new PictureMainFragment();
                    ft.add(R.id.frame_container,fragments[current]);
                }else {
                    ft.show(fragments[current]);
                }
                break;
            case FRAGMENT_VIDEO://视频
                toolbar.setTitle(R.string.title_video);
                if (fragments[current]==null){
                    fragments[current] = new VideoMainFragment();
                    ft.add(R.id.frame_container,fragments[current]);
                }else {
                    ft.show(fragments[current]);
                }
                break;
            case FRAGMENT_MEDIA://头条号
                toolbar.setTitle(R.string.title_media);
                if (fragments[current]==null){
                    fragments[current] = new TopLineMainFragment();
                    ft.add(R.id.frame_container,fragments[current]);
                }else {
                    ft.show(fragments[current]);
                }
                break;
        }
        before = current;
        ft.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            //startActivity(new Intent(MainActivity.this, SearchActivity.class));
            Toast.makeText(MainActivity.this,"点击了首页搜索...",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
