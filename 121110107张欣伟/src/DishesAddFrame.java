import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class DishesAddFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField id;
	private JLabel jLabel5;
	private JButton no;
	private JButton ok;
	private JTextField price;
	private JTextField name;
	
	DishesAddFrame add=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				DishesAddFrame inst = new DishesAddFrame();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public DishesAddFrame() {
		super();
		initGUI();
		add=this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u8f93\u5165\u9910\u54c1\u4fe1\u606f");
				jLabel1.setBounds(133, 24, 148, 26);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u9910\u54c1\u7f16\u53f7");
				jLabel2.setBounds(54, 75, 79, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9910\u54c1\u540d\u79f0");
				jLabel3.setBounds(54, 116, 79, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9910\u54c1\u4ef7\u683c");
				jLabel4.setBounds(54, 159, 79, 17);
			}
			{
				id = new JTextField();
				getContentPane().add(id);
				id.setBounds(138, 72, 115, 24);
			}
			{
				name = new JTextField();
				getContentPane().add(name);
				name.setBounds(138, 113, 115, 24);
			}
			{
				price = new JTextField();
				getContentPane().add(price);
				price.setBounds(138, 156, 115, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("*\u8bf7\u8f93\u51654\u4f4d\u6570\u5b57");
				jLabel5.setBounds(271, 75, 96, 17);
				jLabel5.setFont(new java.awt.Font("微软雅黑",2,12));
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\u4fdd\u5b58");
				ok.setBounds(66, 203, 72, 24);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if("".equals(id.getText()))
						{
							JOptionPane.showConfirmDialog(null, "请填写餐品编号!","提示", JOptionPane.CLOSED_OPTION);
							return;
						}
						if("".equals(name.getText()))
						{
							JOptionPane.showConfirmDialog(null, "请填写餐品名称!","提示", JOptionPane.CLOSED_OPTION);
							return;
						}
						if("".equals(price.getText()))
						{
							JOptionPane.showConfirmDialog(null, "请填写餐品价格!","提示", JOptionPane.CLOSED_OPTION);
							return;
						}
						try 
						{
							int tempid=Integer.valueOf(id.getText());
							String tempname=name.getText();
							double tempprice=Double.valueOf(price.getText());
							DishesControl dc=new DishesControl();
							dc.addDishes(tempid, tempname, tempprice);
							
							add.dispose();
							DishesMainFrame dishesmain=new DishesMainFrame();
							dishesmain.setVisible(true);
							
				               
					    } catch (Exception e) 
					    {
					    	JOptionPane.showConfirmDialog(null, "输入错误!","提示", JOptionPane.CLOSED_OPTION);   
					    }
					}
				});
			}
			{
				no = new JButton();
				getContentPane().add(no);
				no.setText("\u53d6\u6d88");
				no.setBounds(196, 203, 69, 24);
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						add.dispose();
						DishesMainFrame dishesmain=new DishesMainFrame();
						dishesmain.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(421, 298);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
