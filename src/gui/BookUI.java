package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;

import model.Book;
import model.Cat;
import model.Pub;
import dao.CatDao;
import dao.impl.BookImpl;
import dao.impl.CatImpl;
import dao.impl.PubImpl;
/**
 * @author ggg
 *
 */
public class BookUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel label_8;
	BookImpl bookdao = new BookImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUI window = new BookUI();
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
	public BookUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("图书进存销系统");
		frame.setBounds(100, 100, 674, 754);
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
		
		JLabel label_9 = new JLabel("书名：");
		label_9.setBounds(78, 36, 72, 18);
		frame.getContentPane().add(label_9);
		
		JButton button = new JButton("查询全部");
		button.setBounds(516, 32, 113, 27);
		frame.getContentPane().add(button);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(131, 35, 247, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_4 = new JButton("查询");
		button_4.setBounds(389, 32, 113, 27);
		frame.getContentPane().add(button_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 72, 628, 288);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {

		}, new String[] { "\u4E66\u672C\u540D\u79F0", "\u7B80\u4ECB",
				"\u4F5C\u8005", "\u79CD\u7C7B", "\u51FA\u7248\u793E",
				"\u5E93\u5B58", "\u4EF7\u683C" });
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(14, 373, 628, 321);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("书本名称：");
		label_1.setBounds(14, 24, 84, 18);
		panel.add(label_1);

		textField = new JTextField();
		textField.setBounds(87, 21, 108, 24);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("价格：");
		label_2.setBounds(228, 24, 72, 18);
		panel.add(label_2);

		JLabel label_3 = new JLabel("作者：");
		label_3.setBounds(383, 24, 72, 18);
		panel.add(label_3);

		textField_1 = new JTextField();
		textField_1.setBounds(273, 21, 86, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(432, 21, 125, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel label_4 = new JLabel("所属种类：");
		label_4.setBounds(14, 73, 84, 18);
		panel.add(label_4);

		// 开始获取书种类
		CatImpl catdao = new CatImpl();
		List<Cat> listcat = catdao.queryAllCat();

		// 种类
		JComboBox comboBox = new JComboBox(listcat.toArray());
		comboBox.setBounds(97, 70, 115, 24);
		panel.add(comboBox);

		JLabel label_5 = new JLabel("出版社：");
		label_5.setBounds(228, 73, 72, 18);
		panel.add(label_5);

		// 开始获取出版社种类
		PubImpl pubdao = new PubImpl();
		List<Pub> listpub = pubdao.queryAllPub();

		// 出版社
		JComboBox comboBox_1 = new JComboBox(listpub.toArray());
		comboBox_1.setBounds(293, 70, 108, 24);
		panel.add(comboBox_1);

		JLabel label_6 = new JLabel("书本简介：");
		label_6.setBounds(14, 125, 84, 18);
		panel.add(label_6);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(14, 153, 288, 125);
		panel.add(textArea_1);

		JLabel label_7 = new JLabel("书本图片：");
		label_7.setBounds(415, 73, 86, 18);
		panel.add(label_7);

		JButton button_1 = new JButton("提交");
		button_1.setBounds(176, 291, 113, 27);
		panel.add(button_1);

		// 提交的监听
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textField.getText();
				float price = Float.valueOf(textField_1.getText());
				String author = textField_2.getText();
				Cat cat = (Cat) comboBox.getSelectedItem();
				Pub pub = (Pub) comboBox_1.getSelectedItem();
				String des = textArea_1.getText();

				Book book = new Book();
				book.setName(name);
				book.setPrice(price);
				book.setAuthor(author);
				book.setDes(des);
				book.setCid(cat.getId());
				book.setPid(pub.getId());

				if (bookdao.addMes(book)) {
					JOptionPane.showMessageDialog(null, "成功");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textArea_1.setText("");
					label_8.setIcon(null);
				} else {
					JOptionPane.showMessageDialog(null, "失败");
				}
			}
		});

		/**
		 * 查询全部的监听
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// List<Cat> catList = catdao.queryAllCat();
				// JComboBox comboBox = new JComboBox(catList.toArray());
				// List<Pub> pubList = pubdao.queryAllPub();
				// JComboBox comboBox_1 = new JComboBox(pubList.toArray());

				/**
				 * 清空
				 */
				model.getDataVector().clear();
				/**
				 * 查询所有的用户信息
				 */
				List<Book> list = bookdao.queryAll();
				/**
				 * 遍历每一条数据，添加到model中
				 */
				int i = 0;
				for (Book book : list) {
					/**
					 * 种类数据
					 */
					// comboBox.setSelectedItem(new Cat(book.getCid()));
					CatImpl catdao = new CatImpl();
					Cat cat = catdao.queryOneCat(book.getCid());

					/**
					 * 出版社数据
					 */
					PubImpl pubdao = new PubImpl();
					Pub pub = pubdao.queryOnePub(book.getPid());

					// comboBox_1.setSelectedItem(new Pub(book.getPid()));
					/**
					 * 添加行数据
					 */
					model.addRow(new Object[] { book.getName(), book.getDes(),
							book.getAuthor(), cat.getCat_name(),
							pub.getPub_name(), book.getCount(), book.getPrice() });
				}
			}
		});
		JButton button_2 = new JButton("清空");
		button_2.setBounds(318, 291, 113, 27);
		panel.add(button_2);

		label_8 = new JLabel();
		label_8.setBounds(318, 125, 300, 150);
		panel.add(label_8);
		/**
		 * 清空按钮
		 */
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea_1.setText("");
				label_8.setIcon(null);
				textField_3.setText("");
				int rows = model.getRowCount() - 1;
				for (; rows >= 0; rows--) {
					model.removeRow(rows);
				}
			}
		});

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));

		JButton button_3 = new JButton("选择图片");
		button_3.setBounds(499, 69, 115, 27);
		panel.add(button_3);

		/**
		 * 选择图片的监听
		 */
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
					label_8.setIcon(new ImageIcon(name));
					System.out.println(name);
				}
			}
		});
		/**
		 * 查询的监听
		 */
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textField_3.getText();
				
				model.getDataVector().clear();
				BookImpl bookdao= new BookImpl();
				List<Book> list = bookdao.queryOne(name);
				int i = 0;
				for (Book book : list) {
					/**
					 * 种类数据
					 */
					// comboBox.setSelectedItem(new Cat(book.getCid()));
					CatImpl catdao = new CatImpl();
					Cat cat = catdao.queryOneCat(book.getCid());

					/**
					 * 出版社数据
					 */
					PubImpl pubdao = new PubImpl();
					Pub pub = pubdao.queryOnePub(book.getPid());

					// comboBox_1.setSelectedItem(new Pub(book.getPid()));
					/**
					 * 添加行数据
					 */
					model.addRow(new Object[] { book.getName(), book.getDes(),
							book.getAuthor(), cat.getCat_name(),
							pub.getPub_name(), book.getCount(), book.getPrice() });
				}
			}
		});
	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
