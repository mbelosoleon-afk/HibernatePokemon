package Services;

import Model.Adestrador;
import Model.Pokedex;

import javax.xml.stream.*;
import java.io.*;
import java.util.ArrayList;

public class PokedexXML {
    private static String fichero = "Pokedex.xml";

    public static void exportarXML(ArrayList<Pokedex> pokedex) {
        XMLOutputFactory n1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter esc = n1.createXMLStreamWriter(new FileWriter(fichero));

            esc.writeStartDocument();
            esc.writeStartElement("Pokemones");
            for (Pokedex pokemones : pokedex) {
                esc.writeStartElement("Pokemon");
                esc.writeAttribute("ID", "" + pokemones.getId());

                esc.writeStartElement("Nome");
                esc.writeCharacters(pokemones.getNome());
                esc.writeEndElement();

                esc.writeStartElement("Peso");
                esc.writeCharacters("" + pokemones.getPeso());
                esc.writeEndElement();

                esc.writeStartElement("Misc");
                esc.writeCharacters("" + pokemones.getMisc());
                esc.writeEndElement();

                esc.writeEndElement();
            }
            esc.writeEndElement();
            esc.close();
        } catch (IOException e) {
            System.out.println("Error con el fichero pokedex.xml " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error con el servicio XML " + e.getMessage());
        }

    }
}