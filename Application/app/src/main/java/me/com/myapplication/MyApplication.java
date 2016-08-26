package me.com.myapplication;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import android.app.Application;

import java.util.Collections;
import java.util.List;

public class MyApplication extends Application implements ReactApplication {

    private final ReactNativeHost reactNativeHost = new ReactNativeHost(this) {
        @Override
        protected boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Collections.<ReactPackage>singletonList(new MainReactPackage());
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return reactNativeHost;
    }
}
