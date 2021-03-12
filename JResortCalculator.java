// exercise p. 745-748

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{
	// instance variables for this class
final int  BASE_PRICE = 200;
final int  WEEKEND_PREMIUM = 100;
final int  BREAKFAST_PREMIUM = 20;
final int  GOLF_PREMIUM = 75;
int totalPrice = BASE_PRICE;
// GUI components for this class
JCheckBox weekendBox = new JCheckBox("weekend premium $" + WEEKEND_PREMIUM, false);
JCheckBox breakfastBox = new JCheckBox("Breakfast premium $" + BREAKFAST_PREMIUM, false);
JCheckBox golfBox = new JCheckBox("Golf premium $" + GOLF_PREMIUM, false);
JLabel resortLabel = new JLabel("Resort Price Calculatror");
JLabel priceLabel = new JLabel("The price for your stay is");
JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE + ".");
JLabel optionExplainLabel2 = new JLabel("Check the options you want.");
JTextField totPrice = new JTextField(4);

// custom constructor method for this class
public JResortCalculator()
{
	// use constructor from the JFrame class
	super("Resort Price Estimator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	setResizable(false); // not in the book
	add(resortLabel);
	add(optionExplainLabel);
	add(optionExplainLabel2);
	add(weekendBox);
	add(breakfastBox);
	add(golfBox);
	add(priceLabel);
	add(totPrice);
	totPrice.setText("$" + totalPrice);
	weekendBox.addItemListener(this);
	breakfastBox.addItemListener(this);
	golfBox.addItemListener(this);
}
	// event handling method
	// p.735 for Listener Methods: "itemStateChanged"
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getStateChange();
		int select = event.getStateChange();
	
		// first determine what the source variable is referring to
		if(source == weekendBox)
		{
			// now that we know this checkbox is the source, we decide what the state of the checkbox is
			if(select == ItemEvent.SELECTED)

			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if(source == breakfastBox)
		{
			if(select == ItemEvent.SELECTED)

			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		// if(source == golBox) by default if(select == ItemEvent.SELECTED) totalPrice += GOLF_PREMIUM;
		else
		{
			if(select == ItemEvent.SELECTED)

			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}

		totPrice.setText("$" + totalPrice);
	}




	public static void main(String[] args)
	{
		JResortCalculator aFrame = new JResortCalculator();
		final int WIDTH = 300;
		final int HEIGHT = 230;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		// alternative to 103-105: aFrame.setSize(300, 200);
	}
}