import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

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
public class DishesMainFrame extends javax.swing.JFrame {
	private JButton addbutton;
	private JButton deletebutton;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton changebutton;
	
	private DishesMainFrame dishesmain=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DishesMainFrame inst = new DishesMainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public DishesMainFrame() {
		super();
		initGUI();
		dishesmain=this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				addbutton = new JButton();
				getContentPane().add(addbutton);
				addbutton.setText("\u6dfb\u52a0\u9910\u54c1");
				addbutton.setBounds(40, 29, 102, 24);
				addbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dishesmain.dispose();
						DishesAddFrame add=new DishesAddFrame();
						add.setVisible(true);
					}
				});
			}
			{
				changebutton = new JButton();
				getContentPane().add(changebutton);
				changebutton.setText("\u4fee\u6539\u9910\u54c1\u4ef7\u683c");
				changebutton.setBounds(173, 29, 138, 24);
				changebutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(jTable1.getSelectedRowCount()==0)
						{
							JOptionPane.showConfirmDialog(null, "请选择要修改的餐品!","提示", JOptionPane.CLOSED_OPTION);
						}
						else
						{
							Dishes dishes=new Dishes();
							int row=jTable1.getSelectedRow();
							
							TableModel tm = jTable1.getModel();
							
							
							dishes.setId(Integer.parseInt((String) tm.getValueAt(row, 0)));
							dishes.setName((String)tm.getValueAt(row, 1).toString());
							dishes.setPrice(Double.parseDouble((String) tm.getValueAt(row,2)));
							DishesChangeFrame change=new DishesChangeFrame(dishes);
							dishesmain.dispose();
							change.setVisible(true);
							
						}
						
						
					}
				});
			}
			{
				deletebutton = new JButton();
				getContentPane().add(deletebutton);
				deletebutton.setText("\u5220\u9664\u9910\u54c1");
				deletebutton.setBounds(338, 29, 101, 24);
				deletebutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						if(jTable1.getSelectedRowCount()==0)
						{
							JOptionPane.showConfirmDialog(null, "请选择要修改的餐品!","提示", JOptionPane.CLOSED_OPTION);
						}
						else
						{
							Dishes dishes=new Dishes();
							int row=jTable1.getSelectedRow();
							
							TableModel tm = jTable1.getModel();
							
							
							dishes.setId(Integer.parseInt((String) tm.getValueAt(row, 0)));
							dishes.setName((String)tm.getValueAt(row, 1).toString());
							dishes.setPrice(Double.parseDouble((String) tm.getValueAt(row,2)));
							DishesDeleteFrame delete=new DishesDeleteFrame(dishes);
							dishesmain.dispose();
							delete.setVisible(true);
							
						}
						
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(66, 82, 349, 179);
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
									
									new String[] { "餐品编号", "餐品名称","餐品价格" });
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
			pack();
			this.setSize(494, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

}
