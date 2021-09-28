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

    private void initializeParams(String[] command) {
        if (checkParams(command)) {
            switch (command[1]) {
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
                    + "add [shape] [x] [y] [radius/width/height] [color] "
                    + "For more info type help (command).");
        }

    }

    private boolean checkParams(String[] command) {
        for (int i = 2; i < command.length - 1; i++) {
            if (command[i] == null) {
                return false;
            }
            try {
                int d = Integer.parseInt(command[i]);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    private void displayHelp(String[] command) {
   
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
                    initializeParams(command);
                    break;
                case "show":
                    System.out.printf(this.ascii.asAscii());
                    break;
                case "exit":
                    exit = true;
                    break;
                case "help":
                    displayHelp(command);
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
