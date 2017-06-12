package singlepageapp.mohanty.dinesh.com.languagetraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView1 = (TextView) findViewById(R.id.numbers);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Numbers.class);
                startActivity(intent);
            }
        });

        TextView textView2 = (TextView) findViewById(R.id.colors);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Colors.class);
                startActivity(intent);
            }
        });

        TextView textView3 = (TextView) findViewById(R.id.family);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Family.class);
                startActivity(intent);
            }
        });

        TextView textView4 = (TextView) findViewById(R.id.phrases);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Phrases.class);
                startActivity(intent);
            }
        });

    }

}
