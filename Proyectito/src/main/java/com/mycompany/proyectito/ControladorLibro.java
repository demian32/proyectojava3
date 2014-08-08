package com.mycompany.proyectito;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/") 
public class ControladorLibro {
    
       @RequestMapping (value = "/libro/{nombre}/{autor}/{precio}", method = RequestMethod.POST, headers = {"Accept=text/html"}) 
     public @ResponseBody String agregarLibro(@PathVariable String nombre,@PathVariable String autor,@PathVariable float precio){ 
         DAOLibroImpl.agregarLibro(new Libro(nombre, autor, precio));
         return "El nuevo libro se ha agregado correctamente"; 
     } 
      
     @RequestMapping (value = "/libro/{nombre}/{autor}/{precio}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
     public @ResponseBody String actualizar (@PathVariable String nombre,@PathVariable String autor,@PathVariable float precio){ 
          
         try {
             DAOLibroImpl.actualizar(new Libro(nombre, autor, precio)); 
             return "El registro se ha modificado correctamente";     
         } catch (Exception e) { 
             return "El registro no existe buuuu"; 
         } 
          
     } 
      
     @RequestMapping (value = "/libro/{id}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
     public @ResponseBody String borrarLibro (@PathVariable int id, @PathVariable String nombre){ 
          
         try {
             DAOLibroImpl.borrarLibro(new Libro(id, nombre));
            return "El registro se ha eliminado correctamente";     
         } catch (Exception e) { 
             return "El registro no existe"; 
         } 
          
     } 
      
     @RequestMapping (value = "/libro", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
     public @ResponseBody String buscarTodosLibros() throws IOException{ 
          
         ObjectMapper mapper = new ObjectMapper(); 
         return mapper.writeValueAsString(DAOLibroImpl.buscarTodosLibros()); 
     } 
      
     @RequestMapping (value = "/libro/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
     public @ResponseBody String buscarPorId(@PathVariable int id){ 
          
         return DAOLibroImpl.buscarPorId(id).toString(); 
     }     
    
}
