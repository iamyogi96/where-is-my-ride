/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lesly
 */
@Entity
@Table(name = "Puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntos.findAll", query = "SELECT p FROM Puntos p"),
    @NamedQuery(name = "Puntos.findById", query = "SELECT p FROM Puntos p WHERE p.id = :id"),
    @NamedQuery(name = "Puntos.findByNoPunto", query = "SELECT p FROM Puntos p WHERE p.noPunto = :noPunto"),
    @NamedQuery(name = "Puntos.findByLongitud", query = "SELECT p FROM Puntos p WHERE p.longitud = :longitud"),
    @NamedQuery(name = "Puntos.findByLatitud", query = "SELECT p FROM Puntos p WHERE p.latitud = :latitud")})
public class Puntos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_punto")
    private int noPunto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ruta idRuta;

    public Puntos() {
    }

    public Puntos(Integer id) {
        this.id = id;
    }

    public Puntos(Integer id, int noPunto, double longitud, double latitud) {
        this.id = id;
        this.noPunto = noPunto;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNoPunto() {
        return noPunto;
    }

    public void setNoPunto(int noPunto) {
        this.noPunto = noPunto;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntos)) {
            return false;
        }
        Puntos other = (Puntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+"";
    }
    
}
