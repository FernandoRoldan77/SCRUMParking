package com.SCRUMPakingProyect.ApiRest.runner;

import org.apache.logging.log4j.util.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionRunner {
    private static Session session;

    public static void run(Runnable bloque) {
        run(()->{
            bloque.run();
            return null;
        });
    }


    public static <T> T run(Supplier<T> bloque) {
        Transaction tx = null;
        if(session != null){
            return bloque.get();
        }

        try {

            session = SessionFactoryProvider.getInstance().createSession();
            tx = session.beginTransaction();

            //codigo de negocio
            T resultado = bloque.get();

            tx.commit();
            return resultado;
        } catch (RuntimeException e) {
            //solamente puedo cerrar la transaccion si fue abierta antes,
            //puede haberse roto el metodo ANTES de abrir una transaccion
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
    }

    public static Session getCurrentSession() {
        if (session == null) {
            throw new RuntimeException("No hay ninguna session en el contexto");
        }
        return session;
    }
}
