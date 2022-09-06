package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class Portfolio implements ActionListener {
	private ArrayList<Investment> investmentList;
	HashMap<String, ArrayList<Integer>> indexListsMap;
	int index = -1;
	JFrame f=new JFrame("ePortfolio");
	JMenuItem buy,sell,gain,search,update,quit;
	JTextArea textArea;
	JLabel scroJLabel=new JLabel();
	JScrollPane scrollableTextArea;
	SpringLayout sprLayout=new SpringLayout();
	JLabel typeLabel,symbolLab,nameLab,quanLab,priceLab;

	String typeList[]={"Stock","MutualFund"};    
	JComboBox typeComboBox=new JComboBox(typeList); 
	JTextField textSymbol,textName,textQuantity,textPrice;
	JButton resetButton,buyButton;
	Font bigfont = new Font( "Serif", Font.BOLD, 20 );
	Font font = new Font( "Arial", Font.BOLD, 16 );
	Font textFont = new Font( "Serif", Font.PLAIN, 20 );
	Border blackline = BorderFactory.createLineBorder(Color.black);
	Border b1=BorderFactory.createMatteBorder(-1, 0, -1, -1, Color.BLACK);
	Border b2 =BorderFactory.createDashedBorder(null, 5, 5);;
	Border compound = new CompoundBorder(b1, b2);
	private JButton cellButton;
	private JPanel updateCenterPanel;
	private JPanel updatePanelLeft;
	private JPanel updatePanelright;
	private JButton updateButton, prevButton,nextButton,saveButton;
	private JPanel gainCenterPanel;
	private JPanel gainPanelLeft;
	private JLabel totGainLab;
	private JTextField texttotGain;
	private JPanel searchCenterPanel;
	private JPanel searchPanelLeft;
	private JLabel priceHighLab;
	private JTextField textPriceHigh;
	private JButton searchButtonChild;
	private JPanel searchPanelright;
	JPanel textPanel,buyCenterPanel,buyPanelright,buyPanelLeft, scrrollJPanel,cellCenterPanel,cellPanelright,cellPanelLeft;
	private JTextField textQuantitys;
	private JTextField textPrices;
	private JTextField textSymbols;
	private JTextField textSymbolu;
	private JTextField textNameu;
	private JTextField textPriceu;
	private JTextField textSymbolh;
	private JTextField textNameh;
	private JTextField textPriceh;
	private JButton resetButtonh;
	private JButton resetButtons;



	public Portfolio(){
		investmentList = new ArrayList<Investment>();
		indexListsMap = new HashMap<String, ArrayList<Integer>>();
		textPanel=new JPanel();
		f.setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(200,50));
		f.add(menuBar,BorderLayout.NORTH);

		JMenu commands = new JMenu("Commands");
		commands.setBorderPainted(true);
		menuBar.setBorder(blackline);
		commands.setFont(bigfont);

		buy = new JMenuItem("Buy");
		sell = new JMenuItem("Sell");
		update = new JMenuItem("Update");
		gain = new JMenuItem("Get Gain");
		search = new JMenuItem("Search");
		quit = new JMenuItem("Quit");

		buy.addActionListener(this);
		sell.addActionListener(this);
		update.addActionListener(this);
		gain.addActionListener(this);
		search.addActionListener(this);
		quit.addActionListener(this);

		commands.add(buy);
		commands.add(sell);
		commands.add(update);
		commands.add(gain);
		commands.add(search);
		commands.add(quit);

		buy.setBorder(blackline);
		sell.setBorder(blackline);
		update.setBorder(blackline);
		gain.setBorder(blackline);
		search.setBorder(blackline);
		quit.setBorder(blackline);

		buy.setPreferredSize(new Dimension(100, 40));
		sell.setPreferredSize(new Dimension(100, 40));
		update.setPreferredSize(new Dimension(100, 40));
		gain.setPreferredSize(new Dimension(100, 40));
		search.setPreferredSize(new Dimension(100, 40));
		quit.setPreferredSize(new Dimension(100, 40));

		buy.setFont(font);
		sell.setFont(font);
		update.setFont(font);
		gain.setFont(font);
		search.setFont(font);
		quit.setFont(font);
		menuBar.add(commands);


		//////default
		textPanel.setLayout(new BorderLayout());
		JLabel label=new JLabel();
		String str=("\n  Welcome to ePortfolio.\n\n\n\tChoose a command from the “Commands” menu to buy or sell \r\n\t"
				+ "an investment, update prices for all investments, get gain for the \r\n\t"
				+ "portfolio, search for relevant investments, or quit the program. ");
		label.setText(convertToMultiline(str));
		label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

		label.setFont(textFont);
		textPanel.add(label,BorderLayout.CENTER);

		f.add(textPanel);
		textPanel.setVisible(true);
		this.createBuyInvestGUI();
		this.createSellInvestGUI();
		this.createUpdateInvestGUI();
		this.creategainInvestGUI();
		this.createSearchInvestGUI();
		resetButton.addActionListener(this);

		scrrollJPanel=new JPanel(new BorderLayout());
		scroJLabel.setFont(textFont);
		textArea = new JTextArea(10, 79);  
		scrollableTextArea = new JScrollPane(textArea);  

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrrollJPanel.add(scroJLabel, BorderLayout.NORTH);
		scrrollJPanel.add(scrollableTextArea,BorderLayout.CENTER);
		scrrollJPanel.setPreferredSize(new Dimension(850, 220));
		Border b3=BorderFactory.createMatteBorder(0, -1, -1, -1, Color.BLACK);
		Border b4 =BorderFactory.createDashedBorder(null, 5, 5);;
		Border compound2 = new CompoundBorder(b3, b4);
		scrrollJPanel.setBorder(compound2);

		scrrollJPanel.setVisible(false);
		f.add(scrrollJPanel,BorderLayout.SOUTH);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.setVisible(true);
	}
	public static String convertToMultiline(String orig)
	{
		return "<html>" + orig.replaceAll("\n", "<br>");
	}
	void createBuyInvestGUI()
	{
		buyCenterPanel=new JPanel();
		buyCenterPanel.setLayout(new BorderLayout());

		buyPanelLeft=new JPanel(sprLayout);

		JLabel buyInvestment=new JLabel("Buying an Investment");
		buyInvestment.setFont(textFont);

		typeLabel=new JLabel("Type",SwingConstants.CENTER);
		symbolLab=new JLabel("Symbol",SwingConstants.CENTER);
		nameLab=new JLabel("Name",SwingConstants.CENTER);
		quanLab=new JLabel("Quantity",SwingConstants.CENTER);
		priceLab=new JLabel("Price",SwingConstants.CENTER);

		textSymbol=new JTextField(20);
		textName=new JTextField(20);
		textQuantity=new JTextField(20);
		textPrice=new JTextField(20);

		buyPanelLeft.add(typeLabel);
		buyPanelLeft.add(symbolLab);
		buyPanelLeft.add(nameLab);
		buyPanelLeft.add(quanLab);
		buyPanelLeft.add(priceLab);

		buyPanelLeft.add(buyInvestment);

		buyPanelLeft.add(textSymbol);
		buyPanelLeft.add(textQuantity);
		buyPanelLeft.add(textPrice);
		buyPanelLeft.add(textName);
		buyPanelLeft.add(typeComboBox);



		sprLayout.putConstraint(SpringLayout.WEST, buyInvestment,  20, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, buyInvestment,  30, SpringLayout.NORTH, buyPanelLeft);

		sprLayout.putConstraint(SpringLayout.WEST, typeLabel,  50, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, typeLabel,  50, SpringLayout.NORTH, buyInvestment);
		sprLayout.putConstraint(SpringLayout.WEST, typeComboBox,  150, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, typeComboBox, 55, SpringLayout.NORTH, buyInvestment);

		sprLayout.putConstraint(SpringLayout.WEST, symbolLab,  50, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, symbolLab,  50, SpringLayout.NORTH, typeLabel);
		sprLayout.putConstraint(SpringLayout.WEST, textSymbol,  150, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textSymbol, 55, SpringLayout.NORTH, typeComboBox);

		sprLayout.putConstraint(SpringLayout.WEST, nameLab,  50, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, nameLab,  50, SpringLayout.NORTH, symbolLab);
		sprLayout.putConstraint(SpringLayout.WEST, textName,  150, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textName, 55, SpringLayout.NORTH, textSymbol);

		sprLayout.putConstraint(SpringLayout.WEST, quanLab,  50, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, quanLab,  50, SpringLayout.NORTH, nameLab);
		sprLayout.putConstraint(SpringLayout.WEST, textQuantity,  150, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textQuantity, 55, SpringLayout.NORTH, textName);

		sprLayout.putConstraint(SpringLayout.WEST, priceLab,  50, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, priceLab,  50, SpringLayout.NORTH, quanLab);
		sprLayout.putConstraint(SpringLayout.WEST, textPrice,  150, SpringLayout.WEST, buyPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textPrice, 55, SpringLayout.NORTH, textQuantity);




		///left buy panel

		buyPanelright=new JPanel(sprLayout);
		resetButton=new JButton("Reset");
		buyButton=new JButton("Buy");
		resetButton.setPreferredSize(new Dimension(120, 40));
		buyButton.setPreferredSize(new Dimension(120, 40));
		buyButton.addActionListener(this);
		resetButton.addActionListener(this);

		buyPanelright.add(resetButton);
		buyPanelright.add(buyButton);

		sprLayout.putConstraint(SpringLayout.WEST, resetButton,  100, SpringLayout.WEST, buyPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, resetButton, 100, SpringLayout.NORTH, buyPanelright);

		sprLayout.putConstraint(SpringLayout.WEST, buyButton,  100, SpringLayout.WEST, buyPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, buyButton, 150, SpringLayout.NORTH, resetButton);


		buyPanelright.setPreferredSize(new Dimension(300, 400));


		buyPanelright.setBorder(compound);

		buyPanelright.setVisible(true);
		buyCenterPanel.add(buyPanelright,BorderLayout.EAST);

		buyPanelLeft.setVisible(true);
		buyCenterPanel.add(buyPanelLeft,BorderLayout.CENTER);
		buyInvestment.setVisible(false);
		//f.add(buyCenterPanel,BorderLayout.CENTER);


	}
	void createSellInvestGUI()
	{
		cellCenterPanel=new JPanel();
		cellCenterPanel.setLayout(new BorderLayout());

		cellPanelLeft=new JPanel(sprLayout);

		JLabel cellInvestment=new JLabel("Selling an Investment");
		cellInvestment.setFont(textFont);

		symbolLab=new JLabel("Symbol",SwingConstants.CENTER);
		quanLab=new JLabel("Quantity",SwingConstants.CENTER);
		priceLab=new JLabel("Price",SwingConstants.CENTER);

		textSymbols=new JTextField(20);
		textQuantitys=new JTextField(20);
		textPrices=new JTextField(20);

		cellPanelLeft.add(symbolLab);
		cellPanelLeft.add(quanLab);
		cellPanelLeft.add(priceLab);

		cellPanelLeft.add(cellInvestment);

		cellPanelLeft.add(textSymbols);
		cellPanelLeft.add(textQuantitys);
		cellPanelLeft.add(textPrices);



		sprLayout.putConstraint(SpringLayout.WEST, cellInvestment,  20, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, cellInvestment,  30, SpringLayout.NORTH, cellPanelLeft);



		sprLayout.putConstraint(SpringLayout.WEST, symbolLab,  50, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, symbolLab,  70, SpringLayout.NORTH, cellInvestment);
		sprLayout.putConstraint(SpringLayout.WEST, textSymbols,  150, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textSymbols, 75, SpringLayout.NORTH, cellInvestment);

		sprLayout.putConstraint(SpringLayout.WEST, quanLab,  50, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, quanLab,  50, SpringLayout.NORTH, symbolLab);
		sprLayout.putConstraint(SpringLayout.WEST, textQuantitys,  150, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textQuantitys, 55, SpringLayout.NORTH, textSymbols);

		sprLayout.putConstraint(SpringLayout.WEST, priceLab,  50, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, priceLab,  50, SpringLayout.NORTH, quanLab);
		sprLayout.putConstraint(SpringLayout.WEST, textPrices,  150, SpringLayout.WEST, cellPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textPrices, 55, SpringLayout.NORTH, textQuantitys);




		///left cell panel

		cellPanelright=new JPanel(sprLayout);
		cellButton=new JButton("Sell");
		resetButtons=new JButton("Reset");
		cellButton.addActionListener(this);
		resetButtons.addActionListener(this);

		resetButtons.setPreferredSize(new Dimension(120, 40));
		cellButton.setPreferredSize(new Dimension(120, 40));

		cellPanelright.add(resetButtons);
		cellPanelright.add(cellButton);

		sprLayout.putConstraint(SpringLayout.WEST, resetButtons,  100, SpringLayout.WEST, cellPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, resetButtons, 100, SpringLayout.NORTH, cellPanelright);

		sprLayout.putConstraint(SpringLayout.WEST, cellButton,  100, SpringLayout.WEST, cellPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, cellButton, 130, SpringLayout.NORTH, resetButtons);


		cellPanelright.setPreferredSize(new Dimension(300, 400));


		cellPanelright.setBorder(compound);

		cellPanelright.setVisible(true);
		cellCenterPanel.add(cellPanelright,BorderLayout.EAST);

		cellPanelLeft.setVisible(true);
		cellCenterPanel.add(cellPanelLeft,BorderLayout.CENTER);
		cellCenterPanel.setVisible(true);
		//f.add(cellCenterPanel,BorderLayout.CENTER);


	}
	void createUpdateInvestGUI()
	{
		updateCenterPanel=new JPanel();
		updateCenterPanel.setLayout(new BorderLayout());

		updatePanelLeft=new JPanel(sprLayout);

		JLabel updateInvestment=new JLabel("Updating Investments");

		updateInvestment.setFont(textFont);

		symbolLab=new JLabel("Symbol",SwingConstants.CENTER);
		nameLab=new JLabel("Name",SwingConstants.CENTER);
		priceLab=new JLabel("Price",SwingConstants.CENTER);

		textSymbolu=new JTextField(20);
		textNameu=new JTextField(20);
		textPriceu=new JTextField(20);

		updatePanelLeft.add(symbolLab);
		updatePanelLeft.add(nameLab);
		updatePanelLeft.add(priceLab);

		updatePanelLeft.add(updateInvestment);

		updatePanelLeft.add(textSymbolu);
		updatePanelLeft.add(textNameu);
		updatePanelLeft.add(textPriceu);
		textSymbolu.setEditable(false);
		textNameu.setEditable(false);

		sprLayout.putConstraint(SpringLayout.WEST, updateInvestment,  20, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, updateInvestment,  30, SpringLayout.NORTH, updatePanelLeft);

		sprLayout.putConstraint(SpringLayout.WEST, symbolLab,  50, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, symbolLab,  70, SpringLayout.NORTH, updateInvestment);
		sprLayout.putConstraint(SpringLayout.WEST, textSymbolu,  150, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textSymbolu, 75, SpringLayout.NORTH, updateInvestment);

		sprLayout.putConstraint(SpringLayout.WEST, nameLab,  50, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, nameLab,  50, SpringLayout.NORTH, symbolLab);
		sprLayout.putConstraint(SpringLayout.WEST, textNameu,  150, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textNameu, 55, SpringLayout.NORTH, textSymbolu);

		sprLayout.putConstraint(SpringLayout.WEST, priceLab,  50, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, priceLab,  50, SpringLayout.NORTH, nameLab);
		sprLayout.putConstraint(SpringLayout.WEST, textPriceu,  150, SpringLayout.WEST, updatePanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textPriceu, 55, SpringLayout.NORTH, textNameu);




		///left update panel

		updatePanelright=new JPanel(sprLayout);
		prevButton=new JButton("Prev");
		nextButton=new JButton("Next");
		saveButton=new JButton("Save");
		prevButton.setPreferredSize(new Dimension(120, 40));
		nextButton.setPreferredSize(new Dimension(120, 40));
		saveButton.setPreferredSize(new Dimension(120, 40));

		prevButton.addActionListener(this);
		nextButton.addActionListener(this);
		saveButton.addActionListener(this);

		updatePanelright.add(prevButton);
		updatePanelright.add(nextButton);
		updatePanelright.add(saveButton);


		sprLayout.putConstraint(SpringLayout.WEST, prevButton,  100, SpringLayout.WEST, updatePanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, prevButton, 100, SpringLayout.NORTH, updatePanelright);

		sprLayout.putConstraint(SpringLayout.WEST, nextButton,  100, SpringLayout.WEST, updatePanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, nextButton, 100, SpringLayout.NORTH, prevButton);

		sprLayout.putConstraint(SpringLayout.WEST, saveButton,  100, SpringLayout.WEST, updatePanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, saveButton, 100, SpringLayout.NORTH, nextButton);


		updatePanelright.setPreferredSize(new Dimension(300, 400));


		updatePanelright.setBorder(compound);

		updatePanelright.setVisible(true);
		updateCenterPanel.add(updatePanelright,BorderLayout.EAST);

		updatePanelLeft.setVisible(true);
		updateCenterPanel.add(updatePanelLeft,BorderLayout.CENTER);
		updateCenterPanel.setVisible(true);
		//	f.add(updateCenterPanel,BorderLayout.CENTER);


	}
	void creategainInvestGUI()
	{
		gainCenterPanel=new JPanel();
		gainCenterPanel.setLayout(new BorderLayout());

		gainPanelLeft=new JPanel(sprLayout);

		JLabel gainInvestment=new JLabel("Getting total gain");
		gainInvestment.setFont(textFont);

		totGainLab=new JLabel("Total Gain",SwingConstants.CENTER);

		texttotGain=new JTextField(20);
		texttotGain.setEditable(false);
		gainPanelLeft.add(totGainLab);

		gainPanelLeft.add(gainInvestment);
		gainPanelLeft.add(texttotGain);

		sprLayout.putConstraint(SpringLayout.WEST, gainInvestment,  20, SpringLayout.WEST, gainPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, gainInvestment,  30, SpringLayout.NORTH, gainPanelLeft);

		sprLayout.putConstraint(SpringLayout.WEST, totGainLab,  50, SpringLayout.WEST, gainPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, totGainLab,  70, SpringLayout.NORTH, gainInvestment);
		sprLayout.putConstraint(SpringLayout.WEST, texttotGain,  150, SpringLayout.WEST, gainPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, texttotGain, 75, SpringLayout.NORTH, gainInvestment);

		gainPanelLeft.setVisible(true);
		gainCenterPanel.add(gainPanelLeft,BorderLayout.CENTER);
		gainCenterPanel.setVisible(true);
		//f.add(gainCenterPanel,BorderLayout.CENTER);

	}
	void createSearchInvestGUI()
	{
		searchCenterPanel=new JPanel();
		searchCenterPanel.setLayout(new BorderLayout());

		searchPanelLeft=new JPanel(sprLayout);

		JLabel searchInvestment=new JLabel("Searching Investments");
		searchInvestment.setFont(textFont);

		symbolLab=new JLabel("Symbol",SwingConstants.CENTER);
		nameLab=new JLabel("Name Keywords",SwingConstants.CENTER);
		priceLab=new JLabel("Low Price",SwingConstants.CENTER);
		priceHighLab=new JLabel("High Price",SwingConstants.CENTER);

		textSymbolh=new JTextField(20);
		textNameh=new JTextField(20);
		textPriceh=new JTextField(20);
		textPriceHigh=new JTextField(20);


		searchPanelLeft.add(symbolLab);
		searchPanelLeft.add(nameLab);
		searchPanelLeft.add(priceLab);
		searchPanelLeft.add(priceHighLab);


		searchPanelLeft.add(searchInvestment);

		searchPanelLeft.add(textSymbolh);
		searchPanelLeft.add(textNameh);
		searchPanelLeft.add(textPriceh);
		searchPanelLeft.add(textPriceHigh);



		sprLayout.putConstraint(SpringLayout.WEST, searchInvestment,  20, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, searchInvestment,  30, SpringLayout.NORTH, searchPanelLeft);



		sprLayout.putConstraint(SpringLayout.WEST, symbolLab,  50, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, symbolLab,  70, SpringLayout.NORTH, searchInvestment);
		sprLayout.putConstraint(SpringLayout.WEST, textSymbolh,  150, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textSymbolh, 75, SpringLayout.NORTH, searchInvestment);

		sprLayout.putConstraint(SpringLayout.WEST, nameLab,  50, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, nameLab,  50, SpringLayout.NORTH, symbolLab);
		sprLayout.putConstraint(SpringLayout.WEST, textNameh,  150, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textNameh, 55, SpringLayout.NORTH, textSymbolh);

		sprLayout.putConstraint(SpringLayout.WEST, priceLab,  50, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, priceLab,  50, SpringLayout.NORTH, nameLab);
		sprLayout.putConstraint(SpringLayout.WEST, textPriceh,  150, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textPriceh, 55, SpringLayout.NORTH, textNameh);

		sprLayout.putConstraint(SpringLayout.WEST, priceHighLab,  50, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, priceHighLab,  50, SpringLayout.NORTH, priceLab);
		sprLayout.putConstraint(SpringLayout.WEST, textPriceHigh,  150, SpringLayout.WEST, searchPanelLeft);
		sprLayout.putConstraint(SpringLayout.SOUTH, textPriceHigh, 55, SpringLayout.NORTH, textPriceh);




		///left search panel

		searchPanelright=new JPanel(sprLayout);
		resetButtonh=new JButton("Reset");
		searchButtonChild=new JButton("Search");
		resetButtonh.setPreferredSize(new Dimension(120, 40));
		searchButtonChild.setPreferredSize(new Dimension(120, 40));


		searchPanelright.add(resetButtonh);
		searchPanelright.add(searchButtonChild);
		searchButtonChild.addActionListener(this);
		resetButtonh.addActionListener(this);


		sprLayout.putConstraint(SpringLayout.WEST, resetButtonh,  100, SpringLayout.WEST, searchPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, resetButtonh, 100, SpringLayout.NORTH, searchPanelright);

		sprLayout.putConstraint(SpringLayout.WEST, searchButtonChild,  100, SpringLayout.WEST, searchPanelright);
		sprLayout.putConstraint(SpringLayout.SOUTH, searchButtonChild, 100, SpringLayout.NORTH, resetButtonh);

		searchPanelright.setPreferredSize(new Dimension(300, 400));


		searchPanelright.setBorder(compound);

		searchPanelright.setVisible(true);
		searchCenterPanel.add(searchPanelright,BorderLayout.EAST);

		searchPanelLeft.setVisible(true);
		searchCenterPanel.add(searchPanelLeft,BorderLayout.CENTER);
		searchCenterPanel.setVisible(true);
		//f.add(searchCenterPanel,BorderLayout.CENTER);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit)
		{
			writeFile("output");

			System.exit(0);
		}
		else if(e.getSource()==buy)
		{
			hideAll();
			buyCenterPanel.setVisible(true);
			scrrollJPanel.setVisible(true);
			scroJLabel.setText("Messages");
			f.add(buyCenterPanel,BorderLayout.CENTER);

		}
		else if(e.getSource()==sell)
		{
			hideAll();
			cellCenterPanel.setVisible(true);
			scrrollJPanel.setVisible(true);
			scroJLabel.setText("Messages");
			f.add(cellCenterPanel,BorderLayout.CENTER);

		}
		else if(e.getSource()==update)
		{
			if(investmentList.size()>0) {
				index=0;
				update(false);

			}
			else {
				index=-1;
			}
			hideAll();
			updateCenterPanel.setVisible(true);
			scrrollJPanel.setVisible(true);
			scroJLabel.setText("Messages");
			f.add(updateCenterPanel,BorderLayout.CENTER);
			nextButton.setEnabled(true);
			prevButton.setEnabled(true);

		}
		else if(e.getSource()==gain)
		{
			hideAll();
			gainCenterPanel.setVisible(true);
			scrrollJPanel.setVisible(true);
			scroJLabel.setText("Individual Gains");
			f.add(gainCenterPanel,BorderLayout.CENTER);
			getGain();

		}	
		else if(e.getSource()==search)
		{
			hideAll();
			searchCenterPanel.setVisible(true);
			scrrollJPanel.setVisible(true);
			scroJLabel.setText("Search Results");
			f.add(searchCenterPanel,BorderLayout.CENTER);

		}	
		else if(e.getSource()==buyButton)
		{
			buy();
		}
		else if(e.getSource()==cellButton)
		{
			sell();
		}
		else if(e.getSource()==saveButton)
		{
			update(true);
		}
		else if(e.getSource()==prevButton)
		{
			if(index>=0) {
				index--;
				update(false);

			}
			else {
				index=-1;
				prevButton.setEnabled(false);
			}
		}
		else if(e.getSource()==nextButton)
		{
			if(index==investmentList.size()) {
				nextButton.setEnabled(false);
			}
			else {
				index++;
				update(false);

			}
		}
		else if(e.getSource()==searchButtonChild)
		{
			search();
		}
		else if(e.getSource()==resetButton||e.getSource()==resetButtonh||e.getSource()==resetButtons)
		{
			textArea.setText("");
			textName.setText("");
			textNameu.setText("");
			textNameh.setText("");
			textPrice.setText("");
			textPrices.setText("");
			textPriceu.setText("");
			textPriceh.setText("");

			textPriceHigh.setText("");
			textQuantity.setText("");
			textQuantitys.setText("");

			textSymbol.setText("");
			textSymbols.setText("");
			textSymbolu.setText("");
			textSymbolh.setText("");

			texttotGain.setText("");
		}


	}
	void hideAll()
	{
		textPanel.setVisible(false);
		buyCenterPanel.setVisible(false);
		cellCenterPanel.setVisible(false);
		searchCenterPanel.setVisible(false);
		gainCenterPanel.setVisible(false);
		updateCenterPanel.setVisible(false);
	}
	public void writeFile(String fileName){
		try {
			PrintWriter file = new PrintWriter(fileName,"UTF-8");
			for(Investment investment : investmentList){
				if(investment.getClass().equals(MutualFund.class)){
					file.println("type = \"mutualfund\"");
				}
				else{
					file.println("type = \"stock\"");
				}

				file.println("symbol = \"" + investment.getSymbol() + "\"");
				file.println("name = \"" + investment.getName() + "\"");
				file.println("quantity = \"" + investment.getQuantity() + "\"");
				file.println("price = \"" + investment.getPrice() + "\"");
				file.println("bookValue = \"" + investment.getBookValue() + "\"\n");
			}
			System.out.println("Investments has been written to file.");
			file.close();
		} catch (Exception e) {
			System.out.println("Error in writing investments to file");
		}
	}

	public void readFile(String fileName){
		try {
			File f = new File(fileName);
			int i, quantity, indexOfInvestment = 0;
			double price, bookValue;
			String line, symbol, name, type;
			String tokens[];

			if(f.length() == 0){
				System.out.println("Empty file.");
			}else{

				Scanner file = new Scanner(f);

				while (file.hasNextLine()) {
					line = file.nextLine();
					tokens = line.split("\"");
					type = tokens[1];
					line = file.nextLine();
					tokens = line.split("\"");
					symbol = tokens[1];
					line = file.nextLine();
					tokens = line.split("\"");
					name = tokens[1];
					line = file.nextLine();
					tokens = line.split("\"");
					quantity = Integer.parseInt(tokens[1]);
					line = file.nextLine();
					tokens = line.split("\"");
					price = Double.parseDouble(tokens[1]);
					line = file.nextLine();
					tokens = line.split("\"");
					bookValue = Double.parseDouble(tokens[1]);

					if(file.hasNextLine())
						line = file.nextLine();

					if(type.equals("mutualfund")){
						MutualFund mutualFund = new MutualFund(symbol, name, quantity, price, bookValue);
						investmentList.add(mutualFund);

					}else{
						Stock stock = new Stock(symbol, name, quantity, price, bookValue);
						investmentList.add(stock);
					}

					tokens = name.split(" ");
					i = 0;
					while(i < tokens.length){
						ArrayList<Integer> indexList = indexListsMap.get(tokens[i].toLowerCase());
						if(indexList != null){
							indexList.add(indexOfInvestment);
						}else{
							indexList = new ArrayList<Integer>();
							indexList.add(indexOfInvestment);
						}
						indexListsMap.put(tokens[i].toLowerCase(), indexList);
						i++;
					}
					indexOfInvestment++;
				}
				System.out.println("All investment has been read.");
			}
		} catch (Exception e) {
			System.out.println("Error in reading the file.");
		}
	}

	public void buy() {
		int exist = 0, quantity;
		double price;
		String type=textQuantity.getText(), symbol, name = null;

		type = (String) typeComboBox.getSelectedItem();
		symbol = textSymbol.getText();
		quantity = (int) Double.parseDouble(textQuantity.getText());
		price = Double.parseDouble(textPrice.getText());

		if(price <= 0 || quantity <= 0){
			textArea.setText("Price or Quantity can't be zero or negative.");
			return;
		}

		if(type.toLowerCase().equals("mutualfund") ||
				type.toLowerCase().equals("mf") ||
				type.toLowerCase().equals("m")){

			for (int i = 0; i < investmentList.size(); i++) {
				if (investmentList.get(i).symbol.equals(symbol)) {
					investmentList.get(i).setPrice(investmentList.get(i).getPrice() + price);
					investmentList.get(i).setQuantity(investmentList.get(i).getQuantity() + quantity);
					investmentList.set(i, investmentList.get(i));
					exist = 1;
					break;
				}
			}
			if (exist == 0) {
				name = textName.getText();
				MutualFund mf = new MutualFund(symbol, name, quantity, price, 
						price * quantity);

				investmentList.add(mf);
				textArea.setText("buy successfully");
			}
		} else if(type.toLowerCase().equals("stock") ||
				type.toLowerCase().equals("s")){

			for (int i = 0; i < investmentList.size(); i++) {
				if (investmentList.get(i).symbol.equals(symbol)) {
					investmentList.get(i).setPrice(investmentList.get(i).getPrice() + price);
					investmentList.get(i).setQuantity(investmentList.get(i).getQuantity() + quantity);
					investmentList.set(i, investmentList.get(i));

					exist = 1;
					break;
				}
			}
			if (exist == 0) {
				name = textName.getText();
				Stock s = new Stock(symbol, name, quantity, price, 
						(price * quantity + (price * quantity / 100) * 9.99));

				investmentList.add(s);
				textArea.setText("buy successfully");

			}


			if(exist == 0){
				String tokens[] = name.split(" ");
				int i = 0, indexOfInvestment = investmentList.size() - 1;
				while(i < tokens.length){
					ArrayList<Integer> indexList = indexListsMap.get(tokens[i].toLowerCase());
					if(indexList != null){
						indexList.add(indexOfInvestment);
					}else{
						indexList = new ArrayList<Integer>();
						indexList.add(indexOfInvestment);
					}
					indexListsMap.put(tokens[i].toLowerCase(), indexList);
					i++;
				}
				indexOfInvestment++;
			}
		}
	}

	public void removeIndexFromMap(String name, int index){
		String tokens[] = name.split(" ");
		int i = 0, j;
		while(i < tokens.length){
			ArrayList<Integer> indexList = indexListsMap.get(tokens[i].toLowerCase());

			if(indexList != null){
				j = indexList.indexOf(index);
				indexList.remove(j);
			}
			if(indexList.isEmpty()){
				indexListsMap.remove(tokens[i].toLowerCase());
			}else{
				indexListsMap.put(tokens[i].toLowerCase(), indexList);
			}
			i++;
		}
	}

	public void sell(){
		String symbol;
		int quantity, exist = 0;
		double price;
		try {
			symbol = textSymbols.getText();
			price = Double.parseDouble(textPrices.getText());
			quantity = Integer.parseInt(textQuantitys.getText());

			if(price <= 0 || quantity <= 0){
				textArea.setText("Quantity or Price can't be zero or negative.");
				return;
			}
			int i = 0;
			for(Investment investment : investmentList) {
				if(investment.getSymbol().toLowerCase().equals(symbol.toLowerCase())){
					exist = 1;

					if(investment.getQuantity() >= quantity){
						if(investment.getClass().equals(MutualFund.class)){
							MutualFund mf = (MutualFund)investment;
							mf.setQuantity(mf.getQuantity() - quantity);
							if(mf.getQuantity() == 0){
								removeIndexFromMap(mf.getName(), i);
								investmentList.remove(i);
							}else
								investmentList.set(i, mf);
						}else{
							Stock s = (Stock)investment;
							s.setQuantity(s.getQuantity() - quantity);
							if(s.getQuantity() != 0)
								investmentList.set(i, s);
							else{
								removeIndexFromMap(s.getName(), i);
								investmentList.remove(i);
							}
						}
						textArea.setText("Successfully Sell");
					}else{
						textArea.setText("Required quantity is not available for sell.");
						return;
					}
					break;
				}
				i++;
			}
			if(exist == 0)
				textArea.setText("Investment not found");
		}
		catch (Exception e) {
			textArea.setText(e.toString());
		}
	}

	public void update(Boolean updBoolean) {	

		try {
			if(index>=0&&index<investmentList.size()){
				Investment investment = investmentList.get(index);
				textSymbolu.setText(investment.getSymbol());
				textNameu.setText(investment.getName());
				if(updBoolean)
				{
					investment.setPrice(Double.parseDouble(textPriceu.getText()));	
					investmentList.set(index, investment);
					textArea.setText("Updated Successfully");
					investment.display(textArea);
				}
				else {
					textPriceu.setText(investment.getPrice()+"");

				}
			}
		}
		catch (Exception e) {
			textArea.setText(e.toString());
		}
	}

	public void getGain() {
		double totalGain = 0.0;
		textArea.setText("");
		try {
			for(int i = 0; i < investmentList.size(); i++) {
				Investment investment = investmentList.get(i);
				if(investment.getClass().equals(MutualFund.class)){
					MutualFund mutualFund = (MutualFund)investment;
					totalGain = totalGain + mutualFund.calAndGetGain();
					textArea.append("Name: "+mutualFund.getName()+ " Gain :"+mutualFund.calAndGetGain()+"\n");
				}else{
					Stock stock = (Stock)investment;
					totalGain = totalGain + stock.calAndGetGain();
					textArea.append("Name: "+stock.getName()+ " Gain :"+stock.calAndGetGain()+"\n");

				}
			}
			texttotGain.setText(Double.toString(totalGain));
		}
		catch (Exception e) {
			textArea.setText(e.toString());
		}
	}

	public void search() {
		String symbol="", name, tokens[];
		ArrayList<ArrayList<Integer> > listOfLists;
		ArrayList<Integer> list;
		ArrayList<Integer> intersection;
		int choice=0, i;
		double min, max;

		if(!textSymbolh.getText().isEmpty())
		{
			choice=1;
		}
		else if(!textNameh.getText().isEmpty())
		{
			choice=3;
		}
		else if(!textPriceh.getText().isEmpty()&&!textPriceHigh.getText().isEmpty())
		{
			choice=2;
		}
		try {
			switch(choice){
			case 1:
				textArea.setText("Search Results:");

				for(i = 0; i < investmentList.size(); i++)
					if(investmentList.get(i).getSymbol().toLowerCase().equals(symbol.toLowerCase()) ||
							investmentList.get(i).getSymbol().toLowerCase().contains(symbol.toLowerCase()))
						investmentList.get(i).display(textArea);
				break;
			case 2:
				min = Double.parseDouble(textPriceh.getText());
				max = Double.parseDouble(textPriceHigh.getText());

				textArea.setText("Search Results:");

				for(i = 0; i < investmentList.size(); i++)
					if(investmentList.get(i).getPrice() >= min && 
					investmentList.get(i).getPrice() <= max)
						investmentList.get(i).display(textArea);
				break;
			case 3:
				name = textNameh.getText();

				tokens = name.split(" ");
				listOfLists = new ArrayList<ArrayList<Integer>>(tokens.length);

				i = 0;
				while(i < tokens.length){
					list = indexListsMap.get(tokens[i].toLowerCase());
					listOfLists.add(list);
					i++;
				}

				intersection = new ArrayList<Integer>();
				list = listOfLists.get(0);
				if(list == null){
					return;
				}
				int exist;
				for(int index : list){
					exist = 1;
					i = 1;
					while(i < listOfLists.size()){
						if(!listOfLists.get(i).contains(index)){
							exist = 0;
						}
						i++;
					}
					if(exist == 1){
						intersection.add(index);
					}
				}

				exist = 0;
				textArea.setText("Search result:");
				for(int index : intersection){
					if(investmentList.get(index).getName().toLowerCase().equals(name.toLowerCase())){
						investmentList.get(index).display(textArea);
						exist = 1;
					}
				}

				if(exist == 0){

					if(intersection.size() == 0){
						textArea.setText("No investments against your name given found.");
					}else{
						for(int index : intersection){
							investmentList.get(index).display(textArea);
						}
					}
				}
				break;
			}
		}
		catch (Exception e) {
			textArea.setText(e.toString());
		}
	}

	public static void main(String[] args) {
		Portfolio portfolio = new Portfolio();
		//if(args.length > 0){
			portfolio.readFile("output");
		//}
	}



}
