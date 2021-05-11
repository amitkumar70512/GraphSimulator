package Ellipse;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

class SampleDialog extends Dialog
{
ellipse bld;
 Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
SampleDialog(Frame parent, String title)
 {
super(parent, title, false); 
bld=(ellipse)parent;
setLayout(new FlowLayout());
setSize(screenSize);


addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
}


 public void paint(Graphics g) {
      Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
     
     int swidth= screenSize.width/2;
	int sheight= (screenSize.height)/2-25;
    g.setColor(Color.BLACK);
    g.drawLine(screenSize.width/2,50,screenSize.width/2,screenSize.height-100);
	g.drawLine(100,(screenSize.height)/2-25,screenSize.width-100,(screenSize.height)/2-25);
       g.drawString("0",swidth-4,sheight+4);
       
       
    g.drawLine(swidth,50,swidth-10,60);
   g.drawLine(swidth,50,swidth+10,60);
   g.drawLine(100,sheight,110,sheight+10);
   g.drawLine(100,sheight,110,sheight-10);
    g.drawLine(swidth,screenSize.height-100,swidth+10,screenSize.height-110);
    g.drawLine(swidth,screenSize.height-100,swidth-10,screenSize.height-110);
    
    g.drawLine(screenSize.width-100,sheight,screenSize.width-110,sheight-10);
    g.drawLine(screenSize.width-100,sheight,screenSize.width-110,sheight+10);
	 
    
    g.setFont(new Font("Serif",Font.BOLD,25));
    g.drawString("-X",70,(screenSize.height)/2-25);
    g.drawString("+X",screenSize.width-98,(screenSize.height)/2-25);
    g.drawString("-Y",screenSize.width/2 +15,screenSize.height-120);
    g.drawString("+Y",screenSize.width/2 +15,55);
	 
	 
      try{ Thread.sleep(2000); }
      catch(Exception e){}

    int a= bld.x;
    int b= bld.y;
    
    int temp1;temp1= 340/(Math.abs(b)+(bld.height));
    int temp2;temp2= 340/(Math.abs(a)+(bld.width));
    int temp;
    
    if(temp1<=temp2)
    temp=temp1;
    else temp=temp2;
    int i,j=1;
    String s;
    g.setFont(new Font("Serif",Font.BOLD,10));
 for(i=sheight-temp;i>=50;i=i-temp)
    {
		g.drawLine(swidth-5,i,swidth+5,i);
		s= Integer.toString(j);
		j++;
		g.drawString(s,swidth+7,i+2);
	}
	j=-1;
	for(i=sheight+temp;i<=screenSize.height-110;i=i+temp)
    {
		g.drawLine(swidth-5,i,swidth+5,i);
		s= Integer.toString(j);
		j--;
		g.drawString(s,swidth-25,i+2);
	}
	j=1;
	for(i=swidth+temp;i<=screenSize.width-110;i=i+temp)
    {
		g.drawLine(i,sheight-5,i,sheight+5);
		s= Integer.toString(j);
		j++;
		g.drawString(s,i-2,sheight+30);
	}
	j=-1;
	for(i=swidth-temp;i>=110;i=i-temp)
    {
		g.drawLine(i,sheight-5,i,sheight+5);
		s= Integer.toString(j);
		j--;
		g.drawString(s,i-4,sheight-15);
	}
	g.setColor(Color.BLUE);
	g.drawOval(((swidth+(a*temp))-(bld.width*temp)),((sheight-(b*temp))-(bld.height*temp)),bld.width*2*temp,bld.height*2*temp);
	g.drawLine((swidth+(a*temp)),((sheight-(b*temp))-(bld.height*temp)),(swidth+(a*temp)),((sheight-(b*temp))+(bld.height*temp)));
    g.drawLine((swidth+(a*temp)-(bld.width*temp)),(sheight-(b*temp)),((swidth+(a*temp)+(bld.width*temp))),(sheight-(b*temp)));
     
	 String c1,c2;
	c1= Integer.toString(a);
	c2= Integer.toString(b);
	String center = "("+c1+","+c2+")";
        g.setFont(new Font("Courier",Font.BOLD,20));
        g.setColor(Color.RED);
	g.drawString(center,(swidth+(a*temp)),(sheight-(b*temp)));
	 g.drawString("((x-"+a+")/"+bld.width+")^2  +((y-"+b+")/"+bld.height+")^2= 1",(swidth+(a*temp)),((sheight-(b*temp))-(bld.height*temp)-5));
	 }

}
public class ellipse extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4;
JButton b;
JTextField t1,t2,t3,t4;
public int x,y,width,height;
 Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
