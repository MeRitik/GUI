import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JCheckBoxMenuItem;


public class MyEditor extends JFrame {
//	int fsize = 12;
	boolean isSavedFile, stateChanged = false;
	
	File currentFile = null;
	
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
		
		// set opening position on screen
		setBounds(100, 50, 500, 500);
		
		isSavedFile = false;
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
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Select all");
		mnNewMenu_1.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Date/Time");
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
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
		
		JCheckBoxMenuItem wrapped = new JCheckBoxMenuItem("Word wrap");
		wrapped.setSelected(true);
		mnNewMenu_2.add(wrapped);
		
		
		rdbtnmntmNewRadioItem.addActionListener((e)->{
			setSize(500, 500);
		});
		
		
		rdbtnmntmNewRadioItem_1.addActionListener((i)->{
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		});
		
		
		JMenu mnNewMenu_3 = new JMenu("Format");
		menuBar.add(mnNewMenu_3);
		
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
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_13 = new JRadioButtonMenuItem("Microsoft Himalaya");
		mnNewMenu_4.add(rdbtnmntmNewRadioItem_13);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_14 = new JRadioButtonMenuItem("Calibri");
		mnNewMenu_4.add(rdbtnmntmNewRadioItem_14);
		
		fontName.add(rdbtnmntmNewRadioItem_2);
		fontName.add(rdbtnmntmNewRadioItem_3);
		fontName.add(rdbtnmntmNewRadioItem_4);
		fontName.add(rdbtnmntmNewRadioItem_13);
		fontName.add(rdbtnmntmNewRadioItem_14);
		
		
		JMenu mnNewMenu_5 = new JMenu("Font size");
		mnNewMenu_3.add(mnNewMenu_5);
		
		ButtonGroup fontSize = new ButtonGroup();
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_5 = new JRadioButtonMenuItem("10");
		mnNewMenu_5.add(rdbtnmntmNewRadioItem_5);
		fontSize.add(rdbtnmntmNewRadioItem_5);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_6 = new JRadioButtonMenuItem("12");
		rdbtnmntmNewRadioItem_6.setSelected(true);
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
//		contentPane.add(textArea);
		textArea.setLineWrap(true);
		
