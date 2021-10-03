package ascii.paint;

import java.util.Scanner;

/**
 *
 * @author g56212
 */
public class Application {

    private AsciiPaint ascii;

    public Application() {
        this.ascii = new AsciiPaint();

    }

    public Application(int width, int height) {
        this.ascii = new AsciiPaint(width, height);
    }

    private static int readNumber(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message);
        while (!kbd.hasNextInt()) {
            kbd.next();
            System.out.println("Inserted number is not an integer.");
            System.out.println(message);
        }
        return kbd.nextInt();
    }

    private static int sizeBetweenRange(String message, int min) {

        int number = readNumber(message);
        while (number < min) {
            System.out.println("Inserted number isn't above " + min);
            number = readNumber(message);
        }
        return number;
    }

    private Application createAsciiPaint() {
        return new Application(sizeBetweenRange("width", 0),
                sizeBetweenRange("height", 0));
    }

    private static Application defaultSizeOrNot() {
        System.out.println("Are you willing to create a"
                + " default size of the drawing?");

        if (defaultOrNot("Insert y for yes, n for no")) {
            return new Application();
        } else {
            return new Application(
                    sizeBetweenRange("Insert the width,"
                            + " it must be above 10", 10),
                    sizeBetweenRange("Insert the height,"
                            + " it must be above 10", 10));
        }
    }

    private static boolean defaultOrNot(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message);
        while (!kbd.hasNextLine()) {
            kbd.next();
            System.out.println(message);
        }
        return kbd.nextLine().charAt(0) == 'y';
    }

    private boolean checkParams(String[] command, int nbParam) {

        return true;
    }

    public void start() {
        String[] command;
        Scanner kbd = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Avaiable commands: move, add "
                    + "(circle, rectangle, square) and show");
            String input = kbd.nextLine();
            command = input.split(" ");
            switch (command[0]) {
                case "add":
                    if (command[1].toLowerCase() == "circle") {

                        this.ascii.newCircle(Integer.parseInt(command[2]),
                                Integer.parseInt(command[3]),
                                Integer.parseInt(command[4]),
                                command[5].charAt(0));
                    }
                    break;
                case "show":
                    System.out.printf(this.ascii.asAscii());
                    break;
                case "exit":
                    exit = true;
                    break;
                case "help":
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Application app = defaultSizeOrNot();
        app.start();
    }
}
