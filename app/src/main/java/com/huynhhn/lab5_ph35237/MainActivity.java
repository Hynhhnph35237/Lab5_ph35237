package com.huynhhn.lab5_ph35237;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<modle_location> location1 = new ArrayList<>();
        Spinner spinner = findViewById(R.id.sp_Location);

        location1.add(new modle_location("Hà Nội",R.drawable.logo_ha_noi));
        location1.add(new modle_location("Hồ Chí Minh",R.drawable.hcm_icn));
        location1.add(new modle_location("Tây Nguyên",R.drawable.tn_icon));
        location1.add(new modle_location("Cần Thơ",R.drawable.ct_icon));
        location1.add(new modle_location("Đà Nẵng",R.drawable.danang_icon));

        Adapter_location adapter = new Adapter_location(this,location1);
        spinner.setAdapter(adapter);

        Button button = findViewById(R.id.btn_login);
        EditText ten = findViewById(R.id.txt_ten);
        EditText diachi = findViewById(R.id.txt_diachia);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = spinner.getSelectedItemPosition();
                String sTen = ten.getText().toString();
                String sDiachi = diachi.getText().toString();
                String sCoSo = location1.get(index).getName();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("ten",sTen);
                bundle.putString("location",sDiachi);
                bundle.putString("coSo",sCoSo);
                intent.putExtras(bundle);
                setResult(2,intent);
                finish();


            }
        });

    }
}