import model.Adestrador;
import model.Pokedex;
import service.Crud;
import service.EscrituraFicheros;
import service.MetodosAdestrador;
import service.MetodosPokedex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase principal que sirve como punto de entrada para la ejecución del programa.
 *
 * Esta clase utiliza métodos de las clases de servicio para realizar diversas
 * operaciones como lectura, escritura, actualización y eliminación de datos
 * relacionados con pokémons y adestradores.
 * @author cristian
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal del programa.
     *
     * @param args Argumentos pasados desde la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Instancias de clases de servicio
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        Crud crud = new Crud();
        EscrituraFicheros ef = new EscrituraFicheros();

        //insertamos los datos en las tablas
        crud.insertar10Pokemons(metodosPokedex.getPokemonsList());
        crud.insertar2Adestradores(metodosAdestrador.getAdestradoresList());

        // Obtención de listas de pokémons y adestradores desde la base de datos
        List<Pokedex> pokedexList =  crud.readPokemonsFromPokedex();
        List<Adestrador> adestradorList =  crud.readPokemonsFromAdestrador();

        // Lectura y muestra de listas obtenidas
        metodosPokedex.readListPokedex(pokedexList);
        metodosAdestrador.readListAdestrador(adestradorList);

        // Actualización de datos en las tablas de la base de datos
        crud.update2Adestradores(1, "liko", LocalDate.of(2022, 4, 10));
        crud.update2Adestradores(2, "polo", LocalDate.of(2010, 9, 25));

        crud.update2Pokedex(1, "nidoking", BigDecimal.valueOf(62.0), "cornudo");
        crud.update2Pokedex(2, "vaporeon", BigDecimal.valueOf(29.0), "sireno");

        // Escritura de las listas en archivos XML
        ef.writeXmlFilePokedex(pokedexList, "pokedex.xml");
        ef.writeXmlFileAdestrador(adestradorList, "adestrador.xml");

        // Eliminación de datos de las tablas de la base de datos
        crud.deleteDataTables("DELETE FROM Pokedex");
        crud.deleteDataTables("DELETE FROM Adestrador");






    }
}
