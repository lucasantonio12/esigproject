/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.io.Serializable; 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order; 
/**
 *
 * @author lucas
 */
public interface IGenericDao<T, ID extends Serializable> { 
 
    void salvar(T object);
    void deletar(T object); 
    T buscarId(ID id);
 
  
    
}
