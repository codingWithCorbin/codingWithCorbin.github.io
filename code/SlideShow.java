import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		
		// Updated the background color to white to help readability for users.
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			// Uploaded and updated the picture to a hot spring in Japan. Source: OKJaguar.(2018, June 13). [Mizunashi-Kaihin Onsen][Photograph].Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Mizunashi_Kaihin_onsen_(hot_spring_bath),_Hakodate,_Japan.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/JapanSlideShow.jpg") + "'</body></html>";
		} else if (i==2){
			// Uploaded and updated the picture to a beach house in Hawaii. Source: Makeev, D. (2014, June 28). [Beach House][Photograph].Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Sihanoukville_-_Hawaii_beach,_beach_house.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/HawaiiSlideShow.jpg") + "'</body></html>";
		} else if (i==3){
			// Uploaded and updated the picture to a personal pod in Iceland. Source: Alidrunela12. (2023, Nov. 18).[Glamping Dome][Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Aurora-Igloo-Iceland.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/IcelandSlideShow.jpg") + "'</body></html>";
		} else if (i==4){
			// Uploaded and updated the picture to someone getting a massage in Thailand. Source: Tara Angkor Hotel.(2011, July 9). [Massage][Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Classical_Thai_Massage_at_Tara_Angkor_Hotel_(5918685202).jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ThailandSlideShow.jpg") + "'</body></html>";
		} else if (i==5){
			// Uploaded and updated the picture to a mountain resort in Switzerland. Source: Krapf,H. (2012, Aug, 17). [Switzerland][Photograph]. Wikimeida Commons. https://commons.wikimedia.org/wiki/File:2012-08-17_14-27-06_Switzerland_Canton_du_Valais_Blatten.JPG
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/SwitzerlandSlideShow.jpg") + "'</body></html>";
		}
			// Additional resource: Murphy, J. (2024, Feb. 14). The 14 Best Wellness Retreats in the World for Active Travelers. Outside. https://www.outsideonline.com/adventure-travel/advice/best-wellness-retreats-world/
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			
			// Updated location one and description for Japan.
			text = "<html><body><font size='5'>#1 Japan </font> <br> Rejuvenate in the plentiful natural hotsprings. </body></html>";
		} else if (i==2){
			// Updated location two and description for Hawaii. Added HTML modifications to have matching font and boldness.
			text = "<html><body><font size='5'>#2 Hawaii </font> <br> Wake up to beautiful sunrises, sleep to the sound of the ocean, and relax at your own beach house. </body></html>";
		} else if (i==3){
			// Updated location three and description for Iceland. Added HTML modifications to have matching font and boldness.
			text = "<html><body><font size='5'>#3 Iceland </font> <br> Quiet and secluded options to experience Northern Lights and get away from busy life. </body></html>";
		} else if (i==4){
			// Updated location four and description for Thailand. Added HTML modifications to have matching font and boldness.
			text = "<html><body><font size='5'>#4 Thailand </font> <br> Renew with yoga, massages, and a natural refresh for your diet. </body></html>";
		} else if (i==5){
			// Updated location five and description for Switzerland. Added HTML modifications to have matching font and boldness.
			text = "<html><body><font size='5'>#5 Switzerland </font> <br> A breath of fresh air in the mountain resorts with indoor and outdoor treatment options to enhance your experience. </body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}