		// change default font size from here
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		
		// Scroll 
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scroll);
		

		
		mntmNewMenuItem_1.addActionListener((ae)->{
			// Checking if a file is opened
			JFileChooser jfc = new JFileChooser();
			if(isSavedFile) {
				try {
					FileWriter file = new FileWriter(currentFile.getAbsoluteFile());
					file.write(textArea.getText());
					file.close();
				}catch(IOException io) {}
			}else {
				int x = jfc.showSaveDialog(this);
				FileWriter file = null;
				
				if(x == JFileChooser.APPROVE_OPTION) {
					try {
						String path = jfc.getSelectedFile().getAbsolutePath();
						String name = jfc.getSelectedFile().getName();
						setTitle(name + " - My Notepad");
						file = new FileWriter(path);
						
						currentFile = new File(path);
						
						file.write(textArea.getText());
						file.close();
						isSavedFile = true;
					}catch(IOException ie) {}
					
				}
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
					
					// Setting the current file
					currentFile = new File(jfc.getSelectedFile().getAbsolutePath());
					
					textArea.read(bReader, null);
					bReader.close();
					isSavedFile = true;
				}catch(IOException ie) {}
			}
		});
		
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				stateChanged = true;
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				stateChanged = true;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				stateChanged = true;
			}
		});
		
		mntmNewMenuItem_5.addActionListener((ae)->{
			if(textArea.getText().isEmpty()) {
				System.exit(0);
			}
			
			if(stateChanged) {
				JFrame jf = new JFrame("MyEditor");
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setBounds(600, 300, 503, 126);
				jf.setTitle("MyEditor");
				JPanel contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				jf.setContentPane(contentPane);
				contentPane.setLayout(null);
						
				JLabel text = new JLabel("Do you want to save changes to " + getTitle());
				text.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 24));
				text.setBounds(106, 19, 373, 24);
				contentPane.add(text);
						
				JButton btnNewButton = new JButton("Don't Save");
				btnNewButton.setBounds(180, 53, 99, 26);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Save");
				btnNewButton_1.setBounds(52, 53, 99, 26);
				contentPane.add(btnNewButton_1);
						
				JButton btnNewButton_2 = new JButton("Cancel");
				btnNewButton_2.setBounds(306, 53, 99, 26);
				contentPane.add(btnNewButton_2);
						
						
				JLabel lblNewLabel = new JLabel(UIManager.getIcon("OptionPane.warningIcon"));
				lblNewLabel.setBounds(52, 12, 55, 37);
				contentPane.add(lblNewLabel);
						
				btnNewButton.addActionListener((e)->{
					System.exit(0);
				});
						
				btnNewButton_1.addActionListener((e)->{
					// code for saving the file
					// Checking if a file is opened
					JFileChooser jfc = new JFileChooser();
					if(isSavedFile) {
						try {
							FileWriter file = new FileWriter(currentFile.getAbsoluteFile());
							file.write(textArea.getText());
							file.close();
						}catch(IOException io) {}
					}else {
						int x = jfc.showSaveDialog(this);
						FileWriter file = null;
								
						if(x == JFileChooser.APPROVE_OPTION) {
							try {
								String path = jfc.getSelectedFile().getAbsolutePath();
								String name = jfc.getSelectedFile().getName();
								setTitle(name + " - My Notepad");
								file = new FileWriter(path);
										
								currentFile = new File(path);
										
								file.write(textArea.getText());
								file.close();
								isSavedFile = true;
								System.exit(0);
							}catch(IOException ie) {}
									
						}
					}
				});
						
				btnNewButton_2.addActionListener((e)->{
					jf.dispose();
				});
			}
		});
		
		
		mntmNewMenuItem_11.addActionListener((e)->{
			var color = JColorChooser.showDialog(this, "Choose font color", getForeground());
			textArea.setForeground(color);
		});
		
		rdbtnmntmNewRadioItem_2.addActionListener((e)->{
			textArea.setFont(new Font("Arial", Font.PLAIN, textArea.getFont().getSize()));
		});
		
		rdbtnmntmNewRadioItem_3.addActionListener((e)->{
			textArea.setFont(new Font("Times New Roman", Font.PLAIN, textArea.getFont().getSize()));
		});
		
		rdbtnmntmNewRadioItem_4.addActionListener((e)->{
			textArea.setFont(new Font("Monotype Corsiva", Font.PLAIN, textArea.getFont().getSize()));
		});
		
		rdbtnmntmNewRadioItem_13.addActionListener((e)->{
			textArea.setFont(new Font("Microsoft Himalya", Font.PLAIN, textArea.getFont().getSize()));
		});
		
		rdbtnmntmNewRadioItem_14.addActionListener((e)->{
			textArea.setFont(new Font("Calibri", Font.PLAIN, textArea.getFont().getSize()));
		});
		
		rdbtnmntmNewRadioItem_5.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 10));
		});
		
		rdbtnmntmNewRadioItem_6.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 12));
		});
		
//		System.out.println(textArea.getFont().getName());
		
		rdbtnmntmNewRadioItem_7.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 16));
		});
		
		rdbtnmntmNewRadioItem_8.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 18));
		});
		
		rdbtnmntmNewRadioItem_9.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 24));
		});
		
		rdbtnmntmNewRadioItem_10.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 32));
		});
		
		rdbtnmntmNewRadioItem_11.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 48));
		});
		
		rdbtnmntmNewRadioItem_12.addActionListener((e)->{
			textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 72));
		});
		
		
		mntmNewMenuItem_4.addActionListener((e)->{
			var pj = PrinterJob.getPrinterJob();
			boolean x = pj.printDialog();
			
			if(x == true) {
				try {
					pj.print();
				}catch(PrinterException pe) {}
			}
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
		
		
		// WindowStateListener to check if the frame is full screen or not
		// if it is full screen then select full screen mode else normal mode
		addWindowStateListener((we)->{
			int isMaximized = getExtendedState();
			
			if(isMaximized == MAXIMIZED_BOTH) {
				rdbtnmntmNewRadioItem_1.setSelected(true);
			}else {
				rdbtnmntmNewRadioItem.setSelected(true);
			}
		});
		
		wrapped.addActionListener((e)->{
			boolean isWrapped = textArea.getLineWrap();
			
			textArea.setLineWrap(!isWrapped);
		});
		
		mntmNewMenuItem_9.addActionListener((e)->{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			textArea.setText(textArea.getText() + dtf.format(now));
		});
		
		mntmNewMenuItem_12.addActionListener((e)->{
			textArea.selectAll();
		});
		
	}

}
