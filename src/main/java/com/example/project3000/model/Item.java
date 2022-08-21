package com.example.project3000.model;

import com.example.project3000.model.enums.ItemType;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @MapsId("id")
    private User seller;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    public Item() {
    }

    public Item(String description, String name, User seller, ItemType type) {
        this();
        this.description = description;
        this.name = name;
        this.seller = seller;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
