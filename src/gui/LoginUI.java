package gui;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.impl.UserDaoImpl;
import model.lay_user;

/**
 * @author ggg
 *
 */
public class LoginUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	UserDaoImpl userdao = new UserDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
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
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书进存销系统");
		frame.setBounds(100, 100, 420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("账户：");
		label.setBounds(55, 75, 72, 18);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(111, 72, 260, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(55, 145, 72, 18);
		frame.getContentPane().add(label_1);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(111, 142, 260, 24);
		frame.getContentPane().add(passwordField);

		JButton button = new JButton("登录");
		button.setBounds(258, 199, 113, 27);
		frame.getContentPane().add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = textField.getText();
				String upass = String.valueOf(passwordField.getPassword());
				lay_user usr = new lay_user();
				usr.setName(name);
				usr.setPassword(upass);
				if (userdao.QueryByName(name) != null) {
					JOptionPane.showMessageDialog(null, "成功");
					frame.setVisible(false);
					BuyUI buyui = new BuyUI();
					buyui.setVisible(true);
				} else {
					System.out.println("失败");
				}
			}

		});

	}

}
