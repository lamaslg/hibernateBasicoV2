/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javausahibernate;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import managers.ManagerEmpleados;
import pojos.Conocimientos;
import pojos.Empleado;
import pojos.Puesto;

/**
 *
 * @author luis
 */
public class JavaUsaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ManagerEmpleados me=new ManagerEmpleados();
        
       Puesto p=new Puesto();
        p.setIdPuesto(1);
       
        
        Empleado em1=new Empleado("Juan perez", 65000, new Date(), p);
        
        me.addEmpleado(em1);
        
        //Collection<Empleado> le=me.findEmpleadoByPuesto(1);
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("nombre", "Juan Perez");
        
        Collection<Empleado> le=me.consultarDatos("findByNombre", params);
        
        
        
        for (Empleado empleado : le) {
            
            System.out.println("Nombre:"+empleado.getNombre());
            System.out.println("Salario:"+empleado.getSalario());
            System.out.println("Puesto:"+empleado.getPuesto().getNombre());
            System.out.println("Conocimientos:");
            for (Conocimientos conocimiento : empleado.getConocimientos()) {
                
                System.out.println(conocimiento.getNombre());
                
            }
        }
        
        
        
        
    }
    
}
