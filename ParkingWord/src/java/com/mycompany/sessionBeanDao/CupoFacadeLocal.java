/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.Cupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface CupoFacadeLocal {

    void create(Cupo cupo);

    void edit(Cupo cupo);

    void remove(Cupo cupo);

    Cupo find(Object id);

    List<Cupo> findAll();

    List<Cupo> findRange(int[] range);

    int count();
    
}
