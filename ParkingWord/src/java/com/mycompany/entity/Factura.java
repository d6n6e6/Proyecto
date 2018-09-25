/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByTipoComprobante", query = "SELECT f FROM Factura f WHERE f.tipoComprobante = :tipoComprobante")
    , @NamedQuery(name = "Factura.findByNumeroFactura", query = "SELECT f FROM Factura f WHERE f.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "Factura.findBySubTotal", query = "SELECT f FROM Factura f WHERE f.subTotal = :subTotal")
    , @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")
    , @NamedQuery(name = "Factura.findByTotalPago", query = "SELECT f FROM Factura f WHERE f.totalPago = :totalPago")
    , @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Size(max = 10)
    @Column(name = "tipo_comprobante")
    private String tipoComprobante;
    @Column(name = "numero_factura")
    private Integer numeroFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total_pago")
    private Double totalPago;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne
    private Reserva idReserva;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @ManyToOne
    private Pago idPago;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
