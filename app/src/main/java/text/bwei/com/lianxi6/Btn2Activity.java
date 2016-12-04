package text.bwei.com.lianxi6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Btn2Activity extends AppCompatActivity {

    private Button btn22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn2);
        btn22 = (Button) findViewById(R.id.btn22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Test", "点击文字");
                sonThreadUpdateUi();

            }
        });

    }

    private void sonThreadUpdateUi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                btn22.setText("子线程想要更改界面");
            }
        }).start();
    }
}
