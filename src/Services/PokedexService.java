package Services;

import Config.HibernateConfig;
import Model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PokedexService {

    public void crearPokemon(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex pokedex = new Pokedex();
            pokedex.setId(pokemon.getId());
            pokedex.setNome(pokemon.getNome());
            pokedex.setPeso(pokemon.getPeso());
            pokedex.setMisc(pokemon.getMisc());

            session.save(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo Pokemon: " + e.getMessage());
        }
    }
    public Pokedex lerPokemon(String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, nome);
        } catch (Exception e) {
            System.out.println("Erro ao ler o gato: " + e.getMessage());
            return null;
        }
    }
    public List<Pokedex> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokedex", Pokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los Pokedex: " + e.getMessage());
            return null;
        }
    }
    public void actualizarPokedex(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo pokedex: " + e.getMessage());
        }
    }
    public void eliminarPokemon(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokemon = session.get(Pokedex.class, pokedex.getId());
            if (pokemon != null) {
                session.delete(pokemon);
            } else {
                System.out.println("non se atopou o Pokemon");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun Pokemon Y.Y: " + e.getMessage());
        }
    }
    public Pokedex lerPokemonPorNome(String nome) {

        Pokedex pokedex = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Pokedex> pokedexList = session.createQuery("from Pokedex where nome = :nome", Pokedex.class)
                    .setParameter("nome", nome)
                    .getResultList();

            if (!pokedexList.isEmpty()) {
                pokedex = pokedexList.get(0);
            } else {
                System.out.println("Non se atopou o pokemon co nome " + nome);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao ler o adestrador: " + e.getMessage());
        }
        return pokedex;
    }
    public void eliminarPokemonPorNome(String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Pokedex> pokedexList = session.createQuery("from Pokedex where nome = :nome", Pokedex.class)
                    .setParameter("nome", nome)
                    .getResultList();

            if (!pokedexList.isEmpty()) {
                Pokedex gato = pokedexList.get(0);
                session.delete(gato);
                System.out.println("Pokemon " + nome);
            } else {
                System.out.println("Non se atopou o pokemon co nome " + nome);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun pokemon Y.Y: " + e.getMessage());
        }
    }
}
