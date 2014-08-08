
package com.mycompany.proyectito;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOPrestoImpl extends DAO {
    
    public void agregarPrestamo(Prestamolibro prestamo){
        begin();
        getSession().save(prestamo);
        commit();
        close();
    }
    public ArrayList<Prestamolibro> buscarTodosPrestamos() { 
         begin();  
         Criteria c=getSession().createCriteria(Prestamolibro.class); 
         ArrayList<Prestamolibro> pre = (ArrayList<Prestamolibro>)c.list(); 
         commit(); 
         close();
         return pre;
    }
    public void eliminarPrestamo(Prestamolibro prestamo){
        begin();
        getSession().delete(prestamo);
        commit();
        close();
    }
    public Prestamolibro buscarPorId(int idpres){ 
       begin(); 
      Query q = getSession().createQuery("from Prestamolibro where idpres = :idpres"); 
         q.setInteger("idpres",idpres); 
         Prestamolibro pr = (Prestamolibro)q.uniqueResult(); 
         commit(); 
         close(); 
 return pr;   
     
   }
    public void actualizar(Prestamolibro p){
        begin();
        getSession().update(p);
        commit();
        close();
    }

}
