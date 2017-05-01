package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spp.domain.Resume;
import spp.dto.UserDto;
import spp.service.ResumeService;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody List<Resume> getAll() {
        return resumeService.getAll();
    }

    @RequestMapping(value = "/getLast", method = RequestMethod.GET)
    public @ResponseBody List<Resume> getLast() {
        return resumeService.getFiveLast();
    }
}
