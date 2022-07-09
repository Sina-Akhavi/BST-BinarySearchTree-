package ir.ac.kntu.util;

public class EnumUtil {
    public enum WelcomeMenuOptions {
        CREATE_BST, EXIT
    }

    public enum BSTMenuOptions {
        ADD_NUMBERS, DELETE_A_NUMBER, FIND_A_NODE, FIND_PATH_FROM_ROOT, NUMBER_OF_NODES, SHOW_TREE,BACK
    }

    public static WelcomeMenuOptions getWelcomeMenuOption(int choice) {
        WelcomeMenuOptions welcomeMenuOptions = WelcomeMenuOptions.values()[choice - 1];
        return welcomeMenuOptions;
    }

    public static BSTMenuOptions getBSTMenuOption(int choice){
        BSTMenuOptions option = BSTMenuOptions.values()[choice - 1];
        return option;
    }
}
