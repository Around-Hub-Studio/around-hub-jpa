package studio.aroundhub.simple_example.service;

import java.util.List;
import java.util.Optional;
import studio.aroundhub.simple_example.entity.UserEntity;

public interface UserService {

    void saveUser(UserEntity userEntity);

    Optional<UserEntity> getUser(String email);

    void updateUserName(String email, String newName);

    List<UserEntity> getUserList();

    void deleteUser(String email);

}
