import model.Adestrador;
import model.Pokedex;
import service.Crud;
import service.EscrituraFicheros;
import service.MetodosAdestrador;
import service.MetodosPokedex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        Crud crud = new Crud();
        EscrituraFicheros ef = new EscrituraFicheros();
        //crud.insertar10Pokemons(metodosPokedex.getPokemonsList());
        //crud.insertar2Adestradores(metodosAdestrador.getAdestradoresList());
        List<Pokedex> pokedexList =  crud.readPokemonsFromPokedex();
        List<Adestrador> adestradorList =  crud.readPokemonsFromAdestrador();

        metodosPokedex.readListPokedex(pokedexList);
        metodosAdestrador.readListAdestrador(adestradorList);

        crud.update2Adestradores(1, "liko", LocalDate.of(2022, 4, 10));
        crud.update2Adestradores(2, "polo", LocalDate.of(2010, 9, 25));

        crud.update2Pokedex(1, "nidoking", BigDecimal.valueOf(62.0), "cornudo");
        crud.update2Pokedex(2, "vaporeon", BigDecimal.valueOf(29.0), "sireno");

        ef.writeXmlFilePokedex(pokedexList, "pokedex.xml");
        ef.writeXmlFileAdestrador(adestradorList, "adestrador.xml");





    }
}
