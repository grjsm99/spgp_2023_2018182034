package tukorea.ge.spgp2018182034.paladog.framework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

public class BitmapManager {
    private static HashMap<Integer, Bitmap> bitmaps = new HashMap<>();
    public static Bitmap get(int mipmapResId) {
        Bitmap bitmap = bitmaps.get(mipmapResId);
        if (bitmap == null) {
            Resources res = GameView.res;
            bitmap = BitmapFactory.decodeResource(res, mipmapResId);
            bitmaps.put(mipmapResId, bitmap);
        }
        return bitmap;
    }
}
