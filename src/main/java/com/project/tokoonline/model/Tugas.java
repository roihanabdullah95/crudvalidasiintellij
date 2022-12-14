package com.project.tokoonline.model;



import com.project.tokoonline.audiiting.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "tugas")
public class Tugas extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namaBarang", nullable = false)
    private String namaBarang;


    @Column(name = "harga", nullable = false)
    private float price;

    @Column(name = "pemilik", nullable = false)
    private String email ;

    @Override
    public String toString() {
        return "Tugas{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", price=" + price +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
