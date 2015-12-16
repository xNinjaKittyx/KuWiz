package io.github.xninjakittyx.kuwiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t = ((TextView)findViewById(R.id.textResult));

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        switch (score) {
            case 0:
            case 1:
                t.setText("Wow you really don't know anything do you.");
                break;
            case 2:
            case 3:
                t.setText("Alright, you're decent.");
                break;
            case 4:
            case 5:
                t.setText("You're definitely a CS Major");
                break;
        }
    }
}
