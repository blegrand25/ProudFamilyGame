import java.awt.*;

public class SugaMama {
    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;
    public int dx;
    public int dy;
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    public int hits;
    public Rectangle rec;
    public Image pic;

    public SugaMama(int pXpos, int pYpos, int dxParameter, int dyParameter, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        width = 100;
        height = 100;
        dx = dxParameter;
        dy = dyParameter;
        pic = picParameter;
        isAlive = true;
        hits = 0;
        rec = new Rectangle(xpos, ypos, width, height);

    }
}
