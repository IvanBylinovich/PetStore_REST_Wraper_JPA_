package com.example.demo.model;

import com.example.demo.enumPak.Status;

import javax.persistence.*;
import java.util.List;

@Entity

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
    private Status status;

    public Pet(long id, Category category, String name, List<Tag> tags, Status status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
