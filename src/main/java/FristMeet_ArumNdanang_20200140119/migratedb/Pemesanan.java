/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FristMeet_ArumNdanang_20200140119.migratedb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Microsoft
 */
@Entity
@Table(name = "pemesanan")
@NamedQueries({
    @NamedQuery(name = "Pemesanan.findAll", query = "SELECT p FROM Pemesanan p"),
    @NamedQuery(name = "Pemesanan.findByIdPesan", query = "SELECT p FROM Pemesanan p WHERE p.idPesan = :idPesan"),
    @NamedQuery(name = "Pemesanan.findByAlamatTujuan", query = "SELECT p FROM Pemesanan p WHERE p.alamatTujuan = :alamatTujuan"),
    @NamedQuery(name = "Pemesanan.findByAlamatJemput", query = "SELECT p FROM Pemesanan p WHERE p.alamatJemput = :alamatJemput"),
    @NamedQuery(name = "Pemesanan.findByJumlahOrang", query = "SELECT p FROM Pemesanan p WHERE p.jumlahOrang = :jumlahOrang"),
    @NamedQuery(name = "Pemesanan.findByHarga", query = "SELECT p FROM Pemesanan p WHERE p.harga = :harga"),
    @NamedQuery(name = "Pemesanan.findByTanggal", query = "SELECT p FROM Pemesanan p WHERE p.tanggal = :tanggal"),
    @NamedQuery(name = "Pemesanan.findByJam", query = "SELECT p FROM Pemesanan p WHERE p.jam = :jam"),
    @NamedQuery(name = "Pemesanan.findByIdMobil", query = "SELECT p FROM Pemesanan p WHERE p.idMobil = :idMobil")})
public class Pemesanan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPesan")
    private Integer idPesan;
    @Basic(optional = false)
    @Column(name = "alamatTujuan")
    private String alamatTujuan;
    @Basic(optional = false)
    @Column(name = "alamatJemput")
    private String alamatJemput;
    @Basic(optional = false)
    @Column(name = "jumlahOrang")
    private String jumlahOrang;
    @Basic(optional = false)
    @Column(name = "harga")
    private int harga;
    @Basic(optional = false)
    @Column(name = "Tanggal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "Jam")
    private String jam;
    @Basic(optional = false)
    @Column(name = "idMobil")
    private int idMobil;

    public Pemesanan() {
    }

    public Pemesanan(Integer idPesan) {
        this.idPesan = idPesan;
    }

    public Pemesanan(Integer idPesan, String alamatTujuan, String alamatJemput, String jumlahOrang, int harga, Date tanggal, String jam, int idMobil) {
        this.idPesan = idPesan;
        this.alamatTujuan = alamatTujuan;
        this.alamatJemput = alamatJemput;
        this.jumlahOrang = jumlahOrang;
        this.harga = harga;
        this.tanggal = tanggal;
        this.jam = jam;
        this.idMobil = idMobil;
    }

    public Integer getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(Integer idPesan) {
        this.idPesan = idPesan;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public String getAlamatJemput() {
        return alamatJemput;
    }

    public void setAlamatJemput(String alamatJemput) {
        this.alamatJemput = alamatJemput;
    }

    public String getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(String jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPesan != null ? idPesan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pemesanan)) {
            return false;
        }
        Pemesanan other = (Pemesanan) object;
        if ((this.idPesan == null && other.idPesan != null) || (this.idPesan != null && !this.idPesan.equals(other.idPesan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FristMeet_ArumNdanang_20200140119.migratedb.Pemesanan[ idPesan=" + idPesan + " ]";
    }
    
}
