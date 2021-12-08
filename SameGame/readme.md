# SameGame

## Description
SameGame is a game that consists on removing blocks of the same color. Minimal amount of blocks to delete is 2. 
The game have 2 different versions: 
- Terminal
- JavaFX

## How to play?
To play terminal version, the only option to run the game is to run main class which may be found in ControllerFX class.
It goes for the same to the javafx mode but the only difference, the game must be run by choosin javafx run option.



## Files:
```bash
│   pom.xml
│   readme.md
│
└───src
    ├───main
    │   └───java
    │       └───g56212
    │           └───samegame
    │               │   SameGame.java
    │               │
    │               ├───controller
    │               │       Controller.java
    │               │       ControllerFX.java
    │               │
    │               ├───model
    │               │       Block.java
    │               │       Board.java
    │               │       Colors.java
    │               │       Command.java
    │               │       CommandManager.java
    │               │       Game.java
    │               │       Observable.java
    │               │       Observer.java
    │               │       Position.java
    │               │       Remove.java
    │               │       Score.java
    │               │
    │               └───view
    │                       BlockFX.java
    │                       BoardFX.java
    │                       ButtonsFX.java
    │                       MainZoneFX.java
    │                       MenuFX.java
    │                       ScoreMenuFX.java
    │                       View.java
    │                       ViewFX.java
    │
    └───test
        └───java
            └───g56212
                └───samegame
                    └───model
                            BoardTest.java
```