public ellipse()
{
   JFrame frame=new JFrame();
  JPanel panel=new JPanel();
   Label head =new Label (" General Equation of  ellipse: ((x-h)/a)^2  +((y-v)/b)^2= 1  ");
   head.setFont(new Font("Serif",Font.BOLD,30));
   
   
    l1=new JLabel("a=");
    l2=new JLabel("b=");
    l3=new JLabel("h=");
    l4=new JLabel("v=");
    
    t1=new JTextField(5);
    t2=new JTextField(5);
    t3=new JTextField(5);
    t4=new JTextField(5);
   
    ImageIcon submit=new ImageIcon("submiticon.png");
    b = new JButton(submit);
   
   panel.add(head);
   
   JPanel paneltwo=new JPanel();
   ImageIcon ell=new ImageIcon("ellipsepic.png");
   JButton ellipse=new JButton(ell);
   paneltwo.add(ellipse);
  paneltwo.setBounds(500,80,500,1000);
   
   panel.setBounds(40, 20, 1000, 60);
   frame.add(l1);
    frame.add(t1);
    frame.add(l2);
    frame.add(t2);
    frame.add(l3);
    frame.add(t3);
	frame.add(l4);
    frame.add(t4);
    frame.add(b);
   frame.add(panel);
    frame.add(paneltwo); 
     Border blackline = BorderFactory.createLineBorder(Color.black);
     panel.setBorder(blackline);
    head.setForeground(Color.ORANGE);
    head.setBounds(300,0,1000,40);
    
    // for background colors of textfields
    Color c1=new Color(230,230,255);
    Color c2=new Color(255,224,204);
    Color c3= new Color(0,45,179);// foreground color of labels
    Color c4=new Color (51,224,51);
    Color c5=new Color(255,0,0);
    
    
    
    t1.setBounds(140, 120,100, 30);
            t1.setBackground(c1);
            t1.setFont(new Font("Serif",Font.BOLD,23));
            t1.setForeground(c5);
             String s1="2a is horizontal axis ";
            t1.setToolTipText(s1);
     t2.setBounds(140, 200,100, 30);
             t2.setBackground(c2);
             t2.setFont(new Font("Serif",Font.BOLD,23));
             t2.setForeground(c5);
             String s2="2b is vertical axis ";
             t2.setToolTipText(s2);
     t3.setBounds(140, 280,100, 30);
             t3.setBackground(c1);
             t3.setFont(new Font("Serif",Font.BOLD,23));
             t3.setForeground(c5);
             String s3="x displacement ";
             t3.setToolTipText(s3);
	t4.setBounds(140, 340,100, 30);
             t4.setBackground(c2);
             t4.setFont(new Font("Serif",Font.BOLD,23));
             t4.setForeground(c5);
             String s4="y displacement ";
             t4.setToolTipText(s4);		 
            
            
            
            
    l1.setBounds(120, 120,50, 40);
         l1.setFont(new Font("Serif",Font.BOLD,20));
         l1.setForeground(c3);
         
    l2.setBounds(120, 200,225, 40);
         l2.setFont(new Font("Serif",Font.BOLD,20));
          l2.setForeground(c3);
    l3.setBounds(120, 280,225, 40);
         l3.setFont(new Font("Serif",Font.BOLD,20));
          l3.setForeground(c3);
	l4.setBounds(120, 340,225, 40);
         l4.setFont(new Font("Serif",Font.BOLD,20));
          l4.setForeground(c3);	  
    
          
          // for submit button
    
    b.setBounds(140,400,140,50);
    b.setForeground(c4);
  //  b.setFont(new Font("LUCIDA CONSOLE",Font.BOLD,23));
    b.addActionListener(this);
    
    
    frame.setLayout(null);
    frame.setTitle("Circle");
    frame.setSize(screenSize);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   /* addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
   });  */
}
        public void actionPerformed(ActionEvent e)
        {
                width=Integer.parseInt(t1.getText());
                height=Integer.parseInt(t2.getText());
                x=Integer.parseInt(t3.getText());
                y=Integer.parseInt(t4.getText());
                SampleDialog d = new SampleDialog(this, "Dialog");
                d.setVisible(true);

        }
   
}