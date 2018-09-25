/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.TipoEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface TipoEmpleadoFacadeLocal {

    void create(TipoEmpleado tipoEmpleado);

    void edit(TipoEmpleado tipoEmpleado);

    void remove(TipoEmpleado tipoEmpleado);

    TipoEmpleado find(Object id);

    List<TipoEmpleado> findAll();

    List<TipoEmpleado> findRange(int[] range);

    int count();
    
}
