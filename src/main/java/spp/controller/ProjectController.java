package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spp.entity.Project;
import spp.service.ProjectService;

import java.util.List;

/**
 * Created by admin on 08.05.2017.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public @ResponseBody List<Project> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/all/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Project> getAllByOwnerId(@PathVariable("id") Long id) {
        return service.getAllByOwnerId(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Project getOneById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Project save(@RequestBody Project project) {
        return service.save(project);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
