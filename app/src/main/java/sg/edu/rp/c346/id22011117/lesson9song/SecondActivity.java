package sg.edu.rp.c346.id22011117.lesson9song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btn5Star, btnBack;
    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn5Star = findViewById(R.id.btn5star);
        btnBack = findViewById(R.id.btnBack);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SecondActivity.this);
                ArrayList<Song> filteredSongs = db.getFilteredSongs();
                ArrayList<Song> songs = db.getSong();
                db.close();
                aa.clear();
                aa.addAll(filteredSongs);
                aa.notifyDataSetChanged();

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SecondActivity.this,
                        MainActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
}