import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ProudFamilyWorld implements Runnable, KeyListener, MouseListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;
    public boolean gameStart = false;
    public Image pennyPic;
    public Image papiPic;
    public Image sugamamaPic;
    public Image sistersPic;
    public Image proudhousePic;

    public Player penny;
    public Player papi;

    public Player sugaMama;

    public Player grossSisters;
    public ProudHouse proudHouse;
    public Player user;
    public boolean isCrashing;



    public static void main(String[] args) {// psvm for shortcut
        ProudFamilyWorld myApp = new ProudFamilyWorld();
        new Thread(myApp).start();

    }

    public ProudFamilyWorld() {

        setUpGraphics();
        canvas.addKeyListener(this);
        canvas.addMouseListener(this);

        pennyPic = Toolkit.getDefaultToolkit().getImage("penny!.png");
        sugamamaPic = Toolkit.getDefaultToolkit().getImage("sugamama.png");
        papiPic = Toolkit.getDefaultToolkit().getImage("papi.png");
        sistersPic = Toolkit.getDefaultToolkit().getImage("grosssisters.png");
        proudhousePic = Toolkit.getDefaultToolkit().getImage("proudhouse.jpeg");


        penny = new Player(400, 400, 5, 6, pennyPic);
        sugaMama = new Player(200, 400, 5, 6, sugamamaPic);
        papi = new Player(300, 400, 2, 3, papiPic);
        grossSisters = new Player(500, 600, 7, 4, sistersPic);


    }

    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (gameStart == false) {
            g.setColor(Color.PINK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.drawString("Press space to start", 450, 350);
        } else {
            System.out.println("game rendered");
            g.drawImage(proudhousePic, 0, 0, WIDTH, HEIGHT, null);
            g.drawImage(penny.pic, penny.xpos, penny.ypos, penny.width, penny.height, null);
            g.drawImage(papi.pic, penny.xpos, penny.ypos, penny.width, penny.height, null);
            g.drawImage(sugaMama.pic, sugaMama.xpos, sugaMama.ypos, sugaMama.width, sugaMama.height, null);
            g.drawImage(grossSisters.pic, grossSisters.xpos, grossSisters.ypos, grossSisters.width, grossSisters.height, null);
        }


        g.dispose();
        bufferStrategy.show();
    }

    public void moveThings() {
        penny.bounce();
        sugaMama.bounce();
        papi.bounce();
        grossSisters.bounce();

    }

    public void defense(){
        if (penny.rec.intersects(grossSisters.rec) ){
            penny.dx = -penny.dx;
            System.out.println("Please don't take my money!!");
        }
    }

    public void HELLO(){
        if (sugaMama.rec.intersects(papi.rec)){
            papi.dy = -papi.dy;
            System.out.println("¡Adiós mujer fea y perro asqueroso! hehehe");
        }
    }


    public void run() {
        while (true) {
            if (gameStart == true) {
                moveThings();
                checkIntersections();
            }
            render();
            pause(20);
        }
    }

    public void checkIntersections() {

        // insert code here later on
    }

    public void setUpGraphics() {
        frame = new JFrame("CheeseWorld");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }


    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

        if (keyCode == 32) {

            gameStart = true;
            System.out.println("gamestart: " + gameStart);
        }

        if (keyCode == 68) { // d
            user.right = true;
        }
        if (keyCode == 87) { //w
            user.up = true;
        }
        if (keyCode == 83) { //s
            user.down = true;
        }
        if (keyCode == 65) { //a
            user.left = true;
        }

        if (keyCode == 32) { // space
            user.dy = -5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();     //gets the character of the key pressed
        int keyCode = e.getKeyCode();  //gets the keyCode (an integer) of the key pressed

        if (keyCode == 32) {
            gameStart = true;
        }
        if (keyCode == 68) { // d
            user.right = true;
        }
        if (keyCode == 87) { //w
            user.up = true;
        }
        if (keyCode == 83) { //s
            user.down = true;
        }
        if (keyCode == 65) { //a
            user.left = true;
        }

        if (keyCode == 32) { // space
            user.dy = -5;
        }
    }




    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
