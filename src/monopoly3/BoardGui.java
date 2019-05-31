/**
 * Created by dgc1
 * @author Denise Grace Crowley
 * @version 1.0
 *
 */
package monopoly3;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import monopoly3.Buttons;
import javax.imageio.ImageIO;


/**
 * The board class is used to display the monopoly board image, as well as draw the player
 */
class BoardGui extends JPanel implements ActionListener {

    //Timer for the game loop
    Timer t;
    //Instance of the player, needs to be static so it can be seen from the Buttons class
    static Player p;
    //Image of the player
    BufferedImage img;
    //List of locations where the player can move
    static ArrayList<Points> array = new ArrayList<Points>();
    static Client client;
    //BufferedImage[]playerImages;
    private int numOfPlayers;
    static Player[] players;
    static int id;
	Points points;
	
	/**
	* Updates the players position on the board
	*/
	public void updatePlayerPositions(int[] arrayPlayerPosition){
		for(int i=0;i< arrayPlayerPosition.length;i++){
			points = new Points(array.get(arrayPlayerPosition[i]).getX(), array.get(arrayPlayerPosition[i]).getY());
			players[i].move(points);
		}
		repaint();
	}

    /**
     * The Board Constructor, the board image is loaded and added to be displayed on the JPanel
     */
    public BoardGui(int numOfPlayers) { //num of players
        //Initiliazing the variables
        this.numOfPlayers=numOfPlayers;
        t = new Timer(10, this);
        t.start();
        setFocusable(true);    
        try{            
        img = ImageIO.read(new File("monopoly3/monopoly.jpg"));
          
        }
        catch (IOException ex){            
            System.out.println("Error");
        }
      
        boardPositions();
		players = new Player[numOfPlayers];
		for(int counter=0;counter<numOfPlayers;counter++){
			players[counter]=new Player(array.get(0)); //created array of players
		}
        t.start();
        
    }      
    /**
     * Possible positions on board are added to an ArrayList
     */
     
	/**
	*A method that sets the client id and return there player sprite based on their id
	*/
     public void setClientId(int id){
		this.id=id;
		for(int counter=0;counter<numOfPlayers;counter++){
			try{
				BufferedImage playerImage =  ImageIO.read(new File("monopoly3/player" + counter+".png"));
				players[counter].setPlayer(playerImage);
			}catch(Exception e){
				System.out.println(e);
			}
		}
     }
     
     
    //Populating the array with possible board positions
    public void boardPositions(){
        Points p;
        int x = 785;
        int y = 750;
        for(int i = 0; i < 40; i++)
        {
            if(i == 0){
                x = 785;
            }
            else if(i < 10){
                x -= 72;
            }
            else if(i == 10) {
                x = 10;
                y = 710;
            }
            else if(i > 10 && i < 20){
                x = 10;
                y -= 66;
            }
            else if(i == 20){
                x = 69;
                y = 10;
            }
            else if(i > 20 && i <30){
                x += 72;
                y = 10;
            }
            else if(i == 30){
                x = 785;
                y = 55;
            }
            else{
                x = 785;
                y += 66;
            }
            p = new Points(x,y);
            array.add(p);
        }
    }
    
    public void actionPerformed(ActionEvent e) {        
        repaint();
    }
    /**
     * The paintComponent method is responsible for drawing of both the player and the board on screen
     * @param g 
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, 900, 800, this);
      
		for(int counter = 0;counter<numOfPlayers;counter++){
			players[counter].draw(g);
		}
     
        repaint();
    }
    
}
