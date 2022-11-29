package com.project.tokoonline.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tiketkereta")

public class TiketKereta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "krl", nullable = false)
    private String krl;

    @Column(name = "departure", nullable = false)
    private String departure;

    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss")
//    @CreationTimeStamp dipakai untuk membuat data otomatis tanggal waktu
    @CreationTimestamp
    @Column (name = "start_date", updatable = false)
    private Date start_date;

    @Column (name = "kode_booking")
    private String kode_booking;

    @Column(name = "end_departure", nullable = false)
    private String end_departure;

    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss")
    @Column (name = "end_date", updatable = false)
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "passanger_type_id")
    private PassangerType passanger_type_id;


//    toString dipakai untuk menampilkan di console.log saja
    @Override
    public String toString() {
        return "TiketKereta{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", krl='" + krl + '\'' +
                ", departure='" + departure + '\'' +

                ", kode_booking='" + kode_booking + '\'' +
                ", end_departure='" + end_departure + '\'' +

                ", passanger_type_id=" + passanger_type_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKrl() {
        return krl;
    }

    public void setKrl(String krl) {
        this.krl = krl;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getKode_booking() {
        return kode_booking;
    }

    public void setKode_booking(String kode_booking) {
        this.kode_booking = kode_booking;
    }

    public String getEnd_departure() {
        return end_departure;
    }

    public void setEnd_departure(String end_departure) {
        this.end_departure = end_departure;
    }

    public PassangerType getPassanger_type_id() {
        return passanger_type_id;
    }

    public void setPassanger_type_id(PassangerType passanger_type_id) {
        this.passanger_type_id = passanger_type_id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
