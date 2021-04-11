import java.util.Scanner;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class 	CalculatorPanel {
	
	private JFrame frame;
	private JPanel inputCalculator;
	private GridBagConstraints c;
	private JLabel incomeL;
	private JTextField income;
	private JLabel expenseL;
	private JTextField expense;
	private JLabel minIncomeL;
	private JTextField minIncome;
	private JLabel maxExpenseL;
	private JTextField maxExpense;
	private JButton calculate;
	private JButton cancel;    
	private JPanel buttP;
	private CalculatorPanel list2;
	private JTextField sumTxt;
	private JLabel sumL;
	public int sum = 0;
	public int choice = 0;
	public int nextIncome = 10000000;
	public int nextExpense = 0;
	
	public CalculatorPanel(CalculatorPanel list2) {
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setTitle("Calculate");
		frame.setVisible(true);
		
		this.list2 = list2;
		
		inputCalculator = new JPanel(new GridBagLayout());
		inputCalculator.setVisible(true);
		inputCalculator.setBackground(new Color(222,228,49));
		inputCalculator.setPreferredSize(new Dimension(500,400));
		frame.getContentPane().add(inputCalculator, BorderLayout.CENTER);
		
		

		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20,20,20,20);
		
		incomeL = new JLabel("Income: ");
		incomeL.setVisible(true);
		inputCalculator.add(incomeL, c);
		
		c.gridx = 1;
		income = new JTextField("");
		income.setEditable(true);
		income.setPreferredSize(new Dimension(200 , 25));
		inputCalculator.add(income, c);
		
		c.gridx = 0;
		c.gridy = 1;
		expenseL = new JLabel("Expenses:  ");
		expenseL.setVisible(true);
		inputCalculator.add(expenseL, c);
		
		c.gridx = 1;
		expense = new JTextField("");
		expense.setEditable(true);
		expense.setVisible(true);
		expense.setPreferredSize(new Dimension(200 ,25));
		inputCalculator.add(expense, c);
		
		c.gridx = 0;
		c.gridy = 2;
		sumL = new JLabel("SUM:  ");
		sumL.setVisible(true);
		inputCalculator.add(sumL, c);
		
		c.gridx = 1;
		sumTxt = new JTextField("");
		sumTxt.setEditable(true);
		sumTxt.setVisible(true);
		sumTxt.setPreferredSize(new Dimension(200 ,25));
		inputCalculator.add(sumTxt, c);
		
		
		c.gridx = 0;
		c.gridy = 3;
		minIncomeL = new JLabel("LOWEST INCOME:  ");
		minIncomeL.setVisible(true);
		inputCalculator.add(minIncomeL, c);
		
		c.gridx = 1;
		minIncome = new JTextField("");
		minIncome.setEditable(true);
		minIncome.setVisible(true);
		minIncome.setPreferredSize(new Dimension(200 ,25));
		inputCalculator.add(minIncome, c);
		c.gridx = 0;
		c.gridy = 4;
		maxExpenseL = new JLabel("HIGHEST EXPENSE:  ");
		maxExpenseL.setVisible(true);
		inputCalculator.add(maxExpenseL, c);
		
		c.gridx = 1;
		maxExpense = new JTextField("");
		maxExpense.setEditable(true);
		maxExpense.setVisible(true);
		maxExpense.setPreferredSize(new Dimension(200 ,25));
		inputCalculator.add(maxExpense, c);
		buttP = new JPanel(new FlowLayout(50,25,25));
		buttP.setVisible(true);
		buttP.setPreferredSize(new Dimension(500,100));
		buttP.setBackground(new Color(33,33,33));
		frame.getContentPane().add(buttP, BorderLayout.SOUTH);
		
		calculate = new JButton("Calculate");
		calculate.setVisible(true);
		calculate.setPreferredSize(new Dimension(125, 25));
		buttP.add(calculate);
		
		
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int maxHeap = Integer.parseInt(income.getText());
				int minHeap = Integer.parseInt(expense.getText());
				
				if(maxHeap < nextIncome && minHeap > nextExpense) {
					
					sum =sum + (maxHeap - minHeap);
					sumTxt.setText(sum + "");
					minIncome.setText(maxHeap + " ");
					maxExpense.setText(minHeap + " ");
					
				}
				else if(maxHeap > nextIncome &&  minHeap > nextExpense) {
					
					sum =sum + (maxHeap - minHeap);
					sumTxt.setText(sum + "");
					maxExpense.setText(minHeap + " ");
				
				}
				else if(maxHeap < nextIncome  &&  minHeap < nextExpense) {
					
					sum =sum + (maxHeap - minHeap);
					sumTxt.setText(sum + "");
					minIncome.setText(maxHeap + " ");
					
				}
				else if(maxHeap > nextIncome  &&  minHeap < nextExpense) {
					
					sum =sum + (maxHeap - minHeap);
					sumTxt.setText(sum + "");
					
				}
				nextIncome = maxHeap;
				nextExpense = minHeap;
				
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