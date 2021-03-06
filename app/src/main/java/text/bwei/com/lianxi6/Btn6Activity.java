package text.bwei.com.lianxi6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Btn6Activity extends AppCompatActivity {
    private TextView mTextView;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTextView.setText(msg.obj + "" + "arg1=" + msg.arg1 + " arg2=" + msg.arg2);
            super.handleMessage(msg);
        }
    };

    private class Person {
        String name;
        int age;

        @Override
        public String toString() {
            return "name=" + name + " age=" + age;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn6);
        mTextView = (TextView) findViewById(R.id.btn66);

        new Thread() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();//同样可以获取Message对象
                msg.arg1 = 1;
                msg.arg2 = 2;
                Person person = new Person();
                person.name = "pig";
                person.age = 10;
                msg.obj = person;
                msg.sendToTarget();
            }
        }.start();

    }
}
