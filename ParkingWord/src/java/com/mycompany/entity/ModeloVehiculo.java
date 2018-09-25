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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "modelo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloVehiculo.findAll", query = "SELECT m FROM ModeloVehiculo m")
    , @NamedQuery(name = "ModeloVehiculo.findByIdModeloVehiculo", query = "SELECT m FROM ModeloVehiculo m WHERE m.idModeloVehiculo = :idModeloVehiculo")
    , @NamedQuery(name = "ModeloVehiculo.findByModeloVehiculo", query = "SELECT m FROM ModeloVehiculo m WHERE m.modeloVehiculo = :modeloVehiculo")
    , @NamedQuery(name = "ModeloVehiculo.findByEstado", query = "SELECT m FROM ModeloVehiculo m WHERE m.estado = :estado")})
public class ModeloVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modelo_vehiculo")
    private Integer idModeloVehiculo;
    @Size(max = 50)
    @Column(name = "modelo_vehiculo")
    private String modeloVehiculo;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idModeloVehiculo")
    private Collection<Vehiculo> vehiculoCollection;
    @JoinColumn(name = "id_marca_vehiculo", referencedColumnName = "id_marca_Vehiculo")
    @ManyToOne
    private MarcaVehiculo idMarcaVehiculo;

    public ModeloVehiculo() {
    }

    public ModeloVehiculo(Integer idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public Integer getIdModeloVehiculo() {
        return idModeloVehiculo;
    }

    public void setIdModeloVehiculo(Integer idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
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

    public MarcaVehiculo getIdMarcaVehiculo() {
        return idMarcaVehiculo;
    }

    public void setIdMarcaVehiculo(MarcaVehiculo idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModeloVehiculo != null ? idModeloVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloVehiculo)) {
            return false;
        }
        ModeloVehiculo other = (ModeloVehiculo) object;
        if ((this.idModeloVehiculo == null && other.idModeloVehiculo != null) || (this.idModeloVehiculo != null && !this.idModeloVehiculo.equals(other.idModeloVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.ModeloVehiculo[ idModeloVehiculo=" + idModeloVehiculo + " ]";
    }
    
}
