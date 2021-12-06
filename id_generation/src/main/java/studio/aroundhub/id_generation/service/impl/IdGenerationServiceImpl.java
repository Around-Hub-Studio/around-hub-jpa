package studio.aroundhub.id_generation.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.EntityManager;
import studio.aroundhub.id_generation.entity.DirectEntity;
import studio.aroundhub.id_generation.entity.IdentityEntity;
import studio.aroundhub.id_generation.entity.SequenceEntity;
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
            System.out.println("CheckPoint 1");
            Long number = createNumber();
            DirectEntity directEntity = new DirectEntity(number, name, LocalDateTime.now(),
                                                         LocalDateTime.now());

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(directEntity);

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
            System.out.println("CheckPoint 1");

            IdentityEntity identityEntity = new IdentityEntity(name, LocalDateTime.now(),
                                                               LocalDateTime.now());

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(identityEntity); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("CheckPoint 3");
            System.out.println("id value : " + identityEntity.getNumber());

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
            System.out.println("CheckPoint 1");
            TableEntity tableEntity = new TableEntity(name, LocalDateTime.now(),
                                                      LocalDateTime.now());

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(tableEntity); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("CheckPoint 3");
            System.out.println("id value : " + tableEntity.getNumber());

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

    @Override
    public Optional<TableEntity> selectTableEntity(Long id) {
        return Optional.empty();
    }

    @Override
    public void insertSequenceEntity(String name) {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            System.out.println("CheckPoint 1");
            SequenceEntity sequenceEntity = new SequenceEntity(name, LocalDateTime.now(),
                                                         LocalDateTime.now());

            System.out.println("CheckPoint 2");
            // Persistence Context 에 객체 추가
            entityManager.persist(sequenceEntity); // 이 단계에서 Id 값이 영속성 컨텍스트에 반영됨

            System.out.println("CheckPoint 3");
            System.out.println("id value : " + sequenceEntity.getId());

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

    @Override
    public Optional<TableEntity> selectSequenceEntity(Long id) {
        return Optional.empty();
    }
}
