/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.controller;

import asciipaint.command.*;
import asciipaint.model.AsciiPaint;
import asciipaint.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controller {

    private AsciiPaint ascii;
    private final View view;
    private List<Commands> commands;

    public Controller() {
        this.commands = new ArrayList<>();
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
                    Add add = new Add(command, this.ascii);
                    add.execute();
                    this.commands.add(add);
                    break;
                case "delete":
                    Delete delete = new Delete(command, this.ascii);
                    delete.execute();
                    this.commands.add(delete);
                    break;
                case "group":
                    Group group = new Group(this.ascii, command);
                    group.execute();
                    this.commands.add(group);
                    break;
                case "ungroup":
                    Ungroup ungroup = new Ungroup(this.ascii, command);
                    ungroup.execute();
                    this.commands.add(ungroup);
                    break;
                case "move":
                    Move move = new Move(command, this.ascii);
                    move.execute();
                    this.commands.add(move);
                    break;
                case "list":
                    this.view.list(this.ascii.list());
                    break;
                case "show":
                    this.view.displayAscii(this.ascii.asAscii());
                    break;
                case "undo":
                    try {
                        Commands lastCommand = commands.get(commands.size() - 1);
                        lastCommand.undo();
                    } catch (Exception e) {
                        this.view.displayError("Nothing to undo");
                    }
                    break;
                case "redo":
                    try {
                        Commands lastCommand = commands.get(commands.size() - 1);
                        lastCommand.redo();
                    } catch (Exception e) {
                        this.view.displayError("Nothing to redo");
                    }

            }
        }
    }


}

