package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    public void initialLaunch() {
      // What code will run when the program laumches?
      screen.setBackgroundColor(Color.RED);
      
     

      // Draw one circle on each of the four corners
      paint.setFillColor(Color.MAGENTA);
      paint.drawCircle(0, 0, 20);
      
      paint.setFillColor(Color.YELLOW);
      paint.drawCircle(600, 0, 20);
      
      paint.setFillColor(Color.BLUE);
      paint.drawCircle(0, 400, 20);
      
      paint.setFillColor(Color.NAVY);
      paint.drawCircle(600, 400, 20);

      //Want to draw a white rectangle
      paint.setFillColor(Color.WHITE);
      paint.drawRect(30, 30, 540, 340);


      
    }

    public void update() {

    }
}
