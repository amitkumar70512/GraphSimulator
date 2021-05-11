package Line;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

class plot extends Dialog {
 line tri;
  Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
 plot(Frame parent, String title){
  super(parent, title, false); 
  tri= (line)parent;
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
    title= "y = "+tri.m+"x + "+tri.c;
    g.drawString(title,800,80);
    Color c1 = new Color(100, 100, 255);
    g.setColor(Color.BLACK);
    Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
    g.drawLine(screenSize.width/2,50,screenSize.width/2,screenSize.height-50);
    g.drawLine(100,(screenSize.height)/2-25,screenSize.width-100,(screenSize.height)/2-25);
	int swidth= screenSize.width/2;
	int sheight= (screenSize.height)/2-25;
	
    g.drawString("0",swidth-4,sheight+4);
    g.drawLine(swidth,50,swidth-10,60);
   g.drawLine(swidth,50,swidth+10,60);
   g.drawLine(100,sheight,110,sheight+10);
   g.drawLine(100,sheight,110,sheight-10);
    g.drawLine(swidth,screenSize.height-50,swidth+10,screenSize.height-60);
    g.drawLine(swidth,screenSize.height-50,swidth-10,screenSize.height-60);
        g.drawLine(screenSize.width-100,sheight,screenSize.width-110,sheight-10);
        g.drawLine(screenSize.width-100,sheight,screenSize.width-110,sheight+10);

    
         g.setFont(new Font("Serif",Font.BOLD,25));
    g.drawString("-X",70,(screenSize.height)/2-25);
    g.drawString("+X",screenSize.width-98,(screenSize.height)/2-25);
	g.drawString("-Y",screenSize.width/2 +15,screenSize.height-50);
        g.drawString("+Y",screenSize.width/2 +15,55);
	
	 
	 
      try{ Thread.sleep(2000); }
      catch(Exception e){}
    int a= tri.m;
    int a1= tri.c;
    int b;
    if(a1<0)
    b=a1*-1;
    else b=a1;
    //int xint = (c*-1)/m;
    int x =((screenSize.height-200)/2)/(b+5);
    int i,j=1;
    String s;
    g.setFont(new Font("Serif",Font.BOLD,10));
	    for(i=sheight-x;i>=50;i=i-x)
    {
		g.drawLine(swidth-5,i,swidth+5,i);
		s= Integer.toString(j);
		j++;
		g.drawString(s,swidth+7,i+2);
	}
	j=-1;
	for(i=sheight+x;i<=screenSize.height-110;i=i+x)
    {
		g.drawLine(swidth-5,i,swidth+5,i);
		s= Integer.toString(j);
		j--;
		g.drawString(s,swidth-25,i+2);
	}
	j=1;
	for(i=swidth+x;i<=screenSize.width-110;i=i+x)
    {
		g.drawLine(i,sheight-5,i,sheight+5);
		s= Integer.toString(j);
		j++;
		g.drawString(s,i-2,sheight+30);
	}
	j=-1;
	for(i=swidth-x;i>=110;i=i-x)
    {
		g.drawLine(i,sheight-5,i,sheight+5);
		s= Integer.toString(j);
		j--;
		g.drawString(s,i-4,sheight-15);
	}
	int p,q,r,t;
	int k,m;
	k= (int)Math.abs(a);
	m= (int)Math.abs(a1) * -1;
	for(i=-1;;i--)
	{
		q= i*k + m;
		if(q<(m-5))
		{
			q=(i+1)*k + m;
			p=i+1;
			break;
		}
	}
	for(i=1;;i++)
	{
		t= i*k + m;
		if(t>((m*-1)+5))
		{
			t=(i-1)*k+ m;
			r=i-1;
			break;
		}
	}
	g.setColor(c1);
	if(a>=0 && a1<=0)
	g.drawLine(swidth+(x*p),sheight-(q*x),swidth+(x*r),sheight-(x*t));
	else if(a>=0 && a1>0)
	{
		p=p*-1; q=q*-1;r=r*-1;t=t*-1;
		g.drawLine(swidth+(x*p),sheight-(q*x),swidth+(x*r),sheight-(x*t));
	}
	else if(a<0 && a1>=0)
	{
		q=q*-1;t=t*-1;
		g.drawLine(swidth+(x*p),sheight-(q*x),swidth+(x*r),sheight-(x*t));
	}
	else
	{
		p=p*-1;r=r*-1;
		g.drawLine(swidth+(x*p),sheight-(q*x),swidth+(x*r),sheight-(x*t));
	}
    /*for(j=120;j<=1160;j=j+20)
     g.drawLine(j,705,j,695);
     g.drawLine(100,680,360,160);*/
   
  

 }


}
public class line extends JFrame implements ActionListener
{
JLabel l1,l2;
JButton b;
JTextField t1,t2;
int m,c;
Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
public line()
{
   JFrame frame=new JFrame();
  JPanel panel=new JPanel();
   Label head =new Label (" General Equation of  straight line:  y=mx+c  ");
   head.setFont(new Font("Serif",Font.BOLD,30));
    
   
    l1=new JLabel("m(slope) value:",Label.LEFT);
    l2=new JLabel("c(y intercept) value:",Label.LEFT);
    
    t1=new JTextField(5);
    t2=new JTextField(5);
    //t3=new JTextField(5);
   
    //ImageIcon submit=new ImageIcon("Submiticon.jpeg");
    ImageIcon submit=new ImageIcon("Submiticon.png");
    b = new JButton(submit);
   
   panel.add(head);
   
   JPanel paneltwo=new JPanel();
   ImageIcon lin=new ImageIcon("linepic.png");
   JButton line=new JButton(lin);
   paneltwo.add(line);
  paneltwo.setBounds(600,80,500,1000);
  
  panel.setBounds(40, 20, 1000, 60);
   frame.add(l1);
    frame.add(t1);
    frame.add(l2);
    frame.add(t2);
    //frame.add(l3);
    //frame.add(t3);
    frame.add(b);
   frame.add(panel);
   frame.add(paneltwo); 
    
    //x=800;
    //y=200;
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
    
    
    
    t1.setBounds(400, 120,100, 30);
            t1.setBackground(c1);
            t1.setFont(new Font("Serif",Font.BOLD,23));
            t1.setForeground(c5);
             String s1=" m represents the slope ";
            t1.setToolTipText(s1);
     t2.setBounds(400, 200,100, 30);
             t2.setBackground(c2);
             t2.setFont(new Font("Serif",Font.BOLD,23));
             t2.setForeground(c5);
             String s2="c represents the y-intercept";
             t2.setToolTipText(s2);
    
            
            
            
    l1.setBounds(120, 120,200, 40);
         l1.setFont(new Font("Serif",Font.BOLD,20));
         l1.setForeground(c3);
         
    l2.setBounds(120, 200,225, 40);
         l2.setFont(new Font("Serif",Font.BOLD,20));
          l2.setForeground(c3);
     
          // for submit button
    
    b.setBounds(140,280,140,50);
    b.setForeground(c4);
  //  b.setFont(new Font("LUCIDA CONSOLE",Font.BOLD,23));
    b.addActionListener(this);
    
    
    frame.setLayout(null);
    frame.setTitle("Line");
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
                
				m= Integer.parseInt(t1.getText());
				c= Integer.parseInt(t2.getText());
				plot P = new plot(this,"Line");
				P.setVisible(true);
                repaint();

        }
       
          
    
}