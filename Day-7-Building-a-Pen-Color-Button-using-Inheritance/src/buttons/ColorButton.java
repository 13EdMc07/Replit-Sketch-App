package buttons;

import tools.Color;
import tools.MouseInfo;
import tools.PaintingTool;

public class ColorButton extends SquareButton {
    private PaintingTool paint = new PaintingTool();
  
  //Must write our own constructor

   

  public ColorButton(int incomingX, int incomingY, int
  incomingSize, Color incomingColor) {
    super(incomingX, incomingY, incomingSize, incomingColor);
  }
  
  
    //Wrie a custom perfomActio
    @Override
    public void performAction(){
     paint.setLineColor(getColor());
    }  
}