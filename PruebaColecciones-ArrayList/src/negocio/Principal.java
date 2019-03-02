/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author AlumnoLocal
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alumno gladys=new Alumno("Gladys","Ferrer");
        
        Examen ex1,ex2,ex3,ex4,ex5;
        ex1=new Examen(1,"Inglés",8);
        ex2=new Examen(2,"Gramática española",5);
        ex3=new Examen(3,"Física",10);
        ex4=new Examen(4,"Literatura inglesa",4);
        ex5=new Examen(5,"Java",10);
        
        gladys.addExamen(ex1);
        gladys.addExamen(ex2);
        gladys.addExamen(ex3);
        gladys.addExamen(ex4);
        gladys.addExamen(ex5);
        
        System.out.println(gladys.toString());
        System.out.println("\n\nNota promedio: "+gladys.notaPromedio());
        System.out.println("\n\nNota mayor: "+gladys.notaMayor());
        System.out.println("\n\nNota menor: "+gladys.notaMenor());
        System.out.println("\n\nDiferencia entre la mayor y menor nota: "+gladys.difMayMen());
        System.out.println("\n\nPorcentaje de aprobación: "+gladys.porcAprobacion()+"%");
        
        if(gladys.modificarNotaAExamen(4, 6))
        {
            System.out.println("\n\n"+gladys.toString());
        }
        else
        {
            System.out.println("No se encontró el examen a modificar");
        }
        
        if(gladys.removeExamen(2))
        {
            System.out.println("\n\n"+gladys.toString());
        } 
        else
        {
            System.out.println("No se encontró el examen a eliminar");
        }
        
        System.out.println("\n\nNota promedio: "+gladys.notaPromedio());
        System.out.println("\n\nNota mayor: "+gladys.notaMayor());
        System.out.println("\n\nNota menor: "+gladys.notaMenor());
        System.out.println("\n\nDiferencia entre la mayor y menor nota: "+gladys.difMayMen());
        System.out.println("\n\nPorcentaje de aprobación: "+gladys.porcAprobacion()+"%");
    }
    
}
