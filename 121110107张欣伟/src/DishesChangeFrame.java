import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class DishesChangeFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel id;
	private JButton no;
	private JButton ok;
	private JTextField newprice;
	private JLabel price;
	private JLabel name;
	
	private Dishes dishes=null;
	private DishesChangeFrame change=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				DishesChangeFrame inst = new DishesChangeFrame();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	public DishesChangeFrame() {
		super();
		change=this;
		initGUI();
		
	}
	
	
	public DishesChangeFrame(Dishes dishes) {
		super();
		this.dishes=dishes;
		initGUI();
		id.setText(dishes.getId()+"");
		name.setText(dishes.getName());
		price.setText(dishes.getPrice()+"");
		change=this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u8f93\u5165\u9910\u54c1\u4ef7\u683c");
				jLabel1.setBounds(119, 22, 155, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u9910\u54c1\u7f16\u53f7");
				jLabel2.setBounds(47, 66, 86, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9910\u54c1\u540d\u79f0");
				jLabel3.setBounds(47, 102, 86, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9910\u54c1\u539f\u4ef7");
				jLabel4.setBounds(47, 137, 72, 17);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u9910\u54c1\u73b0\u4ef7");
				jLabel5.setBounds(47, 172, 72, 17);
			}
			{
				id = new JLabel();
				getContentPane().add(id);
				id.setBounds(152, 66, 155, 17);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setBounds(152, 102, 155, 17);
			}
			{
				price = new JLabel();
				getContentPane().add(price);
				price.setBounds(152, 137, 155, 17);
			}
			{
				newprice = new JTextField();
				getContentPane().add(newprice);
				newprice.setBounds(152, 169, 82, 24);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\u4fdd\u5b58");
				ok.setBounds(71, 224, 81, 24);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if("".equals(newprice.getText()))
						{
							JOptionPane.showConfirmDialog(null, "请填写修改后的价格!","提示", JOptionPane.CLOSED_OPTION);
						}
						else
						{
							try 
							{
								dishes.setPrice(Double.valueOf(newprice.getText()));
								DishesControl dc=new DishesControl();
								dc.changeDishes(dishes.getId(), dishes.getPrice());
								change.dispose();
								DishesMainFrame dishesmain=new DishesMainFrame();
								dishesmain.setVisible(true);
					               
						    } catch (Exception e) 
						    {
						    	JOptionPane.showConfirmDialog(null, "输入错误!","提示", JOptionPane.CLOSED_OPTION);   
						    }
							
						}
					}
				});
			}
			{
				no = new JButton();
				getContentPane().add(no);
				no.setText("\u53d6\u6d88");
				no.setBounds(191, 224, 72, 24);
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						change.dispose();
						DishesMainFrame dishesmain=new DishesMainFrame();
						dishesmain.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(400, 321);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
