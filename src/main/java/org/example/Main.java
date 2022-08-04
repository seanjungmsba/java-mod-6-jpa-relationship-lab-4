package org.example;


import org.example.models.Actor;
import org.example.models.Character;
import org.example.models.Network;
import org.example.models.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transactions
        transaction.begin();

        // initialize actor, character, show, and network variables
        Actor actor1 = new Actor();
        Character character1 = new Character();
        Character character2 = new Character();
        Show show1 = new Show();
        Show show2 = new Show();
        Network network1 = new Network();

        // set actor
        actor1.setFirst_name("John");
        actor1.setLast_name("Doe");

        // set characters
        character1.setName("Persona A");
        character1.setActor(actor1);
        character1.setShow(show1);
        character1.setCatchphrase("Catch Phrase Example A");
        character2.setName("Persona B");
        character2.setActor(actor1);
        character2.setShow(show2);
        character2.setCatchphrase("Catch Phrase Example B");

        // set network
        network1.setCall_letters("Example call letter A");
        network1.setChannel(55);

        // set shows
        show1.setName("Show A");
        show1.setShowDay("Aired every Tuesday");
        show1.setSeason("Season 1");
        show1.setGenre("Comedy");
        show1.setNetwork(network1);
        show2.setName("Show B");
        show2.setShowDay("Aired every Friday");
        show2.setSeason("Season 2");
        show2.setGenre("Documentary");
        show2.setNetwork(network1);

        // create actor -< character association
        List<Character> characterList = List.of(character1, character2);
        actor1.setCharacterList(characterList);

        character1.setActor(actor1);
        character2.setActor(actor1);

        // create show -< character association
        show1.setCharacterList(characterList);

        character1.setShow(show1);
        character2.setShow(show1);

        // create network -< show association
        List<Show> showList = List.of(show1, show2);
        network1.setShowList(showList);

        show1.setNetwork(network1);
        show2.setNetwork(network1);

        // persist
        entityManager.persist(actor1);
        entityManager.persist(character1);
        entityManager.persist(character2);
        entityManager.persist(show1);
        entityManager.persist(show2);
        entityManager.persist(network1);

        // commit
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}