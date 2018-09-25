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
@Table(name = "sede_parqueadero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SedeParqueadero.findAll", query = "SELECT s FROM SedeParqueadero s")
    , @NamedQuery(name = "SedeParqueadero.findByIdSedeParqueadero", query = "SELECT s FROM SedeParqueadero s WHERE s.idSedeParqueadero = :idSedeParqueadero")
    , @NamedQuery(name = "SedeParqueadero.findBySedeParqueadero", query = "SELECT s FROM SedeParqueadero s WHERE s.sedeParqueadero = :sedeParqueadero")
    , @NamedQuery(name = "SedeParqueadero.findByEstado", query = "SELECT s FROM SedeParqueadero s WHERE s.estado = :estado")})
public class SedeParqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sede_parqueadero")
    private Integer idSedeParqueadero;
    @Size(max = 50)
    @Column(name = "sede_parqueadero")
    private String sedeParqueadero;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idSedeParqueadero")
    private Collection<Parqueadero> parqueaderoCollection;

    public SedeParqueadero() {
    }

    public SedeParqueadero(Integer idSedeParqueadero) {
        this.idSedeParqueadero = idSedeParqueadero;
    }

    public Integer getIdSedeParqueadero() {
        return idSedeParqueadero;
    }

    public void setIdSedeParqueadero(Integer idSedeParqueadero) {
        this.idSedeParqueadero = idSedeParqueadero;
    }

    public String getSedeParqueadero() {
        return sedeParqueadero;
    }

    public void setSedeParqueadero(String sedeParqueadero) {
        this.sedeParqueadero = sedeParqueadero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Parqueadero> getParqueaderoCollection() {
        return parqueaderoCollection;
    }

    public void setParqueaderoCollection(Collection<Parqueadero> parqueaderoCollection) {
        this.parqueaderoCollection = parqueaderoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedeParqueadero != null ? idSedeParqueadero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SedeParqueadero)) {
            return false;
        }
        SedeParqueadero other = (SedeParqueadero) object;
        if ((this.idSedeParqueadero == null && other.idSedeParqueadero != null) || (this.idSedeParqueadero != null && !this.idSedeParqueadero.equals(other.idSedeParqueadero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.SedeParqueadero[ idSedeParqueadero=" + idSedeParqueadero + " ]";
    }
    
}
