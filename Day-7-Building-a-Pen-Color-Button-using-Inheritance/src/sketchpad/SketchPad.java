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
    private ClearButton clearButton = new ClearButton(5, 5, 20,       Color.WHITE);

     private ColorButton colorButton1 = new ColorButton(30, 5, 20,       Color.BLACK);
    private ColorButton colorButton2 = new ColorButton(50, 5, 20,       Color.RED);
    private ColorButton colorButton3 = new ColorButton(70, 5, 20,       Color.BLUE);

  
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

        // Ask the clear button to draw itself
        clearButton.drawSelf();
        colorButton1.drawSelf();
        colorButton2.drawSelf();
        colorButton3.drawSelf();
          
    }
  
    public void update() {
      
        /* Setting the pen color to a random number---- deleted in order to add code to have control of line color
        paint.setLineColor(
               Generator.randomInt(256),
               Generator.randomInt(256),
               Generator.randomInt(256)
        );*/
        
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
        colorButton1.update();
        colorButton2.update();
        colorButton3.update();
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
