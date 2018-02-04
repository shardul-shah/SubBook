package cmput301.subbook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.List;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    private EditText date_text;
    private EditText name_text;
    private EditText comment_text;
    private EditText charge_text;

    private ListView Sub_Records;

    private ArrayList<Record> RecordList;

    private ArrayAdapter<Record> adapter;
    private static final String FILENAME = "subscriptions.sav";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // FIXME  MAYBE USE ACTIVITY_MAIN.XML INSTEAD OF LIST_ROWS HERE or vice versa

        date_text = (EditText) findViewById(R.id.Date);
        name_text = (EditText)findViewById(R.id.Name);
        comment_text = (EditText)findViewById(R.id.Comment);
        charge_text = (EditText)findViewById(R.id.Charge);

        Button EditButton = (Button) findViewById(R.id.edit_btn);
        Button DeleteButton = (Button) findViewById(R.id.delete_btn);

        Sub_Records = (ListView)findViewById(R.id.listView); //bug FIXME

        EditButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String date_str = date_text.getText().toString();
                String name_str = name_text.getText().toString();
                String comment_str = comment_text.getText().toString();
                Double charge_str = Double.parseDouble(charge_text.getText().toString());

                Record record = new Record(name_str, charge_str, comment_str, date_str);
                RecordList.add(record);

                adapter.notifyDataSetChanged();

                //FIXME
                saveInFile();
            }
        });


        DeleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adapter.clear();
                //FIXME
                saveInFile();


            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();

        //FIXME
        loadFromFile();

        adapter = new ArrayAdapter<Record>(this,
                R.layout.list_rows, RecordList);
        Sub_Records.setAdapter(adapter);

    }

    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2018-01-23
            Type listType = new TypeToken<ArrayList<Record>>(){}.getType();
            RecordList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            RecordList = new ArrayList<Record>();
        }

    }

    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(RecordList, out);
            out.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*
    private TextView text;
    private List<String> subListVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.mainText);

      //  ArrayList<String> subListVal = new ArrayList<String>();

        ArrayList<Record> subListVal = new ArrayList<Record>();


        subListVal.add(new Record("Netflix", 10.0));
        subListVal.add(new Record ("Spotify", 5.0));
       // subListVal.add("Github");
       // subListVal.add("Gym");


      /*  ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter <String>(this, R.layout.list_rows, R.id.listText, subListVal);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter); */

        /*
        CustomAdapter adapter = new CustomAdapter(subListVal,this);

        //handle listview and assign adapter
        ListView lView = (ListView) findViewById(R.id.listView);
        lView.setAdapter(adapter);

        Button add_btn = new Button(this);
        add_btn.setText("Add New");
        lView.addFooterView(add_btn);

    } */


    }



