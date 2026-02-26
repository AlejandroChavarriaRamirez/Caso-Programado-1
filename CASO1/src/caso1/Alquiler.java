/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso1;

/**
 *
 * @author Alejandro Chavarria Ramirez
 */
public class Alquiler {
    private String placa;
    private String marca;
    private double precioDia;
    private int dias;
    private String seguro;
    private String gps;
    
    public Alquiler() {
        
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getPlaca() {
        return placa;
    }
    
    public double calcularSubtotal() {

        double base = precioDia * dias;
        double descuento = 0;
        double recSeguro = 0;
        double recGps = 0;

        if (dias > 7) {
            descuento = base * 0.15;
        }

        if (seguro.equals("si")) {
            recSeguro = 5000 * dias;
        }

        if (gps.equals("si")) {
            recGps = 2000 * dias;
        }

        double total = (base - descuento) + recSeguro + recGps;

        return total;
    }

    public int calcularPuntos() {

        int puntos = 0;

        if (dias > 7) {
            puntos = puntos + 5;
        }

        if (seguro.equals("si")) {
            puntos = puntos + 2;
        }

        return puntos;
        
    }
}
