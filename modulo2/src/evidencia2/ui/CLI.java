/**
 * @author Axel Balam Mancera Miramontes
 */

package evidencia2.ui;

import evidencia1.ui.Menu;
import evidencia1.ui.MenuActionPrototype;
import evidencia2.utils.Graph1;
import evidencia2.utils.GraphNode1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by CLI.
     */
    private static Graph1 animals = new Graph1();
    private static ArrayList<String> animalFeatures;
    private static Scanner input = new Scanner(System.in);

    /**
     * Methods used by CLI.
     */
    private static String readYesNoAnswer(){
        Scanner input = new Scanner(System.in);
        String ans = "";

        do {
            System.out.print("Por favor, ingresa 'Sí' o 'No': ");
            ans = input.nextLine().trim();
        } while (!"Sí".equalsIgnoreCase(ans) && !"No".equalsIgnoreCase(ans));

        return ans;
    }

    private static String readAnimalFeature(){
        String feature;

        System.out.println("¿Qué característica tiene el animal en el que pensabas?");
        if(animalFeatures.size() > 0){
            System.out.println(" Además de las siguientes:");
            for(String animalFeature : animalFeatures){
                System.out.println("\t-> " + animalFeature);
            }
            System.out.println();
        }

        feature = input.nextLine();

        return feature;
    }

    private static String readAnimal(){
        String animal;

        System.out.println("¿En qué animal estabas pensando?");
        animal = input.nextLine();

        return animal;
    }

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String GUESS_ANIMAL = "Piensa en un animal e intentaré adivinarlo.";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that simulates the simultaneous work of two different running servers.
     */
    private static MenuActionPrototype startGame = () -> {
        GraphNode1 currentNode = animals.getRoot();

        animalFeatures = new ArrayList<>();
        String hasFeature = "No", isAnimal = "No";

        System.out.println("Juego iniciado.");
        System.out.println("Piensa en un animal e intentaré adivinar de cuál se trata, ¿va?");
        System.out.println("¡Empecemos!");

        while(currentNode.getNeighbours().size() > 0) {

            // Changing animal accordingly.
            System.out.println("¿El animal en el que estás pensando posee la siguiente característica?" +
                    "\n\t-> " + currentNode.getNextAnimalFeature());
            hasFeature = readYesNoAnswer();

            if (hasFeature.equalsIgnoreCase("Sí")) {
                currentNode = currentNode.getNeighbourYes();
            }
            else if (hasFeature.equalsIgnoreCase("No")) {
                currentNode = currentNode.getNeighbourNo();
            }

            // Guessing animal
            System.out.println("¿El animal en el que estás pensando es el siguiente?" +
                    "\n\t-> " + currentNode.getAnimal());
            isAnimal = readYesNoAnswer();
            if(isAnimal.equalsIgnoreCase("Sí")){
                break;
            }
        }

        if(isAnimal.equalsIgnoreCase("Sí")){
            System.out.println("¡He adivinado! ¡Wuuu!");
        }
        else if(isAnimal.equalsIgnoreCase("No")){
            String animal, feature;

            System.out.println("He perdido. :(");
            feature = readAnimalFeature();
            animal = readAnimal();

            currentNode.setNextAnimalFeature(feature);
            if(hasFeature.equalsIgnoreCase("Sí")){
                animals.addEdgeYes(currentNode, new GraphNode1(animal));
            }
            else if(hasFeature.equalsIgnoreCase("No")){
                animals.addEdgeNo(currentNode, new GraphNode1(animal));
            }
        }

    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(GUESS_ANIMAL, startGame)
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