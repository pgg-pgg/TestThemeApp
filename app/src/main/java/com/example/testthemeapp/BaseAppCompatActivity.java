/*
 * Copyright (c) 2015. BiliBili Inc.
 */

package com.example.testthemeapp;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public abstract class BaseAppCompatActivity extends AppCompatActivity {
    private static final String SHADE_TAG = "shade_tag";
    private boolean disableNightModeManipulation = false;

    protected void setDisableNightModeManipulation(boolean disableNightModeManipulation) {
        this.disableNightModeManipulation = disableNightModeManipulation;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private boolean mFragmentStateSaved;
    private boolean mDestroyCalled = false;

    // 是否onDestory被触发
    public boolean isDestroyCalled() {
        return mDestroyCalled;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFragmentStateSaved = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    /**
     * for bugly tracing crash
     */
    protected int getUserSceneTagId() {
        return -1; /* none*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFragmentStateSaved = true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void removeShade() {
        View view = getWindow().getDecorView();
        if (view instanceof ViewGroup) {
            View tagView = view.findViewWithTag(SHADE_TAG);
            if (tagView != null) {
                ((ViewGroup) view).removeView(tagView);
            }
        }
    }

    public boolean isFragmentStateSaved() {
        return mFragmentStateSaved;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDestroyCalled = true;
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        res = LimitTextSizeUtil.INSTANCE.limitTextSize(res);
        return res;
    }
}
