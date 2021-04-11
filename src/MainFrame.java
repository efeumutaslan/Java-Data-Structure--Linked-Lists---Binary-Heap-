import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JPanel screen;
	private JTextArea display;
	private JScrollPane scrollP;
	private JPanel screenPanel;
	private JPanel inputPanel;
	private GridBagConstraints c;
	private JTextField inputBar;
	private JButton telByName;
	private JButton mailByName;
	private JButton priceByName;
	private JButton nameByTel;
	private JPanel lowerP;
	private JButton	addNew;
	private JButton calculator;
	private JButton show;
	private JButton showRev;
	private JButton stringRev;
	private JButton getSize;
	private JButton isEmpty;
	private CarsList list;
	private CalculatorPanel list2;
	
	
	public MainFrame() {
		this.list = new CarsList();
				
		frame = new JFrame();
		frame.setSize(800, 800);
		frame.setTitle("Gasonline - Rent a Car");
		frame.setBackground(new Color(33,33,33));
		
		screenPanel = new JPanel(new FlowLayout(15, 15, 15));
		screenPanel.setVisible(true);
		screenPanel.setPreferredSize(new Dimension(550, 600));
		screenPanel.setBackground(new Color(66,66,66));
		frame.getContentPane().add(screenPanel, BorderLayout.LINE_START);
		
		screen = new JPanel(new BorderLayout());
		screen.setSize(400, 400);
		screen.setPreferredSize(new Dimension(525,575));
		screen.setBackground(new Color(11, 15, 255));
		screen.setVisible(true);
		screen.setLayout(new BorderLayout());
		screenPanel.add(screen);
		
		display = new JTextArea("");
		display.setEditable(false);
		display.setLineWrap(false);
		display.setPreferredSize(new Dimension(525, 550));
		display.setBackground(new Color(255,255,255));
		display.setVisible(true);
		scrollP = new JScrollPane(display);
		screen.add(scrollP);
		
		inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setVisible(true);
		inputPanel.setPreferredSize(new Dimension(225,600));
		inputPanel.setBackground(new Color(222,228,49));
		frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20,10,20,10);
		
		inputBar = new JTextField("");
		inputBar.setEditable(true);
		inputBar.setVisible(true);
		inputBar.setPreferredSize(new Dimension(200, 25));
		inputPanel.add(inputBar, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 10, 5, 10);
		telByName = new JButton("Search Telephone Number by Name");
		telByName.setVisible(true);
		inputPanel.add(telByName, c);
		
		telByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = list.phoneNumberByName(inputBar.getText());
				inputBar.setText("");
				display.setText(input);
			}
		});
		
		
		c.gridy = 2;
		mailByName = new JButton("Search E-mail by Name");
		mailByName.setVisible(true);
		mailByName.setPreferredSize(new Dimension(200,25));
		inputPanel.add(mailByName, c);
		
		mailByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = list.emailByName(inputBar.getText());
				inputBar.setText("");
				display.setText(input);
				
			}	
		});
		
		c.gridy = 3;
		priceByName = new JButton("Search Price by Name");
		priceByName.setVisible(true);
		priceByName.setPreferredSize(new Dimension(200,25));
		inputPanel.add(priceByName, c);
		
		priceByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = list.priceByName(inputBar.getText());
				inputBar.setText("");
				display.setText(input);
				
			}
		});
		
		c.gridy = 4;
		nameByTel = new JButton("Search Name by Telephone Number");
		nameByTel.setVisible(true);
		nameByTel.setPreferredSize(new Dimension(200,25));
		inputPanel.add(nameByTel, c);
		
		nameByTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(list.nameByPhoneNumber(inputBar.getText()));
				inputBar.setText("");
			}
		});
		
		
		
		
		lowerP = new JPanel(new FlowLayout(10,10,10));
		lowerP.setVisible(true);
		lowerP.setPreferredSize(new Dimension(800, 100));
		lowerP.setBackground(new Color(33,33,33));
		frame.getContentPane().add(lowerP, BorderLayout.SOUTH);
		
		
		addNew = new JButton("Enter Customer Register");
		addNew.setVisible(true);
		addNew.setPreferredSize(new Dimension(200, 25));
		lowerP.add(addNew);
		
		calculator = new JButton("Calculator");
		calculator.setVisible(true);
		calculator.setPreferredSize(new Dimension(200, 25));
		lowerP.add(calculator);
		
		show = new JButton("Show Car Models List");
		show.setVisible(true);
		show.setPreferredSize(new Dimension(200 ,25));
		lowerP.add(show);
		
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = list.toString();
				display.setText(input);
			}
		});
		
		showRev = new JButton("Reverse List");
		showRev.setVisible(true);
		showRev.setPreferredSize(new Dimension(200, 25));
		lowerP.add(showRev);
		
		showRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = list.reverse();
			}
			
		});
		
		getSize = new JButton("Show Size");
		getSize.setVisible(true);
		showRev.setPreferredSize(new Dimension(200, 25));
		lowerP.add(getSize);
		
		getSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = "" + list.sizeOf();
				display.setText(input);
			}
			
		});
		
		
		isEmpty = new JButton("Show is Empty");
		isEmpty.setVisible(true);
		isEmpty.setPreferredSize(new Dimension(200, 25));
		lowerP.add(isEmpty);
		
		isEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = "" + list.isEmpty();
				display.setText(input);
			}
			
		});
		
		stringRev = new JButton("Show list in Reverse");
		stringRev.setVisible(true);
		stringRev.setPreferredSize(new Dimension(200, 25));
		lowerP.add(stringRev);
		

		stringRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = "" + list.reverseToString();
				display.setText(input);
			}
			
		});
		
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarsPanel panel = new CarsPanel(list);
			}
			
		});
		
		calculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorPanel calculatorP = new CalculatorPanel(list2);
			}
			
		});
	}
		public void run() {
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}