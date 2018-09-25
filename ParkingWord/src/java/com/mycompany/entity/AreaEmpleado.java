/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "area_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaEmpleado.findAll", query = "SELECT a FROM AreaEmpleado a")
    , @NamedQuery(name = "AreaEmpleado.findByIdAreaEmpleado", query = "SELECT a FROM AreaEmpleado a WHERE a.idAreaEmpleado = :idAreaEmpleado")
    , @NamedQuery(name = "AreaEmpleado.findByAreaEmpleado", query = "SELECT a FROM AreaEmpleado a WHERE a.areaEmpleado = :areaEmpleado")
    , @NamedQuery(name = "AreaEmpleado.findByEstado", query = "SELECT a FROM AreaEmpleado a WHERE a.estado = :estado")})
public class AreaEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_empleado")
    private Integer idAreaEmpleado;
    @Size(max = 45)
    @Column(name = "area_empleado")
    private String areaEmpleado;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idAreaEmpleado")
    private Collection<Empleado> empleadoCollection;

    public AreaEmpleado() {
    }

    public AreaEmpleado(Integer idAreaEmpleado) {
        this.idAreaEmpleado = idAreaEmpleado;
    }

    public Integer getIdAreaEmpleado() {
        return idAreaEmpleado;
    }

    public void setIdAreaEmpleado(Integer idAreaEmpleado) {
        this.idAreaEmpleado = idAreaEmpleado;
    }

    public String getAreaEmpleado() {
        return areaEmpleado;
    }

    public void setAreaEmpleado(String areaEmpleado) {
        this.areaEmpleado = areaEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaEmpleado != null ? idAreaEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaEmpleado)) {
            return false;
        }
        AreaEmpleado other = (AreaEmpleado) object;
        if ((this.idAreaEmpleado == null && other.idAreaEmpleado != null) || (this.idAreaEmpleado != null && !this.idAreaEmpleado.equals(other.idAreaEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.AreaEmpleado[ idAreaEmpleado=" + idAreaEmpleado + " ]";
    }
    
}
