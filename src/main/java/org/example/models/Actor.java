package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTOR_DATA")
@Getter
@Setter
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private int id;

    private String first_name;

    private String last_name;

    @OneToMany(mappedBy = "actor")
    private List<Character> characterList = new ArrayList<>();

}
