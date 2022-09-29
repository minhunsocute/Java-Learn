package com.example.mylistviewweek04.Constant;

import android.content.Context;

public class Resources {
    public static int getDrawableByName(Context context, String name) {
        int drawableResource = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        if (drawableResource == 0) {
            throw new RuntimeException("Can't find drawable with name: " + name);
        }
        return drawableResource;
    }
}
