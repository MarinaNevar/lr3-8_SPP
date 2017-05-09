package spp.service;

import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Service;
import spp.dto.SessionDto;
import spp.dto.UserDto;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class HttpSessionService {

    public void setDataToSession(HttpSession httpSession, SessionDto sessionDto) {
        httpSession.setAttribute(sessionDto.getName(), sessionDto.getBody());
    }

    @Nullable
    public UserDto getUserFromSession(HttpSession httpSession) {
        if (httpSession.getAttribute("currentUserName") != null) {
            return new UserDto(
                    (Long) httpSession.getAttribute("currentUserId"),
                    httpSession.getAttribute("currentUserName").toString(),
                    (Long) httpSession.getAttribute("currentUserAuthorityID"));
        }
        return null;
    }
}
