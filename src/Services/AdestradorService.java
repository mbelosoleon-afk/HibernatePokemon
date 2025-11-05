package Services;

import Config.HibernateConfig;
import Model.Adestrador;
import Model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.internal.EvictVisitor;

import java.util.Date;
import java.util.List;

public class AdestradorService {
    public void crearAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Adestrador entrenador = new Adestrador();
            entrenador.setId(adestrador.getId());
            entrenador.setNome(adestrador.getNome());
            entrenador.setNacemento(adestrador.getNacemento());

            session.save(entrenador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo Adestrador: " + e.getMessage());
        }
    }

    public Adestrador lerAdestradorPorNome(String nome) {

        Adestrador adestrador = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Adestrador> adestradorList = session.createQuery("from Adestrador where nome = :nome", Adestrador.class)
                    .setParameter("nome", nome)
                    .getResultList();

            if (!adestradorList.isEmpty()) {
                adestrador = adestradorList.get(0);
            } else {
                System.out.println("Non se atopou o pokemon co nome " + nome);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao ler o adestrador: " + e.getMessage());
        }
        return adestrador;
    }

    public void actualizarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo adestrador: " + e.getMessage());
        }
    }

    public void eliminarAdestrador(int id){
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if(adestrador != null){
                session.delete(adestrador);
            }else{
                System.out.println("Non se atopou o adestrador");
            }
            transaction.commit();
        }catch (Exception e){
            System.out.println("Non quero eliminar o adestrador");
        }
    }
    public void eliminarAdestradorPorNome(String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Adestrador> adestradorList = session.createQuery("from Adestrador where nome = :nome", Adestrador.class)
                    .setParameter("nome", nome)
                    .getResultList();

            if (!adestradorList.isEmpty()) {
                Adestrador adestrador = adestradorList.get(0);
                session.delete(adestrador);
                System.out.println("Adestrador " + nome);
            } else {
                System.out.println("Non se atopou o adestrador co nome " + nome);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun pokemon Y.Y: " + e.getMessage());
        }
    }

    public List<Adestrador> listarAdestrador() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador", Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los Adostradores: " + e.getMessage());
            return null;
        }
    }
}
