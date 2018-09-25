/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Bean;

import com.mycompany.entity.Empresa;
import com.mycompany.sessionBeanDao.EmpresaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Andres
 */
@ManagedBean(name = "empresaMB")
@SessionScoped
public class EmpresaBean implements Serializable {

    @EJB
    private EmpresaFacadeLocal EmpresaFacade;
    private Empresa empresa;
    private List<Empresa> listaempresa;

    public EmpresaBean() {
        empresa = new Empresa();
    }

    public List<Empresa> getListavempresa() {
        listaempresa = EmpresaFacade.findAll();
        return listaempresa;
    }

    public String verDetalleEmpresa() {
        return "DetalleEmpresas.xhtml";
    }

    public String validarSaveOrUpdateEmpresa() {
        if (empresa.getIdEmpresa() == null) {
            empresa.setIdEmpresa(0);
        }
        if (EmpresaFacade.find(empresa.getIdEmpresa()) != null) {
            EmpresaFacade.edit(empresa);
            empresa = new Empresa();
        } else {
            EmpresaFacade.create(empresa);
            empresa = new Empresa();
        }
        return "RegistroEmpresa";
    }

    public String deletedEmpresa() {        
        empresa = EmpresaFacade.find(empresa.getIdEmpresa());
        EmpresaFacade.remove(empresa);
        return "RegistroEmpresa";
    }
    
    public String limpiar(){
        empresa = new  Empresa();
        return "RegistroEmpresa.xhtml";
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
