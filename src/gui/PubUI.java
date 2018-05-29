package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Cat;
import model.Pub;
import dao.impl.PubImpl;
/**
 * @author ggg
 *
 */
public class PubUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	PubImpl pubdao = new PubImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PubUI window = new PubUI();
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
	public PubUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书进存销系统");
		frame.setBounds(100, 100, 494, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(14, 8, 38, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("系统");
		menu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("书本种类");
		menu.add(menuItem);
		
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				frame.setVisible(false);
				CatUI catui=new CatUI();
				catui.setVisible(true);
			}
		}); 
		
		
		JMenuItem menuItem_1 = new JMenuItem("出版社种类");
		menu.add(menuItem_1);
		
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PubUI pubui=new PubUI();
				pubui.setVisible(true);
			}
		});
		JMenuItem menuItem_2 = new JMenuItem("书籍信息");
		menu.add(menuItem_2);
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				BookUI bookui=new BookUI();
				bookui.setVisible(true);
				
			}
		});
		
		
		JMenuItem menuItem_3 = new JMenuItem("购买");
		menu.add(menuItem_3);
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				BuyUI buyui=new BuyUI();
				buyui.setVisible(true);
			}
		});
		
		
		
		JMenuItem menuItem_4 = new JMenuItem("入库信息");
		menu.add(menuItem_4);
		menuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				gui.InRecord inrecordui=new gui.InRecord();
				inrecordui.setVisible(true);

			}
		});
		
		
		
		
		JMenuItem menuItem_5 = new JMenuItem("退出");
		menu.add(menuItem_5);
		menuItem_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				
			}
		});

		JButton button = new JButton("查询所有");
		button.setBounds(335, 28, 113, 27);
		frame.getContentPane().add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		scrollPane.setBounds(14, 70, 448, 218);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {

		}, new String[] { "\u51FA\u7248\u793E\u540D\u79F0",
				"\u8054\u7CFB\u4EBA", "\u8054\u7CFB\u7535\u8BDD",
				"\u7B80\u4ECB" });
		table.setModel(model);

		JPanel panel = new JPanel();
		panel.setBounds(14, 294, 448, 242);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("出版社名称：");
		label_1.setBounds(14, 25, 97, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("联系人：");
		label_2.setBounds(14, 67, 72, 18);
		panel.add(label_2);

		JLabel label_3 = new JLabel("联系电话：");
		label_3.setBounds(228, 67, 84, 18);
		panel.add(label_3);

		JButton button_3 = new JButton("查询");
		button_3.setBounds(242, 28, 91, 27);
		frame.getContentPane().add(button_3);
		
		JLabel label_5 = new JLabel("名称：");
		label_5.setBounds(57, 32, 72, 18);
		frame.getContentPane().add(label_5);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(99, 29, 129, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("简介：");
		label_4.setBounds(14, 117, 72, 18);
		panel.add(label_4);
		// 简介
		JTextArea textArea = new JTextArea();
		textArea.setBounds(62, 115, 372, 80);
		panel.add(textArea);
		// 出版社名称
		textField = new JTextField();
		textField.setBounds(106, 22, 328, 24);
		panel.add(textField);
		textField.setColumns(10);
		// 联系人
		textField_1 = new JTextField();
		textField_1.setBounds(78, 64, 136, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		// 联系电话
		textField_2 = new JTextField();
		textField_2.setBounds(305, 64, 129, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);

		// 查询监听
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.getDataVector().clear();
				// 查询所有的用户信息
				List<Pub> list = pubdao.queryAll();
				// 遍历每一条数据，添加到model中
				int i = 0;
				for (Pub pub : list) {
					// 添加 行数据
					model.addRow(new Object[] { pub.getPub_name(),
							pub.getPub_preson(), pub.getPub_tel(),
							pub.getPub_des() });
				}
			}

		});

		JButton button_1 = new JButton("提交");
		button_1.setBounds(101, 202, 113, 27);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pubname = textField.getText();
				String person = textField_1.getText();
				String tel = textField_2.getText();
				String des = textArea.getText();

				Pub pub = new Pub();
				pub.setPub_name(pubname);
				pub.setPub_preson(person);
				pub.setPub_tel(tel);
				pub.setPub_des(des);
				if (pubdao.addPub(pub)) {
					JOptionPane.showMessageDialog(null, "成功");
					textArea.setText("");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");

				} else {
					System.out.println("失败");
				}
			}

		});

		JButton button_2 = new JButton("清空");
		button_2.setBounds(252, 202, 113, 27);
		panel.add(button_2);
		//重置按钮
				button_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textArea.setText("");
						int rows =model.getRowCount()-1;
						for(;rows>=0;rows--){
							model.removeRow(rows);
						}
						
					}
				});
				
				button_3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name=textField_3.getText();
						PubImpl pubdao=new PubImpl();
						List<Pub> list=pubdao.queryOne(name);
						
						int i = 0;
						for (Pub pub : list) {
							// 添加 行数据
							model.addRow(new Object[] { pub.getPub_name(),
									pub.getPub_preson(), pub.getPub_tel(),
									pub.getPub_des() });
						}
					}
				});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
