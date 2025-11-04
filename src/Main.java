//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Services.PokedexService;
import Model.Pokedex;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokedexService pokedex = new PokedexService();

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


        //Insertamos los pokemones en la tabla Pokédex
        for(Pokedex p: todosPokemons) {
            pokedex.crearPokemon(p);
        }

        //Listamos los pokemones
        System.out.println(pokedex.listarPokemon());

        //Actualizamos los pokemones
        ArrayList<Pokedex> pokemonActualizados = new ArrayList<>();

        pokemonActualizados.add(pokedex.lerPokemonPorNome("Serperior"));
        pokemonActualizados.add(pokedex.lerPokemonPorNome("Blastoise"));

        for (Pokedex p:pokemonActualizados){
            System.out.println("Actualizamos a " + p.getNome());
            p.setMisc("Misc actualizados");
            pokedex.actualizarPokedex(p);
            System.out.println("Pokemones Actualizados");
        }

        //Listamos de nuevo los pokemones
        System.out.println(pokedex.listarPokemon());

        //Borramos todos los pokemones
        List<Pokedex> pokemonList = pokedex.listarPokemon();
        for(Pokedex p: pokemonList) {
            System.out.println("Borramos todo");
            pokedex.eliminarPokemonPorNome(p.getNome());
            System.out.println("Borrados");
        }
    }
}