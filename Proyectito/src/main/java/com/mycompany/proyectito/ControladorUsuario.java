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
public class ControladorUsuario {

    @RequestMapping (value = "/usuario/{usuario}", method = RequestMethod.POST, headers = {"Accept=text/html"}) 
     public @ResponseBody String agregarUsuario(@PathVariable String usuario){ 
         DAOUsuarioImpl.agregarUsuario(new Usuario(usuario));  
         return "El nuevo usuario se ha agregado correctamente"; 
     } 
      
     @RequestMapping (value = "/usuario/{id}/{usuario}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
     public @ResponseBody String actualizar (@PathVariable String usuario){ 
          
         try { 
             DAOUsuarioImpl.actualizar(new Usuario(usuario)); 
             return "El registro se ha modificado correctamente";     
         } catch (Exception e) { 
             return "El registro no existe buuuu"; 
         } 
          
     } 
      
     @RequestMapping (value = "/usuario/{id}/{usuario}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
     public @ResponseBody String borraUsuario (@PathVariable int id, @PathVariable String usuario){ 
          
         try {
             DAOUsuarioImpl.borraUsuario(new Usuario(id,usuario));
            return "El registro se ha eliminado correctamente";     
         } catch (Exception e) { 
             return "El registro no existe"; 
         } 
          
     } 
      
     @RequestMapping (value = "/usuario", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
     public @ResponseBody String buscarTodosUsuarios() throws IOException{ 
          
         ObjectMapper mapper = new ObjectMapper(); 
         return mapper.writeValueAsString(DAOUsuarioImpl.buscarTodosUsuario()); 
     } 
      
     @RequestMapping (value = "/usuario/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
     public @ResponseBody String buscarPorId(@PathVariable int id){ 
          
         return DAOUsuarioImpl.buscarPorId(id).toString(); 
     }     
    
}
