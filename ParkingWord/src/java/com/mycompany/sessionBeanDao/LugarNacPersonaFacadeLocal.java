/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.LugarNacPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface LugarNacPersonaFacadeLocal {

    void create(LugarNacPersona lugarNacPersona);

    void edit(LugarNacPersona lugarNacPersona);

    void remove(LugarNacPersona lugarNacPersona);

    LugarNacPersona find(Object id);

    List<LugarNacPersona> findAll();

    List<LugarNacPersona> findRange(int[] range);

    int count();
    
}
