package stormdzh.com.moveinput.method2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import stormdzh.com.moveinput.R;

/**
 * Created by Administrator on 2017/9/29.
 *
 * @author Administrator.
 */

public class Method2Activity extends Activity {

    private FloatKeyboardMonitor mFloatKeyboardMonitor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method2);
        mFloatKeyboardMonitor = (FloatKeyboardMonitor) findViewById(R.id.mFloatKeyboardMonitor);

        mFloatKeyboardMonitor.setOnKeyBoardStateChangeListener(new FloatKeyboardMonitor.OnKeyBoardStateChangeListener() {
            @Override
            public void onKeyBoardState(int state) {
                switch (state) {
                    // 键盘关闭
                    case 0:
                        Toast.makeText(Method2Activity.this, "输入法关闭", Toast.LENGTH_SHORT).show();
                        break;
                    // 键盘开启
                    case 1:
                        Toast.makeText(Method2Activity.this, "输入法开启", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
