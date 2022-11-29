package com.project.tokoonline.model;

import javax.persistence.*;

@Entity
@Table(name = "barang_image")
public class BarangImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    private Barang barangId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Barang getBarangId() {
        return barangId;
    }

    public void setBarangId(Barang barangId) {
        this.barangId = barangId;
    }
}
