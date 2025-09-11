package Controller;

import Model.Pratos;
import jakarta.transaction.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.Queue;

public class pratosController {

    public void cadastrarPratos(Pratos pratos) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        Transaction transaction= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
        transaction = (Transaction) session.beginTransaction();
        // Validações de negócio ( nome, tipo, etc.)
            String nomePrato = null;
            if(nomePrato == null || nomePrato.trim().isEmpty()){
                session.persist(pratos); //Salva o objeto no banco
                transaction.commit();
            }
        } catch (Exception e) {
            if(transaction!= null){
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao cadastrar prato: " + e.getMessage());

        }
    }

    public List<Pratos> listarTodosPratos() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // HQL (HIBERNATE Query Language) = similar ao SQL, mas usa o nome da CLASSE
            Query<Pratos> query=session.createQuery("FROM Pratos",  Pratos.class);
            return query.getResultList();
        }
    }

    public Pratos buscarPratosPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Pratos.class, id);
        }
    }
}
