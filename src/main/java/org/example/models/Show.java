package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOW_DATA")
@Getter
@Setter
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String showDay;

    private String season;

    private String genre;

    @OneToMany(mappedBy = "show")
    private List<Character> characterList = new ArrayList<>();

    @ManyToOne
    private Network network;
}
