/****************************************************************/
/*                      Node1	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
/**
 * Summary description for Node1
 *
 */
public class Node2 extends JFrame
{
	// Variables declaration
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;
	//-----
	private JTextField jTextField1;
	private JComboBox jComboBox1;
	private JTextArea jTextArea3;
	private JScrollPane jScrollPane3;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JPanel jPanel1;
	//-----
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	double time,display,calculate;
	ServerSocket ss;
	Socket s2,s5;
	String destination,path,way,dest,check;
	ResultSet rs;
	//-----
	// End of variables declaration


	public Node2()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//
		this.setVisible(true);

		try
		{
			String path=":Node2";
			time=System.nanoTime();
			ServerSocket ss=new ServerSocket(22);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:path","sa","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("truncate table path");
			while(true)
			{

					s2=ss.accept();
					DataInputStream dos=new DataInputStream(s2.getInputStream());
					display=dos.readDouble();
					String check=dos.readUTF();
					String dest=dos.readUTF();
					String way=check+path;
					calculate=time-display;
					
					
					
					//System.out.println(way);
			
					  if(dest.equalsIgnoreCase("Node2"))
				
					  {
						    //stmt.executeUpdate("truncate table path");
							stmt.executeUpdate("insert into path values ('"+way+"','"+calculate+"')");
							rs= stmt.executeQuery("select * from path");
							jTextArea3.setText("");
						   while(rs.next())
							{
							   String p1=rs.getString(1);
							   String p2=rs.getString(2);
							   jTextArea3.append("\n------------------------------------\n                Path   \n----------------------------------\n"+p1+"\nConsumed Time\n"+p2);
							 }
							//System.out.println(way+"Consumed Time\n"+calculate);
							//jTextArea3.append("\n------------------------------------\n                Path   \n----------------------------------\n"+way+"\nConsumed Time\n"+calculate);
					  }
				    	else
					  {
							 //System.out.println("mike testing 1");
							int next[]={11,55};
							String p[]={"Node1","Node5"};
							int count=0;
							String checks[]=check.split(":");
							for(int j=0;j<p.length;j++)
							{
								for(int i=1;i<checks.length;i++)
								{
									if(p[j].equalsIgnoreCase(checks[i]))
									{
										count=1;
										break;
									}
									else
									{
									
										count=0;
									}
								}

							
								if(count==0)
								{							
										
										s5=new Socket("localhost",next[j]);
										DataOutputStream hit=new DataOutputStream(s5.getOutputStream());
										//System.out.println("mike testing 2");
										hit.writeDouble(calculate);
										hit.writeUTF(way);
										hit.writeUTF(dest);
										
								}	 
									 
								
							}
						}
					}
				}
				 catch (Exception jh1)
				 {
						 jh1.printStackTrace();
				 }
				
	            
	       
	}
						
							

	


	private void initializeComponent()
	{
		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
		//-----
		jTextField1 = new JTextField();
		String st[]={"Select","Node1","Node3","Node4","Node5"};
		jComboBox1 = new JComboBox(st);
		jLabel1=new JLabel();
		jLabel1.setFont(new Font("Imprint MT Shadow",Font.PLAIN,12));
		jLabel2=new JLabel();
			jLabel2.setFont(new Font("Imprint MT Shadow",Font.PLAIN,12));
		jLabel3=new JLabel();
			jLabel3.setFont(new Font("Imprint MT Shadow",Font.PLAIN,16));
		jTextArea3 = new JTextArea();
		jScrollPane3 = new JScrollPane();
		jButton1 = new JButton();
		jButton2 =new JButton();
		jButton3 =new JButton();
		jButton4 =new JButton();
		jPanel1 = new JPanel();



		//-----
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		
		jPanel2 = new JPanel();
		//-----
		
		//
		// jTabbedPane1
		//
		addComponent(contentPane, jLabel3, 50,50,83,28);
		jLabel3.setText(" FAST COMPUTATION OF SHORTEST PATH");
		jTabbedPane1.addTab("Node2", jPanel1);
		jTabbedPane1.addTab("Message", jPanel2);
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				jTabbedPane1_stateChanged(e);
			}

		});
		//
		// contentPane
	//	
		contentPane.setLayout(null);
		addComponent(contentPane, jTabbedPane1, 21,71,524,408);
		
		//
		// jTextField1
		//
		jTextField1.setText("");
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jComboBox1
		//
		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox1_actionPerformed(e);
			}

		});
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}
		});
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});

		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton4_actionPerformed(e);
			}

		});
		//
		// jTextArea3
		//
		jTextArea3.setText("");
		//
		// jScrollPane3
		//
		jScrollPane3.setViewportView(jTextArea3);
		//
		// jButton1
		//
		//jButton1.setText("jButton1");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jPanel1
		//
		jPanel1.setLayout(null);
		jPanel1.setBackground(new Color(168,221,255)); 
 		jPanel2.setBackground(new Color(168,221,255)); 
		addComponent(jPanel1, jTextField1, 19,79,150,29);
		addComponent(jPanel1, jComboBox1,180,150,95,28);
		addComponent(jPanel1, jScrollPane3, 310,90,184,250);
		addComponent(jPanel1, jLabel1, 353,50,83,28);
		addComponent(jPanel1, jLabel2, 24,145,100,28);
		addComponent(jPanel1, jButton1, 105,205,145,28);
		addComponent(jPanel1, jButton2,180,80,95,28);
        addComponent(jPanel1, jButton3, 105,255,145,28);
		addComponent(jPanel1, jButton4, 105,305,145,28);
		addComponent(contentPane, jLabel3, 100,23,380,27); 
		//		
		//
		//
		// jTextArea1
		//
		//jTextArea1.setText();
		jLabel1.setText("TIMINGS");
		jLabel2.setText("DESTINATION");
		jButton1.setText("FIND PATH");
		jButton2.setText("BROWSE");
		jButton3.setText("SEND");
		jButton4.setText("EXIT");
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jPanel2
		//
		jPanel2.setLayout(null);
		addComponent(jPanel2, jScrollPane1, 39,36,430,310);
		//
		// Node1
		//
		this.setTitle("Node2 - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(589, 553));
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{
		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jComboBox1_actionPerformed(ActionEvent e)
	{
		
		destination=""+jComboBox1.getSelectedItem();

	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		destination =""+jComboBox1.getSelectedItem();
		try
			{
			  		
				String path="path:Node2";
				time=System.nanoTime();;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					  Connection con=DriverManager.getConnection("jdbc:odbc:path","sa","");
					  Statement stmt=con.createStatement();
					  stmt.executeUpdate("truncate table path");
				if(destination.equalsIgnoreCase("Node2"))	
						{
					     System.out.println(destination);
						}
						else{
									
									int port[]={11,55};
									for(int i=0;i<port.length;i++)
									{	
										s2=new Socket("localhost",port[i]);
										DataOutputStream di=new DataOutputStream(s2.getOutputStream());
										di.writeDouble(time);
										di.writeUTF(path);
                                        di.writeUTF(destination);
										System.out.println("Message Forward to "+port[i]+"....");
									}
						}	
				
			}
			catch (Exception exp)
				{
					exp.printStackTrace();
				}

		
	}
	  private void jButton2_actionPerformed(ActionEvent e)
	{
		FileDialog o= new FileDialog(this,"open",FileDialog.LOAD);
		o.show();
		File fi=new File(o.getDirectory()+o.getFile());
      
		jTextField1.setText( ""+o.getDirectory()+o.getFile());

	}
		private void jButton3_actionPerformed(ActionEvent e)
	{
		

	}
		private void jButton4_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//






























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		
		new Node2();
	}


}