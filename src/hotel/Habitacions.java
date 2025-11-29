/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author ACER
 */
public class Habitacions {
    
    private int numHabitacio;
    private int preuNit;
    private boolean lliure;

    public Habitacions(int numHabitacio, int preuNit, boolean lliure) {
        this.numHabitacio = numHabitacio;
        this.preuNit = preuNit;
        this.lliure = true;
    }
    //getter

    public int getNumHabitacio() {
        return numHabitacio;
    }

    public int getPreuNit() {
        return preuNit;
    }

    public boolean isLliure() {
        return lliure;
    }
    //setter

    public void setNumHabitacio(int numHabitacio) {
        this.numHabitacio = numHabitacio;
    }

    public void setPreuNit(int preuNit) {
        this.preuNit = preuNit;
    }

    public void setLliure(boolean lliure) {
        this.lliure = lliure;
    }
    // tostring

    @Override
    public String toString() {
        return "\nHabitacions{" + "numHabitacio=" + numHabitacio + ", preuNit=" + preuNit + ", lliure=" + lliure + '}';
    }
    
    
}
