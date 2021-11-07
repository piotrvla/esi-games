# ASCII PAINT

## Description:

Ascii paint consists on drawing differents shapes on the drawing.
In this version of Ascii Paint software, you are able to add different shapes(circle, line, rectangle, square),
moving different components (groups, shapes), also you can group up every single component, ungroup, color and delete. 

## Files:

```bash
│   asciipaint.iml
│   nbactions.xml
│   pom.xml
│   readme.md
├───src
   ├───main
   └───java
       └───asciipaint
           │   Main.java
           │
           ├───command
           │       Add.java
           │       Color.java
           │       Commands.java
           │       Delete.java
           │       Group.java
           │       Move.java
           │       Ungroup.java
           │
           ├───controller
           │       Controller.java
           │
           ├───model
           │       AsciiPaint.java
           │       Circle.java
           │       ColoredShape.java
           │       Drawing.java
           │       Line.java
           │       Point.java
           │       Rectangle.java
           │       Shape.java
           │       Square.java
           │
           ├───util
           │       Component.java
           │       Composite.java
           │
           └───view
                   View.java
```
