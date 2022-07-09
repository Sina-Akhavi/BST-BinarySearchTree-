package ir.ac.kntu;

import ir.ac.kntu.logic.BinarySearchTree;
import ir.ac.kntu.logic.Node;
import ir.ac.kntu.util.EnumUtil;
import ir.ac.kntu.util.Menu;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.WaitingMaker;

public class Driver {
    public void start() {
        Menu.printWelcomePage();
        int choice = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();
        EnumUtil.WelcomeMenuOptions option = EnumUtil.getWelcomeMenuOption(choice);

        switch (option) {
            case CREATE_BST:
                BinarySearchTree tree = new BinarySearchTree();
                System.out.println("successfully created BST !!!\n");
                WaitingMaker.getInstance().waiting();
                bstMenu(tree);
                break;
            case EXIT:
                break;
            default:
                System.out.println("Wrong input!!!\n");
                WaitingMaker.getInstance().waiting();
                start();
        }

    }

    private void bstMenu(BinarySearchTree tree) {
        Menu.printBSTMenu();
        int choice = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();

        EnumUtil.BSTMenuOptions option = EnumUtil.getBSTMenuOption(choice);
        switch (option) {
            case ADD_NUMBERS:
                addNumbers(tree);
                System.out.println("successfully added!!!\n");
                WaitingMaker.getInstance().waiting();
                bstMenu(tree);
                break;
            case DELETE_A_NUMBER:
                deleteNumber(tree);
                WaitingMaker.getInstance().waiting();
                bstMenu(tree);
                break;
            case FIND_A_NODE:
                findNode(tree);
                bstMenu(tree);
                break;
            case FIND_PATH_FROM_ROOT:
                findPathFromRoot(tree);
                bstMenu(tree);
                break;
            case NUMBER_OF_NODES:
                System.out.println("number of nodes of tree: " + tree.getNumberOfNodes() + "\n");
                WaitingMaker.getInstance().waiting();
                bstMenu(tree);
                break;
            case SHOW_TREE:
                System.out.print("Tree Preorder Traversing: ");
                tree.printPreorder();
                System.out.println();
                WaitingMaker.getInstance().waiting();
                System.out.println("\n");
                bstMenu(tree);
                break;
            case BACK:
                start();
                break;
        }
    }

    private void findNode(BinarySearchTree tree) {
        System.out.print("\nEnter node you want to find: ");
        int key = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();

        Node foundNode = tree.find(key);

        if (foundNode == null) {
            System.out.println("not found!!!");
        } else {
            try {
                System.out.println(foundNode);
            } catch (NullPointerException ex) {
                System.out.println("node is root: " + foundNode.getData());
            }
        }
        System.out.println();
        WaitingMaker.getInstance().waiting();
    }

    private void findPathFromRoot(BinarySearchTree tree) {
        System.out.print("Enter node you want to find path from root: ");
        int key = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();

        tree.printPathFromRoot(key);
        System.out.println();
        WaitingMaker.getInstance().waiting();
    }

    private void deleteNumber(BinarySearchTree tree) {
        System.out.print("Enter node you want to delete: ");
        int mustDeleteNumber = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();

        tree.delete(mustDeleteNumber);
    }

    private void addNumbers(BinarySearchTree tree) {
        System.out.print("Enter numbers you want to add: ");
        String[] numbers = ScannerWrapper.getInstance().nextLine().split(" ");
        int[] integerNumbers = convertStringsToNumbers(numbers);
        tree.addNumbers(integerNumbers);
    }

    private int[] convertStringsToNumbers(String[] numbers) {
        int n = numbers.length;
        int[] output = new int[numbers.length];

        for (int i = 0; i < n; i++) {
            output[i] = Integer.parseInt(numbers[i]);
        }
        return output;
    }
}
