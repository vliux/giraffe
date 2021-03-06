package com.vliux.giraffe.guide;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

import com.vliux.giraffe.util.Analytics;

/**
 * Created by vliux on 2017/7/8.
 */

public class UserGuideManager {
    public static boolean hasShown(final Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(KEY_GUIDE_SHOWN, false);
    }
    
    public static boolean showUserGuideIfNeeded(final Context context, final boolean forceShow){
        if(forceShow || !hasShown(context)) {
            context.startActivity(new Intent(context, UserGuideActivity.class));
            return true;
        }
        return false;
    }
    
    static void setUserGuideShown(final Context context){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_GUIDE_SHOWN, true)
                .apply();
        Analytics.logWizardComplete();
    }
    
    private static final String KEY_GUIDE_SHOWN = "guide_shown";
}
