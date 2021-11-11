package sutdio.aroundhub.one_to_one;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import sutdio.aroundhub.one_to_one.entity.LockerEntity;
import sutdio.aroundhub.one_to_one.entity.MemberEntity;
import sutdio.aroundhub.one_to_one.factory.CEntityManagerFactory;

/**
 * 이번 프로젝트는 새로운 데이터베이스를 사용합니다. database name : one_to_one
 */
public class OneToOneApplication {

    public static void main(String[] args) throws IOException {

        CEntityManagerFactory.initialization();
        EntityManager entityManager = CEntityManagerFactory.getCurrentEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            MemberEntity memberEntity = new MemberEntity("jjj@jjj.com", "james", LocalDateTime.now());

            entityManager.persist(memberEntity);

            LocalDateTime nowDateTime = LocalDateTime.now();
            LocalDateTime expireDateTime = LocalDateTime.of(nowDateTime.getYear()+1, nowDateTime.getMonth(), nowDateTime.getDayOfMonth(), nowDateTime.getHour(), nowDateTime.getMinute(), nowDateTime.getSecond(), nowDateTime.getNano());

            LockerEntity lockerEntity = new LockerEntity(memberEntity, expireDateTime, nowDateTime);

            entityManager.persist(lockerEntity);

            entityTransaction.commit();

        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }finally {
            CEntityManagerFactory.closeCurrentEntityManager();
            CEntityManagerFactory.close();
        }

    }

}
