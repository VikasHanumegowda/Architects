package com.scienceGateway.nineToFiveIt.controller;

import com.scienceGateway.nineToFiveIt.model.Projects;
import com.scienceGateway.nineToFiveIt.repositories.AddProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddProjectController {
    @Autowired
    AddProjectRepository addProjectRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addProject(@RequestBody Projects project){

       // Projects project=new Projects(request.getParameter("projectId"),"9to5It",request.getParameter("companyName"),10,250,20,"adasdsda","bng","CS","http://sads");

        System.out.println(project.getCompanyName());
        System.out.println(project.getProjectId());

        addProjectRepository.save(new Projects( project.getProjectName(),
                                                project.getCompanyName(),
                                                project.getNumberOfPpl(),
                                                project.getNumberOfHours(),
                                                project.getPayPerHour(),
                                                project.getProjectDescription(),
                                                project.getProjectLocation(),
                                                project.getProjectDepartment(),
                                                project.getProjectLink()
                                                ));
       // addProjectRepository.deleteAll();
       /* for(Projects p : addProjectRepository.findAll()){
            System.out.println(p);
            System.out.println(p.getProjectId() + " " + p.getProjectLink() + " " + p.getProjectLocation());
        }*/
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
