package cmput301.subbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
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

        subListVal = new ArrayList<String>();

        subListVal.add("Netflix");
        subListVal.add("Github");
        subListVal.add("Spotify");
        subListVal.add("Gym");


        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter <String>(this, R.layout.list_rows, R.id.listText, subListVal);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);

    }


    }



