package fr.plx0wn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class Main {

	public static void main(String[] args) {
		displayFrame();
	}

	public static void displayFrame() {
		// FRAME
		JFrame frame = new JFrame("KeyCreator - By Plx0wn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(new Dimension(500, 300));
		frame.setResizable(false);

		// JPANEL
		JPanel container = new JPanel(new BorderLayout());
		JPanel panOptions = new JPanel(new BorderLayout());
		JPanel panOutput = new JPanel(new BorderLayout());
		JPanel panLeft = new JPanel(new BorderLayout());
		panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panRight = new JPanel(new BorderLayout());
		panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panBottom = new JPanel();
		panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panKey = new JPanel();
		panKey.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		panLeft.setBorder(BorderFactory.createTitledBorder("Letters Options"));
		panRight.setBorder(BorderFactory.createTitledBorder("Numbers Options"));

		panOptions.add(panLeft, BorderLayout.EAST);
		panOptions.add(panRight, BorderLayout.WEST);
		panOptions.add(panBottom, BorderLayout.SOUTH);

		panOutput.add(panKey);

		container.add(panOptions, BorderLayout.NORTH);
		container.add(panOutput, BorderLayout.SOUTH);

		// CONTENTS

		JCheckBox optionLetters = new JCheckBox("Letters");
		optionLetters.setSelected(true);
		JCheckBox optionNumbers = new JCheckBox("Numbers");
		optionNumbers.setSelected(true);
		JCheckBox optionUppercases = new JCheckBox("Uppercases");
		optionUppercases.setSelected(true);
		JCheckBox optionSpecials = new JCheckBox("Special Characters");

		JButton keyGenButton = new JButton("Generate Key");
		// JButton spoilerLettersOptionsButton = new JButton("Letters Options");
		// JButton spoilerNumbersOptionsButton = new JButton("Numbers Options");

		JLabel key = new JLabel();
		JLabel keyCopied = new JLabel();

		JTextField keyGenSize = new JTextField(10);
		keyGenSize.setText("32");

		panLeft.add(optionLetters, BorderLayout.NORTH);
		panLeft.add(optionUppercases, BorderLayout.CENTER);
		panLeft.add(optionSpecials, BorderLayout.AFTER_LAST_LINE);

		panRight.add(optionNumbers, BorderLayout.NORTH);
		panRight.add(keyGenSize, BorderLayout.AFTER_LINE_ENDS);

		panBottom.add(keyGenButton);

		panKey.add(key, BorderLayout.NORTH);
		panKey.add(keyCopied, BorderLayout.CENTER);

		// STYLE
		Color green = new Color(78, 173, 57);
		Color red = new Color(197, 65, 65);
		Color blue = new Color(57, 169, 173);
		Color gray = new Color(209, 209, 209);
		Color yellow = new Color(184, 184, 56);

		keyGenButton.setBackground(green);
		keyGenButton.setBorderPainted(false);
		keyGenButton.setForeground(Color.WHITE);

		optionUppercases.setBackground(blue);
		optionUppercases.setForeground(Color.WHITE);
		optionLetters.setBackground(blue);
		optionLetters.setForeground(Color.WHITE);
		optionSpecials.setBackground(blue);
		optionSpecials.setForeground(Color.WHITE);
		optionNumbers.setBackground(blue);
		optionNumbers.setForeground(Color.WHITE);

		keyGenSize.setBorder(null);
		keyGenSize.setBackground(gray);

		container.setBackground(Color.white);

		frame.setContentPane(container);
		frame.pack();
		frame.setVisible(true);

		// EVENTS
		keyGenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean letters = optionLetters.isSelected();
				boolean numbers = optionNumbers.isSelected();
				boolean uppercases = optionUppercases.isSelected();
				boolean specials = optionSpecials.isSelected();
				String str = keyGenSize.getText().replace(" ", "");

				if (letters == false && numbers == false) {
					key.setForeground(Color.red);
					key.setText("Choose a minimum of one option.");
					keyCopied.setText("");
					frame.pack();
				} else {
					try {
						int size = Integer.parseInt(str);
						key.setForeground(Color.black);
						key.setText(CreateKey.KeyGenerator(size, numbers, letters, specials, uppercases));
						keyCopied.setForeground(Color.blue);
						keyCopied.setText("Copied on clipboard.");
						frame.pack();

					} catch (Exception ex) {
						ex.printStackTrace();
						key.setForeground(Color.red);
						key.setText("Only numbers are allowed.");
						keyCopied.setText("");
						keyGenSize.setText(keyGenSize.getText());
						frame.pack();
					}
				}

			}
		});
	}

}
