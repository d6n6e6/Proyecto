/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.Convenio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface ConvenioFacadeLocal {

    void create(Convenio convenio);

    void edit(Convenio convenio);

    void remove(Convenio convenio);

    Convenio find(Object id);

    List<Convenio> findAll();

    List<Convenio> findRange(int[] range);

    int count();
    
}
