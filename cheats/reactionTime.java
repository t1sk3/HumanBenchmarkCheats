import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.Color;

// (75, 219, 106) green
// (43, 135, 209) blue
// You still have to manually position the mouse on the blue/red/green surface
public class reactionTime {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Robot bot = null;
        Color green = new Color(75, 219, 106);
        Color blue = new Color(43, 135, 209);
        int counter = 0;
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        boolean clicked = false;
        try {
            bot = new Robot();
        
            while (counter != 5) {
                if (bot.getPixelColor((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY()).equals(green) && !clicked) {
                    bot.mousePress(mask);
                    bot.mouseRelease(mask);
                    clicked = true;
                    counter++;
                } else if (bot.getPixelColor((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY()).equals(blue)) {
                    bot.mousePress(mask);
                    bot.mouseRelease(mask);
                    clicked = false;
                }            
            }
        } catch (Exception failed) {
            System.err.println("Failed instantiating Robot: " + failed);
        }
    }
}


