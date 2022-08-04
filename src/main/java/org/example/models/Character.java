package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTER_DATA")
@Getter
@Setter
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String catchphrase;

    @ManyToOne
    private Actor actor;

    @ManyToOne
    private Show show;
}
