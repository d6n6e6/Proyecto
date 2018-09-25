/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.TurnoEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface TurnoEmpleadoFacadeLocal {

    void create(TurnoEmpleado turnoEmpleado);

    void edit(TurnoEmpleado turnoEmpleado);

    void remove(TurnoEmpleado turnoEmpleado);

    TurnoEmpleado find(Object id);

    List<TurnoEmpleado> findAll();

    List<TurnoEmpleado> findRange(int[] range);

    int count();
    
}
