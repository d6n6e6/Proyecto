/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionBeanDao;

import com.mycompany.entity.TipoContrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andres
 */
@Stateless
public class TipoContratoFacade extends AbstractFacade<TipoContrato> implements TipoContratoFacadeLocal {

    @PersistenceContext(unitName = "ParkingWordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoContratoFacade() {
        super(TipoContrato.class);
    }
    
}
