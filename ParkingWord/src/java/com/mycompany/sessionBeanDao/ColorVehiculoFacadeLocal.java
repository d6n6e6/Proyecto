/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.ColorVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface ColorVehiculoFacadeLocal {

    void create(ColorVehiculo colorVehiculo);

    void edit(ColorVehiculo colorVehiculo);

    void remove(ColorVehiculo colorVehiculo);

    ColorVehiculo find(Object id);

    List<ColorVehiculo> findAll();

    List<ColorVehiculo> findRange(int[] range);

    int count();
    
}
