package spp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by admin on 01.05.2017.
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SessionDto {

    private String name;
    private Object body;
}
