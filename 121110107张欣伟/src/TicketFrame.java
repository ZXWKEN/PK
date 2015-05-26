import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class TicketFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JLabel price_totle;
	private JButton ok;
	private JLabel jLabel1;
	private JTable jTable1;
	
	private ArrayList<Dishes> dishes=null;
	private TicketFrame ticket=null;
	private double price=0;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				TicketFrame inst = new TicketFrame();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	
	
	
	public TicketFrame(ArrayList<Dishes> dishes) {
		super();
		this.dishes=dishes;
		initGUI();
		ticket=this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(38, 17, 363, 154);
				{
					Dishes tempdishes=null;
					String[][] result=new String[100][3];
					
					for(int i=0;i<dishes.size();i++)
					{
						tempdishes=(Dishes)dishes.get(i);
						price+=tempdishes.getPrice();
						result[i][0]=tempdishes.getId()+"";
						result[i][1]=tempdishes.getName();
						result[i][2]=tempdishes.getPrice()+"";
						//System.out.println(tempdishes.getName());
						tempdishes=null;
					}
					
					
					//pricetotle.setText("1234");
					TableModel jTable1Model = 
							new DefaultTableModel(
									result,
									new String[] { "餐品编号", "餐品名称" ,"餐品价格"});
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u603b\u4ef7");
				jLabel1.setBounds(38, 183, 61, 32);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\u786e\u5b9a");
				ok.setBounds(266, 215, 74, 36);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ticket.dispose();
						OrderMainFrame ordermain=new OrderMainFrame();
						ordermain.setVisible(true);
					}
				});
			}
			{
				price_totle = new JLabel();
				price_totle.setText(Double.toString(price));
				getContentPane().add(price_totle);
				price_totle.setBounds(99, 191, 41, 17);
			}
			pack();
			this.setSize(470, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
