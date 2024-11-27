package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

/**
 * Representa un adestrador (entrenador) en el sistema.
 * Contiene información básica como nombre, fecha de nacimiento e ID único.
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "adestrador")
public class Adestrador {
    /**
     * Identificador único del adestrador. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('adestrador_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del adestrador.
     * No puede superar los 50 caracteres y es obligatorio.
     */
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    /**
     * Fecha de nacimiento del adestrador.
     * Este campo es opcional.
     */
    @Column(name = "nacemento")
    private LocalDate nacemento;

    /**
     * Constructor que inicializa el nombre y la fecha de nacimiento del adestrador.
     *
     * @param nome       Nombre del adestrador.
     * @param nacemento  Fecha de nacimiento del adestrador.
     */
    public Adestrador(String nome, LocalDate nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    //constructor por defecto
    public Adestrador() {
    }

    /**
     * getter y setter
     * @return los atributos correspondientes
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    /**
     * metodo
     * @return el objeto toString
     */
    @Override
    public String toString() {
        return "Adestrador: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nnacemento: " + nacemento;
    }
}