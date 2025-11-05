package Services;

import Model.Adestrador;

import javax.xml.stream.*;
import java.io.*;
import java.util.ArrayList;

public class AdestradorXML {
    private static String fichero = "Adestradores.xml";

    public static void exportarXML(ArrayList<Adestrador> adestradores) {
        XMLOutputFactory n1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter esc = n1.createXMLStreamWriter(new FileWriter(fichero));

            esc.writeStartDocument();
            esc.writeStartElement("Adestradores");
            for (Adestrador adestrador : adestradores) {
                esc.writeStartElement("Adestrador");
                esc.writeAttribute("ID", "" + adestrador.getId());

                esc.writeStartElement("Nome");
                esc.writeCharacters(adestrador.getNome());
                esc.writeEndElement();

                esc.writeStartElement("Nacemento");
                esc.writeCharacters("" + adestrador.getNacemento());
                esc.writeEndElement();

                esc.writeEndElement();
            }
            esc.writeEndElement();
            esc.close();
        } catch (IOException e) {
            System.out.println("Error con el fichero adestrador.xml " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error con el servicio XML " + e.getMessage());
        }

    }
}