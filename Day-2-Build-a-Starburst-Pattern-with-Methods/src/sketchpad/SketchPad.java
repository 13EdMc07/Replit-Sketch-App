package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    public void initialLaunch() {
        // The background color
        screen.setBackgroundColor(Color.CYAN);

        // The corners - feel free to remove these!
        paint.setFillColor(Color.RED);
        paint.drawCircle(0, 0, 20);

        paint.setFillColor(Color.GREEN);
        paint.drawCircle(0, 400, 20);

        paint.setFillColor(Color.BLUE);
        paint.drawCircle(600, 0, 20);

        paint.setFillColor(Color.MAGENTA);
        paint.drawCircle(600, 400, 20);

        // The interior sketch surface
        paint.setFillColor(Color.WHITE);
        paint.drawRect(30, 30, 540, 340);
      
    }

    public void update() {
        paint.setLineColor(Generator.randomInt(256),
                           Generator.randomInt(256),
                           Generator.randomInt(256));
        paint.drawLine(screen.getWidth() / 2,
                       screen.getHeight() / 2,
                       mouseInfo.getX(),
                       mouseInfo.getY());
    }
}
