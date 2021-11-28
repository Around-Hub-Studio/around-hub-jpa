package studio.aroundhub.id_generation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import studio.aroundhub.id_generation.factory.CEntityManagerFactory;
import studio.aroundhub.id_generation.service.IdGenerationService;
import studio.aroundhub.id_generation.service.impl.IdGenerationServiceImpl;

public class IdGenerationApplication {

    public static void main(String[] args) throws IOException {

        CEntityManagerFactory.initialization();
        IdGenerationService idGenerationService = new IdGenerationServiceImpl();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Input your Command // [command] [email] [name]");
            String commandLine = br.readLine();
            String[] splitCommand = commandLine.split(" ");

            // 별도 값 검증하는 로직은 추가하지 않음
            if (splitCommand[0].equalsIgnoreCase("exit")) {
                System.out.println("System closed");
                break;

            } else if (splitCommand[0].equalsIgnoreCase("insertDirect")) {

                idGenerationService.insertDirectEntity(splitCommand[1]);

            } else if (splitCommand[0].equalsIgnoreCase("insertIdentity")) {

                idGenerationService.insertIdentityEntity(splitCommand[1]);

            }else if (splitCommand[0].equalsIgnoreCase("insertTable")) {

                idGenerationService.insertTableEntity(splitCommand[1]);

            }else if (splitCommand[0].equalsIgnoreCase("insertSequence")) {

                idGenerationService.insertSequenceEntity(splitCommand[1]);

            }
        }

    }

}
