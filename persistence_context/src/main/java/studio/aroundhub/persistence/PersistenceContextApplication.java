package studio.aroundhub.persistence;

import studio.aroundhub.persistence.factory.CEntityManagerFactory;
import studio.aroundhub.persistence.service.PersistenceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersistenceContextApplication {

    public static void main(String[] args) throws IOException {
        PersistenceService service = new PersistenceService();

        CEntityManagerFactory.initialization();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Input your Command // [command] [name]");
            String commandLine = br.readLine();
            String[] splitCommand = commandLine.split(" ");

            // 별도 값 검증하는 로직은 추가하지 않음
            if (splitCommand[0].equalsIgnoreCase("exit")) {
                System.out.println("System closed");
                break;

            } else if (splitCommand[0].equalsIgnoreCase("case1")) {
                service.case1();
            } else if (splitCommand[0].equalsIgnoreCase("case2")) {
                service.case2();
            }
        }
    }

}
