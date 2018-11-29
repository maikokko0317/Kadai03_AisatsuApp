package jp.techacademy.saito.maiko.kadai03_aisatsuapp;

import android.app.TimePickerDialog;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    String aisatsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            //Log.d("UI_PARTS", "おはよう");
                            aisatsu = " おはよう";
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            //Log.d("UI_PARTS", "こんにちは");
                            aisatsu = " こんにちは";
                        } else if ((hourOfDay >= 18 && hourOfDay <= 24) || (hourOfDay >= 0 && hourOfDay <= 1)) {
                            //Log.d("UI_PARTS", "こんばんは");
                            aisatsu = " こんばんは";
                        }
                        mTextView.setText(aisatsu);
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
