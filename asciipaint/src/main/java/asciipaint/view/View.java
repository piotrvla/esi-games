package asciipaint.view;

import asciipaint.model.AsciiPaint;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author g56212
 */
public class View {

    private static final Scanner keyboard = new Scanner(System.in);

    public View() {

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

    public AsciiPaint defaultSizeOrNot() {
        System.out.println("Are you willing to create a"
                + " default size of the drawing?");

        if (defaultOrNot("Insert y for yes, n for no")) {
            return new AsciiPaint();
        } else {
            return new AsciiPaint(
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
     * Displays given string.
     *
     * @param ascii string to display.
     */
    public void displayAscii(String ascii) {
        for (int i = 0; i < ascii.length(); i++) {
            System.out.printf("%2s", ascii.charAt(i));
        }
    }

    public String[] askCommand() {
        String input = keyboard.nextLine();
        String[] command = input.split(" ");

        return command;
    }
    public void displayError(String message){
        System.err.println(message);
    }

}
