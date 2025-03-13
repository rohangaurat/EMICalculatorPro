package com.demo.cashloanemi.AdCommon;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class AppsForLight_Const extends MultiDexApplication {

    PrefManager prefManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        this.prefManager = new PrefManager(this);

    }
}
