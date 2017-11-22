import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class InventoryManagementFrame extends JFrame {
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel idAlertLabel;
	private JLabel webIdLabel;
	private JTextField webIdTextField;
	private JLabel webIdAlertLabel;
	private JLabel priceLabel;
	private JTextField priceTextField;
	private JLabel priceAlertLabel;

	public InventoryManagementFrame() {
		super();
		createCompoments();
		createPanel();
		addListeners();
		makeThisVisible();
	}

	private void addListeners() {
		idTextField.addKeyListener(new VIDListener());
		idTextField.setInputVerifier(new VehicleIDVerifier());
	}

	private void createCompoments() {
		idLabel = new JLabel("ID");
		idTextField = new JTextField(10);
		idAlertLabel = new JLabel("ID's length should be 10, only number.");
		idSetTrue();
		priceLabel = new JLabel("Price");
		priceTextField = new JTextField(10);
		priceAlertLabel = new JLabel("Price should be integer.");
		priceSetTrue();
		webIdLabel = new JLabel("WebID");
		webIdTextField = new JTextField(20);
		webIdAlertLabel = new JLabel("Split by \"-\".");
		webIdSetTrue();
	}

	private void createPanel() {
		JPanel componetsPanel = new JPanel();
		componetsPanel.add(idLabel);
		componetsPanel.add(idTextField);
		componetsPanel.add(idAlertLabel);
		componetsPanel.add(webIdLabel);
		componetsPanel.add(webIdTextField);
		componetsPanel.add(webIdAlertLabel);
		componetsPanel.add(priceLabel);
		componetsPanel.add(priceTextField);
		componetsPanel.add(priceAlertLabel);
		this.add(componetsPanel);
	}

	private void makeThisVisible() {
		this.setSize(500, 500);
		this.setVisible(true);
	}

	private void idSetWrong() {
		idTextField.setBorder(new LineBorder(Color.red));
		idAlertLabel.setForeground(Color.red);
	}

	private void idSetTrue() {
		idTextField.setBorder(new LineBorder(Color.black));
		idAlertLabel.setForeground(Color.black);
	}
	private void webidSetWrong() {
		webIdTextField.setBorder(new LineBorder(Color.red));
		webIdAlertLabel.setForeground(Color.red);
	}

	private void webIdSetTrue() {
		webIdTextField.setBorder(new LineBorder(Color.black));
		webIdAlertLabel.setForeground(Color.black);
	}

	private void priceSetTrue() {
		priceTextField.setBorder(new LineBorder(Color.black));
		priceAlertLabel.setForeground(Color.black);
	}

	private void priceSetFalse() {
		priceTextField.setBorder(new LineBorder(Color.red));
		priceAlertLabel.setForeground(Color.red);
	}

	public class VehicleIDVerifier extends InputVerifier {

		public boolean verify(JComponent input) {
			String vid = ((JTextField) input).getText();
			if (vid.length() == 10) {
				return true;
			} else {
				return false;
			}
		}

		public boolean shouldYieldFocus(JComponent input) {
			boolean valid = verify(input);
			if (!valid) {
				idSetWrong();
			} else {
				idSetTrue();
			}
			return valid;
		}
	}
}
