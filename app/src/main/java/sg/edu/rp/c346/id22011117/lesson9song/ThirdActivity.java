package sg.edu.rp.c346.id22011117.lesson9song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle, etSingers, etYear;
    Song data;
    RadioGroup radioGroup;
    RadioButton rB1, rB2, rB3, rB4, rB5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        etTitle = findViewById(R.id.editTextSongTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        radioGroup = findViewById(R.id.radioGroup);
        rB1 = findViewById(R.id.rB1);
        rB2 = findViewById(R.id.rB2);
        rB3 = findViewById(R.id.rB3);
        rB4 = findViewById(R.id.rB4);
        rB5 = findViewById(R.id.rB5);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
    }

    btnUpdate.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        DBHelper dbh = new DBHelper(ThirdActivity.this);
        data.setSongContent(etTitle, etSingers, etYear);
        dbh.updateSong(data);
        dbh.close();
    }
    });

    btnDelete.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        DBHelper dbh = new DBHelper(ThirdActivity.this);
        dbh.deleteSong(data.getId());

        Intent i = new Intent(ThirdActivity.this,
                SecondActivity.class);
        startActivity(i);

    }
    });
}


