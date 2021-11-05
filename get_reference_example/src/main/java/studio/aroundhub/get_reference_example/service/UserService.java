package studio.aroundhub.get_reference_example.service;

import java.util.List;
import java.util.Optional;
import studio.aroundhub.get_reference_example.entity.UserEntity;

public interface UserService {

    void saveUser(UserEntity userEntity);

    Optional<UserEntity> getUser(String email);

    Optional<UserEntity> getReferenceUser(String email);

    void updateUserName(String email, String newName);

    List<UserEntity> getUserList();

    void deleteUser(String email);

}
