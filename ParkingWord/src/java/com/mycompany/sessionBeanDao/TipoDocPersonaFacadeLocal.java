/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.TipoDocPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface TipoDocPersonaFacadeLocal {

    void create(TipoDocPersona tipoDocPersona);

    void edit(TipoDocPersona tipoDocPersona);

    void remove(TipoDocPersona tipoDocPersona);

    TipoDocPersona find(Object id);

    List<TipoDocPersona> findAll();

    List<TipoDocPersona> findRange(int[] range);

    int count();
    
}
