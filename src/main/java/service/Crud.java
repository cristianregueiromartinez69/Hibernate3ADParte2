package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Adestrador;
import model.Pokedex;

import java.time.LocalDate;
import java.util.List;

public class Crud {

    public void insertar10Pokemons(List<Pokedex> pokedexList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            for(Pokedex pokedex : pokedexList){
                em.persist(pokedex);
            }
            System.out.println("Los 10 pokemons han sido insertados con éxito");
            tx.commit();
        }finally{
            if(tx.isActive()) tx.rollback();
        }
    }

    public void insertar2Adestradores(List<Adestrador> adestradorList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            for(Adestrador adestrador : adestradorList){
                em.persist(adestrador);
            }
            System.out.println("Los 2 adestradores han sido ");
            tx.commit();
        }
    }

    public void readPokemonsFromPokedex(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pokedex> pokedexList = null;
        try(managerFactory; em){
            tx.begin();
            pokedexList = em.createQuery("SELECT p FROM Pokedex p", Pokedex.class).getResultList();

            for(Pokedex pokedex : pokedexList){
                System.out.println(pokedex);
            }
            tx.commit();
        }finally{
            if(tx.isActive()) tx.rollback();
        }
    }

    public void readPokemonsFromAdestrador(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Adestrador> adestradorList = null;

        try(managerFactory; em){
            tx.begin();

            adestradorList = em.createQuery("SELECT p FROM Adestrador p", Adestrador.class).getResultList();

            for(Adestrador adestrador : adestradorList){
                System.out.println(adestrador);
            }

            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
    }

    public void update2Adestradores(int id, String newNome, LocalDate newNacemento){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            Adestrador adestrador = em.find(Adestrador.class, id);

            if(adestrador != null){
                adestrador.setNome(newNome);
                adestrador.setNacemento(newNacemento);
            }
            System.out.println("Adestrador actualizado correctamente");
            tx.commit();

            if(tx.isActive()) tx.rollback();

        }
    }

}
