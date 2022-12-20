package buttons;

import tools.Color;
import tools.MouseInfo;
import tools.PaintingTool;

public class ClearButton extends SquareButton {
    private PaintingTool paint = new PaintingTool();
  
  //Must write our own constructor

   

  public ClearButton(int incomingX, int incomingY, int
  incomingSize, Color incomingColor) {
    super(incomingX, incomingY, incomingSize, incomingColor);
  }
  
  // Write custom drawself
  @Override
  public void drawSelf() {
    super.drawSelf(); // Run my parent's code!

    //Draw the red slash for the clear 
    paint.setLineColor(Color.RED);
    paint.drawLine(getLeftX(), getTopY(), getLeftX() + getSize(), getTopY() + getSize());
    paint.setLineColor(Color.BLACK);
    
  }
    //Wrie a custom perfomAction
    @Override
    public void performAction(){
     paint.setFillColor(Color.WHITE);
     paint.drawRect(30, 30, 540, 340);
    }  
}