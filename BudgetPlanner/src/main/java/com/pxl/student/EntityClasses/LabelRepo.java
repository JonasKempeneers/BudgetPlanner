package com.pxl.student.EntityClasses;

import javax.persistence.*;

public class LabelRepo {

    private EntityManagerFactory _emf = Persistence.createEntityManagerFactory("BudgetPlanner");

    public void addLabel(String name, String description){
        EntityManager em = _emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Label label = new Label(name, description);

        tx.begin();
        em.persist(label);
        tx.commit();
    }

    public void addLabelToPayment(int labelId, int paymentId){
        EntityManager em = _emf.createEntityManager();
        Query query = em.createQuery("Update Payment Set labelId = :labelId WHERE id = :paymentId");
        query.setParameter(labelId, labelId);
        query.setParameter(paymentId, paymentId);
        query.executeUpdate();
    }

    public void addLabelToPaymentsWithId(int labelId, int counterAccountId){
        EntityManager em = _emf.createEntityManager();
        Query query = em.createQuery("Update Payment Set labelId = :labelId WHERE counterAccountId = :counterAccountId");
        query.setParameter(labelId, labelId);
        query.setParameter(counterAccountId, counterAccountId);
        query.executeUpdate();
    }

}
