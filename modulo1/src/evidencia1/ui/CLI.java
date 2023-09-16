/**
 * @author Axel Balam Mancera Miramontes
 */

package evidencia1.ui;

import evidencia1.process.ServerSimulation;
import evidencia1.utils.Cola;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed by the Passengers class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by process package.
     */
    private static Cola<Integer> serverA = new Cola<>();
    private static Cola<Integer> serverB = new Cola<>();
    private static Scanner input = new Scanner(System.in);

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String SIMULATE_SERVERS = "Simular trabajo simultáneo de dos servidores.";

    /**
     * Other usefull texts.
     */
    private static String RUN_PROCESS_SERVER_A = "Corriendo proceso del servidor A.\n";
    private static String RUN_PROCESS_SERVER_B = "Corriendo proceso del servidor B.\n";
    private static String NO_PROCESS_IN_SERVER = "¡Ya no hay más procesos a correr en el servidor!.\n";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that simulates the simultaneous work of two different running servers.
     */
    private static MenuActionPrototype simulateServers = () -> {
        int i;
        double probability;
        Random random = new Random();
        Optional<Integer> result;

        for(i = 0; i < ServerSimulation.getNumberOfProcesses(); ++i){
            ServerSimulation.loadServer(serverA, i);
            ServerSimulation.loadServer(serverB, i);
        }


        while(!serverA.isEmpty() || !serverB.isEmpty()){
            probability = random.nextDouble();
            if(probability <= 0.3){
                System.out.printf(RUN_PROCESS_SERVER_A);
            }
            else{
                System.out.printf(RUN_PROCESS_SERVER_B);
            }

            result = ServerSimulation.processProcess(serverA, serverB, probability);
            if(result != null){
                System.out.println(result.get());
            }
            else{
                System.out.printf(NO_PROCESS_IN_SERVER);
            }
        }
    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(SIMULATE_SERVERS, simulateServers)
                .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void launchApp() {
        do {
            menu.showMenu();
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}