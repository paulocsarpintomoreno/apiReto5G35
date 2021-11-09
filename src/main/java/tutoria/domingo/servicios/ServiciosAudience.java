/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Audience;
import tutoria.domingo.repositorio.RepositorioAudience;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosAudience {
     @Autowired
    private RepositorioAudience metodosCrud;
    
    public List<Audience> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Audience> getAudience(int idAudience){
        return metodosCrud.getAudience(idAudience);
    }
    
    public Audience save(Audience audience){
        if(audience.getId()==null){
            return metodosCrud.save(audience);
        }else{
            Optional<Audience> evt=metodosCrud.getAudience(audience.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(audience);
            }else{
                return audience;
            }
        }
    }
    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience> e=metodosCrud.getAudience(audience.getId());
            if(!e.isEmpty()){
                if(audience.getName()!=null){
                    e.get().setName(audience.getName());
                }
                if(audience.getOwner()!=null){
                    e.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    e.get().setYear(audience.getCapacity());
                }
                if(audience.getDescription()!=null){
                    e.get().setDescription(audience.getDescription());
                }
                if(audience.getCategory()!=null){
                    e.get().setCategory(audience.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return audience;
            }
        }else{
            return audience;
        }
    }


    public boolean deleteAudience(int audienceId) {
        Boolean aBoolean = getAudience(audienceId).map(audience -> {
            metodosCrud.delete(audience);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
