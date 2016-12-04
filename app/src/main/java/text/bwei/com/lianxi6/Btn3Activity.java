package text.bwei.com.lianxi6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Btn3Activity extends AppCompatActivity {

    private Button btn33;
    private Handler mHandler;
    private static final int MSG_UPDATE_TEXT = 0x2001; // 更新文本  方式一用的常量
    private static final int MSG_UPDATE_WAY_TWO = 0x2002;  // 更新文本 方式二用的常量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn3);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_UPDATE_TEXT:
                        btn33.setText("让Handler更改界面");
                        break;

                    case MSG_UPDATE_WAY_TWO:
                        btn33.setText("让Handler更改界面方式二");
                        break;
                }
            }
        };


        btn33 = (Button) findViewById(R.id.btn33);
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Test", "点击文字");

                // 方式一和方式二可以达到相同的效果,就是更改界面

                // 方式一
                //mHandler.sendEmptyMessage(MSG_UPDATE_TEXT);

                // 方式二
                Message msg = Message.obtain();
                msg.what = MSG_UPDATE_WAY_TWO;
                mHandler.sendMessage(msg);


            }
        });

    }

/*    private void sonThreadUpdateUi(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mTv.setText("子线程想要更改界面");
            }
        }).start();
    }*/
}
