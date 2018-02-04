package cmput301.subbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private TextView text;
    private List<String> subListVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.mainText);

        ArrayList<String> subListVal = new ArrayList<String>();
      //  subListVal = new ArrayList<String>();

        subListVal.add("Netflix");
        subListVal.add("Github");
        subListVal.add("Spotify");
        subListVal.add("Gym");


      /*  ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter <String>(this, R.layout.list_rows, R.id.listText, subListVal);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter); */

        CustomAdapter adapter = new CustomAdapter(subListVal, this);

        //handle listview and assign adapter
        ListView lView = (ListView) findViewById(R.id.listView);
        lView.setAdapter(adapter);

        Button add_btn = new Button(this);
        add_btn.setText("Add New");
        lView.addFooterView(add_btn);

    }


    }



