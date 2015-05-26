import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
public class OrderMainFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton ok;
	private JButton add;
	
	private ArrayList<Dishes> dishes=new ArrayList<Dishes>();
	private ArrayList<Dishes> temp_dishes=new ArrayList<Dishes>();
	
	private OrderMainFrame ordermain=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OrderMainFrame inst = new OrderMainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OrderMainFrame() {
		super();
		initGUI();
		ordermain=this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(27, 40, 324, 248);
				{
					
					//read from db
					DishesControl dishesControl=new DishesControl();
					ArrayList<Dishes> dishes=dishesControl.readFromDB();
					//System.out.println(dishes.get(0).getName());
					
					Dishes tempdishes=null;
					String[][] result=new String[100][3];
					for(int i=0;i<dishes.size();i++)
					{
						tempdishes=(Dishes)dishes.get(i);
						result[i][0]=tempdishes.getId()+"";
						result[i][1]=tempdishes.getName();
						result[i][2]=tempdishes.getPrice()+"";
						//System.out.println(tempdishes.getName());
						tempdishes=null;
					}
					
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
				add = new JButton();
				getContentPane().add(add);
				add.setText("\u6dfb\u52a0");
				add.setBounds(386, 66, 90, 43);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						if(jTable1.getSelectedRowCount()==0)
						{
							JOptionPane.showConfirmDialog(null, "请选择要购买的餐品!","提示", JOptionPane.CLOSED_OPTION);
						}
						else
						{
							Dishes tempdishes=new Dishes();
							int row=jTable1.getSelectedRow();
							
							TableModel tm = jTable1.getModel();
							
							
							tempdishes.setId(Integer.parseInt((String) tm.getValueAt(row, 0)));
							tempdishes.setName((String)tm.getValueAt(row, 1).toString());
							tempdishes.setPrice(Double.parseDouble((String) tm.getValueAt(row,2)));
							temp_dishes.add(tempdishes);
							
							
							
						}
					}
				});
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\u63d0\u4ea4\u8ba2\u5355");
				ok.setBounds(386, 170, 90, 46);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						TicketFrame ticket=new TicketFrame(temp_dishes);
						ordermain.dispose();
						
						ticket.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(524, 348);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
