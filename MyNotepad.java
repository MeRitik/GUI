import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.PrintJob;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;


public class MyEditor extends JFrame {
	int fsize = 10;
	StringBuilder fontName = new StringBuilder();;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyEditor frame = new MyEditor();
					frame.setVisible(true);
					frame.setSize(500, 500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyEditor() {
		setTitle("Untitled - My Editor");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ritik\\Desktop\\notepad.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener((ae)->{
			try {
				MyEditor frame = new MyEditor();
				frame.setVisible(true);
				frame.setSize(500, 500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save as");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cut");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("View");
		menuBar.add(mnNewMenu_2);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Normal");
		rdbtnmntmNewRadioItem.setSelected(true);
		mnNewMenu_2.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Full screen");
		mnNewMenu_2.add(rdbtnmntmNewRadioItem_1);
		
		ButtonGroup sz = new ButtonGroup();
		sz.add(rdbtnmntmNewRadioItem_1);
		sz.add(rdbtnmntmNewRadioItem);
		
		rdbtnmntmNewRadioItem.addActionListener((e)->{
			setSize(500, 500);
		});
		
		
		rdbtnmntmNewRadioItem_1.addActionListener((i)->{
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		});
		
		
		JMenu mnNewMenu_3 = new JMenu("Format");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("New menu item");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Background");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Font color");
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		
		JMenu mnNewMenu_4 = new JMenu("Font");
		mnNewMenu_3.add(mnNewMenu_4);
		
		ButtonGroup fontName = new ButtonGroup();
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("Arial");
		rdbtnmntmNewRadioItem_2.setSelected(true);
		mnNewMenu_4.add(rdbtnmntmNewRadioItem_2);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_3 = new JRadioButtonMenuItem("Times New Roman");
		mnNewMenu_4.add(rdbtnmntmNewRadioItem_3);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_4 = new JRadioButtonMenuItem("Monotype Corsiva");
		mnNewMenu_4.add(rdbtnmntmNewRadioItem_4);
		
		fontName.add(rdbtnmntmNewRadioItem_2);
		fontName.add(rdbtnmntmNewRadioItem_3);
		fontName.add(rdbtnmntmNewRadioItem_4);
		
		JMenu mnNewMenu_5 = new JMenu("Font size");
		mnNewMenu_3.add(mnNewMenu_5);
		
		ButtonGroup fontSize = new ButtonGroup();
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_5 = new JRadioButtonMenuItem("10");
		rdbtnmntmNewRadioItem_5.setSelected(true);
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_5);
		fontSize.add(rdbtnmntmNewRadioItem_5);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_6 = new JRadioButtonMenuItem("12");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_6);
		fontSize.add(rdbtnmntmNewRadioItem_6);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_7 = new JRadioButtonMenuItem("16");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_7);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_8 = new JRadioButtonMenuItem("18");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_8);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_9 = new JRadioButtonMenuItem("24");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_9);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_10 = new JRadioButtonMenuItem("32");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_10);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_11 = new JRadioButtonMenuItem("48");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_11);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_12 = new JRadioButtonMenuItem("72");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_12);
		
		fontSize.add(rdbtnmntmNewRadioItem_7);
		fontSize.add(rdbtnmntmNewRadioItem_8);
		fontSize.add(rdbtnmntmNewRadioItem_9);
		fontSize.add(rdbtnmntmNewRadioItem_10);
		fontSize.add(rdbtnmntmNewRadioItem_11);
		fontSize.add(rdbtnmntmNewRadioItem_12);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		
		mntmNewMenuItem_1.addActionListener((ae)->{
			JFileChooser jfc = new JFileChooser();
			int x = jfc.showSaveDialog(this);
			FileWriter file = null;
			
			if(x == JFileChooser.APPROVE_OPTION) {
				try {
					String path = jfc.getSelectedFile().getAbsolutePath();
					String name = jfc.getSelectedFile().getName();
					setTitle(name + " - My Notepad");
					file = new FileWriter(path);
					file.write(textArea.getText());
					file.close();
				}catch(IOException ie) {}
				
			}
		});
		
		// Save as
		mntmNewMenuItem_2.addActionListener((e)->{
			JFileChooser jfc = new JFileChooser();
			int x = jfc.showSaveDialog(this);
			FileWriter file = null;
			
			if(x == JFileChooser.APPROVE_OPTION) {
				try {
					String path = jfc.getSelectedFile().getAbsolutePath();
					String name = jfc.getSelectedFile().getName();
					setTitle(name + " - My Notepad");
					file = new FileWriter(path);
					file.write(textArea.getText());
					file.close();
				}catch(IOException ie) {}
				
			}
		});
		
		mntmNewMenuItem_3.addActionListener((e)->{
			JFileChooser jfc = new JFileChooser();
			int x = jfc.showOpenDialog(this);
			
			if(x == JFileChooser.APPROVE_OPTION) {
				try {
					FileReader reader = new FileReader(jfc.getSelectedFile().getAbsolutePath());
					BufferedReader bReader = new BufferedReader(reader);
					setTitle(jfc.getSelectedFile().getName());
					
					textArea.read(bReader, null);
					bReader.close();
				}catch(IOException ie) {}
			}
		});
		
		mntmNewMenuItem_11.addActionListener((e)->{
			var color = JColorChooser.showDialog(this, "Choose font color", getForeground());
			textArea.setForeground(color);
		});
		
		rdbtnmntmNewRadioItem_2.addActionListener((e)->{
			textArea.setFont(new Font("Arial", Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_3.addActionListener((e)->{
			textArea.setFont(new Font("Times New Roman", Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_4.addActionListener((e)->{
			textArea.setFont(new Font("Monotype Corsiva", Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_5.addActionListener((e)->{
			fsize = 10;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_6.addActionListener((e)->{
			fsize = 12;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
//		System.out.println(textArea.getFont().getName());
		
		rdbtnmntmNewRadioItem_7.addActionListener((e)->{
			fsize = 16;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_8.addActionListener((e)->{
			fsize = 18;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_9.addActionListener((e)->{
			fsize = 24;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_10.addActionListener((e)->{
			fsize = 32;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_11.addActionListener((e)->{
			fsize = 48;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		rdbtnmntmNewRadioItem_12.addActionListener((e)->{
			fsize = 72;
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, fsize));
		});
		
		
		mntmNewMenuItem_4.addActionListener((e)->{
			// Not completed
			
			var pj = PrinterJob.getPrinterJob();
			boolean x = pj.printDialog();
		});
		
		mntmNewMenuItem_6.addActionListener((e)->{
			textArea.cut();
		});
		
		mntmNewMenuItem_7.addActionListener((e)->{
			textArea.copy();
		});
		
		mntmNewMenuItem_8.addActionListener((e)->{
			textArea.paste();
		});
		
		mntmNewMenuItem_10.addActionListener((e)->{
			var color = JColorChooser.showDialog(textArea, "Choose background color", textArea.getBackground());
			textArea.setBackground(color);
		});
	}
}
