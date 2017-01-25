package edu.washington.jackw117.lifecounter;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int[] life = new int[5];
    public View parentView;
    public TextView[] tv = new TextView[5];
    public TextView loser;
    public Button[] plus1 = new Button[5];
    public Button[] plus5 = new Button[5];
    public Button[] minus1 = new Button[5];
    public Button[] minus5 = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            for (int i = 1; i < 5; i++) {
                life[i] = 20;
            }
        }
        parentView = findViewById(R.id.activity_main);
        loser = (TextView) findViewById(R.id.textView2);
        for (int i = 1; i < 5; i++) {
            String tag = "" + i;
            tv[i] = (TextView) parentView.findViewWithTag(tag);
            String text = "" + life[i];
            tv[i].setText(text);

            String plus1tag = i + "plus1";
            plus1[i] = (Button) parentView.findViewWithTag(plus1tag);
            plus1[i].setOnClickListener(new MyListener(1, i));

            String plus5tag = i + "plus5";
            plus5[i] = (Button) parentView.findViewWithTag(plus5tag);
            plus5[i].setOnClickListener(new MyListener(5, i));

            String minus1tag = i + "minus1";
            minus1[i] = (Button) parentView.findViewWithTag(minus1tag);
            minus1[i].setOnClickListener(new MyListener(-1, i));

            String minus5tag = i + "minus5";
            minus5[i] = (Button) parentView.findViewWithTag(minus5tag);
            minus5[i].setOnClickListener(new MyListener(-5, i));
        }
    }

    private class MyListener implements View.OnClickListener {

        int num;
        int player;

        public MyListener(int num, int player) {
            this.num = num;
            this.player = player;
        }

        @Override
        public void onClick(View v) {
            loser.setText("");
            String text = "";
            life[player] += num;
            text += life[player];
            if (life[player] <= 0) {
                loser.setText("Player " + player + " LOSES!");
            }
            tv[player].setText(text);
        }
    }
}
