package com.mycompany.proyectito;

import static com.mycompany.proyectito.DAO.close;
import static com.mycompany.proyectito.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAOLibroImpl extends DAO{
    
    public static void agregarLibro(Libro libro){
        begin();
        getSession().save(libro);
        commit();
        close();
    }
    public static ArrayList<Libro> buscarTodosLibros(){
        begin();
        Query q =getSession().createQuery("from Libro");
        ArrayList<Libro> libro=(ArrayList<Libro>) q.list();
        commit();
        close();
        return libro;
    }
    public static void borrarLibro(Libro libro){
        begin();
        getSession().delete(libro);
        commit();
        close();
    }
    public static Libro buscarPorId(int id){
        begin();
        Query q =getSession().createQuery("from Libro where id=:id");
        q.setInteger("id", id);
        Libro a=(Libro)q.uniqueResult();
        commit();
        close();
        return a;
    }
    public static void actualizar(Libro l){
        begin();
        getSession().update(l);
        commit();
        close();
    }
}
