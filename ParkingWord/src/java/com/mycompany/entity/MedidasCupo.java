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
@Table(name = "medidas_cupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedidasCupo.findAll", query = "SELECT m FROM MedidasCupo m")
    , @NamedQuery(name = "MedidasCupo.findByIdMedidasCupo", query = "SELECT m FROM MedidasCupo m WHERE m.idMedidasCupo = :idMedidasCupo")
    , @NamedQuery(name = "MedidasCupo.findByMedidasCupo", query = "SELECT m FROM MedidasCupo m WHERE m.medidasCupo = :medidasCupo")
    , @NamedQuery(name = "MedidasCupo.findByEstado", query = "SELECT m FROM MedidasCupo m WHERE m.estado = :estado")})
public class MedidasCupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medidas_cupo")
    private Integer idMedidasCupo;
    @Size(max = 45)
    @Column(name = "medidas_cupo")
    private String medidasCupo;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idMedidasCupo")
    private Collection<Cupo> cupoCollection;

    public MedidasCupo() {
    }

    public MedidasCupo(Integer idMedidasCupo) {
        this.idMedidasCupo = idMedidasCupo;
    }

    public Integer getIdMedidasCupo() {
        return idMedidasCupo;
    }

    public void setIdMedidasCupo(Integer idMedidasCupo) {
        this.idMedidasCupo = idMedidasCupo;
    }

    public String getMedidasCupo() {
        return medidasCupo;
    }

    public void setMedidasCupo(String medidasCupo) {
        this.medidasCupo = medidasCupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Cupo> getCupoCollection() {
        return cupoCollection;
    }

    public void setCupoCollection(Collection<Cupo> cupoCollection) {
        this.cupoCollection = cupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedidasCupo != null ? idMedidasCupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedidasCupo)) {
            return false;
        }
        MedidasCupo other = (MedidasCupo) object;
        if ((this.idMedidasCupo == null && other.idMedidasCupo != null) || (this.idMedidasCupo != null && !this.idMedidasCupo.equals(other.idMedidasCupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.MedidasCupo[ idMedidasCupo=" + idMedidasCupo + " ]";
    }
    
}
