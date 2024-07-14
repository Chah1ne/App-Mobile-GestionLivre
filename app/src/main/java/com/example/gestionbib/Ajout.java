package com.example.gestionbib;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionbib.SQLite;

public class Ajout extends Activity {
    private EditText edTitre;
    private EditText edNbPage;
    private Button btnAjouter;
    private Button btnRetour;
    private SQLite b;
    private SQLiteDatabase database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout);
        initialiser();
        ecouteurs();
    }

    private void initialiser() {

        edTitre = findViewById(R.id.edTitre);
        edNbPage = findViewById(R.id.edNbPage);
        btnAjouter = findViewById(R.id.btnAjouter);
        btnRetour = findViewById(R.id.btnRetour);
        b=new SQLite(getApplicationContext(),"bib.db",null,1);
        database = b.getWritableDatabase();
    }

    private void ecouteurs() {
        btnRetour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        btnAjouter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ajoutLivre();
            }
        });
    }

    private void ajoutLivre() {
        ContentValues cv=new ContentValues();
        cv.put("titre",edTitre.getText().toString());
        cv.put("nbpage",Integer.parseInt(edNbPage.getText().toString()));
        database.insert("livre",null,cv);
    }
}