package aplications;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import controllers.EventsLabrinty;
import controllers.GenerateLabirinty;

import javax.swing.JTextArea;

public class ScreenHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenHome frame = new ScreenHome();
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
	public ScreenHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//campo de texto
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("FreeSans", Font.PLAIN, 13));
		textField.setBounds(36, 134, 377, 30);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed( KeyEvent e ){
				if(e.getKeyCode() == 10){
					EventsLabrinty.createWarrior(textField.getText());
					setVisible(false);
					
					// chamando outra janela
					ScreenInit init = new ScreenInit();
					init.main(null);
					
				}					
			}
		});
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQualOSeu = new JLabel("Qual o seu nome guerreiro?");
		lblQualOSeu.setLabelFor(textField);
		lblQualOSeu.setFont(new Font("FreeSans", Font.PLAIN, 12));
		lblQualOSeu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualOSeu.setBounds(67, 82, 318, 15);
		contentPane.add(lblQualOSeu);

	}
}
