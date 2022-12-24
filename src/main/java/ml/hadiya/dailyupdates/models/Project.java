package ml.hadiya.dailyupdates.models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ml.hadiya.dailyupdates.enums.ProjectStatus;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    private UUID id;
    private UUID userId;
    private String name;
    private Date startedOn;
    private ProjectStatus projectStatus;
    
    public Project(UUID id, UUID userId, String name, Date startedOn, ProjectStatus projectStatus) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.startedOn = startedOn;
        this.projectStatus = projectStatus;
    }

    public Project() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Date startedOn) {
        this.startedOn = startedOn;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", userId=" + userId + ", name=" + name + ", startedOn=" + startedOn
                + ", projectStatus=" + projectStatus + "]";
    }
}
