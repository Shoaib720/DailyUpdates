package ml.hadiya.dailyupdates.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ml.hadiya.dailyupdates.models.Project;
import ml.hadiya.dailyupdates.services.ProjectService;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects (){
        try {
            List<Project> projects = projectService.fetchAllProjects();
            if(projects == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(projects));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<Project> getProjectById (@PathVariable UUID projectId){
        try{
            Project project = projectService.fetchProjectById(projectId);
            if(project == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(project));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/projects")
    public ResponseEntity<Void> postProject (@RequestBody Project project) {
        try{
            projectService.addProject(project);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<Void> updateProject (@RequestBody Project project, @PathVariable UUID projectId){
        try{
            projectService.updateProject(project, projectId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Void> deleteProject (@PathVariable UUID projectId){
        try{
            projectService.deleteProject(projectId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
