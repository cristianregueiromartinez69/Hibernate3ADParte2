package service;

import model.Pokedex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos para gestionar listas de objetos {@link Pokedex}.
 * @author cristian
 * @version 1.0
 */
public class MetodosPokedex {

    /**
     * Genera una lista de objetos {@link Pokedex} con datos predefinidos.
     *
     * @return Lista de objetos {@link Pokedex}.
     */
    public List<Pokedex> getPokemonsList() {
        List<Pokedex> pokemons = new ArrayList<>();
        Pokedex pokedex1 = new Pokedex("pikachu", BigDecimal.valueOf(6.0), "rata hepatítica");
        Pokedex pokedex2 = new Pokedex("gengar", BigDecimal.valueOf(40.5), "risitas");
        Pokedex pokedex3 = new Pokedex("Feraligatr", BigDecimal.valueOf(88.0), "mandibulon");
        Pokedex pokedex4 = new Pokedex("tinkaton", BigDecimal.valueOf(112.8), "niña martillo");
        Pokedex pokedex5 = new Pokedex("steelix", BigDecimal.valueOf(400.0), "durisimo");
        Pokedex pokedex6 = new Pokedex("houndoom", BigDecimal.valueOf(35.0), "perrazo");
        Pokedex pokedex7 = new Pokedex("sneasler", BigDecimal.valueOf(43.0), "depilador");
        Pokedex pokedex8 = new Pokedex("aerodactyl", BigDecimal.valueOf(59.0), "terry");
        Pokedex pokedex9 = new Pokedex("charizard", BigDecimal.valueOf(90.5), "chorizardo");
        Pokedex pokedex10 = new Pokedex("gholdengo", BigDecimal.valueOf(30.0), "tio gilito");

        pokemons.add(pokedex1);
        pokemons.add(pokedex2);
        pokemons.add(pokedex3);
        pokemons.add(pokedex4);
        pokemons.add(pokedex5);
        pokemons.add(pokedex6);
        pokemons.add(pokedex7);
        pokemons.add(pokedex8);
        pokemons.add(pokedex9);
        pokemons.add(pokedex10);

        return pokemons;
    }

    /**
     * Imprime en la consola los objetos de una lista de {@link Pokedex}.
     *
     * @param pokemons Lista de objetos {@link Pokedex} a mostrar.
     */
    public void readListPokedex(List<Pokedex> pokemons) {
        for(Pokedex pokedex : pokemons) {
            System.out.println(pokedex);
        }
    }


}
