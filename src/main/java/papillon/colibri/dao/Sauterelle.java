package papillon.colibri.dao;

import java.sql.Date;

public class Sauterelle {
    private int id;
    private Date naissance;
    private String couleur;
    private String nom;

    public Sauterelle(int id, Date naissance, String couleur) {
        this.id = id;
        this.naissance = naissance;
        this.couleur = couleur;
    }

    public Sauterelle(int id, Date naissance, String couleur, String nom) {
        this.id = id;
        this.naissance = naissance;
        this.couleur = couleur;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Sauterelle{" +
                "id=" + id +
                ", naissance=" + naissance +
                ", couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
