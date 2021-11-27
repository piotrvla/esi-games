package g56212.samegame.controller;

import g56212.samegame.model.Command;
import g56212.samegame.model.Remove;
import g56212.samegame.model.SameGame;
import g56212.samegame.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    
    private final SameGame samegame;
    private final View view;
    private List<Command> commands;
    private List<Command> undoCommands;
    
    public Controller() {
        this.samegame = new SameGame();
        this.view = new View(this.samegame);
        this.samegame.startGame(view.askSize(), view.askDifficulty());
        this.commands = new ArrayList<>();
        this.undoCommands = new ArrayList<>();
    }
    
    void run() {
        while (!this.samegame.isGameOver()) {
            this.view.displayGame();
            String[] command = this.view.askCommand();
            switch (command[0]) {
                case "remove":
                    try {
                    Remove remove = new Remove(samegame,
                            Integer.parseInt(command[1]) - 1,
                            Integer.parseInt(command[2]) - 1);
                    remove.execute();
                    this.commands.add(remove);
                    this.samegame.refactorBoard();
                } catch (IllegalArgumentException ex) {
                    view.displayError("Cannot remove at this position.");
                }                
                break;
                
                case "redo":
                    try {
                    Command lastCmd = undoCommands.get(undoCommands.size() - 1);
                    undoCommands.remove(lastCmd);
                    commands.add(lastCmd);
                    lastCmd.execute();
                } catch (Exception ex) {
                    view.displayError("Nothing to undo");
                }
                
                break;
                case "undo":
                    try {
                    Command lastCm = commands.get(commands.size() - 1);
                    commands.remove(lastCm);
                    undoCommands.add(lastCm);
                    lastCm.undo();
                } catch (Exception ex) {
                    view.displayError("Nothing to undo.");
                }
                
                break;
            }
          
        }
        this.view.displayFinalScore();
    }
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
