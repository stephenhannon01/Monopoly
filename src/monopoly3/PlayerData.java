package monopoly3;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.*;

public class PlayerData {

  JTable playerStats;
  JScrollPane scrollPane;
  ArrayList<Client> playerData;
	
  public PlayerData() {
	
	playerData = new ArrayList<Client>(4); // Initialise storage structure for table contents
	for (int i = 0; i < playerData.size(); i++) {
	    // Add each corresponding client object stored elsewhere to ArrayList at position i
	}
	  
	Object columnNames[] = { "ID", "Username", "Money", "Properties", "Cards" }; // Define text for columns
        //playerStats = new JTable(playerData, columnNames); // Create JTable
    	//scrollPane = new JScrollPane(playerStats); // Create JScrollPane
	  
	/* // Create panel and add table to it
	playerDataPanel = new JPanel(new flowLayout());
	playerDataPanel.setOpaque(true);
	playerDataPanel.add(scrollPane); */
  }
  
  public void populateTable() {
	int rowNumber = 0;
	for (int i = 0; i < playerData.size(); i++) {
		// Get client ID at position i and add to first column
		// Get username at position i and add to second column
		// Get money at position i and add to third column
		// Get properties at position i owned and add to fourth column
		// Get GOOJ Card info at position i and add to fifth column
		rowNumber++; // Move to next row
	}
  }
} 
