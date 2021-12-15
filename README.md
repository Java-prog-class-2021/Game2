# Game2
Ryanna, Rami, Ziad

Skeleton for an Android game written in Java. To import this in Android Studio:

File -> New -> Project from Version Control -> GitHub -> Select the repository and clone it. Everything should work.
Java files are in app/java/com.group2.androidgame. There are 3 classes so far:
- GameView:       This class implements SurfaceView, which creates a drawing surface
- MainActivity:   The main class, is referenced in activity_main.xml.
- MainThread:     Extends Thread class, makes sure that drawing is done smoothly and uninterrupted
