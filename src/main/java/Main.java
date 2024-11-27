import service.Crud;
import service.MetodosAdestrador;
import service.MetodosPokedex;

public class Main {

    public static void main(String[] args) {
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        Crud crud = new Crud();
        //crud.insertar10Pokemons(metodosPokedex.getPokemonsList());
        //crud.insertar2Adestradores(metodosAdestrador.getAdestradoresList());
        crud.readPokemonsFromPokedex();

    }
}
