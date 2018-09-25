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
@Table(name = "marca_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaVehiculo.findAll", query = "SELECT m FROM MarcaVehiculo m")
    , @NamedQuery(name = "MarcaVehiculo.findByIdmarcaVehiculo", query = "SELECT m FROM MarcaVehiculo m WHERE m.idmarcaVehiculo = :idmarcaVehiculo")
    , @NamedQuery(name = "MarcaVehiculo.findByMarcaVehiculo", query = "SELECT m FROM MarcaVehiculo m WHERE m.marcaVehiculo = :marcaVehiculo")
    , @NamedQuery(name = "MarcaVehiculo.findByEstado", query = "SELECT m FROM MarcaVehiculo m WHERE m.estado = :estado")})
public class MarcaVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca_Vehiculo")
    private Integer idmarcaVehiculo;
    @Size(max = 50)
    @Column(name = "marca_Vehiculo")
    private String marcaVehiculo;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_Vehiculo")
    @ManyToOne
    private TipoVehiculo idTipoVehiculo;
    @OneToMany(mappedBy = "idMarcaVehiculo")
    private Collection<Vehiculo> vehiculoCollection;
    @OneToMany(mappedBy = "idMarcaVehiculo")
    private Collection<ModeloVehiculo> modeloVehiculoCollection;

    public MarcaVehiculo() {
    }

    public MarcaVehiculo(Integer idmarcaVehiculo) {
        this.idmarcaVehiculo = idmarcaVehiculo;
    }

    public Integer getIdmarcaVehiculo() {
        return idmarcaVehiculo;
    }

    public void setIdmarcaVehiculo(Integer idmarcaVehiculo) {
        this.idmarcaVehiculo = idmarcaVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @XmlTransient
    public Collection<ModeloVehiculo> getModeloVehiculoCollection() {
        return modeloVehiculoCollection;
    }

    public void setModeloVehiculoCollection(Collection<ModeloVehiculo> modeloVehiculoCollection) {
        this.modeloVehiculoCollection = modeloVehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarcaVehiculo != null ? idmarcaVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaVehiculo)) {
            return false;
        }
        MarcaVehiculo other = (MarcaVehiculo) object;
        if ((this.idmarcaVehiculo == null && other.idmarcaVehiculo != null) || (this.idmarcaVehiculo != null && !this.idmarcaVehiculo.equals(other.idmarcaVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.MarcaVehiculo[ idmarcaVehiculo=" + idmarcaVehiculo + " ]";
    }
    
}
