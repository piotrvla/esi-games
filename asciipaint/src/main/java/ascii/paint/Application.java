package ascii.paint;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author g56212
 */
public class Application {

    private AsciiPaint ascii;

    /**
     *
     */
    public Application() {
        this.ascii = new AsciiPaint();

    }

    /**
     *
     * @param width
     * @param height
     */
    public Application(int width, int height) {
        this.ascii = new AsciiPaint(width, height);
    }

    /**
     *
     * @param message
     * @return
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

    /**
     *
     * @param message
     * @param min
     * @param max
     * @return
     */
    private static int sizeBetweenRange(String message, int min, int max) {

        int number = readNumber(message);
        while (number < min || (max < number && max != 0)) {
            System.out.println("Inserted number isn't above " + min);
            number = readNumber(message);
        }
        return number;
    }

    /**
     *
     * @return
     */
    private static Application defaultSizeOrNot() {
        System.out.println("Are you willing to create a"
                + " default size of the drawing?");

        if (defaultOrNot("Insert y for yes, n for no")) {
            return new Application();
        } else {
            return new Application(
                    sizeBetweenRange("Insert the width,"
                            + " it must be above 10", 10, 0),
                    sizeBetweenRange("Insert the height,"
                            + " it must be above 10", 10, 0));
        }
    }

    /**
     *
     * @param message
     * @return
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
     *
     * @param command
     */
    private void initializeParams(String[] command) {
        if (checkTypeOfParams(command) && checkValueOfParams(command)) {
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
            }
        } else {
            System.err.println("Retry, the command looks like: "
                    + "add [shape] [x] [y] [radius/width/height] [color] ");
        }

    }

    /**
     *
     * @param command
     * @return
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

    private boolean checkValueOfParams(String[] command) {
        int width;
        int height;
        if (command.length == 6) {
            width = Integer.parseInt(command[4]);
            height = Integer.parseInt(command[4]);
        } else if (command.length == 7) {
            width = Integer.parseInt(command[4]);
            height = Integer.parseInt(command[5]);
        } else {
            return false;
        }
        if (Integer.parseInt(command[2]) >= this.ascii.getWidth()
                || Integer.parseInt(command[2]) + width
                >= this.ascii.getWidth()) {
            return false;
        }
        if (Integer.parseInt(command[3]) > this.ascii.getHeight()
                || Integer.parseInt(command[3]) + height
                >= this.ascii.getWidth()) {
            return false;
        }
        return true;
    }

    /**
     *
     */
    public void start() {
        String[] command;
        Scanner kbd = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Avaiable commands: add "
                    + "(circle, rectangle, square), show, help and exit");
            String input = kbd.nextLine();
            command = input.split(" ");
            switch (command[0].toLowerCase()) {
                case "add":
                    initializeParams(command);
                    break;
                case "show":
                    String ascii = this.ascii.asAscii();
                    for (int i = 0; i < ascii.length(); i++) {
                        System.out.printf("%2s", ascii.charAt(i));
                    }
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.err.println("Wrongly implemented command,"
                            + " use command help");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Application app = defaultSizeOrNot();
        app.start();
    }
}
