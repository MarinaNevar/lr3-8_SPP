package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spp.entity.Vacancy;
import spp.service.VacancyService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
@RequestMapping("/vacancy")
public class VacanciesController {

    private final VacancyService vacancyService;

    @Autowired
    public VacanciesController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Vacancy> getAll() {
        return vacancyService.getAll();
    }

    @RequestMapping(value = "/get/last", method = RequestMethod.GET)
    public @ResponseBody List<Vacancy> getLast() {
        return vacancyService.getFiveLast();
    }


    @RequestMapping(value = "/get/all/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Vacancy> getAllByOwnerId(@PathVariable("id") Long id) {
        return vacancyService.getByOwnerId(id);
    }

    @RequestMapping(value = "/get/project/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Vacancy> getAllByProjectId(@PathVariable("id") Long id) {
        return vacancyService.getByProjectId(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Vacancy getOneById(@PathVariable("id") Long id) {
        return vacancyService.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Vacancy save(@RequestBody Vacancy vacancy, HttpSession httpSession) {
        return vacancyService.save(vacancy, httpSession);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") Long id) {
        vacancyService.delete(id);
    }
}
