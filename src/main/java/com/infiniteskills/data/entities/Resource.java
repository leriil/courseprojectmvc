package com.infiniteskills.data.entities;

import javax.persistence.*;

@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "cost")
    private String cost;
    @Column(name = "unit_of_measure")
    private String unitOfMeasure;
    @Column(name = "notes")
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

//    @Override
//    public String toString() {
//        return "Resource{" +
//                "resourceId=" + resourceId +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", cost='" + cost + '\'' +
//                ", unitOfMeasure='" + unitOfMeasure + '\'' +
//                ", notes='" + notes + '\'' +
//                '}';
//    }
}
