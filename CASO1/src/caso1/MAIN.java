/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso1;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Chavarria Ramirez 
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula: "));
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono: ");
        String categoria = JOptionPane.showInputDialog("Categoria VIP o Regular:").toLowerCase();
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del mes: "));
        
        while (mes < 1 || mes > 12){
            mes = Integer.parseInt(JOptionPane.showInputDialog("Erro. Mes fuera de rango, ingreselo de nuevo: "));
        }
        
        String mes_nombre = "";
        
        switch (mes) {
            case 1: mes_nombre = "enero"; 
            break;
            case 2: mes_nombre = "febrero"; 
            break;
            case 3: mes_nombre = "marzo"; 
            break;
            case 4: mes_nombre = "abril"; 
            break;
            case 5: mes_nombre = "mayo"; 
            break;
            case 6: mes_nombre = "junio"; 
            break;
            case 7: mes_nombre = "julio"; 
            break;
            case 8: mes_nombre = "agosto"; 
            break;
            case 9: mes_nombre = "septiembre"; 
            break;
            case 10: mes_nombre = "octubre"; 
            break;
            case 11: mes_nombre = "noviembre"; 
            break;
            case 12: mes_nombre = "diciembre"; 
            break;
        }
        
        double TotalGeneral = 0;
        int TotalPuntos = 0;
        int contador = 0;
        
        String continuar = "si";
        
        while("si".equals(continuar)) {
            
            Alquiler obj = new Alquiler();
            
            obj.setPlaca(JOptionPane.showInputDialog("Placa del vehiculo:"));
            obj.setMarca(JOptionPane.showInputDialog("Marca del vehiculo:"));
            obj.setPrecioDia(Double.parseDouble(JOptionPane.showInputDialog("Precio por dia:")));
            
            int dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dias: "));
            
            obj.setDias(dias);
            obj.setSeguro(JOptionPane.showInputDialog("Indique si incluye seguro (si/no): "));
            obj.setGps(JOptionPane.showInputDialog("Indique si incluye gps (si/no): "));
            
            double subtotal = obj.calcularSubtotal();
            int puntos = obj.calcularPuntos();
            
            TotalGeneral = TotalGeneral + subtotal;
            TotalPuntos = TotalPuntos + puntos;
            contador ++;
            
            JOptionPane.showMessageDialog(null,"Vehiculo ingresado correctamente");

            continuar = JOptionPane.showInputDialog("Indique si desea ingresar otro vehiculo (si/no): ").toLowerCase();
            
        }
        
        double TotalFinal = TotalGeneral;
        int PuntosAntes = TotalPuntos;
        
        if (categoria.equals("vip")) {
            TotalFinal = TotalGeneral - (TotalGeneral * 0.05);
            TotalPuntos = TotalPuntos * 2;
        }
        
        String resultado = "\tResumen final de alquileres\n";
        resultado += "Cliente: " + nombre + "\n";
        resultado += "Cedula: " + cedula + "\n";
        resultado += "Categoria: " + categoria + "\n";
        resultado += "Mes de registro: " + mes_nombre + "\n";
        resultado += "Cantidad de vehiculos procesados: " + contador + "\n";
        resultado += "Subtotal antes de descuento VIP: " + TotalGeneral + "\n";
        resultado += "Puntos antes del bono VIP: " + PuntosAntes + "\n";
        
        if (categoria.equals("vip")) {
            resultado +=  "\t  * Aplicando beneficios vip (5% Descuento / Puntos x2) *\n";
        }
        resultado += "Total a pagar: " + TotalFinal + "\n";
        resultado += "Puntos de lealtad totales: " + TotalPuntos + "\n";
        
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
