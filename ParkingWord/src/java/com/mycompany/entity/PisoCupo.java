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
@Table(name = "piso_cupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PisoCupo.findAll", query = "SELECT p FROM PisoCupo p")
    , @NamedQuery(name = "PisoCupo.findByIdPisoCupo", query = "SELECT p FROM PisoCupo p WHERE p.idPisoCupo = :idPisoCupo")
    , @NamedQuery(name = "PisoCupo.findByPisoCupo", query = "SELECT p FROM PisoCupo p WHERE p.pisoCupo = :pisoCupo")
    , @NamedQuery(name = "PisoCupo.findByEstado", query = "SELECT p FROM PisoCupo p WHERE p.estado = :estado")})
public class PisoCupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_piso_cupo")
    private Integer idPisoCupo;
    @Size(max = 45)
    @Column(name = "piso_cupo")
    private String pisoCupo;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idPisoCupo")
    private Collection<Cupo> cupoCollection;

    public PisoCupo() {
    }

    public PisoCupo(Integer idPisoCupo) {
        this.idPisoCupo = idPisoCupo;
    }

    public Integer getIdPisoCupo() {
        return idPisoCupo;
    }

    public void setIdPisoCupo(Integer idPisoCupo) {
        this.idPisoCupo = idPisoCupo;
    }

    public String getPisoCupo() {
        return pisoCupo;
    }

    public void setPisoCupo(String pisoCupo) {
        this.pisoCupo = pisoCupo;
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
        hash += (idPisoCupo != null ? idPisoCupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PisoCupo)) {
            return false;
        }
        PisoCupo other = (PisoCupo) object;
        if ((this.idPisoCupo == null && other.idPisoCupo != null) || (this.idPisoCupo != null && !this.idPisoCupo.equals(other.idPisoCupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.PisoCupo[ idPisoCupo=" + idPisoCupo + " ]";
    }
    
}
