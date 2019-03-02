/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import java.util.ArrayList;
/**
 *
 * @author AlumnoLocal
 */
public class Alumno {
    private int legajo;
    private static int nro=1;
    private String nombre;
    private String apellido;
    private ArrayList examenes;
    /*private ArrayList<Examen> examenes;
    Estoy declarando un ArrayList que manejará
    objetos de la clase Examen. Esto me permite
    no realizar el casteo cada vez que acceda
    a un elemento de la colección y lo asigne
    a una variable de la clase Examen.
    */
    //private Examen[] examenes;
    
    public Alumno(String nom,String ape)
    {
        legajo=nro;
        nro=nro+1;
        nombre=nom;
        apellido=ape;
        examenes=new ArrayList(30);//constructor con parámetro que permite definir el tamaño "inicial" del ArrayList
        //examenes=new Examen[30];
    }

    public int getLegajo() {
        return legajo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public boolean addExamen(Examen ex)
    {
        /*con vector
        boolean res=false;
        for(int i=0;i<examenes.length;i++)
            if(examenes[i]!=null
            {
                examenes[i]=ex;
                res=true;
                break;
            }
        return res;
        */
        return examenes.add(ex);
    }
    
    public boolean removeExamen(int cod)
    {
        /*con vector
        boolean res=false;
        for(int i=0;i<examenes.length;i++)
            if(examenes[i]!=null && examenes[i].getCodigo()==cod)
            {
                examenes[i]=null;
                res=true;
                break;
            }
        return res;
        */
        boolean res=false;
        Examen ex=null;
        for(int i=0;i<examenes.size();i++)
        {
            ex=(Examen)examenes.get(i);
            if(ex.getNroExamen()==cod)
            {
                res=examenes.remove(ex);
                break;
            }
        }
        return res;
    }
    
    public float notaPromedio()
    {
        int suma=0;
        int cant=examenes.size();
        float prom=0f;
        Examen ex=null;
        if(cant>0)
        {
            for(int i=0;i<cant;i++)
            {
                ex=(Examen)examenes.get(i);
                //ex=examenes[i];
                suma=suma+ex.getNota();
            }
            prom=(float)suma/cant;
        }
        return prom;
    }
    
    public int notaMayor()
    {
        /*Examen ex=null;
        int cant=examenes.size();
        int may=0;
        if(cant>0)
        {
            may=((Examen)examenes.get(0)).getNota();
            for(int i=1;i<cant;i++)
            {
                ex=(Examen)examenes.get(i);
                if(may<ex.getNota())
                    may=ex.getNota();
            }
        }
        return may;  */ 
        
        Examen ex=null;
        int cant=examenes.size();
        Examen mayEx=null;
        int may=0;
        if(cant>0)
        {
            mayEx=(Examen)examenes.get(0);
            for(int i=1;i<cant;i++)
            {
                ex=(Examen)examenes.get(i);
                if(mayEx.getNota()<ex.getNota())
                    mayEx=ex;
            }
            may=mayEx.getNota();
        }
        return may;
    }
    
    
    public int notaMenor()
    {
        /*Examen ex=null;
        int cant=examenes.size();
        int men=0;
        if(cant>0)
        {
            men=((Examen)examenes.get(0)).getNota();
            for(int i=1;i<cant;i++)
            {
                ex=(Examen)examenes.get(i);
                if(men>ex.getNota())
                    men=ex.getNota();
            }
        }
        return may;  */ 
        
        //Examen ex=null;
        int cant=examenes.size();
        int men=0;
        Examen menEx=null;
        if(cant>0)
        {
            menEx=(Examen)examenes.get(0);
            for(Object ex:examenes)
            {
                if(menEx.getNota()>((Examen)ex).getNota())
                {
                  menEx=(Examen)ex;
                }
            }
            men=menEx.getNota();
        }
        return men;
    }
    
    public double porcAprobacion()
    {
        int cantApro=0;
        int cant=examenes.size();
        double porc=0.0;
        //for(ClaseDeObjetoEnLaColeccion varIt:nombreColeccion)
        if(cant>0)
        {
            for(Object ex:examenes)
            {
                if(((Examen)ex).aprobado())
                    cantApro++;
            }
            porc=cantApro*100/cant;
        }
        return porc;  
    }
    
    public int difMayMen()
    {
        int dif=-1;
        if(examenes.size()>=2)
            dif=notaMayor()-notaMenor();
        return dif;  
    }
    
    public String toString()
    {
        String aux="Legajo: "+getLegajo()+"\nNombre: "+getNombre()+"\nApellido: "+getApellido();
        for(Object ex:examenes)
        {
            aux+="\n"+((Examen)ex).toString();
        }
        return aux;
    }
    
    public boolean modificarNotaAExamen(int cod,int nuevaNota)
    {
        Examen buscado=buscarExamen(cod);
        boolean res=false;
        if(buscado!=null)
        {
            buscado.setNota(nuevaNota);
            res=true;
        }
        
        return res;
    }
    
    private Examen buscarExamen(int cod)
    {
        Examen buscado=null;
        for(Object ex:examenes)
        {
            if(((Examen)ex).getNroExamen()==cod)
            {
                //buscado=new Examen((Examen)ex);generamos una copia, en lugar de asingar el objeto original
                buscado=(Examen) ex;//asignamos directamente el objeto original de la colección, desde el cual se podrá modificar a traves de esta copia de referencias
                break;
            }
        }
        return buscado;
        
   
    }
   
}
