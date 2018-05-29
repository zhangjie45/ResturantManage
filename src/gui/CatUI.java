package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import model.Cat;
import model.lay_user;
import dao.impl.CatImpl;


/**
 * @author ggg
 *
 */
public class CatUI {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	CatImpl catdao = new CatImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatUI window = new CatUI();
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
	public CatUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书进存销管理系统");
		frame.setBounds(100, 100, 515, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 278, 456, 233);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("种类：");
		label.setBounds(14, 45, 72, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(60, 42, 367, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("名称：");
		lblNewLabel.setBounds(57, 28, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(100, 25, 147, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_3 = new JButton("查询");
		button_3.setBounds(250, 24, 113, 27);
		frame.getContentPane().add(button_3);
		JLabel label_1 = new JLabel("简介：");
		label_1.setBounds(14, 91, 72, 18);
		panel.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 89, 367, 82);
		panel.add(textArea);
		
		JButton button = new JButton("提交");
		button.setBounds(92, 174, 113, 27);
		panel.add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.setBounds(247, 174, 113, 27);
		panel.add(button_1);
		
		
		
		//表单数据
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 59, 469, 206);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		// 初始化存储表格数据的对象
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {},new String[] {"种类", "简介"});
		// 将数据绑定到对象中
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(132);
		table.getColumnModel().getColumn(1).setPreferredWidth(221);
		
		
		
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
		//查询按钮
		JButton button_2 = new JButton("查询全部");
		button_2.setBounds(370, 24, 113, 27);
		frame.getContentPane().add(button_2);
		
		//查询全部监听
		button_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.getDataVector().clear();
				// 查询所有的用户信息
				List<Cat> list = catdao.queryAll();
				// 遍历每一条数据，添加到model中
				int i = 0;
				for (Cat cat : list) {
					// 添加 行数据
					model.addRow(new Object[] { cat.getCat_name(), cat.getDes()});
				}
			}

	
		});
		//重置按钮
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
				textArea.setText("");
				textField_1.setText("");
				int rows =model.getRowCount()-1;
				for(;rows>=0;rows--){
					model.removeRow(rows);
				}
			}
		});
		
			//查询按钮监听
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				
				CatImpl catdao=new CatImpl();
				List<Cat> list=catdao.queryOne(name);
				int i = 0;
				for (Cat cat : list) {
					// 添加 行数据
					model.addRow(new Object[] { cat.getCat_name(), cat.getDes()});
				}
			}
		});
			
			
			
			//提交按钮的监听
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textField.getText();
				String des = textArea.getText();
				Cat cat = new Cat();
				cat.setCat_name(name);
				cat.setDes(des);
				if(catdao.addCat(cat))
				{	
					JOptionPane.showMessageDialog(null, "成功");
					textArea.setText("");
					textField.setText("");

				}
				else
				{
                    System.out.println("失败");				
                    }
			}			
			
		});
			}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

		
	
	}	


		
		
	
