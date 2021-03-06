package com.pxl.student.EntityClasses;

import javax.persistence.*;
import java.util.List;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "label")
    List<Payment> payments;

    public Label(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Label(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Label() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
