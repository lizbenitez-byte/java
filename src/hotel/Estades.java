/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Estades {

private String nifclients;
private ArrayList <Serveis> servei = new ArrayList();    
private LocalDate dataEntrada = LocalDate.now();
private LocalDate dataSortida = null;
private Habitacions Habitacio;
private double importActual = 0;
          

    public Estades(String nifclients, Habitacions Habitacio) {
        this.nifclients = nifclients;
        this.Habitacio = Habitacio;
    
    }

    public String getNifclients() {
        return nifclients;
    }

    public void setNifclients(String nifclients) {
        this.nifclients = nifclients;
    }

    public ArrayList<Serveis> getServei() {
        return servei;
    }

    public void setServei(ArrayList<Serveis> servei) {
        this.servei = servei;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    public Habitacions getHabitacio() {
        return Habitacio;
    }

    public void setHabitacio(Habitacions Habitacio) {
        this.Habitacio = Habitacio;
    }

    public double getImportActual() {
        return importActual;
    }

    public void setImportActual(double importActual) {
        this.importActual = importActual;
    }
    
     public double CalculFactura(double DiesEstada) {
        return (DiesEstada *
                this.getHabitacio().getPreuNit()+ 
                this.getImportActual())* 1.16;
    }
    

    @Override
    public String toString() {
        return "Estades{" + "nifclients=" + nifclients + ", servei=" + servei + ", dataEntrada=" + dataEntrada + ", dataSortida=" + dataSortida + ", Habitacio=" + Habitacio + ", importActual=" + importActual + '}';
    }
    
}