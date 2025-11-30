    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author ACER
 */
//atributs
public class Clients {
    
    private String nom;
    private String nif;
    private String dataNaix;
    private String localitat ;
    private boolean cobrat;
    private boolean checkin;

    public Clients(String nif, String nom,  String dataNaix, String localitat) {
        this.nif = nif;
        this.nom = nom;
        this.dataNaix = dataNaix;
        this.localitat = localitat;
        this.cobrat = false;
        this.checkin = false;
    }
    //Getters
    public Clients(){}

    public boolean isCheckin() {
        return checkin;
    }
    public String getNif() {
        return nif;
    }

    public String getNom() {
        return nom;
    }

    public String getDataNaix() {
        return dataNaix;
    }

    public String getLocalitat() {
        return localitat;
    }

    public boolean isCobrat() {
        return cobrat;
    }
    
    //Setters

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDataNaix(String dataNaix) {
        this.dataNaix = dataNaix;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    public void setCobrat(boolean cobrat) {
        this.cobrat = cobrat;
    }
    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }
    //to String

    @Override
    public String toString() {
        return "Clients{" + "nif=" + nif + ", nom=" + nom + ", dataNaix=" + dataNaix + ", localitat=" + localitat + ", cobrat=" + cobrat + '}';
    }
    
}


