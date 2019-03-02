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
public class Examen {
    private int nroExamen;
    private String tema;
    private int nota;
    
    //realizar javadoc
    public Examen(int nro,String t,int nota)
    {
        nroExamen=nro;
        tema=t;
        this.nota=nota;
    }
    
    //realizar javadoc
    public Examen()
    {
        nroExamen=0;
        tema="sin tema";
        nota=0;
    }
    
    /**
     *Método constructor que permite inicializar 
     * un nuevo objeto Examen con los mismos datos
     * que otro objeto examen el cual se recibe como
     * parámetro
     * @param ex objeto de referencia de la clase Examen a partir del cual 
     * se copiarán el valor de sus atributos al nuevo objeto generado
     */ 
    public Examen(Examen ex)
    {
        this.nroExamen=ex.nroExamen;
        this.tema=ex.tema;
        this.nota=ex.nota;
    }
    
    

    
    /**
     * Método de acceso que devuevle el número de examen
     * @return valor int que representa el número que identifica
     * unívocamente a un examen
     */
    public int getNroExamen() {
        return nroExamen;
    }

    //realizar javadoc
    public void setNroExamen(int nroExamen) {
        this.nroExamen = nroExamen;
    }

    //realizar javadoc
    public String getTema() {
        return tema;
    }

   //realizar javadoc
    public void setTema(String tema) {
        this.tema = tema;
    }

    //realizar javadoc
    public int getNota() {
        return nota;
    }

    //realizar javadoc
    public void setNota(int nota) {
        
        if(nota<1 || nota>10)
            nota=0;
        this.nota = nota;
    }
    
    //realizar javadoc
    public String toString()
    {
        return "\nNúmero de examen: "+nroExamen+"\nTema: "+tema+"\nNota: "+nota;
    }
    
    /**
     * Devuelve un true si la nota del examen es mayor o igual que 6, y un 
     * false en caso contrario
     * @return valor boolean que resulta de evaluar si la nota del examen
     * es o no es de aprobación
     */
    public boolean aprobado()
    {
        boolean res=false;
        if(nota>=6)
            res=true;
        return res;
    }
   
}
