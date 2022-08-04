package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NETWORK_DATA")
@Getter
@Setter
@NoArgsConstructor
public class Network {

    @Id
    @GeneratedValue
    private int id;

    private String call_letters;

    private int channel;

    @OneToMany(mappedBy = "network")
    private List<Show> showList = new ArrayList<>();
}
