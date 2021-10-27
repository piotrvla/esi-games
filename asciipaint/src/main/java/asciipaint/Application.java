package asciipaint;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author g56212
 */
public class Application {

    private AsciiPaint ascii;

    /**
     * Creates a new Application instance by initialazing it at the default
     * parameters, defined in drawing's class.
     */
    public Application() {
        this.ascii = new AsciiPaint();

    }

    /**
     * Creates new Application instance by initializing new AsciiPaint instance,
     * at given parameters.
     *
     * @param width width used to initialize new AsciiPaint
     * @param height height used to initialize new AsciiPaint
     */
    public Application(int width, int height) {
        this.ascii = new AsciiPaint(width, height);
    }

    /**
     * Reads an integer from the keyboard
     *
     * @param message Message to display.
     * @return an Integer.
     */
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

    public void blabla() {
    }

    /**
     * Returns only a number that's is bigger than minimal number given, as the
     * parameter
     *
     * @param message Message to display to the user.
     * @param min Minimal integer.
     * @return An integer.
     */
    private static int sizeBetweenRange(String message, int min) {

        int number = readNumber(message);
        while (number < min) {
            System.out.println("Inserted number isn't above " + min);
            number = readNumber(message);
        }
        return number;
    }

    /**
     * Creates new application class by it's default size or chosen one by the
     * user.
     *
     * @return new Application instance.
     */
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

    /**
     * Asks the user for the keyboard input if it's a 'y' it returns true if not
     * a false.
     *
     * @param message Message to print.
     * @return a Boolean if it's a 'y' it returns true if not a false.
     */
    private static boolean defaultOrNot(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message);
        while (!kbd.hasNextLine()) {
            kbd.next();
            System.out.println(message);
        }
        return kbd.nextLine().charAt(0) == 'y';
    }

    /**
     * Initializes a new shape given in the parameter, but at first all it's
     * values and types are verified if it is correct.
     *
     * @param command Command used to initialize a new shape.
     */
    private void initializeParams(String[] command) {

        switch (command[1].toLowerCase()) {
            case "circle":
                this.ascii.newCircle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
            case "rectangle":
                this.ascii.newRectangle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        Double.parseDouble(command[5]),
                        command[6].charAt(0));
                break;
            case "square":
                this.ascii.newSquare(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
            case "line":
                this.ascii.newLine(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Integer.parseInt(command[4]),
                        Integer.parseInt(command[5]),
                        command[6].charAt(0));
        }

    }

    /**
     * Verifies if the type of the parameters is correct, in this case the
     * algorithm verifies if the parameters are of the type numeric.
     *
     * @param command Command to verify.
     * @return Boolean
     */
    private boolean checkTypeOfParams(String[] command) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        if ((command.length == 6 && !"rectangle".equals(command[1]))
                || (command.length == 7 && "rectangle".equals(command[1]))) {

            for (int i = 2; i < command.length - 1; i++) {
                if (command[i] == null) {
                    return false;
                }
                if (!pattern.matcher(command[i]).matches()) {
                    return false;
                }
            }

        } else {
            return false;
        }
        return true;
    }

    /**
     * Displays given string.
     *
     * @param ascii string to display.
     */
    private void displayAscii(String ascii) {
        for (int i = 0; i < ascii.length(); i++) {
            System.out.printf("%2s", ascii.charAt(i));
        }
    }

    /**
     * Controls the whole algorithm and its behavior during its lifetime.
     *
     */
    public void start() {
        String[] command;
        Scanner kbd = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {

            System.out.println("Avaiable commands: add "
                    + "(circle, rectangle, square), show, and exit");

            String input = kbd.nextLine();
            command = input.split(" ");
            switch (command[0]) {
                case "add":
                    initializeParams(command);

                    break;

                case "show":

                    displayAscii(this.ascii.asAscii());

                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.err.println("Retry, the command looks like: "
                            + "add [shape] [x] [y] [radius/width/height] [color] ");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Application app = defaultSizeOrNot();
        app.start();
    }
}
