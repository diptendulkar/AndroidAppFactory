package com.dip.androidappfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.dip.alarmmanager.AlarmMainActivity;
import com.dip.profilepicture.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listview = (ListView) findViewById(R.id.listview);

        /*Add all Modules here*/
        String[] values = new String[] { "Alarm Manager" ,"Profile Photo"  };

       /* final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemAtPosition = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemAtPosition, Toast.LENGTH_LONG).show();
                if (itemAtPosition.equals("Alarm Manager")) {

                    Intent launchIntent = new Intent(view.getContext(), AlarmMainActivity.class);
                    startActivity(launchIntent);

                } else if (itemAtPosition.equals("Profile Photo")) {
                    Intent launchIntent = new Intent(view.getContext(), ProfileActivity.class);
                    startActivity(launchIntent);
                }
            }
        });
    }
}
