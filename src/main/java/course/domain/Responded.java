package course.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by admin on 23.04.2017.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Responded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "project_id")
    private long projectId;

    @Column(name = "vacancy_id")
    private long vacancyId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "resume_id")
    private long resumeId;

}
