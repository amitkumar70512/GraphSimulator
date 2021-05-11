package Parabola;
import java.lang.Math;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

class SampleDialog extends Dialog
{
parabola bld;
 Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
SampleDialog(Frame parent, String title)
 {
super(parent, title, true); 
bld=(parabola)parent;
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
    
	
	
	g.setColor(Color.BLACK);
    Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
    g.drawLine(screenSize.width/2,50,screenSize.width/2,screenSize.height-100); //y
	g.drawLine(100,(screenSize.height)/2-25,screenSize.width-100,(screenSize.height)/2-25); //x
	int swidth= screenSize.width/2;
	int sheight= (screenSize.height)/2-25;
    
    
    
     g.drawString("0",swidth-4,sheight+4);
    g.drawLine(swidth,50,swidth-10,60);   //arrows
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
    int c= bld.z;
	
    
	int temp,temp1,temp2;
    
    
	if(bld.rad==1)
	{
	temp1= (((screenSize.height-200)/2)/(Math.abs(b)+(Math.abs(c)*4)));
	temp2= (((screenSize.width-200)/2)/(Math.abs(a)+2));
	}
    else 
	{
	temp1= (((screenSize.width-200)/2)/(Math.abs(a)+(Math.abs(c)*4)));
	temp2= (((screenSize.height-200)/2)/(Math.abs(b)+2));
	}
	
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
	
	int radius=c*4;
	g.setColor(Color.BLUE);
	if(bld.rad==1){
	if(c>0)
	g.drawArc(((swidth+(a*temp))-(2*temp)),((sheight-(b*temp))-(2*radius*temp)),4*temp,radius*2*temp,180,180);
	else
	g.drawArc((swidth+(a*temp)-(2*temp)),(sheight-(b*temp)),4*temp,radius*2*temp,0,180);
	}
    else
	{
	if(c>0)
	g.drawArc((swidth+(a*temp)),((sheight-(b*temp))-(2*temp)),radius*2*temp,4*temp,90,180);
	else
	 g.drawArc((swidth+(a*temp)-radius*2*temp),(sheight-(b*temp)-2*temp),radius*2*temp,4*temp,90,-180);
	}
	g.setFont(new Font("Courier",Font.BOLD,20));
        g.setColor(Color.BLUE);
         String s1="equation:  (y-"+b+")^2=4*"+a+"(x-"+c+")";
          String s2="equation: (x-"+c+")^2=4*"+a+"(y-"+b+")";
        if(bld.selected==1)
        {
        g.drawString(s1,(2*swidth-400),(2*sheight-10));    
        }
        else if(bld.selected==2)
        {
            g.drawString(s2,(2*swidth-400),(2*sheight-10));    
        }
	
    
     
}


}
public class parabola extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4;
JButton b;
JTextField t1,t2,t3,t4;
int x,y,z,rad=0;
int selected=0;
JFrame frame;
 Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();

