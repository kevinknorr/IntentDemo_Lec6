package com.example.knorr.intentdemo_lec6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.knorr.intentdemo_lec6.utils.Utils.AGE_MSG_KEY;
import static com.example.knorr.intentdemo_lec6.utils.Utils.NAME_MSG_KEY;

public class Main2Activity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1=(TextView)findViewById(R.id.tv1_ma2);
        String incomingAge = getIntent().getExtras().getString(AGE_MSG_KEY);

        textView2=(TextView)findViewById(R.id.tv2_ma2);
        String incomingName = getIntent().getExtras().getString(NAME_MSG_KEY);

        textView3=(TextView)findViewById(R.id.tv3_ma2);

        textView1.setText(incomingAge);
        textView2.setText(incomingName);
    }
}
