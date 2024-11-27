package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Adestrador;
import model.Pokedex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase que proporciona operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para las entidades
 * {@link Pokedex} y {@link Adestrador} en una base de datos utilizando JPA.
 * @author cristian
 * @version 1.0
 */
public class Crud {

    /**
     * Inserta una lista de 10 objetos de tipo {@link Pokedex} en la base de datos.
     *
     * @param pokedexList Lista de objetos {@link Pokedex} a insertar.
     */
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

    /**
     * Inserta una lista de 2 objetos de tipo {@link Adestrador} en la base de datos.
     *
     * @param adestradorList Lista de objetos {@link Adestrador} a insertar.
     */
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

    /**
     * Obtiene todos los registros de la entidad {@link Pokedex} desde la base de datos.
     *
     * @return Lista de objetos {@link Pokedex}.
     */
    public List<Pokedex> readPokemonsFromPokedex(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pokedex> pokedexList = null;
        try(managerFactory; em){
            tx.begin();
            pokedexList = em.createQuery("SELECT p FROM Pokedex p", Pokedex.class).getResultList();
            tx.commit();
        }finally{
            if(tx.isActive()) tx.rollback();
        }
        return pokedexList;
    }

    /**
     * Obtiene todos los registros de la entidad {@link Adestrador} desde la base de datos.
     *
     * @return Lista de objetos {@link Adestrador}.
     */
    public List<Adestrador> readPokemonsFromAdestrador(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Adestrador> adestradorList = null;

        try(managerFactory; em){
            tx.begin();

            adestradorList = em.createQuery("SELECT p FROM Adestrador p", Adestrador.class).getResultList();

            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
        return adestradorList;
    }

    /**
     * Actualiza un registro de la entidad {@link Adestrador} con nuevos valores.
     *
     * @param id           ID del adestrador a actualizar.
     * @param newNome      Nuevo nombre del adestrador.
     * @param newNacemento Nueva fecha de nacimiento del adestrador.
     */
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

    /**
     * Actualiza un registro de la entidad {@link Pokedex} con nuevos valores.
     *
     * @param id           ID del registro a actualizar.
     * @param newNome      Nuevo nombre del Pokémon.
     * @param newPeso      Nuevo peso del Pokémon.
     * @param miscelanea   Nueva información adicional del Pokémon.
     */
    public void update2Pokedex(int id, String newNome, BigDecimal newPeso, String miscelanea){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            Pokedex pokedex = em.find(Pokedex.class, id);

            if(pokedex != null){
                pokedex.setNome(newNome);
                pokedex.setPeso(newPeso);
                pokedex.setMisc(miscelanea);
            }
            System.out.println("pokemon de la pokedex actualizado correctamente");
            tx.commit();

            if(tx.isActive()) tx.rollback();

        }
    }

    /**
     * Elimina datos de las tablas utilizando una consulta nativa.
     *
     * @param query Consulta SQL nativa para eliminar registros.
     */
    public void deleteDataTables(String query){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            int deleteCount = em.createNativeQuery(query).executeUpdate();

            tx.commit();
            if(deleteCount > 0){
                System.out.println("Se han los datos de las tablas correctamente");
            }
            if(tx.isActive()) tx.rollback();
        }
    }








}
