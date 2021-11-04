package asciipaint.view;

import asciipaint.model.AsciiPaint;
import asciipaint.util.Component;

import java.util.List;
import java.util.Scanner;


/**
 * View of AsciiPaint
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
     * @param min     Minimal integer.
     * @return An integer.
     */
    private static int sizeBetweenRange(String message, int min, int max) {

        int number = readNumber(message);
        while (number < min || number > max) {
            System.out.println("Inserted number isn't between " + min + " and " + max);
            number = readNumber(message);
        }
        return number;
    }

    /**
     * Asks the user if he wants a standard size of the drawing board or not
     *
     * @return AsciiPaint instance with the user's chosen size.
     */
    public AsciiPaint defaultSizeOrNot() {
        System.out.println("Are you willing to create a"
                + " default size of the drawing?");

        if (defaultOrNot("Insert y for yes, n for no")) {
            return new AsciiPaint();
        } else {
            return new AsciiPaint(
                    sizeBetweenRange("Insert the width,"
                            + " it must be between 10 and 999", 10, 999),
                    sizeBetweenRange("Insert the height,"
                            + " it must be between 10 and 999", 10, 999));
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

    /**
     * Asks the user to insert a command, then it's verified if it respects the written pattern of the commands.
     *
     * @return Command with no error in it.
     */
    public String[] askCommand() {


        String color = "([a-zA-Z])";
        String nbParam = "\\d{1,3}";
        String twoParam = "(\\d{1,3}\\s){2}" + color;
        String fourParam = "(\\d{1,3}\\s){3}" + color;
        String fiveParam = "(\\d{1,3}\\s){4}" + color;
        String negNbParam = "[-+]?" + nbParam;


        String pattern = "(add (circle|square) " + fourParam + ")" +
                "|(add (rectangle|line) " + fiveParam + ")" +
                "|(show)" +
                "|(move " + nbParam + " " + negNbParam + ")" +
                "|(list)" +
                "|(exit)" +
                "|(group " + twoParam + ")" +
                "|(ungroup " + nbParam + ")" +
                "|(undo)" +
                "|(redo)" +
                "|(color " + nbParam + " " + color + ")" +
                "|(help)" +
                "|(delete) " + nbParam;
        ;


        keyboard.useDelimiter("\n");
        while (!keyboard.hasNext(pattern)) {
            displayError("Error! Your command " + keyboard.next() + " doesn't seem right , type help for some info!");
        }

        return keyboard.next().split(" ");
    }

    /**
     * Displays the given error.
     *
     * @param message error to print.
     */
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Displays every command available, also it's brief description of it's functionality
     */
    public void displayHelp() {
        System.out.println("________________________________________________________________________");
        System.out.println("Add allows to create a component and add it to the drawing.");
        System.out.println("Add: add circle <x> <y> <radius> <color>");
        System.out.println("Add: add square <x> <y> <size> <color>");
        System.out.println("Add: add line <x> <y> <x> y> <color>");
        System.out.println("Add: add rectangle <x> <y> <width> <height> <color>");
        System.out.println("________________________________________________________________________");
        System.out.println("Group and ungroup allows to ungroup and group the component by theirs id shown using " +
                "list command");
        System.out.println("Group: group <shape one> <shape two>");
        System.out.println("Ungroup: ungroup <component to ungroup>");
        System.out.println("________________________________________________________________________");
        System.out.println("Show and list, list displays the list of every added component, show displays the drawing");
        System.out.println("List: list");
        System.out.println("Show: show");
        System.out.println("________________________________________________________________________");
        System.out.println("Colors up the component by theirs id and given color");
        System.out.println("Color: color <shape to color> <color>");
        System.out.println("________________________________________________________________________");
        System.out.println("exit: stops the program");

    }

    /**
     * Prints every shape available.
     *
     * @param shapes shapes to print.
     */
    public void list(List<Component> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i) + ") " + shapes.get(i).getName());
        }

    }
}
