package aplications;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;

import controllers.GenerateLabirinty;
import controllers.Move;

import java.awt.Panel;

public class ScreenInit extends JFrame {

	private JPanel contentPane;
	private JTextField txtCommands;
	private int countLines = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//mandando gerar o labirinto
					GenerateLabirinty.generate(6);
					
					ScreenInit frame = new ScreenInit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScreenInit() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrArea = new JTextArea();		
		txtrArea.setBounds(205, 12, 231, 218);
		txtrArea.setEditable(false);		
		JScrollPane scroll = new JScrollPane(txtrArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(scroll);
		contentPane.add(txtrArea);
		
		//-> textarea
		JTextArea textAreaCoodenadas = new JTextArea();
		textAreaCoodenadas.setBounds(12, 165, 160, 64);
		
		//apresenta onde o guerreiro esta e qual o lv dele
		textAreaCoodenadas.setText(Move.status());
		
		contentPane.add(textAreaCoodenadas);
				
		
		txtCommands = new JTextField();
		txtCommands.setBounds(12, 243, 416, 19);
		txtCommands.setFocusable(true);
		
		
		txtCommands.addKeyListener(new KeyAdapter() {  
			  
		     public void keyPressed(KeyEvent evt) {
		    	 if(evt.getKeyCode() == 10){
		    		 
		    		 //condicional para limpar a tela quando tiver algumas linhas já lá.
		    		 if(countLines == 10){
		    			 txtrArea.setText("");
		    			 countLines = -1;
		    		 }
		    		 
		    		 txtrArea.append(GenerateLabirinty.go(txtCommands.getText())+"\n");
		    		 textAreaCoodenadas.setText(Move.status());
		    		 txtCommands.setText("");
		    		 
		    		 countLines++;
		    	 }
		     }  
		}); 
		
		
		contentPane.add(txtCommands);
		txtCommands.setColumns(10);
		
	
	}	
	
}
