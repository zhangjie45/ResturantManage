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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.border.LineBorder;

import dao.impl.BookImpl;
import dao.impl.CatImpl;
import dao.impl.InRecordImpl;
import model.Book;
import model.Cat;
import model.Pub;

/**
 * @author ggg
 *
 */
public class InRecord {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	InRecordImpl inrecorddao = new InRecordImpl();
	int numAll = 0;
	DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InRecord window = new InRecord();
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
	public InRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书进存销系统");
		frame.setBounds(100, 100, 560, 679);
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
		button.setBounds(415, 32, 113, 27);
		frame.getContentPane().add(button);

		JButton button_4 = new JButton("查询");
		button_4.setBounds(295, 32, 113, 27);
		frame.getContentPane().add(button_4);
		
		JLabel label_8 = new JLabel("日期：");
		label_8.setBounds(49, 36, 72, 18);
		frame.getContentPane().add(label_8);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(99, 33, 182, 24);
		dateChooser1.register(textField_1);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 67, 514, 232);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {

		}, new String[] { "\u5165\u5E93\u4E66\u672C",
				"\u5165\u5E93\u65E5\u671F", "\u5165\u5E93\u6570\u91CF" });
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(14, 312, 514, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 45, 514, 176);
		panel.add(scrollPane_1);
		/**
		 *  表二
		 */
		table_1 = new JTable();
		DefaultTableModel model_1 = new DefaultTableModel(new Object[][] {},
				new String[] { "\u4E66\u540D", "\u5355\u4EF7", "\u6570\u91CF" });
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);

		JLabel lblNewLabel = new JLabel("入库日期：");
		lblNewLabel.setBounds(0, 13, 81, 18);
		panel.add(lblNewLabel);

		JLabel label_1 = new JLabel("总数量：");
		label_1.setBounds(247, 13, 72, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("书本：");
		label_2.setBounds(10, 237, 72, 18);
		panel.add(label_2);

		/**
		 *  获取书名称
		 */
		BookImpl bookdao = new BookImpl();
		List<Book> listbook = bookdao.queryAllBookname();

		JComboBox comboBox = new JComboBox(listbook.toArray());
		comboBox.setBounds(59, 234, 89, 24);
		panel.add(comboBox);

		//comboBox.setSelectedItem();
		/**
		 *  获取名字
		 */
		Object namebook = comboBox.getSelectedItem();
		String namebook_1 = String.valueOf(namebook);
		InRecordImpl inrecorddao = new InRecordImpl();
		// InRecord inrecord=new InRecord();
		int bookcount = (inrecorddao.QueryByName(namebook_1)).getNum();
		String bookcount_1 = String.valueOf(bookcount);

		/**
		 * 显示库存数量
		 */
		JLabel label_7 = new JLabel("");
		label_7.setBounds(334, 237, 32, 18);
		panel.add(label_7);

		label_7.setText(bookcount_1);

		/**
		 *  checkbox的监听器
		 */
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object namebook = comboBox.getSelectedItem();
				String namebook_1 = String.valueOf(namebook);
				InRecordImpl inrecorddao = new InRecordImpl();
				// InRecord inrecord=new InRecord();
				int bookcount = (inrecorddao.QueryByName(namebook_1)).getNum();
				String bookcount_1 = String.valueOf(bookcount);
				label_7.setText(bookcount_1);

			}

		});

		JLabel label_3 = new JLabel("数量：");
		label_3.setBounds(154, 237, 72, 18);
		panel.add(label_3);

		textField = new JTextField();
		textField.setBounds(195, 234, 96, 24);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_4 = new JLabel("库存：");
		label_4.setBounds(293, 237, 72, 18);
		panel.add(label_4);

		JButton button_1 = new JButton("增加");
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(366, 233, 72, 27);
		panel.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(442, 234, 72, 27);
		panel.add(button_2);

		JButton button_3 = new JButton("入库");
		button_3.setBounds(124, 271, 113, 27);
		panel.add(button_3);

		JButton btnNewButton = new JButton("清空");
		btnNewButton.setBounds(293, 271, 113, 27);
		panel.add(btnNewButton);

		/**
		 *  显示时间
		 */
		JLabel label_5 = new JLabel("");
		label_5.setBackground(Color.LIGHT_GRAY);
		label_5.setBounds(76, 14, 157, 18);
		panel.add(label_5);
		label_5.setText(sdf.format(new Date()));

		/**
		 * 显示数量
		 */
		JLabel label_6 = new JLabel("");
		label_6.setBackground(Color.LIGHT_GRAY);
		label_6.setBounds(310, 13, 157, 18);
		panel.add(label_6);

		/**
		 * 增加的监听
		 */
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object namebook = comboBox.getSelectedItem();
				String namebook_1 = String.valueOf(namebook);
				String num = textField.getText();
				InRecordImpl inrecorddao = new InRecordImpl();
				float price = (inrecorddao.QueryPriceByName(namebook_1))
						.getPrice();

				
				int haoma = Integer.valueOf(num);

				model_1.addRow(new Object[] { namebook_1, price, haoma });

				int num_1 = Integer.valueOf(num);
				numAll+=num_1;
				String num_value = String.valueOf(numAll);
				label_6.setText(num_value);
			}
		});
		
		
		/**
		 * 删除按钮的监听
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
					
					int num_2 = Integer.valueOf(table_1.getValueAt(
							table_1.getSelectedRow(), 2).toString());
					int num_3 = Integer.valueOf(numAll);
					 numAll = num_3 - num_2;
					
					String new1 = String.valueOf(numAll);
					label_6.setText(new1);
					
					model_1.removeRow(table_1.getSelectedRow());
				}
			}

		});

		/**
		 *  查询全部的监听
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 清空
				model.getDataVector().clear();
				// 查询所有的用户信息
				List<model.InRecord> list = inrecorddao.queryAllrecord();
				// 遍历每一条数据，添加到model中
				int i = 0;
				for (model.InRecord inrecord : list) {

					// 添加行数据
					model.addRow(new Object[] { inrecord.getName(),
							inrecord.getDate(), inrecord.getNum() });
				}
			}
		});
		
		/** 
		 *插入数量 到数据库中
		 */
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				InRecordImpl inrecorddao= new InRecordImpl();
				for(;i<table_1.getRowCount();i++){
					//获取增加数量
					int num_insert = Integer.valueOf(table_1.getValueAt(i, 2).toString());
					//获取名字
					String name_insert =table_1.getValueAt(i, 0).toString();
					System.out.println(name_insert+"-----"+num_insert);
					//获取原有数量
					int bookcount = (inrecorddao.QueryByName(name_insert)).getNum();
					int book_new=bookcount+num_insert;
					
					//执行操作
					if(inrecorddao.updateInCount(name_insert, num_insert, book_new)!=0)
					{
						JOptionPane.showMessageDialog(null, "成功");
						int rows_1=model_1.getRowCount()-1;
						for(;rows_1>=0;rows_1--)
						{
						model_1.removeRow(rows_1);
						}
						textField.setText("");
						label_6.setText("0");
					}
					else 
						JOptionPane.showMessageDialog(null, "失败");
				}
				
			}
		});
		/**
		 * 清空监听
		 */
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				label_6.setText("");
				label_7.setText("");
				textField_1.setText("");
				int rows_1=model_1.getRowCount()-1;
				for(;rows_1>=0;rows_1--)
				{
				model_1.removeRow(rows_1);
				}
				
				int rows =model.getRowCount()-1;
				for(;rows>=0;rows--){
					model.removeRow(rows);
				}
				
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String date=textField_1.getText();
				int rows =model.getRowCount()-1;
				for(;rows>=0;rows--){
					model.removeRow(rows);
				}
				InRecordImpl inredao=new InRecordImpl();
				List<model.InRecord> list=inredao.QueryOne(date);
				int i = 0;
				for (model.InRecord inrecord : list) {

					// 添加行数据
					model.addRow(new Object[] { inrecord.getName(),
							inrecord.getDate(), inrecord.getNum() });
				}
				
			}
		});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}