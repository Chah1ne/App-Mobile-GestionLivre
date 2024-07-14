package com.example.gestionbib;

import java.io.Serializable;

public class Livre implements Serializable {
    private int id;
    private String titre;
    private int nbpage;

    public Livre(int id, String titre, int nbpage) {
        this.id = id;
        this.nbpage = nbpage;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public int getNbpage() {
        return nbpage;
    }

    public String toString() {
        return id + "-" + titre + "-" + nbpage;
    }
}
