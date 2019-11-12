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

        public T recuperar(Long id) {
            Session session = TransactionRunner.getCurrentSession();
            return session.get(entityType, id);
        }

        public void actualizar(T id) {
            Session session = TransactionRunner.getCurrentSession();
            session.update(id);
        }

        public T recuperar(Integer id) {
            Session session = TransactionRunner.getCurrentSession();
            return session.get(entityType, id);
        }

}