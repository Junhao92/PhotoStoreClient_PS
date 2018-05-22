package com.example.a14049472.photostoreclient_ps;

public class Category {
    private int category_id;
    private String name;
    private String description;

    public Category(int id, String name, String description) {
        this.category_id = id;
        this.name = name;
        this.description =description;
    }

    public int getCategory_id () {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
