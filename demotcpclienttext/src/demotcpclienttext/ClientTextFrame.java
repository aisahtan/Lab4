package demotcpclienttext;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientTextFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerText;
	private JLabel lblStatusValue;
	private JLabel lblServerWord;

	
	// Private attributes for frame size
	private int width = 700;
	private int height = 200;


	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientTextFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblServerText = new JLabel("-");
		lblStatusValue = new JLabel("-");
		lblServerWord = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	public void updateServerText (String serverText) {
		
		this.lblServerText.setText(serverText);
		
	}
	
	public void updateServerWord (String serverWord) {
		this.lblServerWord.setText(serverWord);
	}
	
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
		
		
	}
	

	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
		
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
		
	}
	
	private JPanel getServerTextPanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblText = new JLabel ("Text: ");

		// Style the component
		lblText.setFont(font);
		lblServerText.setFont(font);
		lblText.setBackground(Color.WHITE);
		lblText.setOpaque(true);
		lblServerText.setBackground(Color.WHITE);
		lblServerText.setOpaque(true);

		// Organize components into panel
		panel.add(lblText);
		panel.add(lblServerText);
		
		return panel;
	} 
	
	private JPanel getServerWordPanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblWord = new JLabel ("Number of words: ");

		// Style the component
		lblWord.setFont(font);
		lblServerWord.setFont(font);
		lblWord.setBackground(Color.WHITE);
		lblWord.setOpaque(true);
		lblServerWord.setBackground(Color.WHITE);
		lblServerWord.setOpaque(true);

		// Organize components into panel
		panel.add(lblWord);
		panel.add(lblServerWord);
		
		return panel;
	} 
	
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getServerTextPanel(font);
		this.add(center, BorderLayout.CENTER);
		
		// Get server date's panel and add to frame
		JPanel southPanel = getServerWordPanel(font);
		this.add(southPanel, BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
	
	
	
	
	
}
