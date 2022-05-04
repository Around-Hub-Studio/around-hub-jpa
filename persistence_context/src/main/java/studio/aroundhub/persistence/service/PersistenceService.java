package studio.aroundhub.persistence.service;

import studio.aroundhub.persistence.entity.Company;
import studio.aroundhub.persistence.factory.CEntityManagerFactory;

import javax.persistence.EntityManager;

public class PersistenceService {

    public void case1() {
        setData();

        EntityManager entityManager = CEntityManagerFactory.createEntityManger();
        entityManager.getTransaction().begin();

        try {
            System.out.println("## check 1 ##");

            Company foundCompany1 = entityManager.find(Company.class, "aroundhub123");

            System.out.println("## check 2 ##");

            Company foundCompany2 = entityManager.find(Company.class, "aroundhub123");

            System.out.println("## check 3 ##");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        resetData();
    }

    public void case2() {
        setData();

        EntityManager entityManager = CEntityManagerFactory.createEntityManger();
        entityManager.getTransaction().begin();

        try {
            System.out.println("## check 1 ##");

            Company foundCompany1 = entityManager.find(Company.class, "aroundhub123");

            System.out.println("## check 2 ##");


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        entityManager = CEntityManagerFactory.createEntityManger();
        entityManager.getTransaction().begin();

        try {
            System.out.println("## check 3 ##");

            Company foundCompany1 = entityManager.find(Company.class, "aroundhub123");

            System.out.println("## check 4 ##");


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        resetData();
    }


    private void setData() {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        entityManager.getTransaction().begin();

        try {
            Company company = new Company("aroundhub123", "어라운드허브", "01234",
                    "어라운드로", "강남구", "서울특별시");

            entityManager.persist(company);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void resetData() {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        entityManager.getTransaction().begin();

        try {
            Company foundCompany = entityManager.find(Company.class, "aroundhub123");
            entityManager.remove(foundCompany);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}
