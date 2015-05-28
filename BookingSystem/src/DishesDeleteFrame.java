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
public class DishesDeleteFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel id;
	private JButton no;
	private JButton ok;
	private JLabel price;
	private JLabel name;
	
	Dishes dishes=null;
	DishesDeleteFrame delete=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				DishesDeleteFrame inst = new DishesDeleteFrame();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public DishesDeleteFrame() {
		super();
		initGUI();
	}
	public DishesDeleteFrame(Dishes dishes) {
		super();
		initGUI();
		delete=this;
		this.dishes=dishes;
		id.setText(dishes.getId()+"");
		name.setText(dishes.getName());
		price.setText(dishes.getPrice()+"");
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u60a8\u786e\u5b9a\u8981\u6267\u884c\u5220\u9664\u64cd\u4f5c\uff1f");
				jLabel1.setBounds(123, 27, 174, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u9910\u54c1\u7f16\u53f7");
				jLabel2.setBounds(70, 84, 84, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9910\u54c1\u540d\u79f0");
				jLabel3.setBounds(70, 119, 84, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9910\u54c1\u4ef7\u683c");
				jLabel4.setBounds(70, 158, 84, 17);
			}
			{
				id = new JLabel();
				getContentPane().add(id);
				id.setBounds(175, 84, 137, 17);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setBounds(175, 119, 137, 17);
			}
			{
				price = new JLabel();
				getContentPane().add(price);
				price.setBounds(175, 158, 137, 17);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\u786e\u5b9a");
				ok.setBounds(70, 207, 84, 24);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						DishesControl dishesControl=new DishesControl();
						dishesControl.delectDishes(dishes.getId());
						delete.dispose();
						DishesMainFrame dishesmain=new DishesMainFrame();
						dishesmain.setVisible(true);
					}
				});
			}
			{
				no = new JButton();
				getContentPane().add(no);
				no.setText("\u53d6\u6d88");
				no.setBounds(211, 207, 86, 24);
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						delete.dispose();
						DishesMainFrame dishesmain=new DishesMainFrame();
						dishesmain.setVisible(true);
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
