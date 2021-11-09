/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.interfaces.InterfaceAudience;
import tutoria.domingo.modelo.Audience;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioAudience {
     @Autowired
    private InterfaceAudience crud;
    

    public List<Audience> getAll(){
        return (List<Audience>) crud.findAll();       
    }
    
    public Optional <Audience> getAudience(int id){
        return crud.findById(id);
    }
    
    public Audience save(Audience audience){
        return crud.save(audience);
    }
      public void delete(Audience audience){
        crud.delete(audience);
    }
    
    
}
