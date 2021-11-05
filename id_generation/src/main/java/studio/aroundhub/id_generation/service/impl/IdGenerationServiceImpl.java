package studio.aroundhub.id_generation.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.EntityManager;
import studio.aroundhub.id_generation.entity.DirectEntity;
import studio.aroundhub.id_generation.entity.IdentityEntity;
import studio.aroundhub.id_generation.entity.TableEntity;
import studio.aroundhub.id_generation.factory.CEntityManagerFactory;
import studio.aroundhub.id_generation.service.IdGenerationService;

public class IdGenerationServiceImpl implements IdGenerationService {

    static long num = 0;

    private static Long createNumber() {

        return num++;
    }

    @Override
    public void insertDirectEntity(String name) {

        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            Long number = createNumber();
            DirectEntity directEntity = new DirectEntity(number, name, LocalDateTime.now(),
                                                         LocalDateTime.now());

            // Persistence Context 에 객체 추가
            entityManager.persist(directEntity);
            // 실제 DB 적용
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

    }

    @Override
    public Optional<DirectEntity> selectDirectEntity(String id) {
        return Optional.empty();
    }

    @Override
    public void insertIdentityEntity(String name) {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            IdentityEntity identityEntity = new IdentityEntity(name, LocalDateTime.now(),
                                                               LocalDateTime.now());

            // Persistence Context 에 객체 추가
            entityManager.persist(identityEntity); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("id value : " + identityEntity.getNumber());

            // 실제 DB 적용
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<IdentityEntity> selectIdentityEntity(Long id) {
        return Optional.empty();
    }

    @Override
    public void insertTableEntity(String name) {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            TableEntity tableEntity = new TableEntity(name, LocalDateTime.now(),
                                                      LocalDateTime.now());

            // Persistence Context 에 객체 추가
            entityManager.persist(tableEntity); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("id value : " + tableEntity.getNumber());

            // 실제 DB 적용
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<IdentityEntity> selectTableEntity(Long id) {
        return Optional.empty();
    }
}
