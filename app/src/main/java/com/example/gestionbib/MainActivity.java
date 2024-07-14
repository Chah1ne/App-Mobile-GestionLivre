package com.example.gestionbib;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.gestionbib.Modification;
import com.example.gestionbib.SQLite;
import com.example.gestionbib.Suppression;

public class MainActivity extends Activity implements OnClickListener {
    private Button btnAjout;
    private Button btnSuppression;
    private Button btnModification;
    private Button btnConsultation;

    private SQLite b;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiser();
        ecouteurs();
    }

    private void initialiser() {
        btnAjout = findViewById(R.id.btnAjout);
        btnSuppression = findViewById(R.id.btnSuppression);
        btnModification = findViewById(R.id.btnModification);
        btnConsultation = findViewById(R.id.btnConsultation);
        b=new SQLite(getApplicationContext(),"bib.db",null,1);
        database = b.getWritableDatabase();
    }

    private void ecouteurs() {
        btnAjout.setOnClickListener(this);
        btnSuppression.setOnClickListener(this);
        btnModification.setOnClickListener(this);
        btnConsultation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=null;
        switch (view.getId()) {
            case R.id.btnAjout:
                i = new Intent(MainActivity.this, Ajout.class);
                break;
            case R.id.btnConsultation:
                i = new Intent(MainActivity.this, Consultation.class);
                break;
            case R.id.btnModification:
                i = new Intent(MainActivity.this, Modification.class);
                break;
            case R.id.btnSuppression:
                i = new Intent(MainActivity.this, Suppression.class);
                break;
        }
        startActivity(i);
    }
}
