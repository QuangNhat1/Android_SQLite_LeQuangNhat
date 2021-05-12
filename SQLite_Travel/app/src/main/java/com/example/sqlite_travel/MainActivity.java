package com.example.sqlite_travel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqlite_travel.Model_travel.Travel;
import com.example.sqlite_travel.adapter.CustomAdapter;
import com.example.sqlite_travel.data.DBManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText edtName;
    private Button btnSave;
    private Button btnCancel;
    private ListView lvTravel;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Travel> travels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager dbManager = new DBManager(this);
        initWidget();
        travels = dbManager.getAllTravel();

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Travel travel = createTravel();
                if (travel != null) {
                    dbManager.addTravel(travel);
                }
                travels.clear();
                travels.addAll(dbManager.getAllTravel());
                setAdapter();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private Travel createTravel(){
        String name = edtName.getText().toString();

        Travel travel = new Travel(name);
        return travel;

    }
    public void initWidget(){
        edtName =(EditText) findViewById(R.id.edt_name);
        btnSave =(Button) findViewById(R.id.btn_save);
        btnCancel =(Button) findViewById(R.id.btn_cancel);
        lvTravel = (ListView) findViewById(R.id.lv_travel);
    }
    private void setAdapter(){
        if(customAdapter==null){
            customAdapter= new CustomAdapter(this,R.layout.item_list_travel,travels);
            lvTravel.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            lvTravel.setSelection(customAdapter.getCount()-1);
        }

    }
}