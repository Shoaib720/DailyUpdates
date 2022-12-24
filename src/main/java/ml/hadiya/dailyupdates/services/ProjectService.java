package ml.hadiya.dailyupdates.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ml.hadiya.dailyupdates.models.Project;
import ml.hadiya.dailyupdates.repositories.ProjectRepository;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> fetchAllProjects() {
        List<Project> projects = null;
        try{
            projects = projectRepository.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return projects;
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void updateProject(Project project, UUID projectId) {
        project.setId(projectId);
        projectRepository.save(project);
    }

    public Project fetchProjectById(UUID projectId){
        Project project = null;
        try{
            project = projectRepository.findById(projectId).get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return project;
        
    }

    public void deleteProject(UUID projectId){
        projectRepository.deleteById(projectId);
    }
}
