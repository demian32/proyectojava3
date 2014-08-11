
package com.mycompany.proyectito;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOPrestoImpl extends DAO {
    
    public static void agregarPrestamo(Prestamolibro prestamo){
        begin();
        getSession().save(prestamo);
        commit();
        close();
    }
    public static ArrayList<Prestamolibro> buscarTodosPrestamos() { 
         begin();  
         Criteria c=getSession().createCriteria(Prestamolibro.class); 
         ArrayList<Prestamolibro> pre = (ArrayList<Prestamolibro>)c.list(); 
         commit(); 
         close();
         return pre;
    }
    public static void eliminarPrestamo(Prestamolibro prestamo){
        begin();
        getSession().delete(prestamo);
        commit();
        close();
    }
    public  static Prestamolibro buscarPorId(int idpres){ 
       begin(); 
      Query q = getSession().createQuery("from Prestamolibro where idpres = :idpres"); 
         q.setInteger("idpres",idpres); 
         Prestamolibro pr = (Prestamolibro)q.uniqueResult(); 
         commit(); 
         close(); 
 return pr;   
     
   }
    public static void actualizar(Prestamolibro p){
        begin();
        getSession().update(p);
        commit();
        close();
    }

}
