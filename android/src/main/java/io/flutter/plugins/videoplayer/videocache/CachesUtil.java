package io.flutter.plugins.videoplayer.videocache;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class CachesUtil {

    public static String VIDEO = "video";

    /**
     * 获取媒体缓存文件
     *
     * @param child
     * @return
     */
    public static File getMediaCacheFile(Context context, String child) {
        String directoryPath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 外部储存可用
            directoryPath = context.getExternalFilesDir(child).getAbsolutePath();
        } else {
            directoryPath = context.getFilesDir().getAbsolutePath() + File.separator + child;
        }
        File file = new File(directoryPath);
        //判断文件目录是否存在
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.e("TAG", "getMediaCacheFile ====> " + directoryPath);
        return file;
    }
}