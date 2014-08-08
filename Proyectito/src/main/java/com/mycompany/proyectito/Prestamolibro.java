
package com.mycompany.proyectito;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prestamolibro")
public class Prestamolibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpres")
    private Integer idpres;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Float total;
    @JoinColumn(name = "id_a", referencedColumnName = "id")
    @ManyToOne
    private Usuario idA;
    @JoinColumn(name = "id_l", referencedColumnName = "id")
    @ManyToOne
    private Libro idL;

    public Prestamolibro() {
    }

    public Prestamolibro(Integer idpres) {
        this.idpres = idpres;
    
    }
    public Prestamolibro(Date fecha, Integer cantidad, Float total, Usuario idA, Libro idL) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.idA = idA;
        this.idL = idL;
    }

    public Integer getIdpres() {
        return idpres;
    }

    public void setIdpres(Integer idpres) {
        this.idpres = idpres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Usuario getIdA() {
        return idA;
    }

    public void setIdA(Usuario idA) {
        this.idA = idA;
    }

    public Libro getIdL() {
        return idL;
    }

    public void setIdL(Libro idL) {
        this.idL = idL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpres != null ? idpres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamolibro)) {
            return false;
        }
        Prestamolibro other = (Prestamolibro) object;
        if ((this.idpres == null && other.idpres != null) || (this.idpres != null && !this.idpres.equals(other.idpres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectito.Prestamolibro[ idpres=" + idpres + " ]";
    }
    
}
