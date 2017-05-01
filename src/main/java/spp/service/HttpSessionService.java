package spp.service;

import org.springframework.stereotype.Service;
import spp.dto.SessionDTO;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class HttpSessionService {

    public void setDataToSession(HttpSession httpSession, SessionDTO sessionDTO) {
        httpSession.setAttribute(sessionDTO.getName(), sessionDTO.getBody());
    }
}
