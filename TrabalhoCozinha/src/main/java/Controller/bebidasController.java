package Controller;

import Model.Bebidas;
import Model.Pratos;
import jakarta.transaction.*;
import org.hibernate.Session;
import org.hibernate.dialect.function.array.H2ArrayContainsFunction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class bebidasController {

    public void cadastrarBebidas(Bebidas bebidas) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            //Validação de negócios( nome, tipo etc. )
            String nomeBebida = null;
            if(nomeBebida == null || nomeBebida.trim().isEmpty()){
                session.persist(bebidas); //Salva o objeto no banco
                transaction.commit();
            }
        } catch (Exception e) {
            if(transaction!= null){
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao cadastrar bebida: " + e.getMessage());
        }
    }

    public List<Bebidas> listarTodasBebidas() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // HQL (HIBERNATE Query Language) = similar ao SQL, mas usa o nome da CLASSE
            Query<Bebidas> query=session.createQuery("FROM Bebidas",  Bebidas.class);
            return query.getResultList();
        }
    }

    public Bebidas buscarBebidasPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Bebidas.class, id);
        }
    }
}
