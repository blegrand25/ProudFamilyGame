
import java.awt.*;
public class Player {
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public Rectangle rec;
    public Image pic;

    //movement booleans
    public boolean right;
    public boolean down;
    public boolean left;
    public boolean up;



    public Player(int pXpos, int pYpos, int dxParameter, int dyParameter, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        width = 100;
        height = 100;
        dx = dxParameter;
        dy = dyParameter;
        pic = picParameter;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    } // constructor

    //move( ) method for a keyboard controlled character

    public void move(){
        xpos = xpos + dx;
        ypos = ypos + dy;
    }

    public void bounce(){
        if (left == true){
            dx = -5;
            dy=0;
        }

        if (right == true){
            dx = 5;
            dy=0;
        }

        if (down == true){
            dx = 0;
            dy=-5;
        }

        if (up == true){
            dx = 0;
            dy=5;
        }

        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >= 1000-width || xpos <=0){
            dx = -dx;
        }

        if (ypos >= 700-height || ypos <= 0){
            dy=-dy;
        }

        rec = new Rectangle (xpos, ypos, width, height);
    }
    public void move4() {

        if(right== true){
            xpos = xpos +dx;
            if(xpos>1000-width){
                xpos = 1000-width;
            }
        }

        if(up == true){
            ypos = ypos -dy;
            if(ypos<0-height){
                ypos = 700-height;
            }
        }

        if(down == true){
            ypos = ypos +dy;
            if(ypos>700-height){
                ypos = 700-height;
            }
        }

        if(left== true){
            xpos = xpos -dx;
            if(xpos<0-height){
                xpos = 1000-width;
            }
        }

        //always put this after you've done all the changing of the xpos and ypos values
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void move2(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (ypos < 250){
            dy = dy + 1;
        }

        if (ypos > 250){
            ypos = 250;
        }

    }

    public void move3(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (right == true){
            dx = 5;
        } else if (left == true){
            dx = -5;
        } else { //(right == false && left == false)
            dx = 0;
        } // if not thinking of one condition will move on to the next condition

        if (down == true){
            dy = 8;
        } else if (up == true){ // up always negative
            dy = -8;
        } else {//(down == false && up == false)
            dy = 0;
        }

        if (xpos < 0){ // left wall
            xpos = 0;
        }

        if (xpos > 1000 - width){ // right wall
            xpos = 1000 - width;
        }

        if (ypos < 0){ // up wall
            ypos = 0;
        }

        if (ypos > 700 - height){ // down wall
            ypos = 700 - height;
        }

        rec = new Rectangle (xpos, ypos, width, height);

    }

}
