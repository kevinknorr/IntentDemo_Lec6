package com.example.knorr.intentdemo_lec6;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static com.example.knorr.intentdemo_lec6.utils.Utils.AGE_MSG_KEY;
import static com.example.knorr.intentdemo_lec6.utils.Utils.NAME_MSG_KEY;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText editText1;
    private EditText editText2;
    private ListView lsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsView=(ListView)findViewById(R.id.ls_view_ma1);

        final String[] myItems=getResources().getStringArray(R.array.my_itm_lst);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myItems);
        lsView.setAdapter(adapter);

        //Source Code for changing the background found at:
        //http://stackoverflow.com/a/30050942

        lsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0; i < lsView.getChildCount(); i++) {
                    if(position == i ){
                        lsView.getChildAt(i).setBackgroundColor(Color.GRAY);
                    }else{
                        lsView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                Intent intent=new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(AGE_MSG_KEY,"Age is : "+myItems[position]);
                startActivity(intent);
            }
        });

        editText1=(EditText) findViewById(R.id.edttxt_ma1);
        editText2=(EditText) findViewById(R.id.edttxt_ma1_2);
        btn1=(Button)findViewById(R.id.btn1_ma1);
        btn1.setOnClickListener(new MyLstner());

    }

    class MyLstner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this, Main2Activity.class);
            Bundle addon = new Bundle();
            addon.putString(AGE_MSG_KEY,"Age is : "+editText1.getText());
            addon.putString(NAME_MSG_KEY,"Name is : "+editText2.getText());
            intent.putExtras(addon);
            startActivity(intent);
        }
    }
}
