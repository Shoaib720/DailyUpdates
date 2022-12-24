package ml.hadiya.dailyupdates.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ml.hadiya.dailyupdates.models.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    
}
