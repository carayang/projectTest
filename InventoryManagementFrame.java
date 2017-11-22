package project;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.*;

public class InventoryManagementFrame extends JFrame {
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel idAlertLabel;
	private JTextField test;

	public InventoryManagementFrame() {
		super();
		createCompoments();
		createPanel();
		addListeners();
		makeThisVisible();
	}

	private void addListeners() {
		idTextField.addKeyListener(new VIDListener());
	}

	private void createCompoments() {
		idLabel = new JLabel("ID");
		idTextField = new JTextField(10);
		idAlertLabel = new JLabel("ID's length should be 10, only number.");
		idAlertLabel.setForeground(Color.red);
		idSetTrue();
		test =  new JTextField(10);
	}

	private void createPanel() {
		JPanel componetsPanel = new JPanel();
		componetsPanel.add(idLabel);
		componetsPanel.add(idTextField);
		componetsPanel.add(idAlertLabel);
		componetsPanel.add(test);
		this.add(componetsPanel);
	}

	private void makeThisVisible() {
		this.setSize(500, 500);
		this.setVisible(true);
	}

	private void idSetWrong() {
		idTextField.setBorder(new LineBorder(Color.red));
		idAlertLabel.setVisible(true);
	}

	private void idSetTrue() {
		idTextField.setBorder(new LineBorder(Color.black));
		idAlertLabel.setVisible(false);
	}

	private class VIDListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			int keyInput = e.getKeyChar();
			if (keyInput < KeyEvent.VK_0 || keyInput > KeyEvent.VK_9) {
				idSetWrong();
				e.consume();// invalid input will be eliminated
			}
			String str = idTextField.getText();// button from UI
			if (str.length() > 9) {
				idSetWrong();
				e.consume();// invalid input will be eliminated
			}
		}
	}
}
