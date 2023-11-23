package evidencia3.process;

import evidencia3.utils.Graph1;
import evidencia3.utils.GraphNode1;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    /**
     * Other useful texts.
     */
    private static final String FEATURE_QUESTION = "¿El animal en el que estás pensando posee la siguiente característica?";
    private static final String ANIMAL_GUESS = "¿Este es el animal en el que estás pensando?";

    /**
     * Methods used by CLI.
     */
    public static String readYesNoAnswer() {
        Scanner input = new Scanner(System.in);
        String ans = "";

        do {
            System.out.print("Por favor, ingresa 'Sí' o 'No': ");
            ans = input.nextLine().trim();
        } while (!"Sí".equalsIgnoreCase(ans) && !"No".equalsIgnoreCase(ans));

        return ans;
    }

    public static String readAnimalFeature(ArrayList<String> animalFeatures) {
        Scanner input = new Scanner(System.in);
        String feature;

        System.out.println("¿Qué característica posee el animal en el que piensas?");
        if (animalFeatures.size() > 0) {
            System.out.println("Además de las siguientes:");
            for (String animalFeature : animalFeatures) {
                System.out.printf("\t-> %s%n", animalFeature);
            }
            System.out.println();
        }

        feature = input.nextLine();

        return feature;
    }

    public static String readAnimal() {
        Scanner input = new Scanner(System.in);
        String animal;

        System.out.println("¿En qué animal estás pensando?");
        animal = input.nextLine();

        return animal;
    }

    public static void guessAnimal(GraphNode1 currentNode, String hasFeature, String isAnimal){
        while (currentNode.getNeighbours().size() > 0) {

            // Changing animal accordingly.
            System.out.printf("%s%n\t-> %s%n", FEATURE_QUESTION, currentNode.getNextAnimalFeature());
            hasFeature = Process.readYesNoAnswer();

            if (hasFeature.equalsIgnoreCase("Yes")) {
                currentNode = currentNode.getNeighbourYes();
            } else if (hasFeature.equalsIgnoreCase("No")) {
                currentNode = currentNode.getNeighbourNo();
            }

            // Guessing animal
            System.out.printf("%s%n\t-> %s%n", ANIMAL_GUESS, currentNode.getAnimal());
            isAnimal = Process.readYesNoAnswer();
            if (isAnimal.equalsIgnoreCase("Yes")) {
                break;
            }
        }
    }

    public static void improveSystem(ArrayList<String> animalFeatures, GraphNode1 currentNode, String hasFeature, Graph1 animals){
        String animal, feature;
        feature = Process.readAnimalFeature(animalFeatures);
        animal = Process.readAnimal();

        currentNode.setNextAnimalFeature(feature);
        if (hasFeature.equalsIgnoreCase("Yes")) {
            animals.addEdgeYes(currentNode, new GraphNode1(animal));
        } else if (hasFeature.equalsIgnoreCase("No")) {
            animals.addEdgeNo(currentNode, new GraphNode1(animal));
        }
    }
}
