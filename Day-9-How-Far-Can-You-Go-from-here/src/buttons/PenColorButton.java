package buttons;
import tools.Color;
import tools.PaintingTool;

// Building a class to represent a Button that can be used to change the pen color


public class PenColorButton extends SquareButton {
    private final PaintingTool paint = new PaintingTool();

    public PenColorButton(int incomingX, int incomingY, int incomingSize, Color incomingColor) {
        // Send the necessary information to our parent(super)'s constructor
        super(incomingX, incomingY, incomingSize, incomingColor);
    }

    @Override
    public void performAction() {
        // Update the line color of the painting tool
        paint.setLineColor(getColor());
    }
}
