package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import com.SCRUMPakingProyect.ApiRest.model.Ganancia;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GananciaDAOImpl extends HibernateDAO<Ganancia> implements GananciaDAO {

    public GananciaDAOImpl() {
        super(Ganancia.class);
    }

    @Override
    public void guardar(Ganancia ganancia) {
        Session session = TransactionRunner.getCurrentSession();
        session.save(ganancia);
    }

    @Override
    public Ganancia recuperar(int id) {
        Session session = TransactionRunner.getCurrentSession();
        String hql =  "from Ganancia " +
                "WHERE id = :ElId";
        Query<Ganancia> query = session.createQuery(hql, Ganancia.class);
        query.setParameter("ElId", id);
        return query.getSingleResult();
    }

   @Override
   public void actualizar(Ganancia ganancia) {
       Session session = TransactionRunner.getCurrentSession();
       session.update(ganancia);
   }

}
