package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spp.entity.Vacancy;
import spp.service.VacancyService;

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

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Vacancy> getAll() {
        return vacancyService.getAll();
    }

    @RequestMapping(value = "/getLast", method = RequestMethod.GET)
    public @ResponseBody List<Vacancy> getLast() {
        return vacancyService.getFiveLast();
    }
}
