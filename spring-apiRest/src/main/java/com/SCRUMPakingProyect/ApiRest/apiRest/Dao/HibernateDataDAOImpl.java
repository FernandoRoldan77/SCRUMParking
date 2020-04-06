package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.hibernate.Session;

import java.util.List;

public class HibernateDataDAOImpl implements DataDAO {

    public void clear(){
        Session session = TransactionRunner.getCurrentSession();
        List nombreDeTablas = session.createNativeQuery("show tables").getResultList();
        session.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;").executeUpdate();
        nombreDeTablas.forEach(tabla->{
            if(!tabla.equals("hibernate_sequence")){
                session.createNativeQuery("truncate table " + tabla).executeUpdate();
            }
        });
        session.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;").executeUpdate();
    }
}
