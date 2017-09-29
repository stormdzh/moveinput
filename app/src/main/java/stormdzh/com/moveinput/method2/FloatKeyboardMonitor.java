package stormdzh.com.moveinput.method2;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;

import stormdzh.com.moveinput.AppUtils;

/**
 * 监听输入法
 *
 * @author Administrator
 */
public class FloatKeyboardMonitor extends View {
    private int oldOrientation = 0;
    private Context mContext;

    public FloatKeyboardMonitor(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    public FloatKeyboardMonitor(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public FloatKeyboardMonitor(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onSizeChanged(int w, final int h, int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (listener == null || h == 0 || oldh == 0) return;

        post(new Runnable() {
            @Override
            public void run() {
                if (h > oldh && h - oldh > AppUtils.dp2px(mContext, 70))
                    listener.onKeyBoardState(0);
                else if (oldh > h && oldh - h > AppUtils.dp2px(mContext, 70))
                    listener.onKeyBoardState(1);
            }
        });
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (oldOrientation != newConfig.orientation) {
            oldOrientation = newConfig.orientation;
        }
    }

    /**
     * 监听键盘变化
     * state 1 开始软键盘  0关闭软键盘
     *
     * @author haoweilai
     */
    public interface OnKeyBoardStateChangeListener {
        void onKeyBoardState(int state);
    }


    private OnKeyBoardStateChangeListener listener;

    public void setOnKeyBoardStateChangeListener(OnKeyBoardStateChangeListener listener) {
        this.listener = listener;
    }
}