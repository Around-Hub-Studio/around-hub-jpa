package studio.aroundhub.id_generation.service;

import java.util.Optional;
import studio.aroundhub.id_generation.entity.DirectEntity;
import studio.aroundhub.id_generation.entity.IdentityEntity;

public interface IdGenerationService {

    void insertDirectEntity(String name);

    Optional<DirectEntity> selectDirectEntity(String id);

    void insertIdentityEntity(String name);

    Optional<IdentityEntity> selectIdentityEntity(Long id);

    void insertTableEntity(String name);

    Optional<IdentityEntity> selectTableEntity(Long id);

}
