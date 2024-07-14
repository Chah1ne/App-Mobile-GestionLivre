package com.example.gestionbib;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Suppression extends Activity {
    private Spinner spLivre;
    private Button btnSupprimer;
    private Button btnRetour;
    private ArrayAdapter<Livre> adpLivre;
    private SQLite b;
    private SQLiteDatabase database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suppression);
        initialiser();
        ecouteurs();
        remplir();
    }

    private void initialiser() {
        spLivre =findViewById(R.id.spLivre);
        btnSupprimer = findViewById(R.id.btnSupprimer);
        btnRetour = findViewById(R.id.btnRetour);
        adpLivre = new ArrayAdapter<Livre>(this, android.R.layout.simple_spinner_item);
        spLivre.setAdapter(adpLivre);
        b=new SQLite(getApplicationContext(),"bib.db",null,1);
        database = b.getWritableDatabase();
    }

    private void remplir() {
        Cursor c= database.query("livre",new String[]{"id","titre","nbpage"},"",null,null,null,null);
        while (c.moveToNext()){
            int id = c.getInt(0);
            String titre = c.getString(1);
            int nbpage = c.getInt(2);
            Livre l = new Livre(id,titre,nbpage);
            adpLivre.add(l);
            Toast.makeText(getApplicationContext(),l.toString(),Toast.LENGTH_LONG).show();
        }
        c.close();
    }

    private void ecouteurs() {
        btnSupprimer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                supprimelivre();
            }
        });
        btnRetour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    protected void supprimelivre() {
        Livre livre=(Livre) spLivre.getSelectedItem();
        database.delete("livre","id="+livre.getId(),null);
    }
}