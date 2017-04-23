package spp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by admin on 23.04.2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "owner_id")
    private long ownerId;

    @Column
    private String title;

    @Column(name = "exp_json")
    private String expJson;

    @Column(name = "skills_json")
    private String skillsJson;

    @Column
    private String about;
}
