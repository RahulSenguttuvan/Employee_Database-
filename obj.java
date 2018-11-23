import java.io.*;
import java.lang.String;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;   
import java.util.HashMap; 
import java.util.Map; 
import java.awt.*;
import java.awt.event.*;         
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JTable;  
import java.util.*;
import javax.swing.SortingFocusTraversalPolicy;


public class obj extends Frame implements Serializable {

   String name,filename,newname;
   Vector<Vector> rowData = new Vector<Vector>();
   int age,number,count,newage,option = 0,counter=0,done=1,cc=0;
   long mobile,newmobile;
   boolean exists = false, filethere = false,n=false;
   ArrayList<obj> o = new ArrayList<obj>();
   HashMap<Integer, String> map = new HashMap<Integer, String>();    // Used to store records 

   JLabel lblReg, lblName, lblage, lblmobile, lblInsert, lblUpdate, lbltemp, lblView, lblDelete, lblOptions, lblHome, lbltext; // JLabels for fields 
   JTextField tfReg, tfName, tfAge, tfMobile, tfUpdate, tfView, tfDelete ,tfUpdatedName, tfUpdatedAge, tfUpdatedMobile, tfViewarea;  // Area where used enters the input 
   Button btnInsert,btnUpdate,btnView, btnDelete, btnClear, btn1, btn2, btn3, btn4, btn5,    btnUpdateClear, btnDeleteClear, btnViewAll, btnNext, btnPrevious, btnFirst, btnLast;  

   JComboBox drop = new JComboBox(); 
   JPanel pn1 = new JPanel(); 
   JPanel pn2 = new JPanel();
   JPanel pn3 = new JPanel();
   JPanel pn4 = new JPanel();
   Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
   //FocusTraversalPolicy policy = new SortingFocusTraversalPolicy(pn1);
   //Border loweredBorder = BorderFactory.createBevelBorder( BevelBorder.LOWERED );
   //Border border1 = BorderFactory.createLineBorder(Color.WHITE, 5);
   JPanel pn5 = new JPanel();

   Font myFont = new Font("Serif",Font.BOLD,18);
   Frame f = new Frame();
      
