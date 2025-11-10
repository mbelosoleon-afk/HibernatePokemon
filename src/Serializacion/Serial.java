package Serializacion;

import Model.Pokedex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Serial {
    //Serializa la Pokedex
    public static void serializarPokedex(List<Pokedex> pokedexModel){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("Serializar.txt")));
            oos.writeObject(pokedexModel);
        }catch (IOException e){
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }
    //Deserializa la pokedex
    public static List<Pokedex> deserializar(){
        List<Pokedex> pokedexModel = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream((new FileInputStream("Serializar.txt")));
            pokedexModel = (List<Pokedex>) ois.readObject();
            System.out.println(pokedexModel);
        }catch (IOException e){
            System.out.println("Error al deserializar");
        }catch (ClassNotFoundException e){
            System.out.println("Objeto no encontrado para deserializar");
        }
        return pokedexModel;
    }
}
