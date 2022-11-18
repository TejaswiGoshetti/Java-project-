import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;
import java.io.*;
class ATM_GUI extends JFrame{
	  JLabel jl,jl1,jl2,jl3,jl4,jl5;
                   JTextField jt4,jt5,jt6,jt,jt3,jt1,jt2,jt7;
	 JButton jb,jb1,jb2,jb3,jb4;
ATM_GUI()
            {
	super("Automated Teller Machine");
	jl=new JLabel("welcome to ATM-INTERFACE!!");
	jl.setFont(new Font("Arial",Font.PLAIN,20));
	jl1=new JLabel("Enter pin:");
	jl2=new JLabel("Enter account holder name: ");
	jl3=new JLabel(" Enter account number:");
	jl4=new JLabel(" Enter amount to be transferred: ");
	jl5=new JLabel(" Enter amount: ");	
	jt1=new JTextField(50);
	jt2=new JTextField(50);
	jt=new JTextField(4);
	jt3=new JTextField(50);
	jt4=new JTextField(50);
	jt5=new JTextField(50);
	jt6=new JTextField(50);
	jt7=new JTextField(50);
	jb=new JButton("SUBMIT");
	jb1=new JButton("DEPOSIT");
	jb2=new JButton("WITHDRAW");
	jb3=new JButton("BALANCE");
	jb4=new JButton("TRANSFER");
	jl.setBounds(150,35,300,25);
	jl1.setBounds(50,75,100,25);
	jt1.setBounds(50,250,100,25);
	jt2.setBounds(50,300,300,25);
	jb1.setBounds(400,225,100,25);
	jb2.setBounds(400,275,100,25);
	jb3.setBounds(400,325,100,25);
	jb4.setBounds(400,450,100,25);
	jt.setBounds(50,100,100,25);
	jt3.setBounds(50,150,300,25);
                  jb.setBounds(400,100,100,25);
	jt4.setBounds(50,400,300,25);
	jt5.setBounds(50,460,300,25);
	jt6.setBounds(50,520,300,25);
	jl2.setBounds(50,375,300,20);
	jl3.setBounds(50,435,300,20);
	jl4.setBounds(50,495,300,20);
	jl5.setBounds(50,225,100,20);
	jt7.setBounds(50,560,300,25);
	
	this.add(jl);
	this.add(jl1);
	this.add(jt1);
	this.add(jt2);
	this.add(jb1);
	this.add(jb2);
	this.add(jb3);
	this.add(jb4);
	this.add(jt);
	this.add(jt3);
	this.add(jb);
	this.add(jt4);
	this.add(jt5);
	this.add(jt6);
	this.add(jl2);
	this.add(jl3);
	this.add(jl4);
	this.add(jl5);
	this.add(jt7);	
	this.setSize(600,700);
	this.setLayout(null);
	this.setVisible(true);
//PIN
jb.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent ae)
    {                   
	int pin = 1234;
                  int entry=Integer.parseInt(jt.getText());
	jt.setText(String.valueOf(entry));
	if( entry != pin )	
	{
             	    jt3.setText(String.valueOf("Incorrect Pin Try Again!!.."));   
	}

	else{
	      jt3.setText(String.valueOf("Pin Accepted"));
	      transaction();
	}
	try{
		FileWriter fw=new FileWriter("atmint.text");
		fw.write(jt.getText()+"  "+jt3.getText());
		fw.close();
	}
	catch(Exception e ){}
    }
});
}
void transaction(){
//DEPOSIT
jb1.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent ae)
    {
        int dcash=Integer.parseInt(jt1.getText());
        GUI.updatebalance(dcash);  
         jt2.setText(String.valueOf("Amount Rs."+dcash+"/- deposited successfully")); 
	try{
		FileWriter fw=new FileWriter("atmint.text");
		fw.write(jt1.getText()+"  "+jt2.getText());
		fw.close();
	}
	catch(Exception e ){}
    }                             
});       

//WITHDRAW
jb2.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae)
       {
        int wcash=Integer.parseInt(jt1.getText());
        if(wcash<=GUI.balance){
              GUI.balance=GUI.balance-wcash;
              jt2.setText(String.valueOf("Amount Rs."+wcash+"/- withdraw successfully"));  
          }
        else{
              jt2.setText(String.valueOf("insufficient balance to withdraw the cash"));
           } 
	try{
		FileWriter fw=new FileWriter("atmint.text");
		fw.write(jt1.getText()+"  "+jt2.getText());
		fw.close();
	}
	catch(Exception e ){}    
      }                        
  });    


//BALANCE
jb3.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent ae)
    {    
          jt2.setText(String.valueOf("The available balance in the bank account :"+GUI.balance));
	try{
		FileWriter fw=new FileWriter("atmint.text");
		fw.write(jt2.getText());
		fw.close();
	}
	catch(Exception e ){}
     }   
});

//TRANSFER  
jb4.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent ae)
    {
        String name=jt4.getText();       
        int number=Integer.parseInt(jt5.getText());        
        int tcash=Integer.parseInt(jt6.getText());
        if(tcash<=GUI.balance){
            GUI.balance=GUI.balance-tcash;
        jt7.setText(String.valueOf("Amount Rs."+tcash+"/- transferred successfully"));
     }  
     else{
          jt7.setText(String.valueOf("insufficient balance to transfer the cash"));      
       } 
         try{
		FileWriter fw=new FileWriter("atmint.text");
		fw.write(jt4.getText()+" "+jt5.getText()+" "+jt6.getText()+"  "+jt7.getText());
		fw.close();
	}
	catch(Exception e ){}            
   }      
});    
}	 
public class GUI 
{
   	public static int balance=0;
	public static JTextField jt2;
  	static void updatebalance(int dcash){
               	           balance=balance+dcash;
                }
    	static void showbalance(){
                             jt2.setText(String.valueOf(balance));
      	}
}         
              public static void main (String[] args) 
              {
                   new ATM_GUI();
              }
}