   public obj(){

      f.removeAll();
      f.setLayout( new BorderLayout() );
      f.setBackground(Color.WHITE);

      f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
               System.exit(0);
               // dispose();
        }
      });


      lbltext = new JLabel("Employee Management System ");
      lbltext.setText("<html><font color = white> Employee Management System </html>");
      lbltext.setFont(new Font("Serif",Font.BOLD,40));

      pn2.setLayout( new GridBagLayout());
      pn2.add(lbltext);
      pn2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      pn2.setPreferredSize( new Dimension(200,100));
      pn2.setBackground(Color.orange);

      f.add(pn2,BorderLayout.NORTH);

      lblHome = new JLabel("Welcome, Please Choose an option! ");
      lblHome.setFont(new Font("Serif",Font.BOLD,32));
      
      pn5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));     

      pn1.setLayout( new GridBagLayout() );
      pn1.add(lblHome);
      pn1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      pn1.setPreferredSize( new Dimension(200,200) ); 
      f.add(pn1,BorderLayout.CENTER);

      pn5.setLayout( new GridLayout(5,1));
      

      btn1 = new Button("INSERT");
      btn1.setPreferredSize( new Dimension(100,50) );
      pn5.add(btn1);
     
      btn2 = new Button("Update"); 
      btn2.setPreferredSize( new Dimension(100,50) );
      pn5.add(btn2);
     

      btn3 = new Button("View");   
      btn3.setPreferredSize( new Dimension(100,50) );
      pn5.add(btn3);
   

      btn5 = new Button("ViewALL");
      btn5.setPreferredSize( new Dimension(100,50) );
      pn5.add(btn5);
    

      btn4 = new Button("Delete"); 
      btn4.setPreferredSize( new Dimension(100,50) );
      pn5.add(btn4);

      f.add(pn5,BorderLayout.WEST);

      pn3.setLayout( new GridBagLayout() );
      pn3.setPreferredSize( new Dimension(200,100) );
      pn3.setBackground(Color.orange); 
      f.add(pn3,BorderLayout.SOUTH);

      btnInsert = new Button("Insert");   
      btnClear = new Button("Clear");   

      pre();

      btn1.addActionListener( new ActionListener() {

         public void actionPerformed(ActionEvent e){

            Button1();

         }

      });

      btnUpdate = new Button("Update"); 
      btnUpdateClear = new Button("Clear");
      btn2.addActionListener( new ActionListener() {

         public void actionPerformed(ActionEvent e){

             Button2();
         }

      });

      btnView = new Button("View ( Please Specify Register no above ) ");   

      btn3.addActionListener( new ActionListener() {

         public void actionPerformed(ActionEvent e){

            Button3();
        }

      });

      btnDelete = new Button("Delete"); 
      btnDeleteClear = new Button("Clear");   

      btn4.addActionListener( new ActionListener() {

         public void actionPerformed(ActionEvent e){

            Button4();
       }

      });      

      btnNext = new Button("Next");
      btnPrevious = new Button("Previous");

      btnFirst = new Button("First");
      btnLast = new Button("Last");


      btn5.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){

            Button5();

          }

      });

      btnInsert.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){

            number = Integer.parseInt(tfReg.getText());
            name = tfName.getText();
            age = Integer.parseInt(tfAge.getText());
            mobile = Long.parseLong(tfMobile.getText());
            tfReg.setText("");
            tfAge.setText("");
            tfMobile.setText("");
            tfName.setText("");
            getvalue();
            mapread();  
            mapwrite();
            object();  

         }

      });

      btnClear.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){

            tfReg.setText("");
            tfAge.setText("");
            tfMobile.setText("");
            tfName.setText("");

         }

      });

   
      btnUpdate.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){
           int choice = 0;
           boolean flag = false;
            number = Integer.parseInt(tfUpdate.getText());
            mapread();  
            view();
           
            if( tfUpdatedName.getText().isEmpty() ) choice = 0; else {  newname = tfUpdatedName.getText(); update(1); }
            if( tfUpdatedAge.getText().isEmpty()) choice = 0; else { newage = Integer.parseInt(tfUpdatedAge.getText()); update(2); }
            if( tfUpdatedMobile.getText().isEmpty()) choice = 0; else { newmobile = Long.parseLong(tfUpdatedMobile.getText()); update(3); }
            tfUpdatedName.setText("");
            tfUpdatedAge.setText("");
            tfUpdatedMobile.setText("");
            tfUpdate.setText("");   
         }

      });

        btnUpdateClear.addActionListener( new ActionListener() {

         public void actionPerformed(ActionEvent e){
               
            tfUpdate.setText("");
            tfUpdatedName.setText("");
            tfUpdatedAge.setText("");
            tfUpdatedMobile.setText("");

         }

      });
      int count = 0;
               String[] description = {"5","10","20","50"};
                for (int i = 0; i < 4; i++)
                  drop.addItem(description[count++]);

      drop.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     Object ob;
                     //cc = 0;
                     if(!n)
                        done-=cc;
                     if(n)
                        n = false;
                     System.out.println(((JComboBox) e.getSource()).getSelectedItem());
                     ob  =  ((JComboBox) e.getSource()).getSelectedItem();
                     String val = String.valueOf(ob);
                     option = Integer.parseInt(val);
                     System.out.println("Option is "+option);
                     System.out.println("VAlue of done at drop"+done);
                     viewAll(option,done);
                     done+=cc;
                     Button5();
                  }
      });


      btnNext.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent e) {
                     n = true;
                     System.out.println("Value of done at next is "+done);
                     System.out.println("Value of done is :"+done);  
                     cc = 0; 
                     counter++;
                     rowData.clear();
                     Button5();
                  }
      });


      btnPrevious.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                     option = 5;
                     done -= (cc+option);
                     if( done <= 0){
                        done = 1;
                     }
                     cc = 0;
                     System.out.println("Value of done at prev is "+done);
                     viewAll(option,done);
                     done+=cc;
                     counter--;
                     Button5();
                  }
      });


      btnView.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){
            boolean flag = false;
            number = Integer.parseInt(tfView.getText());
            mapread();  
            view();
            tfView.setText("");
            tfViewarea.setText("");
             for( int i = 0; i < o.size(); i++ ){
               System.out.println(o.get(i));
               if( number == o.get(i).number ){
                  flag = true;
                  tfViewarea.setText(o.get(i)+"\n");    
               }
             }
             if(!flag)
               tfViewarea.setText("Null");
         }
      });
      
      btnDelete.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){

            number = Integer.parseInt(tfDelete.getText());
            tfDelete.setText("");
            mapread();  
            delete();
         }

      });

      btnDeleteClear.addActionListener( new ActionListener() {

          public void actionPerformed(ActionEvent e){

            tfDelete.setText("");
         }

      });

      f.setTitle("Employee Enrollment: ");  
      f.pack();  
      f.setSize(1000,1000);     
      f.setVisible(true);         // "super" Frame shows
   }

   void Button1(){
                     
                     pn1.removeAll();
                     pn1.setBackground(Color.WHITE);
                     pre();
                     btn1.setFont( new Font ("Arial",Font.BOLD,20));
                     btn1.setBackground(Color.orange);
                     pn1.setLayout(new GridBagLayout() );

                    
                   //  f.setFocusTraversalPolicy(policy);

                     GridBagConstraints c = new GridBagConstraints();
                     c.fill = GridBagConstraints.BOTH;      
                     pn1.setBackground(Color.WHITE);    
                     f.add(pn1,BorderLayout.CENTER);   
                     pn1.setVisible(true);
                     pn1.setPreferredSize( new Dimension(200,200) ); 
                     pn1.revalidate();
                     pn1.repaint();
                     f.add(pn1,BorderLayout.CENTER);
                     pn1.setVisible(true);
                     pn1.setPreferredSize( new Dimension(200,200) ); 
                     lblName = new JLabel("",JLabel.CENTER);
                     lblName.setText("<html><font color = black> Insert Operation </html>");
                     lblName.setFont(new Font ("Arial",Font.BOLD,30) );
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 0;
                     pn1.add(lblName,c);
                     
                     lblReg = new JLabel("Register No",JLabel.CENTER); 
                     lblReg.setBorder(border);
                     lblReg.setText("<html><font color = black> Register No: </html>");  
                     lblReg.setFont(myFont);
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 1;
                     pn1.add(lblReg,c);

                     tfReg = new JTextField(15);
                     tfReg.setFont(myFont);
                     tfReg.setEditable(true);  
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 1;
                     c.gridy = 1;
                     pn1.add(tfReg,c);

                     lblName = new JLabel("",JLabel.CENTER); 
                     lblName.setBorder(border);
                     lblName.setText("<html><font color = black> Name: </html>");  
                     lblName.setFont(myFont);
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 2;
                     pn1.add(lblName,c);

                     tfName = new JTextField(15);
                     tfName.setFont(myFont);
                     tfName.setEditable(true);  
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 1;
                     c.gridy = 2;
                     pn1.add(tfName,c);

                     lblage = new JLabel("",JLabel.CENTER); 
                     lblage.setBorder(border);
                     lblage.setText("<html><font color = black> Age: </html>");  
                     lblage.setFont(myFont);
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 3;
                     pn1.add(lblage,c);

                     tfAge = new JTextField(15);
                     tfAge.setFont(myFont);
                     tfAge.setEditable(true);  
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 1;
                     c.gridy = 3;
                     pn1.add(tfAge,c);

                     lblmobile = new JLabel("",JLabel.CENTER); 
                     lblmobile.setBorder(border);
                     lblmobile.setText("<html><font color = black> Mobile: </html>");  
                     lblmobile.setFont(myFont);
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 4;
                     pn1.add(lblmobile,c);

                     tfMobile = new JTextField(15);
                     tfMobile.setFont(myFont);
                     tfMobile.setEditable(true);  
                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 100;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 1;
                     c.gridy = 4;
                     pn1.add(tfMobile,c);

                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 50;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 0;
                     c.gridy = 5;

                     pn1.add(btnInsert,c);

                     c.insets = new Insets(2, 2, 2, 2);
                     c.weightx = 0; 
                     c.weighty = 0;
                     c.ipadx = 50;
                     c.ipady = 50;
                     c.gridwidth = 1;
                     c.gridheight = 1;
                     c.gridx = 1;
                     c.gridy = 5;

                     pn1.add(btnClear,c);
                     f.setVisible(true);
               }

   void Button2(){

               pn1.removeAll();
               pn1.setBackground(Color.WHITE);
               pre();
               btn2.setFont( new Font ("Arial",Font.BOLD,20));
               btn2.setBackground(Color.orange);
               pn1.setLayout(new GridBagLayout() );
               GridBagConstraints c = new GridBagConstraints();
               c.fill = GridBagConstraints.BOTH;      
               pn1.setBackground(Color.WHITE);    
               f.add(pn1,BorderLayout.CENTER);   
               pn1.setVisible(true);
               pn1.setPreferredSize( new Dimension(200,200) ); 
               pn1.revalidate();
               pn1.repaint();
               f.add(pn1,BorderLayout.CENTER);
               pn1.setVisible(true);
               pn1.setPreferredSize( new Dimension(200,200) ); 
               lblName = new JLabel("",JLabel.CENTER);
               lblName.setText("<html><font color = black> Update Operation </html>");
               lblName.setFont(new Font ("Arial",Font.BOLD,30) );
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 0;
               pn1.add(lblName,c);

               lblReg = new JLabel("Register No",JLabel.CENTER); 
               lblReg.setBorder(border);
               lblReg.setText("<html><font color = black> Register No: </html>");  
               lblReg.setFont(myFont);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 1;
               pn1.add(lblReg,c);

               tfUpdate = new JTextField(15);
               tfUpdate.setFont(myFont);
               tfUpdate.setEditable(true);  
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 1;
               c.gridy = 1;
               pn1.add(tfUpdate,c);

               lblOptions = new JLabel("",JLabel.CENTER);
               lblOptions.setText("<html><font color = black size = 120%> 1. Name: </html>");  
               lblOptions.setBorder(border);
               lblOptions.setFont(myFont);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 2;
               pn1.add(lblOptions,c);

               tfUpdatedName = new JTextField(15); 
               tfUpdatedName.setFont(myFont);
               tfUpdatedName.setEditable(true);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 1;
               c.gridy = 2;
               pn1.add(tfUpdatedName,c);

               lblOptions = new JLabel("",JLabel.CENTER);
               lblOptions.setBorder(border);
               lblOptions.setText("<html><font color = black size = 120%> 2. Age </html>");  
               lblOptions.setFont(myFont);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 3;
               pn1.add(lblOptions,c);

               tfUpdatedAge = new JTextField(15);
               tfUpdatedAge.setFont(myFont);
               tfUpdatedAge.setEditable(true);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 1;
               c.gridy = 3;
               pn1.add(tfUpdatedAge,c); 

               lblOptions = new JLabel("",JLabel.CENTER);
               lblOptions.setBorder(border);
               lblOptions.setText("<html><font color = black size = 120%> 3. Mobile: </html>");  
               lblOptions.setFont(myFont);    
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 4;
               pn1.add(lblOptions,c);


               tfUpdatedMobile = new JTextField(15);
               tfUpdatedMobile.setFont(myFont);
               tfUpdatedMobile.setEditable(true);
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 100;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 1;
               c.gridy = 4;
               pn1.add(tfUpdatedMobile,c);

               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 50;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 0;
               c.gridy = 5;

               pn1.add(btnUpdate,c);

               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipadx = 50;
               c.ipady = 50;
               c.gridwidth = 1;
               c.gridheight = 1;
               c.gridx = 1;
               c.gridy = 5;

               pn1.add(btnUpdateClear,c);

               f.setVisible(true);
         }


   void Button3(){


            pn1.removeAll();
            pre();
            btn3.setFont( new Font ("Arial",Font.BOLD,20));
            btn3.setBackground(Color.orange);
            pn1.setLayout(new GridBagLayout()); 
            pn1.revalidate();
            pn1.repaint();

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;      
            pn1.setBackground(Color.WHITE);    
            f.add(pn1,BorderLayout.CENTER);   
            pn1.setVisible(true);
            pn1.setPreferredSize( new Dimension(200,200) ); 
                  
            lblName = new JLabel("",JLabel.CENTER);
            lblName.setText("<html><font color = black> View Employee Record </html>");
            lblName.setFont( new Font ("Arial",Font.BOLD,30));
            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 0; 
            c.weighty = 0;
            c.ipadx = 50;
            c.ipady = 20;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.gridx = 0;
            c.gridy = 0;
            pn1.add(lblName,c);
            lblReg= new JLabel("Reg",JLabel.CENTER); 
            lblReg.setBorder(border);
            lblReg.setBackground(Color.blue);
            lblReg.setText("<html><font color = black size = 120%> Reg </html>");
            lblReg.setFont(myFont);

            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 0; 
            c.weighty = 0;
            c.ipadx = 50;
            c.ipady = 20;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.gridx = 0;
            c.gridy = 1;
          //  c.anchor =  GridBagConstraints.NORTH;
            pn1.add(lblReg,c);

            tfView = new JTextField(20); 
            tfView.setFont(myFont);
            tfView.setEditable(true);
            tfView.setPreferredSize( new Dimension(100,20) );  
            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 0; 
            c.weighty = 0;
            c.gridwidth = 2;
            c.gridheight = 1;
            c.ipadx = 100;
            c.ipady = 100;
            c.gridx = 1;
            c.gridy = 1;
            pn1.add(tfView,c);
            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 0; 
            c.weighty = 0;
            c.ipady = 20;
            c.gridwidth = 4;
            c.gridheight = 1;
            c.ipadx = 100;
            c.gridx = 0;
            c.gridy = 2;
            pn1.add(btnView,c);

            tfViewarea = new JTextField(20);
            tfViewarea.setFont(myFont);
            tfViewarea.setEditable(true);
            tfViewarea.setPreferredSize( new Dimension(100,20) );  
            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 0; 
            c.weighty = 0;
            c.ipady = 20;
            c.ipadx = 100;
            c.gridwidth = 4;
            c.gridheight = 4;
            c.gridx = 0;
            c.gridy = 4;
            pn1.add(tfViewarea,c);

            f.setVisible(true);

   }

   void Button4(){

         pn1.removeAll();
         pre();
         btn4.setFont( new Font ("Arial",Font.BOLD,20));
         btn4.setBackground(Color.orange);
         pn1.setLayout(new GridBagLayout()); 
         pn1.revalidate();
         pn1.repaint();
        // pn1.setBorder(BorderFactory.createTitledBorder( loweredBorder, "Delete Record") );
         GridBagConstraints c = new GridBagConstraints();    
         c.fill = GridBagConstraints.BOTH;     
         pn1.setBackground(Color.WHITE);    
         f.add(pn1,BorderLayout.CENTER);
         pn1.setVisible(true);
         pn1.setPreferredSize( new Dimension(200,200) ); 
         
         lblName = new JLabel("Delete Operation ",JLabel.CENTER);
         lblName.setText("<html><font color = black> Delete Operation </html>");
         lblName.setFont( new Font ("Arial",Font.BOLD,30) );
         c.insets = new Insets(2, 2, 2, 2);
         c.weightx = 0; 
         c.weighty = 0;
         c.ipadx = 100;
         c.ipady = 100;
         c.gridwidth = 1;
         c.gridheight = 1;
         c.gridx = 0;
         c.gridy = 0;
         lblName.setPreferredSize( new Dimension(100,20) );
         pn1.add(lblName,c);
         lblReg = new JLabel("Reg ",JLabel.CENTER); 
         lblReg.setBorder(border);
         //lblReg.setText("<html><font color = black> Reg </html>");
         lblReg.setFont(myFont);
         c.insets = new Insets(2, 2, 2, 2);
         c.weightx = 0; 
         c.weighty = 0;
         c.ipadx = 100;
         c.ipady = 100;
         c.gridwidth = 1;
         c.gridheight = 1;
         c.gridx = 0;
         c.gridy = 1;
         lblReg.setPreferredSize( new Dimension(100,20) );
         pn1.add(lblReg,c);

         tfDelete = new JTextField(20); 
         tfDelete.setFont(myFont);
         tfDelete.setEditable(true);
         c.insets = new Insets(2, 2, 2, 2);
         c.weightx = 0; 
         c.weighty = 0;
         c.gridwidth = 4;
         c.gridheight = 1;
         c.ipadx = 100;
         c.ipady = 100;
         c.gridx = 1;
         c.gridy = 1;
         tfDelete.setPreferredSize( new Dimension(100,20) );
         pn1.add(tfDelete,c);

         c.insets = new Insets(2, 2, 2, 2);
         c.weightx = 0; 
         c.weighty = 0;
         c.ipady = 20;
         c.gridwidth = 8;
         c.gridheight = 1;
         c.ipadx = 100;
         c.gridx = 0;
         c.gridy = 2;
         btnDelete.setPreferredSize( new Dimension(100,30) );
         pn1.add(btnDelete,c);
         c.insets = new Insets(2, 2, 2, 2);
         c.weightx = 0; 
         c.weighty = 0;
         c.ipady = 20;
         c.gridwidth = 8;
         c.gridheight = 1;
         c.ipadx = 100;
         c.gridx = 0;
         c.gridy = 3;
         pn1.add(btnDeleteClear,c);

         f.setVisible(true);
   }

   void Button5(){

               pn1.removeAll();
               pre();
               btn5.setFont( new Font ("Arial",Font.BOLD,20));
               btn5.setBackground(Color.orange);
               pn1.setLayout(new GridBagLayout()); 
               pn1.revalidate();
               pn1.repaint();
               GridBagConstraints c = new GridBagConstraints();    
               c.fill = GridBagConstraints.BOTH;     
               pn1.setBackground(Color.WHITE);    
               f.add(pn1,BorderLayout.CENTER);
               pn1.setVisible(true);

               pn1.setPreferredSize( new Dimension(200,200) ); 
               lblName = new JLabel("View all Employee Records Below ",JLabel.CENTER); 
               lblName.setFont(new Font ("Arial",Font.BOLD,30));
               lblName.setText("<html><font color = black> View all Employee Records Below  </html>");
               c.insets = new Insets(2, 2, 2, 2);
               c.weightx = 0; 
               c.weighty = 0;
               c.ipady = 20;
               c.ipadx = 100;
               c.gridwidth = 8;
               c.gridheight = 2;
               c.gridx = 0;
               c.gridy = 0;
               pn1.add(lblName,c);


              if( counter != 0 ){

                  c.insets = new Insets(2, 2, 2, 2);
                  c.weightx = 0; 
                  c.weighty = 0;
                  c.ipady = 20;
                  c.ipadx = 20;
                  c.gridwidth = 2;
                  c.gridheight = 2;
                  c.gridx = 3;
                  c.gridy = 3;
                  pn1.add(btnPrevious,c);

             }

               if( !filethere ){

                  c.insets = new Insets(2, 2, 2, 2);
                  c.weightx = 0; 
                  c.weighty = 0;
                  c.ipady = 20;
                  c.ipadx = 20;
                  c.gridwidth = 2;
                  c.gridheight = 2;
                  c.gridx = 5;
                  c.gridy = 3;
                  btnNext.setPreferredSize( new Dimension (40,40));
                  pn1.add(btnNext,c);
               }


               c.weightx = 0; 
               c.weighty = 0;
               c.ipady = 20;
               c.ipadx = 20;
               c.gridwidth = 1;
               c.gridheight = 2;
               c.gridx = 0;
               c.gridy = 3;
               pn1.add(drop,c);
                
               
               System.out.println("Option: "+option);
              
               //viewAll(option,done);
               Vector<String> columnNames = new Vector<String>();
               columnNames.addElement("Register No: ");
               columnNames.addElement("Name: ");
               columnNames.addElement("Age: ");
               columnNames.addElement("Mobile No: ");
               JTable table = new JTable(rowData, columnNames);
               c.weightx = 0; 
               c.weighty = 0;
               c.insets = new Insets(2, 2, 2, 2);
               c.ipady = 20;
               c.ipadx = 100;
               c.gridwidth = 8;
               c.gridheight = 6;
               c.gridx = 0;
               c.gridy = 6;
               
               table.setRowHeight(30);

              // DefaultTableModel tableModel = new DefaultTableModel() {
              //      public boolean isCellEditable(int row, int column) {                // Setting the table to non-editable
              //         return false;
              //      }
              //  };
              //  table.setModel(tableModel);

               JScrollPane scrollPane = new JScrollPane(table);
               pn1.add(scrollPane,c);
               f.setVisible(true); 
   }

   void pre(){

       btn1.setBackground(Color.blue);
       btn1.setForeground(Color.WHITE);
       btn2.setBackground(Color.blue);
       btn2.setForeground(Color.WHITE);
       btn3.setBackground(Color.blue);
       btn3.setForeground(Color.WHITE);
       btn4.setBackground(Color.blue);
       btn4.setForeground(Color.WHITE);
       btn5.setBackground(Color.blue);
       btn5.setForeground(Color.WHITE);
       btn1.setFont( new Font ("Arial",Font.PLAIN,14));
       btn2.setFont( new Font ("Arial",Font.PLAIN,14));
       btn3.setFont( new Font ("Arial",Font.PLAIN,14));
       btn4.setFont( new Font ("Arial",Font.PLAIN,14));
       btn5.setFont( new Font ("Arial",Font.PLAIN,14));
   }

   void update(int choice){    

      for(int  i = 0; i < o.size(); i++ ){
         if( this.number == o.get(i).number ){
            System.out.println("Found!");      
               if( choice == 1 ) {
                  o.get(i).name = this.newname; 
               }
              if( choice == 2){
                  o.get(i).age = this.newage; 
               }
               if( choice == 3){
                  o.get(i).mobile = this.newmobile; 
               }
         }
      }
      objwrite();
   }

   void objwrite(){

      try {
         ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(this.filename));
         oos.writeObject(o);
         oos.close();
      }
      catch(Exception e){

         e.printStackTrace();
      }

   }


   void objread(){

      try { 
         FileInputStream is = new FileInputStream(this.filename);
         ObjectInputStream ois = new ObjectInputStream(is);
            o = (ArrayList<obj>) ois.readObject();
            ois.close();
         is.close();
      }
      catch(Exception e){}

   }


   void helper(){    
         objread();
            o.add(this);  
         objwrite();
   }

   void object(){

      try {
         System.out.println("Filename : "+this.filename);
         exists = new File(this.filename).exists();
         if(exists)
         {
            helper();
         }
         else{
            System.out.println("New Record");
            o.clear();           // Clear is put here as just after reading the file in Checksize, the value of arraylist O has not been modified and must be emptied
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(this.filename));
            o.add(this);
            oos.writeObject(o);  
         }

      }
      catch( Exception e ){

         e.printStackTrace();
      }
   }
   void viewAll(int option, int done){
      
      mapread();
      boolean flag = false;
      int fno = 0,j=0;
      cc=0;
      this.filename = "sample0.ser";
      rowData.clear();
      filethere = false;
      while(exists = new File(this.filename).exists()){
      objread();
         for ( int i = 0; i < o.size(); i++ ){
           j++;
           if( done > j )              // Records seen so far...
               continue; 
                             // PageNation
           Vector<String> rowOne = new Vector<String>();
           rowOne.addElement(String.valueOf(o.get(i).number));
           rowOne.addElement(String.valueOf(o.get(i).name));
           rowOne.addElement(String.valueOf(o.get(i).age));
           rowOne.addElement(String.valueOf(o.get(i).mobile));
           rowData.addElement(rowOne);
           cc++;
           //done+=cc;
           if( rowData.size() >= option ){
               flag = true;
               break;
           }
         } 
         if(flag){
            break;
         }

         fno++;
         this.filename = "sample"+fno+".ser";
         System.out.println(" FNO is "+fno);
         System.out.println(" FILE NAme is  "+this.filename);
         System.out.println("Value of done below is "+done);
         
      }
      if(!(exists = new File(this.filename).exists()))
         filethere = true;
   }

   void view(){

         System.out.println("The file is :"+this.filename);
         objread();
   }

   boolean checksize(){

         objread();
         if( o.size() == 0 )
            return true;
         if( o.size() < 2 )            // Checking condition for size greater than 5 
            return true;   
      return false;

   }


   void getvalue(){
      
      while(true) // Checking if current filesize has greater than 5 records
      {
         try{ 

            exists = new File(this.filename).exists();
            if( exists && (!this.checksize()) ){      // iterating through the files, to see if it exists already
               this.count++;
               System.out.println("Checking a new file...");
               this.filename = "sample"+this.count+".ser";
            }
            else
               break;      
         }
         catch (Exception e) {
            
            e.printStackTrace();
         }
      }
      System.out.println(this.number+" "+this.filename);

   }


   void delete(){

      objread();
      System.out.println("Record in file: "+this.filename);
      System.out.println("Size of ArrayList Before :"+o.size());
      for( int i = 0; i < o.size(); i++ ){

         if( this.number == o.get(i).number ){
            mapread();
            map.remove(o.get(i).number);
            mapwrite();
            System.out.println("Elements in arraylist :"+o);
            o.remove(i);
            objwrite();
            if(checksize()){
               System.out.println("File empty after last recrod, so file deleted");
               File file = new File("sample1.ser.ser");
               if(file.delete())
                  System.out.println("Deleted");
            }
         }
      }     
      System.out.println("Size of ArrayList After :"+o.size());
      objwrite();
   }

   public String toString() {

      return "Register:"+this.number+" "+"Name:"+this.name+" "+"Age:"+this.age+" "+"Mobile:"+this.mobile;
   }

   void mapread(){

      try { 
          File toRead=new File("map.txt");
           FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            map=(HashMap<Integer,String>)ois.readObject();
            ois.close();
            fis.close();
         }
         catch(Exception e){}
         if( map.containsKey(this.number) ){
               this.filename = map.get(this.number);
               System.out.println(this.filename);
         }
   }

   void mapwrite(){

            map.put(this.number,this.filename);    // Inserting records into a hash map
            try{
               File f1 = new File("map.txt");
               FileOutputStream fos=new FileOutputStream(f1);
               ObjectOutputStream oos=new ObjectOutputStream(fos);
                 oos.writeObject(map);
                 oos.flush();
                 oos.close();
                 fos.close(); 
            }
            catch(Exception e){}
      }


   public static void main(String args[]){

        try { 
  
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 

      obj db = new obj();
      Scanner sc = new Scanner(System.in);
      db.filename = "sample0.ser";
      boolean exists = false;
      int choice;
   }
}  
