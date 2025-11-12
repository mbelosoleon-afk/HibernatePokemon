package Services;

import Config.HibernateConfig;
import Model.Adestrador;
import Model.Pokedex;
import Model.Pokemon;
import org.hibernate.Session;

import javax.transaction.Transaction;
import java.util.Date;
import java.util.List;

public class PokemonService {
    public void crearPokemon(String nome, Date nacemento, int pokedexentry, int adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemonModel = new Pokemon();

            Adestrador adestradorModel = new AdestradorService().lerAdestrador(adestrador);
            Pokedex pokedexModel = new PokedexService().lerPokemon(pokedexentry);

            pokemonModel.setNome(nome);
            pokemonModel.setNacemento(nacemento);
            pokemonModel.setPokedexentry(pokedexModel);
            pokemonModel.setAdestrador(adestradorModel);
            session.save(pokemonModel);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo pokemon: " + e.getMessage());
        }
    }
    public Pokedex leerPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o pokedex: " + e.getMessage());
            return null;
        }
    }
    public void actualizarPokemon(int id,String novoNome, Date novoNacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Obtener la entrada específica por ID
            Pokemon pokemon = session.get(Pokemon.class, id);

            if (pokemon != null) {
                pokemon.setNome(novoNome);
                pokemon.setNacemento(novoNacemento);
                session.update(pokemon);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo pokemon: " + e.getMessage());
        }
    }
    public void eliminarPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedexModel = session.get(Pokedex.class, id);
            if (pokedexModel != null) {
                session.delete(pokedexModel);
            } else {
                System.out.println("non se atopou o pokedex");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningunha pokedex Y.Y: " + e.getMessage());
        }
    }
    public List<Pokemon> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokemon", Pokemon.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-las pokedex: " + e.getMessage());
            return null;
        }
    }
}
