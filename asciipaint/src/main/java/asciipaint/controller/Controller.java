/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.controller;

import asciipaint.model.AsciiPaint;
import asciipaint.view.View;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controller {

    private AsciiPaint ascii;
    private final View view;

    public Controller() {

        this.view = new View();
    }

    public void start() {
        this.ascii = this.view.defaultSizeOrNot();
        boolean exit = false;
        while (!exit) {

            System.out.println("Avaiable commands: add "
                    + "(circle, rectangle, square), show, and exit");
            String[] command = view.askCommand();
            switch (command[0].toLowerCase()) {
                case "add":
                    switchAddShape(command);
                    break;
                case "show":
                    this.view.displayAscii(ascii.asAscii());
                    break;

                case "list":
                    this.ascii.list();
                    break;
                case "move":
                    this.ascii.move(Integer.parseInt(command[1]),
                            Integer.parseInt(command[2]),
                            Integer.parseInt(command[3]));
                    break;
                case "group":
                    this.ascii.group(Integer.parseInt(command[1]),
                            Integer.parseInt(command[2]),
                            command[3],
                            command[4].charAt(0));
                    break;
                case "ungroup":
                    try {
                } catch (Exception e) {
                    view.displayError("This component isn't a group!");
                }
                this.ascii.ungroup(Integer.parseInt(command[1]));
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

    private void switchAddShape(String[] command) {
        switch (command[1].toLowerCase()) {
            case "circle":
                try {
                this.ascii.newCircle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
            } catch (Exception ex) {
                this.view.displayError("One of the parameters is out of bonds");
            }

            break;
            case "rectangle":
                try {
                this.ascii.newRectangle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        Double.parseDouble(command[5]),
                        command[6].charAt(0));
            } catch (Exception ex) {
                this.view.displayError("One of the parameters is out of bonds");
            }
            break;
            case "square":
                try {
                this.ascii.newSquare(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
            } catch (Exception ex) {
                this.view.displayError("One of the parameters is out of bonds");
            }
            break;
            case "line":
                try {
                this.ascii.newLine(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Integer.parseInt(command[4]),
                        Integer.parseInt(command[5]),
                        command[6].charAt(0));
            } catch (Exception ex) {
                this.view.displayError("One of the parameters is out of bonds");
            }

        }
    }
}
