/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.SedeParqueadero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface SedeParqueaderoFacadeLocal {

    void create(SedeParqueadero sedeParqueadero);

    void edit(SedeParqueadero sedeParqueadero);

    void remove(SedeParqueadero sedeParqueadero);

    SedeParqueadero find(Object id);

    List<SedeParqueadero> findAll();

    List<SedeParqueadero> findRange(int[] range);

    int count();
    
}
