package spa.lyh.cn.richtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn1:
                intent = new Intent(MainActivity.this,PreviewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(MainActivity.this,EditActivity.class);
                startActivity(intent);
                break;
        }
    }
}
