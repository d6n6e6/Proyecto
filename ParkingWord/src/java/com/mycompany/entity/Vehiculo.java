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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Size(max = 10)
    @Column(name = "placa")
    private String placa;
    @OneToMany(mappedBy = "idVehiculo")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;
    @JoinColumn(name = "id_color_vehiculo", referencedColumnName = "id_color_vehiculo")
    @ManyToOne
    private ColorVehiculo idColorVehiculo;
    @JoinColumn(name = "id_marca_vehiculo", referencedColumnName = "id_marca_Vehiculo")
    @ManyToOne
    private MarcaVehiculo idMarcaVehiculo;
    @JoinColumn(name = "id_modelo_vehiculo", referencedColumnName = "id_modelo_vehiculo")
    @ManyToOne
    private ModeloVehiculo idModeloVehiculo;
    @JoinColumn(name = "id_parqueadero", referencedColumnName = "id_parqueadero")
    @ManyToOne
    private Parqueadero idParqueadero;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_Vehiculo")
    @ManyToOne
    private TipoVehiculo idTipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public ColorVehiculo getIdColorVehiculo() {
        return idColorVehiculo;
    }

    public void setIdColorVehiculo(ColorVehiculo idColorVehiculo) {
        this.idColorVehiculo = idColorVehiculo;
    }

    public MarcaVehiculo getIdMarcaVehiculo() {
        return idMarcaVehiculo;
    }

    public void setIdMarcaVehiculo(MarcaVehiculo idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    public ModeloVehiculo getIdModeloVehiculo() {
        return idModeloVehiculo;
    }

    public void setIdModeloVehiculo(ModeloVehiculo idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public Parqueadero getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Parqueadero idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
