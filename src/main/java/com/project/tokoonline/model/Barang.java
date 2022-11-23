package com.project.tokoonline.model;

import javax.persistence.*;

@Entity
@Table( name = "barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name = "No Name";

    @Column(name = "price")
    private float price;

    @Column(name = "count")
    private int count;

    @Column(name = "rating")
    private int rating;

    @Column(name = "description")
    private @Lob String description;

    @Column(name = "publish")
    private boolean publish;

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }
}
