/**
 * @author Axel Balam Mancera Miramontes
 */

package evidencia1.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu provides a set of variables and members that outline a template of a user menu.
 */
public class Menu {
    /**
     * Texts that may appear when interacting with the menu.
     */
    private String MENU_WELCOME = "Menú";
    private String REQUEST_OPTION = "Digite el número correspondiente a la opción a elegir: ";
    private String NUMERIC_TYPE_ERROR = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";
    private String OUT_OF_RANGE_ERROR = "Opción no disponible. Intente de nuevo: ";
    private String END_OF_PROGRAM = "Programa finalizado.";

    /**
     * optionList stores the strings that correspond to the options shown to the user + an exit option.
     * menuActionPrototypeList stores the functions associated to every option shown to the user but the exit option.
     */
    private ArrayList<String> optionList = new ArrayList<>();
    private ArrayList<MenuActionPrototype> menuActionPrototypeList = new ArrayList<>();

    /**
     * alive sets the state of availability of the menu to the user and helps determine whether the menu should keep shown or not.
     */
    private boolean alive = true;

    /**
     * killMenu sets that the user menu should stop being shown to the user.
     */
    public void killMenu() {
        alive = false;
    }

    /**
     * isAlive determines the state of availability of the menu to the user.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * addOption a user menu given the options it should provide them and the actions associated to each of them.
     * @param option: a text containing one of the menu options.
     * @param menuActionPrototype: the method that should be executed when selecting the option associated to it.
     * @return this: the current menu with its corresponding modifications.
     */
    public Menu addOption(String option, MenuActionPrototype menuActionPrototype) {
        optionList.add(option);
        menuActionPrototypeList.add(menuActionPrototype);
        return this;
    }

    /**
     * createMenu adds an exit method at the end of the menu.
     */
    public void addExitOption() {
        optionList.add("Salir");
    }

    /**
     * cleanMenu removes all the options and actions associated to them from the menu.
     */
    public void clearMenu() {
        optionList.clear();
        menuActionPrototypeList.clear();
    }

    /**
     * showMenu displays the options within the menu
     */
    public void showMenu() {
        System.out.println(MENU_WELCOME);
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(i + 1 + ") " + optionList.get(i));
        }
    }

    public void requestOption(){
        System.out.print(REQUEST_OPTION);
    }

    /**
     * readOption reads the user's input and validates it was given in an appropriate format.
     * @return option: a number that represents the index of a specific option.
     */
    public int readOption() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                int option = input.nextInt();
                input.nextLine();
                if (option < 0 || option > optionList.size()) {
                    System.out.print(OUT_OF_RANGE_ERROR);
                    continue;
                }
                else if(option == 0){
                    killMenu();
                    option = optionList.size();
                }
                return option;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print(NUMERIC_TYPE_ERROR);
            }
        }
    }

    /**
     * selectAndRunOption executes the function associated to the option selected by the user
     * @param option: the number that represents the index of the option selected by the user.
     */
    public void executeOption(int option) {
        if (option == optionList.size()) {
            killMenu();
            System.out.println(END_OF_PROGRAM);
            return;
        }
        menuActionPrototypeList.get(option - 1).definedAction();
    }
}

