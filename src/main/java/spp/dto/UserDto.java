package spp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by admin on 01.05.2017.
 */
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable{
    private String name;
    private Long authorityId;
}
