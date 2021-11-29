package studio.aroundhub.get_reference_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Optional;
import studio.aroundhub.get_reference_example.entity.UserEntity;
import studio.aroundhub.get_reference_example.factory.CEntityManagerFactory;
import studio.aroundhub.get_reference_example.service.UserService;
import studio.aroundhub.get_reference_example.service.impl.UserServiceImpl;

public class GetReferenceApplication {

    public static void main(String[] args) throws IOException {

        CEntityManagerFactory.initialization();
        UserService userService = new UserServiceImpl();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Input your Command // [command] [email] [name]");
            String commandLine = br.readLine();
            String[] splitCommand = commandLine.split(" ");

            // 별도 값 검증하는 로직은 추가하지 않음
            if (splitCommand[0].equalsIgnoreCase("exit")) {
                System.out.println("System closed");
                break;

            } else if (splitCommand[0].equalsIgnoreCase("insert")) {
                UserEntity userEntity = new UserEntity(splitCommand[1], splitCommand[2],
                                                       LocalDateTime.now(), LocalDateTime.now());
                userService.saveUser(userEntity);

            } else if (splitCommand[0].equalsIgnoreCase("select")) {
                Optional<UserEntity> userEntity = userService.getUser(splitCommand[1]);
                if (userEntity.isPresent()) {
                    UserEntity user = userEntity.get();
                    System.out.println("email : " + user.getEmail());
                    System.out.println("name : " + user.getName());
                    System.out.println("created date : " + user.getCreatedAt());
                    System.out.println("updated date : " + user.getUpdatedAt());

                } else {
                    System.out.println("값을 찾을 수 없습니다.");
                }

            } else if (splitCommand[0].equalsIgnoreCase("select2")) {
                Optional<UserEntity> userEntity = userService.getReferenceUser(splitCommand[1]);

                if (userEntity.isPresent()) {
                    UserEntity user = userEntity.get();
                    System.out.println("email : " + user.getEmail());
                    System.out.println("name : " + user.getName());
                    System.out.println("created date : " + user.getCreatedAt());
                    System.out.println("updated date : " + user.getUpdatedAt());

                } else {
                    System.out.println("값을 찾을 수 없습니다.");
                }

            } else {
                System.out.println(
                    "Please input Correct Command. ex) exit, insert, select, list, updateName, delete, getReference");
            }

        }

        CEntityManagerFactory.close();

    }

}
