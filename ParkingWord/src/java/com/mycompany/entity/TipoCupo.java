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
@Table(name = "tipo_cupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCupo.findAll", query = "SELECT t FROM TipoCupo t")
    , @NamedQuery(name = "TipoCupo.findByIdTipoCupo", query = "SELECT t FROM TipoCupo t WHERE t.idTipoCupo = :idTipoCupo")
    , @NamedQuery(name = "TipoCupo.findByTipoCupo", query = "SELECT t FROM TipoCupo t WHERE t.tipoCupo = :tipoCupo")
    , @NamedQuery(name = "TipoCupo.findByEstado", query = "SELECT t FROM TipoCupo t WHERE t.estado = :estado")})
public class TipoCupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cupo")
    private Integer idTipoCupo;
    @Size(max = 45)
    @Column(name = "tipo_cupo")
    private String tipoCupo;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idTipoCupo")
    private Collection<Cupo> cupoCollection;

    public TipoCupo() {
    }

    public TipoCupo(Integer idTipoCupo) {
        this.idTipoCupo = idTipoCupo;
    }

    public Integer getIdTipoCupo() {
        return idTipoCupo;
    }

    public void setIdTipoCupo(Integer idTipoCupo) {
        this.idTipoCupo = idTipoCupo;
    }

    public String getTipoCupo() {
        return tipoCupo;
    }

    public void setTipoCupo(String tipoCupo) {
        this.tipoCupo = tipoCupo;
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
        hash += (idTipoCupo != null ? idTipoCupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCupo)) {
            return false;
        }
        TipoCupo other = (TipoCupo) object;
        if ((this.idTipoCupo == null && other.idTipoCupo != null) || (this.idTipoCupo != null && !this.idTipoCupo.equals(other.idTipoCupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TipoCupo[ idTipoCupo=" + idTipoCupo + " ]";
    }
    
}
