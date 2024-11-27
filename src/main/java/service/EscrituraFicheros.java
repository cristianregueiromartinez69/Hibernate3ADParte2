package service;

import model.Adestrador;
import model.Pokedex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscrituraFicheros {

    public void writeXmlFilePokedex(List<Pokedex>pokedexList, String path){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("pokedex");

            for(int i = 0; i < pokedexList.size(); i++){
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("pokemon");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(String.valueOf(pokedexList.get(i).getId()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nome");
                xmlStreamWriter.writeCharacters(pokedexList.get(i).getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("peso");
                xmlStreamWriter.writeCharacters(String.valueOf(pokedexList.get(i).getPeso()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("miscelanea");
                xmlStreamWriter.writeCharacters(pokedexList.get(i).getMisc());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
            System.out.println("Fichero pokedex xml, escrito correctamente correctamente");
        } catch (XMLStreamException e) {
            System.out.println("Ups, ha ocurrido un error durante la ejecución de escritura de fichero xml pokedex");
        } catch (IOException e) {
            System.out.println("Ups, error durante la escritura de fichero xml pokedex");;
        }
    }

    public void writeXmlFileAdestrador(List<Adestrador>adestradorList, String path){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("adestradores");

            for(int i = 0; i < adestradorList.size(); i++){
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("adestrador");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(String.valueOf(adestradorList.get(i).getId()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nome");
                xmlStreamWriter.writeCharacters(adestradorList.get(i).getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nacemento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestradorList.get(i).getNacemento()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
            System.out.println("Fichero adestradores xml, escrito correctamente");
        } catch (XMLStreamException e) {
            System.out.println("Ups, ha ocurrido un error durante la ejecución de escritura de fichero xml adestrador");
        } catch (IOException e) {
            System.out.println("Ups, error durante la escritura de fichero xml adestrador");;
        }
    }
}
