package jorgesidgo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: JorgeSidgo
 * fecha: 18/04/18
 * Versión: 1.0
 * CopyRight: Jorge Luis Sidgo Pimentel
 * @author Jorge Luis Sidgo Pimentel
 */
public class JorgeSidgo {

    public static void main(String[] args) {
        
        boolean bandera = true;
        int opcion = 0;
        int contador = 0;
        String nombre[] = new String[100];
        double salario[] = new double[100];
        double horas[] = new double[100];
        double sueldoTotal[]  = new double[100];
        int sueldosMayores = 0;
        double sueldoMayor = 0.0;
        double totalNomina = 0.0;
        
        
        String empleados = "";
        
        DecimalFormat df = new DecimalFormat("##.##");
        
        while(bandera)
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una Opción:\n     1- Agregar Empleado \n     2-Calcular Planilla \n     3- Salir"));
             
             switch(opcion)
             {
                 
                // Agregar Empleado 
                case 1:
                     nombre[contador] = JOptionPane.showInputDialog("Ingrese el Nombre del Empleado: ");
                     salario[contador] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo por Hora del Empleado: "));
                     horas[contador] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el número de horas trabajadas por el Empleado: "));
                     sueldoTotal[contador] = (salario[contador] * horas[contador]) - ((salario[contador] * horas[contador]) * 0.10);
                     contador++;
                    break;
                    
                case 2:
                        empleados = "";
                        totalNomina = 0.0;
                        sueldosMayores = 0;
                    for (int i = 0; i <= (contador - 1); i++) {
       
                        empleados += "Nombre: "+nombre[i]+"\nSalario Total: $"+df.format(sueldoTotal[i])+ "\n\n";
                        totalNomina += sueldoTotal[i];
                        
                        if(sueldoTotal[i] > 800)
                        {
                            sueldosMayores++;
                        }
                        if(sueldoMayor < sueldoTotal[i])
                        {
                            sueldoMayor = sueldoTotal[i];
                        }
                    }
                    
                    JOptionPane.showMessageDialog(null, empleados+"\nTotal de la Nomina: $" + totalNomina + "\nCantidad de empleados que superan sueldo de $800.00: " + sueldosMayores + "\nSueldo Mayor: $"+sueldoMayor, "Planilla", 1);
                    break;
                // Salir del Programa        
                case 3: 
                    bandera = false;
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Ingrese una Opción válida", "Error", 1);
                    break;
             }
        }
        
    }
    
}
