import Circle.*;
import Ellipse.*;
import Parabola.*;
import Line.*;
import java.awt.Choice;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class project extends JFrame implements ItemListener,ActionListener{
    JFrame frame;
    JLabel pic;
    JPanel header;
    JPanel left,right;
    Timer tm;
    JButton Next;
    Choice ch;
    int x = 0;
    int z=0;
    //Images Path In Array
    String[] list = {
                      "lineslide.jpeg",
       "ellie.jpeg",
       "circleslide.jpeg",
       "paraslide.jpeg"
                    };
    
    public project(){
        super("Java SlideShow");
        frame=new JFrame();
        header=new JPanel();
        left=new JPanel();
        right=new JPanel();
        pic = new JLabel();
        
             Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
        pic.setBounds(screenSize.width*30/100,screenSize.height*40/100,screenSize.width*40/100,screenSize.height*40/100);
            
        Label head =new Label ("GRAPH SIMULATOR ");
          head.setFont(new Font("Serif",Font.BOLD,30));
        header.add(head);
       
        header.setBounds(screenSize.width*10/100,screenSize.height*2/100,screenSize.width*80/100,screenSize.height*7/100);
        // for left panel
       
        left.setBounds(0,screenSize.height*9/100,screenSize.width*19/100,screenSize.height*81/100);
        left.setBackground(Color.decode("#eeeeee"));
         right.setBounds(screenSize.width*81/100,screenSize.height*9/100,screenSize.width*19/100,screenSize.height*81/100);
        right.setBackground(Color.decode("#eeeeee"));
        
       Next=new JButton("NEXT");
       Next.setToolTipText("Click Next for Graph Simulation ");
       ch=new Choice();
       ch.add("Line");
       ch.add("Circle");
       ch.add("Ellipse");
       ch.add("Parabola");
       
       ch.setBounds(screenSize.width/2-screenSize.width/10,screenSize.height*15/100,screenSize.width/5,screenSize.height*10/100);
       Next.setBounds(screenSize.width/2- screenSize.width/30,screenSize.height*25/100,screenSize.width/20,screenSize.height*5/100);
        //Call The Function SetImageSize
        SetImageSize(3);
               //set a timer
        tm = new Timer(1500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        frame.add(pic);
        frame.add(ch);
        frame.add(header);
        frame.add(Next);
        frame.add(left);
        frame.add(right);
        tm.start();
        ch.addItemListener(this);
        Next.addActionListener(this);
        frame.setLayout(null);
        frame.setSize(screenSize);
        frame.getContentPane().setBackground(Color.decode("#eeeeee"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent we)
    {
        dispose();
    }
   });
        
        
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
     public void itemStateChanged(ItemEvent ie){
        z=ch.getSelectedIndex();// starts from 0 to soon
      
   }
   
   public void actionPerformed(ActionEvent ae){
       if(z==0)
       {

        
       Line.line  l= new Line.line();
       //frame.setVisible(false);
     
       }
       else if(z==1)
       {
         
          Circle.circle c=new Circle.circle(); 
            //frame.setVisible(false);
       
       }
       else if(z==2)
       {
           
           Ellipse.ellipse e=new Ellipse.ellipse();
           //frame.setVisible(false);
          
       }
       else if(z==3)
       {
           
           Parabola.parabola p=new Parabola.parabola();
           //frame.setVisible(false);
       }
       else
       {// if nothing selected, line will be auto selected
          
          
          Line.line  l= new Line.line();
          //frame.setVisible(false);
          
       }
       
   }
   


public static void main(String[] args){ 
      
    new project();
}
}