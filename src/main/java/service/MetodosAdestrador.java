package service;

import model.Adestrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos para gestionar listas de objetos {@link Adestrador}.
 * @author cristian
 * @version 1.0
 */
public class MetodosAdestrador {

    /**
     * Genera una lista de objetos {@link Adestrador} predefinidos.
     *
     * @return Lista de objetos {@link Adestrador}.
     */
    public List<Adestrador> getAdestradoresList(){
        List<Adestrador> adestradores = new ArrayList<>();
        LocalDate dateAd1 = LocalDate.of(1990, 10, 20);
        Adestrador ad1 = new Adestrador("ash mostaza", dateAd1);

        LocalDate dateAd2 = LocalDate.of(2006, 5, 12);
        Adestrador ad2 = new Adestrador("tobías", dateAd2);

        adestradores.add(ad1);
        adestradores.add(ad2);

        return adestradores;
    }

    /**
     * Imprime en la consola los objetos de una lista de {@link Adestrador}.
     *
     * @param adestradores Lista de objetos {@link Adestrador} a mostrar.
     */
    public void readListAdestrador(List<Adestrador> adestradores){
        for(Adestrador ad : adestradores){
            System.out.println(ad);
        }
    }

}
