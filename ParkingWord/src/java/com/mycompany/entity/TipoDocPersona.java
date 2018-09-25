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
@Table(name = "tipo_doc_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocPersona.findAll", query = "SELECT t FROM TipoDocPersona t")
    , @NamedQuery(name = "TipoDocPersona.findByIdTipoDocPersona", query = "SELECT t FROM TipoDocPersona t WHERE t.idTipoDocPersona = :idTipoDocPersona")
    , @NamedQuery(name = "TipoDocPersona.findByTipoDocumento", query = "SELECT t FROM TipoDocPersona t WHERE t.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "TipoDocPersona.findByEstado", query = "SELECT t FROM TipoDocPersona t WHERE t.estado = :estado")})
public class TipoDocPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_doc_persona")
    private Integer idTipoDocPersona;
    @Size(max = 50)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idTipoDocPersona")
    private Collection<Persona> personaCollection;

    public TipoDocPersona() {
    }

    public TipoDocPersona(Integer idTipoDocPersona) {
        this.idTipoDocPersona = idTipoDocPersona;
    }

    public Integer getIdTipoDocPersona() {
        return idTipoDocPersona;
    }

    public void setIdTipoDocPersona(Integer idTipoDocPersona) {
        this.idTipoDocPersona = idTipoDocPersona;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        hash += (idTipoDocPersona != null ? idTipoDocPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocPersona)) {
            return false;
        }
        TipoDocPersona other = (TipoDocPersona) object;
        if ((this.idTipoDocPersona == null && other.idTipoDocPersona != null) || (this.idTipoDocPersona != null && !this.idTipoDocPersona.equals(other.idTipoDocPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TipoDocPersona[ idTipoDocPersona=" + idTipoDocPersona + " ]";
    }
    
}
