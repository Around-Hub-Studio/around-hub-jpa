package studio.aroundhub.value.service;

import javax.persistence.EntityManager;
import studio.aroundhub.value.entity.Address;
import studio.aroundhub.value.entity.OriginProvider;
import studio.aroundhub.value.entity.Provider;
import studio.aroundhub.value.factory.CEntityManagerFactory;

public class ValueService {

    public void insertOriginalProvider() {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            System.out.println("CheckPoint 1");

            OriginProvider originProvider = new OriginProvider("aroundhub123", "어라운드허브", "01234",
                                                               "어라운드로", "강남구", "서울특별시");

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(originProvider); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("CheckPoint 3");

            // 실제 DB 적용
            entityManager.getTransaction().commit();

            System.out.println("CheckPoint 4");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

    public void insertProvider() {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            System.out.println("CheckPoint 1");

            Provider provider = new Provider("aroundhub123", "어라운드허브",
                                             new Address("01234", "어라운드로", "강남구", "서울특별시"));

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(provider); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("CheckPoint 3");

            // 실제 DB 적용
            entityManager.getTransaction().commit();

            System.out.println("CheckPoint 4");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

}
