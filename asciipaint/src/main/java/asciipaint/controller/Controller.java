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

// @pbt javadoc is rare
// @pbt write in comments, this class is invoker in command pattern

/**
 * @author 56212
 */
public class Controller {

    private AsciiPaint ascii;
    private final View view;
    private List<Commands> commands;
    private List<Commands> undoCommands;

    public Controller() {
        this.commands = new ArrayList<>();
        this.undoCommands = new ArrayList<>();
        this.view = new View();
    }

    public void start() {
        this.ascii = this.view.defaultSizeOrNot();
        boolean exit = false;
        while (!exit) {

            System.out.println("Type help to get all the commands and theirs utility");
            String[] command = view.askCommand();

            switch (command[0].toLowerCase()) {
                case "add":
                    Add add = new Add(command, this.ascii);
                    add.execute();
                    this.commands.add(add);
                    break;
                case "delete":
                    try {
                        Delete delete = new Delete(command, this.ascii);
                        delete.execute();
                        this.commands.add(delete);
                    } catch (Exception e) {
                        this.view.displayError("No shape to delete");
                    }

                    break;
                case "group":
                    try {
                        Group group = new Group(this.ascii, command);
                        group.execute();
                        this.commands.add(group);
                    } catch (Exception e) {
                        this.view.displayError("Cannot group these shapes, they do not exist");
                    }

                    break;
                case "ungroup":
                    try {
                        Ungroup ungroup = new Ungroup(this.ascii, command);
                        ungroup.execute();
                        this.commands.add(ungroup);
                    } catch (Exception e) {
                        this.view.displayError("Component does not exist, cannot ungroup.");
                    }

                    break;
                case "move":
                    try {
                        Move move = new Move(command, this.ascii);
                        move.execute();
                        this.commands.add(move);
                    } catch (Exception e) {
                        this.view.displayError("Cannot move the component, it does not exist.");
                    }

                    break;
                case "list":
                    this.view.list(this.ascii.list());
                    break;
                case "show":
                    this.view.displayAscii(this.ascii.asAscii());
                    break;
                case "color":
                    try {
                        Color color = new Color(ascii, command);
                        color.execute();
                        this.commands.add(color);
                    } catch (Exception e) {
                        this.view.displayError("Cannot color the component, it does not exist");
                    }

                    break;
                case "undo":
                    try {
                        Commands lastCmd = commands.get(commands.size() - 1);
                        commands.remove(lastCmd);
                        undoCommands.add(lastCmd);
                        lastCmd.undo();
                    } catch (Exception e) {
                        this.view.displayError("Nothing to undo");
                    }
                    break;
                case "redo":
                    try {
                        Commands lastCmd = undoCommands.get(commands.size() - 1);
                        undoCommands.remove(lastCmd);
                        commands.add(lastCmd);
                        lastCmd.redo();
                    } catch (Exception e) {

                    }
                    break;
                case "help":
                    this.view.displayHelp();
                    break;

            }
        }
    }


}