public parabola()
{
    frame=new JFrame();
  JPanel panel=new JPanel();
   Label head =new Label (" General Equation of  parabola: \nType1: y=a(x-h)^2 +k \nType2: x=a(y-k)^2 +h");
   head.setFont(new Font("Serif",Font.BOLD,30));
   panel.add(head);
   
   
    Font myFont = new Font("Courier", Font.BOLD,20);
         Color colorcb=new Color(0,205,40);  
        JCheckBox CB1 = new JCheckBox("X-Axis as Major axis");  
        CB1.setBounds(100,110, 300,50);  
        CB1.setFont(myFont);
        CB1.setForeground(colorcb);
        CB1.setToolTipText("2a on X-axis");
        
        JCheckBox CB2 = new JCheckBox("Y-Axis as Major axis");  
        CB2.setBounds(420,110, 300,50);  
         CB2.setFont(myFont);
         CB2.setForeground(colorcb);
         CB2.setToolTipText("2a on Y-axis");
             CB1.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
                if(selected==2){
                  CB2.setSelected(false);
                }
                 if(e.getStateChange()==1)
                     selected=1;
                 rad=2;
             }    
          });  
               CB2.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
               if(selected==1){
                   CB1.setSelected(false);
               }
                  if(e.getStateChange()==1)
                     selected=2;// saying that 2nd option checkbox is selected
                   rad=1;
             }    
          }); 
    //l1=new JLabel("Type of parabola= ");
    l2=new JLabel("Horizontal displacement-h= ");
    l3=new JLabel("Vertical displacement-k= ");
    l4=new JLabel("a= ");
   // t1=new JTextField(5);
    t2=new JTextField(5);
    t3=new JTextField(5);
    t4=new JTextField(5);
    ImageIcon submit=new ImageIcon("Submiticon.png");
    b = new JButton(submit);
    
   JPanel paneltwo=new JPanel();
   ImageIcon par=new ImageIcon("parabolapic.jpeg");
   JButton parabola=new JButton(par);
   paneltwo.add(parabola);
   paneltwo.setBounds(700,200,600,1000);
   panel.setBounds(40, 20, 1000, 60);
   
   frame.add(CB1);
   frame.add(CB2);
   //frame.add(l1);
    //frame.add(t1);
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
     b.setBorder(blackline);
    // for background colors of textfields
    Color c1=new Color(230,230,255);
    Color c2=new Color(255,224,204);
    Color c3= new Color(0,45,179);// foreground color of labels
    Color c4=new Color (51,224,51);
    Color c5=new Color(255,0,0);
    
    
  /*  
   t1.setBounds(400, 120,100, 30);
            t1.setBackground(c1);
            t1.setFont(new Font("Serif",Font.BOLD,23));
            t1.setForeground(c5);
            String s1="Enter your option ";
            t1.setToolTipText(s1);
    */
     t2.setBounds(400, 200,100, 30);
             t2.setBackground(c2);
             t2.setFont(new Font("Serif",Font.BOLD,23));
             t2.setForeground(c5);
             String s2="x value of vertex ";
             t2.setToolTipText(s2);
     t3.setBounds(400, 280,100, 30);
             t3.setBackground(c1);
             t3.setFont(new Font("Serif",Font.BOLD,23));
             t3.setForeground(c5);
             String s3="y value of vertex ";
             t3.setToolTipText(s3);
	t4.setBounds(400, 340,100, 30);
             t4.setBackground(c2);
             t4.setFont(new Font("Serif",Font.BOLD,23));
             t4.setForeground(c5);
             String s4="value of a ";
             t4.setToolTipText(s4);		 
           
      
    /*        
    l1.setBounds(120, 120,250, 40);
         l1.setFont(new Font("Serif",Font.BOLD,20));
         l1.setForeground(c3);
      */   
    l2.setBounds(120, 200,250, 40);
         l2.setFont(new Font("Serif",Font.BOLD,20));
          l2.setForeground(c3);
    l3.setBounds(120, 280,250, 40);
         l3.setFont(new Font("Serif",Font.BOLD,20));
          l3.setForeground(c3);
	l4.setBounds(120, 340,250, 40);
         l4.setFont(new Font("Serif",Font.BOLD,20));
          l4.setForeground(c3);	  
    
          
          // for submit button
    
    b.setBounds(140,600,140,50);
    b.setForeground(c4);
  //  b.setFont(new Font("LUCIDA CONSOLE",Font.BOLD,23));
    b.addActionListener(this);
    
    
    frame.setLayout(null);
    frame.setTitle("parabola");
    frame.setSize(screenSize);
    frame.setVisible(true);
    frame.setResizable(false);
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
                x=Integer.parseInt(t2.getText());
                y=Integer.parseInt(t3.getText());
                z=Integer.parseInt(t4.getText());
		
                 SampleDialog d = new SampleDialog(this, "Graph");
                d.setVisible(true);
                

        }
       
}