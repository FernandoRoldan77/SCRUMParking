package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import org.hibernate.*;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;


public class HibernateDAO<T>  {
        private Class<T> entityType;

        public HibernateDAO(Class<T> entityType){
            this.entityType = entityType;
        }

        public void guardar(T obj) {
            Session session = TransactionRunner.getCurrentSession();
            session.save(obj);
        }

        public void actualizar(T obj) {
            Session session = TransactionRunner.getCurrentSession();
            session.update(obj);
        }

        public T recuperar(Integer id) {
            Session session = TransactionRunner.getCurrentSession();
            return session.get(entityType, id);
        }

}
