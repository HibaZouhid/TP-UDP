package Ex3;

import java.io.Serializable;
import java.util.Date;

public class Personne implements Serializable {

    private String nom ;
    private String prénom ;
    private Date date_naissance ;

    public Personne(String nom, String prénom, Date date_naissance) {
        this.nom = nom;
        this.prénom = prénom;
        this.date_naissance = date_naissance;
    }
    public int calcul_age(){
        return 0;
    }

    public String getNom() {
        return nom;
    }
}
