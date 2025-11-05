import Model.Adestrador;
import Services.AdestradorService;
import Services.AdestradorXML;
import Services.PokedexService;
import Model.Pokedex;
import Services.PokedexXML;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokedexService pokedex = new PokedexService();
        AdestradorService adestrador = new AdestradorService();

        Pokedex p1 = new Pokedex("Luxray",42,"Mi pokemon fav");
        Pokedex p2 = new Pokedex("Machamp",100.59,"Top pokemon lucha");
        Pokedex p3 = new Pokedex("Feraligart",40.3,"Cocodrilo endemoniao");
        Pokedex p4 = new Pokedex("Charizard",90.5,"No es tipo dragón xd");
        Pokedex p5 = new Pokedex("Bulbasaur",320,"God");
        Pokedex p6 = new Pokedex("Empoleon",304.2,"Pinguino");
        Pokedex p7 = new Pokedex("Palkia",60,"Legendario fav");
        Pokedex p8 = new Pokedex("Blastoise",50.84,"Tortuga");
        Pokedex p9 = new Pokedex("Serperior",23.2,"Inicial planta quinta gen");
        Pokedex p10 = new Pokedex("Seviper",23,"serpiente veneno");

        //Los añadimos a todos en un arrayList
        ArrayList<Pokedex> todosPokemons = new ArrayList<>();
        todosPokemons.add(p1);
        todosPokemons.add(p2);
        todosPokemons.add(p3);
        todosPokemons.add(p4);
        todosPokemons.add(p5);
        todosPokemons.add(p6);
        todosPokemons.add(p7);
        todosPokemons.add(p8);
        todosPokemons.add(p9);
        todosPokemons.add(p10);

        //Creamos los entrenadores
        Adestrador a1 = new Adestrador("Rojo", new Date(10-12-2005));
        Adestrador a2 = new Adestrador("Azul", new Date(16-9-2005));

        //Los añadimos en un array
        ArrayList<Adestrador> todosAdestradores = new ArrayList<>();
        todosAdestradores.add(a1);
        todosAdestradores.add(a2);

        //Insertamos los pokemones en la tabla Pokédex
        for(Pokedex p: todosPokemons) {
            pokedex.crearPokemon(p);
        }

        //Insertamos los entrenadores
        adestrador.crearAdestrador(a1);
        adestrador.crearAdestrador(a2);

        //Listamos os pokemones
        pokedex.listarPokemon();

        //Modificamos os dous adestradores
        ArrayList<Adestrador> adestradoresActualizados = new ArrayList<>();

        adestradoresActualizados.add(adestrador.lerAdestradorPorNome("Rojo"));
        adestradoresActualizados.add(adestrador.lerAdestradorPorNome("Azul"));

        for (Adestrador a:adestradoresActualizados){
            System.out.println("Actualizamos a " + a.getNome());
            a.setNome("Nombres actualizados");
            adestrador.actualizarAdestrador(a);
            System.out.println("Adestradores Actualizados");
        }

        //Modificamos duas entradas na pokedex
        ArrayList<Pokedex> pokemonActualizados = new ArrayList<>();

        pokemonActualizados.add(pokedex.lerPokemonPorNome("Blastoise"));
        pokemonActualizados.add(pokedex.lerPokemonPorNome("Serperior"));

        for (Pokedex p: pokemonActualizados){
            System.out.println("Actualizamos a " + p.getNome());
            p.setMisc("Misc actualizados");
            pokedex.actualizarPokedex(p);
            System.out.println("Adestradores Actualizados");
        }

        //listamos pokedex
        System.out.println(pokedex.listarPokemon());
        //listamos adestradores
        System.out.println(adestrador.listarAdestrador());

        //xml de pokedex
        PokedexXML.exportarXML(todosPokemons);
        //xml de adestradores
        AdestradorXML.exportarXML(todosAdestradores);

        //eliminamos todo das táboas
        List<Pokedex> pokemonList = pokedex.listarPokemon();
        for(Pokedex p: pokemonList){
            pokedex.eliminarPokemonPorNome(p.getNome());
        }
        List<Adestrador> adestradorList = adestrador.listarAdestrador();
        for(Adestrador a: adestradorList){
            adestrador.eliminarAdestradorPorNome(a.getNome());
        }
    }
}