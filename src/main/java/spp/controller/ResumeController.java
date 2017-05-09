package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spp.entity.Resume;
import spp.service.ResumeService;

import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public @ResponseBody List<Resume> getAll() {
        return resumeService.getAll();
    }

    @RequestMapping(value = "/get/last", method = RequestMethod.GET)
    public @ResponseBody List<Resume> getLast() {
        return resumeService.getFiveLast();
    }

    @RequestMapping(value = "/get/all/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Resume> getAllByOwnerId(@PathVariable("id") Long id) {
        return resumeService.getByOwnerId(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Resume getOneById(@PathVariable("id") Long id) {
        return resumeService.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Resume save(@RequestBody Resume project) {
        return resumeService.save(project);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") Long id) {
        resumeService.delete(id);
    }
}
