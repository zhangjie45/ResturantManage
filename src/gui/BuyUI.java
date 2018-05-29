package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Book;
import model.Buy;
import model.InRecord;
import dao.impl.BookImpl;
import dao.impl.BuyImpl;
import dao.impl.InRecordImpl;
/**
 * @author gg
 *
 */
public class BuyUI {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int num_all=0;
	private float price_all=0;
	DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyUI window = new BuyUI();
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
	public BuyUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书进存销系统");
		frame.setBounds(100, 100, 611, 632);
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

		JButton button = new JButton("查询全部");
		button.setBounds(466, 13, 113, 27);
		frame.getContentPane().add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 47, 565, 224);
		frame.getContentPane().add(scrollPane);

		// 表1
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { " \u8D2D\u4E70\u4E66\u672C", "\u603B\u4EF7",
						"\u4EA4\u6613\u65E5\u671F", "购买总数量" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 323, 565, 157);
		frame.getContentPane().add(scrollPane_1);

		// 表2
		table_1 = new JTable();
		DefaultTableModel model_1 = new DefaultTableModel(new Object[][] {},
				new String[] { "\u4E66\u540D", "\u5355\u4EF7", "\u6570\u91CF" });
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);
		JLabel label_1 = new JLabel("书本：");
		label_1.setBounds(14, 493, 72, 18);
		frame.getContentPane().add(label_1);

		/**
		 * 获取书名称
		 */
		BookImpl bookdao = new BookImpl();
		List<Book> listbook = bookdao.queryAllBookname();

		JComboBox comboBox = new JComboBox(listbook.toArray());
		comboBox.setBounds(56, 490, 85, 24);
		frame.getContentPane().add(comboBox);

		JLabel label_2 = new JLabel("数量：");
		label_2.setBounds(147, 493, 72, 18);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(185, 490, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		
		
		JButton button_5 = new JButton("查询");
		button_5.setBounds(356, 13, 101, 27);
		frame.getContentPane().add(button_5);
		
		JLabel label_13 = new JLabel("日期：");
		label_13.setBounds(129, 17, 72, 18);
		frame.getContentPane().add(label_13);
		
		//日期选择
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(185, 14, 159, 24);
		dateChooser1.register(textField_1);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel label_3 = new JLabel("单价：");
		label_3.setBounds(272, 493, 72, 18);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(319, 493, 38, 18);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("库存：");
		label_5.setBounds(364, 493, 72, 18);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setBounds(396, 493, 40, 18);
		frame.getContentPane().add(label_6);

		JButton button_1 = new JButton("增加");
		button_1.setBounds(441, 489, 62, 27);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.setBounds(517, 489, 62, 27);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("成交");
		button_3.setBounds(140, 533, 113, 27);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("清空");
		button_4.setBounds(295, 533, 113, 27);
		frame.getContentPane().add(button_4);

		JLabel label_7 = new JLabel("总价：");
		label_7.setBounds(14, 284, 72, 18);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setBounds(70, 284, 85, 18);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel("交易日期：");
		label_9.setBounds(154, 284, 85, 18);
		frame.getContentPane().add(label_9);

		/**
		 * 日期设置
		 * 
		 */
		JLabel label_10 = new JLabel("");
		label_10.setBounds(231, 284, 126, 18);
		frame.getContentPane().add(label_10);
		label_10.setText(sdf.format(new Date()));

		JLabel label_11 = new JLabel("数量：");
		label_11.setBounds(364, 284, 72, 18);
		frame.getContentPane().add(label_11);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(416, 284, 113, 18);
		frame.getContentPane().add(label_12);
		/**
		 * 默认combox值
		 * 
		 */
		Object name_book = comboBox.getSelectedItem();
		String namebook_1 = String.valueOf(name_book);
		BuyImpl buydao = new BuyImpl();
		// InRecord inrecord=new InRecord();
		int bookcount = (buydao.QueryPriceCountByName(namebook_1))
				.getBookcount();
		float bookprice = (buydao.QueryPriceCountByName(namebook_1)).getPrice();

		String bookcount_1 = String.valueOf(bookcount);
		String bookprice_1 = String.valueOf(bookprice);

		label_4.setText(bookprice_1);
		label_6.setText(bookcount_1);
		/**
		 * checkbox的监听器
		 */
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object name_book = comboBox.getSelectedItem();
				String namebook_1 = String.valueOf(name_book);
				BuyImpl buydao = new BuyImpl();
				// InRecord inrecord=new InRecord();
				int bookcount = (buydao.QueryPriceCountByName
				(namebook_1)).getBookcount();
				float bookprice = (buydao.QueryPriceCountByName(namebook_1))
						.getPrice();

				String bookcount_1 = String.valueOf(bookcount);
				String bookprice_1 = String.valueOf(bookprice);

				label_4.setText(bookprice_1);
				label_6.setText(bookcount_1);

			}

		});
		
		/** 增加按钮监听
		 * 
		 */
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object namebook = comboBox.getSelectedItem();
				String namebook_1 = String.valueOf(namebook);
				String num = textField.getText();
				BuyImpl buydao = new BuyImpl();
				float bookprice = (buydao.QueryPriceCountByName(namebook_1)).getPrice();
				String bookprice_1 = String.valueOf(bookprice);
				model_1.addRow(new Object[] {namebook_1,bookprice_1,num});
				
				int num_1=Integer.valueOf(num);
				num_all+=num_1;
				
				label_12.setText(String.valueOf(num_all));
				
				float center;
				center = bookprice*num_1;
				price_all+=center;
				label_8.setText(String.valueOf(price_all));
			}
		});
		
		/** 删除按钮的监听
		 * 
		 */
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table_1.getSelectedRowCount() <= 0) {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据行");
					return;
				}
				int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");
				// 判断用户是否点击
				if (result == JOptionPane.OK_OPTION) {
					/** 数量删除
					 * 
					 */
					int num_2 = Integer.valueOf(table_1.getValueAt(
							table_1.getSelectedRow(), 2).toString());
					int num_3 = num_all;
					int num_new = num_3 - num_2;
					num_all=num_new;
					String new1 = String.valueOf(num_new);
					label_12.setText(new1);
					
					/** 价格改变
					 * 
					 */
					float price_2=Float.valueOf(table_1.getValueAt(
							table_1.getSelectedRow(), 1).toString());
					float price_center = price_2 * num_2;
					price_all-=price_center;
					label_8.setText(String.valueOf(price_all));
					model_1.removeRow(table_1.getSelectedRow());
				}
				
			}
		});
		
		/** 成交按钮监听
		 *  添加总价格，购买数量，书名到数据库
		 */
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				BuyImpl buydao= new BuyImpl();
				InRecordImpl inrecorddao= new InRecordImpl();
				for(;i<table_1.getRowCount();i++){
					
					
					//获取减少数量
					int num_insert = Integer.valueOf(table_1.getValueAt(i, 2).toString());
					//获取名字
					String name_insert =table_1.getValueAt(i, 0).toString();
					//System.out.println(name_insert+"-----"+num_insert);
					//获取原有数量
					int bookcount = (inrecorddao.QueryByName(name_insert)).getNum();
					//更新数量
					int book_new=bookcount-num_insert;
					
					
					//获取价格
					float price_2=Float.valueOf(table_1.getValueAt(
							i, 1).toString());
					float price_3=price_2*num_insert;
					
					
					//执行操作
					if(buydao.InsertPriceName(name_insert, num_insert,price_3, book_new)!=0)
					{
						JOptionPane.showMessageDialog(null, "成功");
						int rows_1 =model_1.getRowCount()-1;
						for(;rows_1>=0;rows_1--){
							model_1.removeRow(rows_1);
						}
						textField.setText("");
						label_12.setText("0");
					}
					else 
						JOptionPane.showMessageDialog(null, "失败");
				}
				
			}
				
		});
		
		/**查询全部按钮监听
		 * 
		 */
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 清空
				model.getDataVector().clear();
				// 查询所有的用户信息
				List<Buy> list = buydao.queryAllrecord();
				// 遍历每一条数据，添加到model中
				int i = 0;
				for (Buy buy : list) {

					// 添加行数据
					model.addRow(new Object[] { buy.getName(),
							buy.getPrice(),buy.getBut_date(), buy.getBuy_num() });
				}
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rows =model.getRowCount()-1;
				for(;rows>=0;rows--){
					model.removeRow(rows);
				}
				int rows_1 =model_1.getRowCount()-1;
				for(;rows_1>=0;rows_1--){
					model_1.removeRow(rows_1);
				}
				label_12.setText("");
				label_8.setText("");
				label_4.setText("");
				label_6.setText("");
				textField.setText("");
				textField_1.setText("");
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String date=textField_1.getText();
//				System.out.println(date);
				int rows =model.getRowCount()-1;
				for(;rows>=0;rows--){
					model.removeRow(rows);
				}
				BuyImpl buydao=new BuyImpl();
				List<Buy> list=buydao.queryOne(date);
				int i = 0;
				for (Buy buy : list) {

					// 添加行数据
					model.addRow(new Object[] { buy.getName(),
							buy.getPrice(),buy.getBut_date(), buy.getBuy_num() });
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
