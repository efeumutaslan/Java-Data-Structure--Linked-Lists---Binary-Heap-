import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarsPanel {

	private JFrame frame;
	private JPanel inputPanel;
	private GridBagConstraints c;
	private JLabel nameL;
	private JTextField name;
	private JLabel telL;
	private JTextField tel;
	private JLabel emailL;
	private JTextField email;
	private JLabel modelCarL;
	private JTextField modelCar;
	private JLabel priceL;
	private JTextField price;
	private JPanel buttP;
	private JButton addFront;
	private JButton addRear;
	private JButton cancel;
	private CarsList list;



	public CarsPanel(CarsList newList) {
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setTitle("New Customer Page");
		frame.setVisible(true);
		
		this.list = newList;
		
		inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setVisible(true);
		inputPanel.setBackground(new Color(222,228,49));
		inputPanel.setPreferredSize(new Dimension(500,400));
		frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20,20,20,20);
		
		nameL = new JLabel("Name: ");
		nameL.setVisible(true);
		inputPanel.add(nameL, c);
		
		c.gridx = 1;
		name = new JTextField("");
		name.setEditable(true);
		name.setPreferredSize(new Dimension(200 , 25));
		inputPanel.add(name, c);
		
		c.gridx = 0;
		c.gridy = 1;
		telL = new JLabel("Telephone Number: ");
		telL.setVisible(true);
		inputPanel.add(telL, c);
		
		c.gridx = 1;
		tel = new JTextField("");
		tel.setEditable(true);
		tel.setVisible(true);
		tel.setPreferredSize(new Dimension(200 ,25));
		inputPanel.add(tel, c);
		
		c.gridx = 0;
		c.gridy = 2;
		emailL = new JLabel("Email Adress: ");
		emailL.setVisible(true);
		inputPanel.add(emailL, c);
		
		c.gridx = 1;
		email = new JTextField("");
		email.setEditable(true);
		email.setVisible(true);
		email.setPreferredSize(new Dimension(200 ,25));
		inputPanel.add(email, c);
		
		c.gridx = 0;
		c.gridy = 3;
		modelCarL = new JLabel("ModelCar: ");
		modelCarL.setVisible(true);
		inputPanel.add(modelCarL, c);
		
		c.gridx = 1;
		modelCar = new JTextField("");
		modelCar.setEditable(true);
		modelCar.setVisible(true);
		modelCar.setPreferredSize(new Dimension(200 ,25));
		inputPanel.add(modelCar, c);
		
		c.gridx = 0;
		c.gridy = 4;
		priceL = new JLabel("Price: ");
		priceL.setVisible(true);
		inputPanel.add(priceL, c);
		
		c.gridx = 1;
		price = new JTextField("");
		price.setEditable(true);
		price.setVisible(true);
		price.setPreferredSize(new Dimension(200 ,25));
		inputPanel.add(price, c);
		
		buttP = new JPanel(new FlowLayout(50,25,25));
		buttP.setVisible(true);
		buttP.setPreferredSize(new Dimension(500,100));
		buttP.setBackground(new Color(33,33,33));
		frame.getContentPane().add(buttP, BorderLayout.SOUTH);
		
		addFront = new JButton("Add to the Front");
		addFront.setVisible(true);
		addFront.setPreferredSize(new Dimension(125, 25));
		buttP.add(addFront);
		
		addFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.addToFront(name.getText(), tel.getText(), email.getText(), modelCar.getText(), price.getText());
				frame.dispose();
			}
		});
				
		addRear = new JButton("Add to the Rear");
		addRear.setVisible(true);
		addRear.setPreferredSize(new Dimension(125,25));
		buttP.add(addRear);
		
		
		addRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.addToBack(name.getText(), tel.getText(), email.getText(), modelCar.getText(), price.getText());
				frame.dispose();
			}
		});
		
		cancel = new JButton("Cancel");
		cancel.setVisible(true);
		cancel.setPreferredSize(new Dimension(100, 25));
		buttP.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		
		
	}
}
