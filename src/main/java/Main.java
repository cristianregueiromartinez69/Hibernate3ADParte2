import service.Crud;
import service.MetodosAdestrador;
import service.MetodosPokedex;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        Crud crud = new Crud();
        //crud.insertar10Pokemons(metodosPokedex.getPokemonsList());
        //crud.insertar2Adestradores(metodosAdestrador.getAdestradoresList());
        crud.readPokemonsFromPokedex();
        crud.readPokemonsFromAdestrador();

        crud.update2Adestradores(1, "liko", LocalDate.of(2022, 4, 10));
        crud.update2Adestradores(2, "polo", LocalDate.of(2010, 9, 25));




    }
}
