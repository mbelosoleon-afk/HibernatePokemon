import Model.Adestrador;
import Model.Pokemon;
import Serializacion.Serial;
import Services.*;
import Model.Pokedex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Instanciar servicios
        AdestradorService adestrador = new AdestradorService();
        PokedexService pokedex = new PokedexService();
        PokemonService pokemon = new PokemonService();

        //Crear 10 pokemones en Pokedex
        pokedex.crearPokemon(new Pokedex("Luxray",42,"Mi pokemon fav"));
        pokedex.crearPokemon(new Pokedex("Machamp",100.59,"Top pokemon lucha"));
        pokedex.crearPokemon(new Pokedex("Feraligart",40.3,"Cocodrilo endemoniao"));
        pokedex.crearPokemon(new Pokedex("Charizard",90.5,"No es tipo dragón xd"));
        pokedex.crearPokemon(new Pokedex("Bulbasaur",320,"God"));
        pokedex.crearPokemon(new Pokedex("Empoleon",304.2,"Pinguino"));
        pokedex.crearPokemon(new Pokedex("Palkia",60,"Legendario fav"));
        pokedex.crearPokemon(new Pokedex("Blastoise",50.84,"Tortuga"));
        pokedex.crearPokemon(new Pokedex("Serperior",23.2,"Inicial planta quinta gen"));
        pokedex.crearPokemon(new Pokedex("Seviper",23,"serpiente veneno"));

        //Crear 2 adestradores
        Adestrador a1 = new Adestrador("Rojo", new Date(10-12-2005));
        Adestrador a2 = new Adestrador("Azul", new Date(16-9-2005));

        //Adestrador 1 pokemones
        pokemon.crearPokemon("Luxray",new java.util.Date(2018-1-2),1,1);
        pokemon.crearPokemon("Machamp",new java.util.Date(2018-8-1),2,1);
        pokemon.crearPokemon("Feraligart",new java.util.Date(2017-2-5),3,1);
        pokemon.crearPokemon("Charizard",new java.util.Date(5678-12-1),4,1);
        pokemon.crearPokemon("Bulbasaur",new java.util.Date(1231-12-4),5,1);

        //Adestrador 2 pokemones
        pokemon.crearPokemon("Empoleon",new java.util.Date(2018-1-2),1,1);
        pokemon.crearPokemon("Palkia",new java.util.Date(2018-8-1),2,1);
        pokemon.crearPokemon("Blastoise",new java.util.Date(2017-2-5),3,1);
        pokemon.crearPokemon("Serperior",new java.util.Date(5678-12-1),4,1);
        pokemon.crearPokemon("Seviper",new java.util.Date(1231-12-4),5,1);

        //Listamos pokemon
        for(Pokemon pokemonModel: pokemon.listarPokemon()){
            System.out.println(pokemonModel);
        }
        //Listamos pokemon na pokedex
        for (Pokedex pokedexModel: pokedex.listarPokedex()) {
            System.out.println(pokedexModel);
        }
        //Listamos adestradores
        for (Adestrador adestradorModel: adestrador.listarAdestrador()){
            System.out.println(adestradorModel);
        }

        //Serializamos
        List<Pokedex> pokedexSerial = new ArrayList<>();
        pokedexSerial.add(pokedex.lerPokemon(1));
        pokedexSerial.add(pokedex.lerPokemon(2));

        Serial.serializarPokedex(pokedexSerial);

        //Deserializamos
        Serial.deserializar();

        //XML adestrador
        AdestradorXML.exportarXML(adestrador.listarAdestrador());

        //Actualizar entradas
        pokedex.actualizarCamposPokedex(1,"Luxray",1000,"Esto está actualizado");
        pokedex.actualizarCamposPokedex(2,"Machamp",1000,"Esto está actualizado");

        adestrador.actualizarAdestrador(1,"Actualizado1",new Date(1000-10-10));
        adestrador.actualizarAdestrador(2,"Actualizado2",new Date(1000-10-10));

        pokemon.actualizarPokemon(1, "Actualizado1",new Date(1000-10-10));
        pokemon.actualizarPokemon(2, "Actualizado2",new Date(1000-10-10));
        pokemon.actualizarPokemon(3, "Actualizado3",new Date(1000-10-10));
        pokemon.actualizarPokemon(4,"Actualizado4",new Date(1000-10-10));

        //Listar
        //Listar
        List<Pokedex>pokedexModels = pokedex.listarPokedex();
        for(Pokedex pokedexModel: pokedexModels){
            System.out.println(pokedexModel);
        }

        List<Pokemon>pokemonModels = pokemon.listarPokemon();
        for(Pokemon pokemonModel: pokemonModels){
            System.out.println(pokemonModel);
        }

        List<Adestrador> adestradorModels = adestrador.listarAdestrador();
        for(Adestrador adestradorModel : adestradorModels){
            System.out.println(adestradorModel);
        }

        //Recuperar
        List<Pokedex>pokedexModels1 = Serial.deserializar();
        for(Pokedex pokedexModel : pokedexModels1){
            pokedex.actualizarCamposPokedex(pokedexModel.getId(),pokedexModel.getNome(),pokedexModel.getPeso(),pokedexModel.getMisc());
        }

    }
}