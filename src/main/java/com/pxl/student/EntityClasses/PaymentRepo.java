package com.pxl.student.EntityClasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PaymentRepo {
    private EntityManagerFactory _emf = Persistence.createEntityManagerFactory("BudgetPlanner");

    public List<Payment> getPaymentsByAccountId(int accountId) {
        EntityManager em = _emf.createEntityManager();
        Query query = em.createQuery("Select p.id, p.date, p.amount, p.currency, p.detail, p.accountId, p.counterAccountId, " +
                "p.labelId FROM Payment AS p where p.accountId = :accountId");
        query.setParameter("accountId", accountId);
        List<Payment> paymentList = query.getResultList();

        return paymentList;
    }
}
