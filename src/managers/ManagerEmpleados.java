/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Empleado;

/**
 *
 * @author luis
 */
public class ManagerEmpleados {
    
    
    
    public Empleado getEmpleado(Integer id){
    
        Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        
        Empleado em=(Empleado) ses.get(Empleado.class, id);
      
    
        return em;
    }
    
    public void addEmpleado(Empleado em){
        
     Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        ses.beginTransaction();
        ses.save(em);
        ses.getTransaction().commit();
        
    }
    public void deleteEmpleado(Empleado em){
         Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        ses.beginTransaction();
        ses.delete(em);
        ses.getTransaction().commit();
    
    }
    public void updateEmpleado(Empleado em){
     Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        ses.beginTransaction();
        ses.update(em);
        ses.getTransaction().commit();
    }
    
    public Collection<Empleado> getAllEmpleados(){
        
         Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        
        Query q=ses.createQuery("from Empleado");
        
        List<Empleado> emple=q.list();
        
        
        
        return emple;
    }
    
    public Collection<Empleado> findEmpleadoByPuesto(int idPuesto){
        
        Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        
        Query q= 
            ses.createQuery("from Empleado where idPuesto= :puesto");
        
        q.setInteger("puesto", idPuesto);
    
        
        List<Empleado> l=q.list();
        
        return l;
    
    }
    
    public Collection<Empleado> consultarDatos(String consulta,
            Map<String,Object> params){
        
        Session ses=  HibernateUtil.getSessionFactory().
                openSession();
        Query q=ses.getNamedQuery(consulta);
        
        for (String object : params.keySet()) {
            q.setParameter(object, params.get(object));
        }
        
        Collection<Empleado> l=q.list();
        
        return l;
        
    
    }
           
    
}









































