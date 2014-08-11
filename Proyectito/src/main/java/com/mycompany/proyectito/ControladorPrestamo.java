package com.mycompany.proyectito;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;


@Controller 
@RequestMapping("/") 
public class ControladorPrestamo {
    @RequestMapping( value ="/prestamo/{id_a}/{id_l}/{fecha}/{cantidad/{total}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable int id_a, @PathVariable int id_l, 
            @PathVariable Date fecha, @PathVariable int cantidad,@PathVariable float total){
     try{
         DAOPrestoImpl.agregarPrestamo(new Prestamolibro(fecha,cantidad,total,new Usuario(id_a),new Libro(id_l)));;
            return "El registro se ha insertado correctamente";
        } catch (Exception e) {
            return "La categoria o el proveedor no existen";
        }
    }
    
    @RequestMapping (value = "/prestamo/{idpres}/{id_a}/{id_l}/{fecha}/{cantidad}/{total}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int idpres,@PathVariable int id_a, @PathVariable int id_l, 
            @PathVariable Date fecha, @PathVariable int cantidad,@PathVariable float total){
        
        try {
            DAOPrestoImpl.actualizar(new Prestamolibro(idpres,fecha,cantidad,total,new Usuario(id_a),new Libro(id_l)));
            return "El registro se ha actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el registro";
        }
    }
    
    @RequestMapping (value = "/prestamo/{idpres}/{total}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int idpres, @PathVariable float total){
        
        try {
            DAOPrestoImpl.eliminarPrestamo(new Prestamolibro(idpres,total));
            return "El registro se ha eliminado";
        } catch (Exception e) {
            return "Error al borrar el registro";
        }
    }
    
    @RequestMapping (value = "/productos", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOPrestoImpl.buscarTodosPrestamos());
    }
    
    @RequestMapping (value = "/productos/{idpres}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int idpres){
        
        return DAOPrestoImpl.buscarPorId(idpres).toString();
    }
}
