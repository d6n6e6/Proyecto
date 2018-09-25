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
@Table(name = "turno_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnoEmpleado.findAll", query = "SELECT t FROM TurnoEmpleado t")
    , @NamedQuery(name = "TurnoEmpleado.findByIdTurnoEmpleado", query = "SELECT t FROM TurnoEmpleado t WHERE t.idTurnoEmpleado = :idTurnoEmpleado")
    , @NamedQuery(name = "TurnoEmpleado.findByTurnoEmpleado", query = "SELECT t FROM TurnoEmpleado t WHERE t.turnoEmpleado = :turnoEmpleado")
    , @NamedQuery(name = "TurnoEmpleado.findByEstado", query = "SELECT t FROM TurnoEmpleado t WHERE t.estado = :estado")})
public class TurnoEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_turno_empleado")
    private Integer idTurnoEmpleado;
    @Size(max = 45)
    @Column(name = "turno_empleado")
    private String turnoEmpleado;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idTurnoEmpleado")
    private Collection<Empleado> empleadoCollection;

    public TurnoEmpleado() {
    }

    public TurnoEmpleado(Integer idTurnoEmpleado) {
        this.idTurnoEmpleado = idTurnoEmpleado;
    }

    public Integer getIdTurnoEmpleado() {
        return idTurnoEmpleado;
    }

    public void setIdTurnoEmpleado(Integer idTurnoEmpleado) {
        this.idTurnoEmpleado = idTurnoEmpleado;
    }

    public String getTurnoEmpleado() {
        return turnoEmpleado;
    }

    public void setTurnoEmpleado(String turnoEmpleado) {
        this.turnoEmpleado = turnoEmpleado;
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
        hash += (idTurnoEmpleado != null ? idTurnoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnoEmpleado)) {
            return false;
        }
        TurnoEmpleado other = (TurnoEmpleado) object;
        if ((this.idTurnoEmpleado == null && other.idTurnoEmpleado != null) || (this.idTurnoEmpleado != null && !this.idTurnoEmpleado.equals(other.idTurnoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TurnoEmpleado[ idTurnoEmpleado=" + idTurnoEmpleado + " ]";
    }
    
}
