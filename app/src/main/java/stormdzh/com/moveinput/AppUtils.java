package stormdzh.com.moveinput;

import android.content.Context;

/**
 * Created by Administrator on 2017/9/29.
 *
 * @author Administrator.
 */

public class AppUtils {

    /**
     * 把密度转换为像素
     */
    public static int dp2px(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px * scale + 0.5);
    }

}
