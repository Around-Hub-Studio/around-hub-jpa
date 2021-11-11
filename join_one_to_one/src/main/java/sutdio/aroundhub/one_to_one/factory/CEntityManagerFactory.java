package sutdio.aroundhub.one_to_one.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory;
    private static ThreadLocal<EntityManager> entityManager = new ThreadLocal<>();

    /**
     * EntityManagerFactory는 EntityManager를 생성하기 위한 팩토리 인터페이스로 persistence 단위별로 팩토리를 생성
     */
    public static void initialization() {
        entityManagerFactory = Persistence.createEntityManagerFactory("entity_manager_factory");
    }

    /**
     * EntityManager 객체를 생성 EntityManager 는 Persistence Context와 Entity를 관리
     *
     * @return EntityManager 객체
     */
    public static EntityManager createEntityManger() {
        return entityManagerFactory.createEntityManager();
    }

    public static EntityManager getCurrentEntityManager() {
        EntityManager currentEntityManager = entityManager.get();
        if (currentEntityManager == null) {
            currentEntityManager = createEntityManger();
            entityManager.set(currentEntityManager);
        }
        return currentEntityManager;
    }

    public static void closeCurrentEntityManager() {
        EntityManager currentEntityManager = entityManager.get();
        if (currentEntityManager != null) {
            currentEntityManager.close();
            entityManager.remove();
        }
    }

    /**
     * EntityManagerFactory 객체 종료
     */
    public static void close() {
        entityManagerFactory.close();
    }

}
