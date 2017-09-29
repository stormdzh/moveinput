package stormdzh.com.moveinput;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import stormdzh.com.moveinput.method2.Method2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RelativeLayout rl_login_icon_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_login_icon_layout = (RelativeLayout) findViewById(R.id.rl_login_icon_layout);

        SoftKeyBoardListener mSoftKeyBoardListener = new SoftKeyBoardListener(this);
        mSoftKeyBoardListener.setOnSoftKeyBoardChangeListener(new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                hideLogoLayout(true);
            }

            @Override
            public void keyBoardHide(int height) {
                hideLogoLayout(false);
            }
        });

        findViewById(R.id.tvForget).setOnClickListener(this);
    }

    private void hideLogoLayout(boolean hide) {
        if (rl_login_icon_layout == null) return;
        ObjectAnimator a1;
        if (hide)
            a1 = ObjectAnimator.ofFloat(rl_login_icon_layout, "alpha", 1.0f, 0f);
        else
            a1 = ObjectAnimator.ofFloat(rl_login_icon_layout, "alpha", 0f, 1.0f);

        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) rl_login_icon_layout.getLayoutParams();
        a1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float cVal = (float) valueAnimator.getAnimatedValue();
                lp.height = (int) (AppUtils.dp2px(MainActivity.this, 118) * cVal);
                rl_login_icon_layout.setLayoutParams(lp);
            }
        });
        a1.start();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, Method2Activity.class));
    }
}
