package text.bwei.com.lianxi6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Btn4Activity extends AppCompatActivity {

    private TextView mTextView;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private String[] str = new String[]{"夏奇顶", "范永兴", "孟向阳", "张玉杰"};
    private int index = 0;
    MyRunnable myRunnable = new MyRunnable();

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            index = index % 3;
            mTextView.setText(str[index]);
            index++;
            mHandler.postDelayed(myRunnable, 1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn4);
        mTextView = (TextView) findViewById(R.id.btn44);


        mHandler.postDelayed(myRunnable, 1000);
    }
}
