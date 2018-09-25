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
@Table(name = "color_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorVehiculo.findAll", query = "SELECT c FROM ColorVehiculo c")
    , @NamedQuery(name = "ColorVehiculo.findByIdColorVehiculo", query = "SELECT c FROM ColorVehiculo c WHERE c.idColorVehiculo = :idColorVehiculo")
    , @NamedQuery(name = "ColorVehiculo.findByColorVehiculo", query = "SELECT c FROM ColorVehiculo c WHERE c.colorVehiculo = :colorVehiculo")
    , @NamedQuery(name = "ColorVehiculo.findByEstado", query = "SELECT c FROM ColorVehiculo c WHERE c.estado = :estado")})
public class ColorVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_color_vehiculo")
    private Integer idColorVehiculo;
    @Size(max = 50)
    @Column(name = "color_vehiculo")
    private String colorVehiculo;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idColorVehiculo")
    private Collection<Vehiculo> vehiculoCollection;

    public ColorVehiculo() {
    }

    public ColorVehiculo(Integer idColorVehiculo) {
        this.idColorVehiculo = idColorVehiculo;
    }

    public Integer getIdColorVehiculo() {
        return idColorVehiculo;
    }

    public void setIdColorVehiculo(Integer idColorVehiculo) {
        this.idColorVehiculo = idColorVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColorVehiculo != null ? idColorVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorVehiculo)) {
            return false;
        }
        ColorVehiculo other = (ColorVehiculo) object;
        if ((this.idColorVehiculo == null && other.idColorVehiculo != null) || (this.idColorVehiculo != null && !this.idColorVehiculo.equals(other.idColorVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.ColorVehiculo[ idColorVehiculo=" + idColorVehiculo + " ]";
    }
    
}
