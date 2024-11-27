package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

/**
 * Representa un registro en la Pokedex, que incluye información sobre un Pokémon.
 * Contiene atributos como el nombre, el peso y datos adicionales.
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "pokedex")
public class Pokedex {
    /**
     * Identificador único del registro en la Pokedex.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('pokedex_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del Pokémon.
     * Es obligatorio y tiene un máximo de 50 caracteres.
     */
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    /**
     * Peso del Pokémon, con una precisión máxima de 10 dígitos y 2 decimales.
     * Este campo es opcional.
     */
    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    /**
     * Información adicional sobre el Pokémon.
     * Este campo puede contener texto de longitud ilimitada.
     */
    @Column(name = "misc", length = Integer.MAX_VALUE)
    private String misc;

    /**
     * Constructor que inicializa el nombre, el peso y la información adicional del Pokémon.
     *
     * @param nome Nombre del Pokémon.
     * @param peso Peso del Pokémon.
     * @param misc Información adicional del Pokémon.
     */
    public Pokedex(String nome, BigDecimal peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    //constructor por defecto
    public Pokedex() {
    }

    /**
     * getter y setter de la clase
     * @return el atributo correspondiente
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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    /**
     * Metodo toString  de la clase
     * @return devuelve el objeto Pokedex
     */
    @Override
    public String toString() {
        return "Pokedex: " +
                "\nid: " + id +
                "\nnome: " + nome+
                "\npeso: " + peso +
                "\nmisc: " + misc;
    }
}