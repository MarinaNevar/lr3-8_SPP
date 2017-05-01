package spp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 01.05.2017.
 */
@AllArgsConstructor
@Getter
@Setter
public class SessionDTO {

    private String name;
    private Object body;
}
