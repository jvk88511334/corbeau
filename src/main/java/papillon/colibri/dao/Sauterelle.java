package papillon.colibri.dao;

import java.sql.Date;

public class Sauterelle {
    private int id;
    private Date naissance;
    private String couleur;

    public Sauterelle(int id, Date naissance, String couleur) {
        this.id = id;
        this.naissance = naissance;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Sauterelle{" +
                "id=" + id +
                ", naissance=" + naissance +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
