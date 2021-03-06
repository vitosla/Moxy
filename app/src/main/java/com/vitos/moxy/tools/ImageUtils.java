package com.vitos.moxy.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

import javax.inject.Inject;

/**
 * Created by Victor on 28.05.2017.
 */

public class ImageUtils {

    public static File bitmapToFile(Context context, Bitmap bitmap){
        File file;
        file = new File(context.getFilesDir(), "profile.jpg");
        if (file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.close();
        } catch (Exception e) {
            Log.e("SAVE_IMAGE", e.getMessage(), e);
        }
        return file;
    }
}
