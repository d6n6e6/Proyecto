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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "cupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupo.findAll", query = "SELECT c FROM Cupo c")
    , @NamedQuery(name = "Cupo.findByIdCupo", query = "SELECT c FROM Cupo c WHERE c.idCupo = :idCupo")
    , @NamedQuery(name = "Cupo.findByNumeroCupo", query = "SELECT c FROM Cupo c WHERE c.numeroCupo = :numeroCupo")
    , @NamedQuery(name = "Cupo.findByEstado", query = "SELECT c FROM Cupo c WHERE c.estado = :estado")})
public class Cupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cupo")
    private Integer idCupo;
    @Column(name = "numero_cupo")
    private Integer numeroCupo;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @JoinTable(name = "cupo_tarifa", joinColumns = {
        @JoinColumn(name = "id_cupo", referencedColumnName = "id_cupo")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa")})
    @ManyToMany
    private Collection<Tarifa> tarifaCollection;
    @OneToMany(mappedBy = "idCupo")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "id_medidas_cupo", referencedColumnName = "id_medidas_cupo")
    @ManyToOne
    private MedidasCupo idMedidasCupo;
    @JoinColumn(name = "id_piso_cupo", referencedColumnName = "id_piso_cupo")
    @ManyToOne
    private PisoCupo idPisoCupo;
    @JoinColumn(name = "id_tipo_cupo", referencedColumnName = "id_tipo_cupo")
    @ManyToOne
    private TipoCupo idTipoCupo;

    public Cupo() {
    }

    public Cupo(Integer idCupo) {
        this.idCupo = idCupo;
    }

    public Integer getIdCupo() {
        return idCupo;
    }

    public void setIdCupo(Integer idCupo) {
        this.idCupo = idCupo;
    }

    public Integer getNumeroCupo() {
        return numeroCupo;
    }

    public void setNumeroCupo(Integer numeroCupo) {
        this.numeroCupo = numeroCupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Tarifa> getTarifaCollection() {
        return tarifaCollection;
    }

    public void setTarifaCollection(Collection<Tarifa> tarifaCollection) {
        this.tarifaCollection = tarifaCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public MedidasCupo getIdMedidasCupo() {
        return idMedidasCupo;
    }

    public void setIdMedidasCupo(MedidasCupo idMedidasCupo) {
        this.idMedidasCupo = idMedidasCupo;
    }

    public PisoCupo getIdPisoCupo() {
        return idPisoCupo;
    }

    public void setIdPisoCupo(PisoCupo idPisoCupo) {
        this.idPisoCupo = idPisoCupo;
    }

    public TipoCupo getIdTipoCupo() {
        return idTipoCupo;
    }

    public void setIdTipoCupo(TipoCupo idTipoCupo) {
        this.idTipoCupo = idTipoCupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCupo != null ? idCupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupo)) {
            return false;
        }
        Cupo other = (Cupo) object;
        if ((this.idCupo == null && other.idCupo != null) || (this.idCupo != null && !this.idCupo.equals(other.idCupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Cupo[ idCupo=" + idCupo + " ]";
    }
    
}
