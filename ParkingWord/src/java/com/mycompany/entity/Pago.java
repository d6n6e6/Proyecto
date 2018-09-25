/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pago.findByFechaSalida", query = "SELECT p FROM Pago p WHERE p.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Pago.findByHoraSalida", query = "SELECT p FROM Pago p WHERE p.horaSalida = :horaSalida")
    , @NamedQuery(name = "Pago.findByDiasConsumidos", query = "SELECT p FROM Pago p WHERE p.diasConsumidos = :diasConsumidos")
    , @NamedQuery(name = "Pago.findByTiempoTranscurrido", query = "SELECT p FROM Pago p WHERE p.tiempoTranscurrido = :tiempoTranscurrido")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.DATE)
    private Date horaSalida;
    @Column(name = "dias_consumidos")
    private Integer diasConsumidos;
    @Column(name = "tiempo_transcurrido")
    private Integer tiempoTranscurrido;
    @OneToMany(mappedBy = "idPago")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne
    private Convenio idConvenio;
    @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa")
    @ManyToOne
    private Tarifa idTarifa;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getDiasConsumidos() {
        return diasConsumidos;
    }

    public void setDiasConsumidos(Integer diasConsumidos) {
        this.diasConsumidos = diasConsumidos;
    }

    public Integer getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(Integer tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Convenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Tarifa getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Tarifa idTarifa) {
        this.idTarifa = idTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Pago[ idPago=" + idPago + " ]";
    }
    
}
