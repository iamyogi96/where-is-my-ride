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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lesly
 */
@Entity
@Table(name = "Transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findById", query = "SELECT t FROM Transporte t WHERE t.id = :id"),
    @NamedQuery(name = "Transporte.findByNumEconomico", query = "SELECT t FROM Transporte t WHERE t.numEconomico = :numEconomico"),
    @NamedQuery(name = "Transporte.findByTipoTrans", query = "SELECT t FROM Transporte t WHERE t.tipoTrans = :tipoTrans"),
    @NamedQuery(name = "Transporte.findByDisponible", query = "SELECT t FROM Transporte t WHERE t.disponible = :disponible"),
    @NamedQuery(name = "Transporte.findByTotales", query = "SELECT t FROM Transporte t WHERE t.totales = :totales")})
public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_economico")
    private int numEconomico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_trans")
    private int tipoTrans;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "disponible")
    private String disponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totales")
    private int totales;
    @JoinColumn(name = "Ruta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ruta rutaid;

    public Transporte() {
    }

    public Transporte(Integer id) {
        this.id = id;
    }

    public Transporte(Integer id, int numEconomico, int tipoTrans, String disponible, int totales) {
        this.id = id;
        this.numEconomico = numEconomico;
        this.tipoTrans = tipoTrans;
        this.disponible = disponible;
        this.totales = totales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumEconomico() {
        return numEconomico;
    }

    public void setNumEconomico(int numEconomico) {
        this.numEconomico = numEconomico;
    }

    public int getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(int tipoTrans) {
        this.tipoTrans = tipoTrans;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public int getTotales() {
        return totales;
    }

    public void setTotales(int totales) {
        this.totales = totales;
    }

    public Ruta getRutaid() {
        return rutaid;
    }

    public void setRutaid(Ruta rutaid) {
        this.rutaid = rutaid;
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
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Transporte[ id=" + id + " ]";
    }
    
}
