package com.infiniteskills.data.entities;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "project")
public class Project {
    private Long projectId;
    private String name;
    private Sponsor sponsor;
    @NotBlank(message="we need a decription")
    private String description;
    private String type;
    private List<String>pointsOfContact;

    public List<String> getPointsOfContact() {
        return pointsOfContact;
    }

    public void setPointsOfContact(List<String> pointsOfContact) {
        this.pointsOfContact = pointsOfContact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", sponsor=" + sponsor +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", pointsOfContact=" + pointsOfContact +
                '}';
    }
}
