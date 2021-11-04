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
    List<T> findAllBy(String property, List<?> values); 
    List<T> findAllBy(String property, List<?> values, Order order); 
    List<T> findAllBy(String property, Object value); 
    List<T> findAllBy(String property, Object value, Order order); 
    List<T> findAll(); 
    List<T> findAll(Order order); 
    T findBy(String property, Object value); 
    
}
