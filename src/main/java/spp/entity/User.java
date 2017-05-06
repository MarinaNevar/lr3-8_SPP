package spp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Артем Константинович on 02.10.2016.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "authority_id")
    private long authorityId;
}
