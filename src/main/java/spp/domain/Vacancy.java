package spp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 23.04.2017.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "owner_id")
    private long ownerId;

    @Column
    private String title;

    @Column(name = "about_json")
    private String aboutJson;

    @Column(name = "project_id")
    private long projectId;

    @Column(name = "creation_date")
    private Date creationDate;
}
