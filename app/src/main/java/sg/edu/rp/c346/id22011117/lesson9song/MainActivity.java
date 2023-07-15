package sg.edu.rp.c346.id22011117.lesson9song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    TextView tvTitle, tvSingers, tvYear, tvStars, tvResults;
    EditText etTitle, etSingers, etYear;
    ListView lv;

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnShowList);
        tvTitle = findViewById(R.id.textViewSongTitle);
        tvSingers = findViewById(R.id.textViewSingers);
        tvYear = findViewById(R.id.textViewYear);
        tvStars = findViewById(R.id.textViewStars);
        tvResults = findViewById(R.id.textViewResults);
        etTitle = findViewById(R.id.editTextSongTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        lv = findViewById(R.id.listView);

        etSingers.setText("");
        etTitle.setText("");
        etYear.setText("");
        radioGroup.clearCheck();


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = RadioGroup.getCheckedRadioButtonId();
                int stars = 0;
                if (radioID == R.id.rB1) {
                    stars = 1;
                } else if (radioID == R.id.rB2) {
                    stars = 2;
                } else if (radioID == R.id.rB3) {
                    stars = 3;
                } else if (radioID == R.id.rB4) {
                    stars = 4;
                } else if (radioID == R.id.rB5) {
                    stars = 5;
                }

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertSong(etTitle.getText().toString(), etSingers.getText().toString(),
                        etYear.getText().toString(), stars);

                etSingers.setText("");
                etTitle.setText("");
                etYear.setText("");
                radioGroup.setId(-1);

            }
    });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                DBHelper db = new DBHelper(MainActivity.this);


                ArrayList<String> data = db.getTaskContent();

                ArrayList<Song> alTasks = db.getSong();

                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);

                ArrayAdapter<Song> aaTasks = new ArrayAdapter<Song>(MainActivity.this, android.R.layout.simple_list_item_1, alTasks);
                lv.setAdapter(aaTasks);
            }
        });
    }
}