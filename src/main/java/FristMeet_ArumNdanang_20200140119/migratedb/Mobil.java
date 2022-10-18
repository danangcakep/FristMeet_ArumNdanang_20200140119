/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FristMeet_ArumNdanang_20200140119.migratedb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Microsoft
 */
@Entity
@Table(name = "mobil")
@NamedQueries({
    @NamedQuery(name = "Mobil.findAll", query = "SELECT m FROM Mobil m"),
    @NamedQuery(name = "Mobil.findByIdMobil", query = "SELECT m FROM Mobil m WHERE m.idMobil = :idMobil"),
    @NamedQuery(name = "Mobil.findByNamaMobil", query = "SELECT m FROM Mobil m WHERE m.namaMobil = :namaMobil"),
    @NamedQuery(name = "Mobil.findByPlatNo", query = "SELECT m FROM Mobil m WHERE m.platNo = :platNo"),
    @NamedQuery(name = "Mobil.findByJenisMobil", query = "SELECT m FROM Mobil m WHERE m.jenisMobil = :jenisMobil"),
    @NamedQuery(name = "Mobil.findByMerk", query = "SELECT m FROM Mobil m WHERE m.merk = :merk")})
public class Mobil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMobil")
    private Integer idMobil;
    @Basic(optional = false)
    @Column(name = "NamaMobil")
    private String namaMobil;
    @Basic(optional = false)
    @Column(name = "PlatNo")
    private String platNo;
    @Basic(optional = false)
    @Column(name = "jenisMobil")
    private String jenisMobil;
    @Basic(optional = false)
    @Column(name = "Merk")
    private String merk;

    public Mobil() {
    }

    public Mobil(Integer idMobil) {
        this.idMobil = idMobil;
    }

    public Mobil(Integer idMobil, String namaMobil, String platNo, String jenisMobil, String merk) {
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.platNo = platNo;
        this.jenisMobil = jenisMobil;
        this.merk = merk;
    }

    public Integer getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(Integer idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMobil != null ? idMobil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobil)) {
            return false;
        }
        Mobil other = (Mobil) object;
        if ((this.idMobil == null && other.idMobil != null) || (this.idMobil != null && !this.idMobil.equals(other.idMobil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FristMeet_ArumNdanang_20200140119.migratedb.Mobil[ idMobil=" + idMobil + " ]";
    }
    
}
