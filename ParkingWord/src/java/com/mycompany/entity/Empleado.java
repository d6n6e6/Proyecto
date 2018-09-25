/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdPersona", query = "SELECT e FROM Empleado e WHERE e.idPersona = :idPersona")
    , @NamedQuery(name = "Empleado.findByUsuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario")
    , @NamedQuery(name = "Empleado.findByPass", query = "SELECT e FROM Empleado e WHERE e.pass = :pass")
    , @NamedQuery(name = "Empleado.findByFechaCreacion", query = "SELECT e FROM Empleado e WHERE e.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Empleado.findByFechaModificacion", query = "SELECT e FROM Empleado e WHERE e.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Empleado.findByEstadoVip", query = "SELECT e FROM Empleado e WHERE e.estadoVip = :estadoVip")
    , @NamedQuery(name = "Empleado.findByDireccionPorteria", query = "SELECT e FROM Empleado e WHERE e.direccionPorteria = :direccionPorteria")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 45)
    @Column(name = "pass")
    private String pass;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Size(max = 15)
    @Column(name = "estado_vip")
    private String estadoVip;
    @Size(max = 45)
    @Column(name = "direccion_porteria")
    private String direccionPorteria;
    @JoinColumn(name = "id_turno_empleado", referencedColumnName = "id_turno_empleado")
    @ManyToOne
    private TurnoEmpleado idTurnoEmpleado;
    @JoinColumn(name = "id_area_empleado", referencedColumnName = "id_area_empleado")
    @ManyToOne
    private AreaEmpleado idAreaEmpleado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_tipo_empleado", referencedColumnName = "id_tipo_empleado")
    @ManyToOne
    private TipoEmpleado idTipoEmpleado;

    public Empleado() {
    }

    public Empleado(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstadoVip() {
        return estadoVip;
    }

    public void setEstadoVip(String estadoVip) {
        this.estadoVip = estadoVip;
    }

    public String getDireccionPorteria() {
        return direccionPorteria;
    }

    public void setDireccionPorteria(String direccionPorteria) {
        this.direccionPorteria = direccionPorteria;
    }

    public TurnoEmpleado getIdTurnoEmpleado() {
        return idTurnoEmpleado;
    }

    public void setIdTurnoEmpleado(TurnoEmpleado idTurnoEmpleado) {
        this.idTurnoEmpleado = idTurnoEmpleado;
    }

    public AreaEmpleado getIdAreaEmpleado() {
        return idAreaEmpleado;
    }

    public void setIdAreaEmpleado(AreaEmpleado idAreaEmpleado) {
        this.idAreaEmpleado = idAreaEmpleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Empleado[ idPersona=" + idPersona + " ]";
    }
    
}
