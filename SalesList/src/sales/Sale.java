package sales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Sale {

	private JFrame frame;
	private JTextField item;
	private JTextField cost;
	private JTextField quantity;
	private JTextField listOutput;
	private JTextField costOutput;
	private JButton addItemButton;
	
	private SalesSlip slip = new SalesSlip();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale window = new Sale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sale() {
		initialize();
		createItemEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSalesList = new JLabel("Sales List");
		lblSalesList.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesList.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSalesList.setBounds(198, 16, 270, 50);
		frame.getContentPane().add(lblSalesList);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItem.setBounds(112, 116, 69, 20);
		frame.getContentPane().add(lblItem);
		
		JLabel lblCost = new JLabel("Cost: $");
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCost.setBounds(112, 174, 69, 20);
		frame.getContentPane().add(lblCost);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantity.setBounds(96, 232, 85, 20);
		frame.getContentPane().add(lblQuantity);
		
		item = new JTextField();
		item.setFont(new Font("Tahoma", Font.BOLD, 18));
		item.setBounds(198, 114, 346, 26);
		frame.getContentPane().add(item);
		item.setColumns(10);
		
		cost = new JTextField();
		cost.setFont(new Font("Tahoma", Font.BOLD, 18));
		cost.setBounds(198, 172, 270, 26);
		frame.getContentPane().add(cost);
		cost.setColumns(10);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		quantity.setBounds(198, 230, 270, 26);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		addItemButton = new JButton("Add Item to Sales List");
		addItemButton.setForeground(Color.BLACK);
		addItemButton.setBackground(Color.WHITE);
		addItemButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addItemButton.setBounds(211, 294, 227, 29);
		frame.getContentPane().add(addItemButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 348, 523, 136);
		frame.getContentPane().add(scrollPane);
		
		listOutput = new JTextField();
		listOutput.setFont(new Font("Tahoma", Font.BOLD, 20));
		scrollPane.setViewportView(listOutput);
		listOutput.setColumns(10);
		
		JLabel lblTotalSales = new JLabel("Total Sales:");
		lblTotalSales.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTotalSales.setBounds(56, 546, 125, 20);
		frame.getContentPane().add(lblTotalSales);
		
		costOutput = new JTextField();
		costOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		costOutput.setBounds(211, 534, 161, 38);
		frame.getContentPane().add(costOutput);
		costOutput.setColumns(10);
	}
	
	private void createItemEvent() {
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createItem();
			}
		}
				);
	}
	
	private void createItem() {
		slip.addItem(item.getText(), cost.getText(), quantity.getText());
		updateOutput();
	}
	
	private void updateOutput() {
		listOutput.setText(slip.getList());
		costOutput.setText(""+slip.getTotal());
	}
	
}
