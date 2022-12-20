package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    // Declaring variables to represent the last location of the mouse
    private int lastMouseX;
    private int lastMouseY;

    // Declaring and initialize a variable for the clear button
    private ClearButton clearButton = new ClearButton(5, 5, 20, Color.WHITE);

    // Declare and initialize a array of penColorButtons
    private PenColorButton[] colorButtons = new PenColorButton[24];
   
    
    public void initialLaunch() {
        // The background color
        screen.setBackgroundColor(Color.CYAN);

        // Generate many random circles for a colorful backdground
        for (int circleNumber = 0; circleNumber < 500; circleNumber++) {
            drawRandomCircle();
        }

        // The interior sketch surface
        paint.setFillColor(Color.WHITE);
        paint.drawRect(30, 30, 540, 340);

        // Ask the clear button to be draw itself
        clearButton.drawSelf();

        // Ask the pen color buttons to be built and draw themselves
        
      int startX = 60;
      colorButtons[0] = new PenColorButton(startX, 5, 20, Color.BLACK);
      colorButtons[0].drawSelf();
      startX += 20;

      
      for (int i = 1; i < colorButtons.length; i++) {
          
        // Build a PenColorButton
        // hues go from o to 1

        
        
        float hue = 1.0f / colorButtons.length * i;
                    
          colorButtons[i] = new PenColorButton(startX, 5, 20, new Color (hue));
          startX += 20;
          colorButtons[i].drawSelf();
        }
    }

    public void update() {
       
        // If the mouse was just clicked, update the last mouse location data
        if (mouseInfo.isMousePressed()) {
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

        // Only draw lines if the mouse was dragged and inside the interior sketch surface
        if (mouseInfo.isMouseDragged() &&
            mouseInfo.getX() >= 30 &&
            mouseInfo.getX() <= 570 &&
            mouseInfo.getY() >= 30 &&
            mouseInfo.getY() <= 370) {

            paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

        // Ask the clearButton to run its update method
        clearButton.update();

        // Ask the pen color buttons run their update method
        // loop through each pen color button
        // ask them to update
        // for (int i =0; i < colorButtons.length; i++) {
        //   colorButtons[i].update();
        // }
        
        // for-each
        for (PenColorButton button : colorButtons){
          button.update();
        }

      
    }
    
    public void drawRandomCircle() {
        int x = Generator.randomInt(600);
        int y = Generator.randomInt(400);
        int radius = Generator.randomInt(10, 30);
        int r = Generator.randomInt(255);
        int g = Generator.randomInt(255);
        int b = Generator.randomInt(255);
        paint.setFillColor(r, g, b);
        paint.drawCircle(x, y, radius);
    }
}
 