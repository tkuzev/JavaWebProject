package com.example.project3000.model.dto;

import com.example.project3000.model.User;
import com.example.project3000.model.enums.ItemType;

import javax.validation.constraints.NotBlank;

public class ItemAddDTO {

    @NotBlank
    private String name;

    private String description;

    private String pictureUrl;

    private ItemType category;

    private User seller;

    public ItemAddDTO() {
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public ItemType getCategory() {
        return category;
    }

    public void setCategory(ItemType category) {
        this.category = category;
    }
}
