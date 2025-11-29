/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author ACER
 */
public class Serveis {
   
    private int idServei;
    private String descripcio;
    private double preu;

    public Serveis(int idServei, String descripcio, double preu) {
        this.idServei = idServei;
        this.descripcio = descripcio;
        this.preu = preu;
    }

    public int getIdServei() {
        return idServei;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public double getPreu() {
        return preu;
    }
    
    //setters

    public void setIdServei(int idServei) {
        this.idServei = idServei;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    //to string

    @Override
    public String toString() {
        return "\nServeis{" + "idServei=" + idServei + ", descripcio=" + descripcio + ", preu=" + preu + '}';
    }
    
    
}
