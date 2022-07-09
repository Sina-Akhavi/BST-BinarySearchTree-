package ir.ac.kntu.util;

public class Menu {

    public static void printWelcomePage() {
        System.out.println("\n\n--Welcome To Binary Search Tree--\n");
        System.out.println("1) create a BST");
        System.out.println("2) exit\n");
        System.out.print("-Enter your choice: ");
    }

    public static void printBSTMenu() {
        System.out.println("--BST Menu--\n");
        System.out.println("1) add numbers");
        System.out.println("2) delete a number");
        System.out.println("3) find a node");
        System.out.println("4) find the path of a node from root");
        System.out.println("5) number of nodes");
        System.out.println("6) show tree");
        System.out.println("7) Back\n");
        System.out.print("-Enter your choice: ");
    }
}
