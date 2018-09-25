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
@Table(name = "lugar_nac_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugarNacPersona.findAll", query = "SELECT l FROM LugarNacPersona l")
    , @NamedQuery(name = "LugarNacPersona.findByIdLugarNacPersona", query = "SELECT l FROM LugarNacPersona l WHERE l.idLugarNacPersona = :idLugarNacPersona")
    , @NamedQuery(name = "LugarNacPersona.findByLugarDocumento", query = "SELECT l FROM LugarNacPersona l WHERE l.lugarDocumento = :lugarDocumento")
    , @NamedQuery(name = "LugarNacPersona.findByEstado", query = "SELECT l FROM LugarNacPersona l WHERE l.estado = :estado")})
public class LugarNacPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lugar_nac_persona")
    private Integer idLugarNacPersona;
    @Size(max = 50)
    @Column(name = "lugar_documento")
    private String lugarDocumento;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idLugarNacPersona")
    private Collection<Persona> personaCollection;

    public LugarNacPersona() {
    }

    public LugarNacPersona(Integer idLugarNacPersona) {
        this.idLugarNacPersona = idLugarNacPersona;
    }

    public Integer getIdLugarNacPersona() {
        return idLugarNacPersona;
    }

    public void setIdLugarNacPersona(Integer idLugarNacPersona) {
        this.idLugarNacPersona = idLugarNacPersona;
    }

    public String getLugarDocumento() {
        return lugarDocumento;
    }

    public void setLugarDocumento(String lugarDocumento) {
        this.lugarDocumento = lugarDocumento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugarNacPersona != null ? idLugarNacPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugarNacPersona)) {
            return false;
        }
        LugarNacPersona other = (LugarNacPersona) object;
        if ((this.idLugarNacPersona == null && other.idLugarNacPersona != null) || (this.idLugarNacPersona != null && !this.idLugarNacPersona.equals(other.idLugarNacPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.LugarNacPersona[ idLugarNacPersona=" + idLugarNacPersona + " ]";
    }
    
}
