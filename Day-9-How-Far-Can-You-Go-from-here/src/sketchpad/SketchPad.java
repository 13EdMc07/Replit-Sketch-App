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

    // Declare and initialize an array of pen color buttons
    private PenColorButton[] penColorButtons = new PenColorButton[24];

    // Literal values
    private final int DESIRED_NUMBER_OF_CIRCLES = 500;
    private final int MARGIN = 50;
  
    public void initialLaunch() {

        //Display the background (color and the circles)
        //Display the interior sketch
        //Dispaly the buttons
        displayBackground();
        displayInteriorSketch();
        displayButtons();
    }
    public void displayBackground(){
        // The background color
        screen.setBackgroundColor(Color.CYAN);

        // Generate many random circles for a colorful background
        for (int circleNumber = 0; circleNumber < DESIRED_NUMBER_OF_CIRCLES; circleNumber++) {
            drawRandomCircle();
                  
        }
    }  
    public void displayInteriorSketch(){
        // The interior sketch surface
        paint.setFillColor(Color.WHITE);
        paint.drawRect(MARGIN,
                       MARGIN,
                       screen.getWidth() - 2  * MARGIN,
                       screen.getHeight() - 2  * MARGIN);
    }
        
    public void displayButtons(){
      // Ask the clear button to draw itself
        clearButton.drawSelf();

        // Determine where the first pen color button will appear
        int startX = 60;

        // Build the first pen color (black) button and place it in index 0, then ask it to draw itself
        penColorButtons[0] = new PenColorButton(startX, 5, 20, Color.BLACK);
        penColorButtons[0].drawSelf();

        // Using a loop, build each of the additional pen color buttons
        for (int i = 1; i < penColorButtons.length; i++) {
            // hues range from 0 to 1, we will use the current index value, i, to calculate a hue value
            float hue = 1f / penColorButtons.length * i;

            // build the pen color button, place it in the right index of the array, then ask it to draw itself
            startX += 20;
            penColorButtons[i] = new PenColorButton(startX, 5, 20, new Color(hue));
            penColorButtons[i].drawSelf();

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

        // Ask each pen color button in the array to update
        for (PenColorButton button : penColorButtons) {
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
