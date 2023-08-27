import entity.CustomersEntity;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            CustomersEntity customer = new CustomersEntity();
//            customer.setName("Dung");
//            customer.setGender(1);
//            customer.setAddress("a");
//            customer.setPhone("111234567");
//            entityManager.persist(customer);

//            TypedQuery<CustomersEntity> customersEntityTypedQuery = entityManager.createNamedQuery("customers.byName", CustomersEntity.class);
//            customersEntityTypedQuery.setParameter(1, 3);
//            for (CustomersEntity customer: customersEntityTypedQuery.getResultList()) {
//                System.out.println(customer);
//            }
            //Native SQL
            Query countCustomer = entityManager.createNativeQuery("Select COUNT(*) from customers");
            System.out.println(countCustomer.getSingleResult());

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
