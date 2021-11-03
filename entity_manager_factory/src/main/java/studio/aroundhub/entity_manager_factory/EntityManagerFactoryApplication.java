package studio.aroundhub.entity_manager_factory;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import studio.aroundhub.entity_manager_factory.entity.UserEntity;
import studio.aroundhub.entity_manager_factory.factory.CEntityManagerFactory;

public class EntityManagerFactoryApplication {

    public static void main(String[] args) {

        CEntityManagerFactory.initialization();

        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityManager에서 트랜잭션을 가져와 관리하기 위한 객체 생성
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            // 트랜잭션을 시작해야 DB를 조작할 수 있음
            entityTransaction.begin();

            // 저장하고자 하는 엔티티 객체를 생성
            UserEntity userEntity = new UserEntity("thinkground.flature@gmail.com", "Flature",
                                                   LocalDateTime.now(), LocalDateTime.now());

            // UserEntity 객체를 Persistence Context에 추가
            entityManager.persist(userEntity);

            // 실제 DB에 반영
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

            // 예외가 발생했을 경우 트랜잭션 롤백 진행
            entityTransaction.rollback();

        } finally {

            // 엔티티 매니저 종료. JDBC에서 Connection 종료하는 것과 동일한 기능으로 보면 됨
            entityManager.close();
        }

        // 팩토리 종료. 커넥션 풀 자원을 반환
        CEntityManagerFactory.close();

    }

}
