package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import com.SCRUMPakingProyect.ApiRest.model.Propietario;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class PropietarioDAOImpl extends HibernateDAO<Propietario> implements PropietarioDAO {

    public PropietarioDAOImpl() {
        super(Propietario.class);
    }

    @Override
    public void registrar(Propietario propietario) {
        Session session = TransactionRunner.getCurrentSession();
        session.save(propietario);
    }

    @Override
    public List<Propietario> listarTodos() {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select documento " +
                "from Propietario";
        Query<Propietario> query = session.createQuery(hql, Propietario.class);

        return query.getResultList();
    }

    @Override
    public Propietario recuperarPropietario(int documento) {
        Session session = TransactionRunner.getCurrentSession();
        String hql =  "from Propietario p " +
                "WHERE documento = :elDocumento";
        Query<Propietario> query = session.createQuery(hql, Propietario.class);
        query.setParameter("elDocumento", documento);
        return query.getSingleResult();
    }

    @Override
    public void eliminar(int documento) {

        Session session = TransactionRunner.getCurrentSession();
        String hql = "DELETE FROM Propietario WHERE documento = :elDocumento";
        TypedQuery query = session.createQuery(hql);
        query.setParameter("elDocumento", documento);
        query.executeUpdate();
    }
}
