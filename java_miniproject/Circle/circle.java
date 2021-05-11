package Circle;
import java.lang.Math;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

class SampleDialog extends Dialog
{
circle bld;
 Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
SampleDialog(Frame parent, String title)
 {
super(parent, title, true); 
bld=(circle)parent;
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
    g.setColor(Color.RED);
    g.setFont(new Font("Serif",Font.BOLD,20));
    String title;
    int radius= bld.width/2;
    title= "[x-("+bld.x+")]^2 + [y-("+bld.y+")]^2 = "+(radius*radius);
    g.drawString(title,800,80);
    g.setColor(Color.BLACK);
    Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
    g.drawLine(screenSize.width/2,50,screenSize.width/2,screenSize.height-100);
	g.drawLine(100,(screenSize.height)/2-25,screenSize.width-100,(screenSize.height)/2-25);
	int swidth= screenSize.width/2;
	int sheight= (screenSize.height)/2-25;
    
    
    
    
    
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
    
    
    int a= bld.x;
    int b= bld.y;
    
    int temp1;temp1= ((screenSize.height-200)/2)/(Math.abs(b)+(bld.width/2));
    int temp2;temp2= ((screenSize.height-200)/2)/(Math.abs(a)+(bld.width/2));
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
	g.drawOval(((swidth+(a*temp))-(radius*temp)),((sheight-(b*temp))-(radius*temp)),radius*2*temp,radius*2*temp);
	g.drawLine((swidth+(a*temp)),(sheight-(b*temp)),(swidth+(a*temp)+(radius*temp)),(sheight-(b*temp)));
	String c1,c2;
	c1= Integer.toString(a);
	c2= Integer.toString(b);
	String center = "C("+c1+","+c2+")";
        g.setFont(new Font("Courier",Font.BOLD,20));
        g.setColor(Color.RED);
	g.drawString(center,(swidth+(a*temp)),(sheight-(b*temp)));
    
    
 
     }


}
public class circle extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JButton b;
JTextField t1,t2,t3;
int x,y,width,height;
 JFrame frame;
  Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
 
public circle()
{
    frame=new JFrame();
  JPanel panel=new JPanel();
   Label head =new Label (" General Equation of  circle:  (x-h)^2 +(y-k)^2=r^2  ");
   head.setFont(new Font("Serif",Font.BOLD,30));
   panel.add(head);
   
    l1=new JLabel("Radius of Circle-R");
    l2=new JLabel("Horizontal displacement-h");
    l3=new JLabel("Vertical displacement-k");
    
    t1=new JTextField(5);
    t2=new JTextField(5);
    t3=new JTextField(5);
   
    ImageIcon submit=new ImageIcon("Submiticon.png");
    b = new JButton(submit);
    
   JPanel paneltwo=new JPanel();
   ImageIcon cir=new ImageIcon("circleone.png");
   JButton circle=new JButton(cir);
   paneltwo.add(circle);
  paneltwo.setBounds(600,80,800,1000);
   
   panel.setBounds(40, 20, 1000, 60);
   frame.add(l1);
    frame.add(t1);
    frame.add(l2);
    frame.add(t2);
    frame.add(l3);
    frame.add(t3);
    frame.add(b);
   frame.add(panel);
   frame.add(paneltwo); 
   
     Border blackline = BorderFactory.createLineBorder(Color.black);
     panel.setBorder(blackline);
    head.setForeground(Color.ORANGE);
    head.setBounds(300,0,1000,40);
     b.setBorder(blackline);
    // for background colors of textfields
    Color c1=new Color(230,230,255);
    Color c2=new Color(255,224,204);
    Color c3= new Color(0,45,179);// foreground color of labels
    Color c4=new Color (51,224,51);
    Color c5=new Color(255,0,0);
    
    
    
    t1.setBounds(400, 120,100, 30);
            t1.setBackground(c1);
            t1.setFont(new Font("Serif",Font.BOLD,23));
            t1.setForeground(c5);
             String s1=" r represents the radius ";
            t1.setToolTipText(s1);
     t2.setBounds(400, 200,100, 30);
             t2.setBackground(c2);
             t2.setFont(new Font("Serif",Font.BOLD,23));
             t2.setForeground(c5);
             String s2="h represents the horizontal displacement : how far to the left or to the right of the y-axis  the center of the circle is.";
             t2.setToolTipText(s2);
     t3.setBounds(400, 280,100, 30);
            t3.setBackground(c2);
            t3.setFont(new Font("Serif",Font.BOLD,23));
            t3.setForeground(c5);
            String s3="k represents the vertical displacement : how far above or below the x-axis  the center falls. ";
            t3.setToolTipText(s3);
            
            
            
            
    l1.setBounds(120, 120,200, 40);
         l1.setFont(new Font("Serif",Font.BOLD,20));
         l1.setForeground(c3);
         
    l2.setBounds(120, 200,225, 40);
         l2.setFont(new Font("Serif",Font.BOLD,20));
          l2.setForeground(c3);
          
    l3.setBounds(120,280,225, 40);
         l3.setFont(new Font("Serif",Font.BOLD,20));
          l3.setForeground(c3);
          
          // for submit button
    
    b.setBounds(120,360,140,50);
    b.setForeground(c4);
  //  b.setFont(new Font("LUCIDA CONSOLE",Font.BOLD,23));
    b.addActionListener(this);
    
    
    frame.setLayout(null);
    frame.setTitle("Circle");
    frame.setSize(screenSize);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    // for awt 
   /* addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
   });  */
}
        public void actionPerformed(ActionEvent e)
        {
                x=Integer.parseInt(t2.getText());
                y=Integer.parseInt(t3.getText());
                int rad=Integer.parseInt(t1.getText());
                width=height=2*rad;
                 SampleDialog d = new SampleDialog(this, "Graph");
                d.setVisible(true);
                

        }
}