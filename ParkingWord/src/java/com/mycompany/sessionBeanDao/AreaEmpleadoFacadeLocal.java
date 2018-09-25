/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.AreaEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface AreaEmpleadoFacadeLocal {

    void create(AreaEmpleado areaEmpleado);

    void edit(AreaEmpleado areaEmpleado);

    void remove(AreaEmpleado areaEmpleado);

    AreaEmpleado find(Object id);

    List<AreaEmpleado> findAll();

    List<AreaEmpleado> findRange(int[] range);

    int count();
    
}
