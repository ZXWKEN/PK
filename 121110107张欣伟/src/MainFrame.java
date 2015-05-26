import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton manage;
	private JButton customer;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u9009\u62e9\u767b\u5f55\u65b9\u5f0f");
				jLabel1.setBounds(107, 31, 161, 41);
			}
			{
				manage = new JButton();
				getContentPane().add(manage);
				manage.setText("\u7ba1\u7406\u5458");
				manage.setBounds(112, 115, 125, 33);
				manage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						DishesMainFrame dishes=new DishesMainFrame();
						dishes.setVisible(true);
						
					}
				});
			}
			{
				customer = new JButton();
				getContentPane().add(customer);
				customer.setText("\u987e\u5ba2");
				customer.setBounds(112, 173, 125, 36);
				customer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						OrderMainFrame order=new OrderMainFrame();
						order.setVisible(true);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
