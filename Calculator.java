   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import javax.accessibility.*;

   public class Calculator extends JFrame implements ActionListener{
   
      private JMenuItem calculateButton;
      private JMenuItem clearButton;
      private JMenuItem exitButton;
      private JMenuItem aboutButton;
      private JMenuItem inputInformationButton;
   
      private JTextArea textArea = new JTextArea(3,10);
                     
   
      private JPanel panelOne = new JPanel();
      private JPanel panelTwo = new JPanel();
      private JPanel panelThree = new JPanel();
   
   //******************************
      private AccessibleEditableText at = textArea.getAccessibleContext().getAccessibleEditableText();
      private JLabel outputLabel = new JLabel();
   //******************************
      
      String line;
   
   
      public static void main(String[] args){
      
         Calculator calculator = new Calculator();
      
         calculator.setTitle("Project 2");
         calculator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         calculator.setSize(400,300);
         calculator.setVisible(true);
      }
   
      public Calculator(){
      
      
      ///////////////////////////////////////////////////MENU BAR//////////////////////////////////////////////
      //creates menu bar object
         JMenuBar menu = new JMenuBar();
      
         setJMenuBar(menu);
      
      //creates the different menus
         JMenu operation = new JMenu("Operation");
         JMenu help = new JMenu("Help");
      
      //adds the menus to the menu bar
         menu.add(operation);
         menu.add(help);
      
      //adds menu items to the operation menu
         operation.add(calculateButton = new JMenuItem("Calculate",'L'));
         operation.add(clearButton = new JMenuItem("Clear",'R'));
         operation.addSeparator();
         operation.add(exitButton = new JMenuItem("Exit",'E'));
      
      //adds menu items to the help menu
         help.add(aboutButton = new JMenuItem("About",'T'));
         help.add(inputInformationButton = new JMenuItem("Input Information",'I'));
      
      //adds keyboard shortcuts to each menu item
         calculateButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK)); //change from KeyEvent.VK_C to KeyEvent.VK_L
         clearButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
         exitButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
         aboutButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
         inputInformationButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
      
      //adds action listener to each menu item      
         calculateButton.addActionListener(this);
         clearButton.addActionListener(this);
         exitButton.addActionListener(this);
         aboutButton.addActionListener(this);
         inputInformationButton.addActionListener(this);
      /////////////////////////////////////////////////////////////////////////////////////////////      
      
      //////////////////////////////////////////GRID LAYOUT////////////////////////////////////////
      /*WEST PANEL*/
         panelOne.setLayout(new GridLayout(2,1));
         panelOne.add(new JLabel("Enter Equation"));
         panelOne.add(new JLabel("Value"));
      
      /*EAST PANEL*/
         panelTwo.setLayout(new GridLayout(2,1));
         panelTwo.add(textArea);
         panelTwo.add(outputLabel);
      
      /*SOUTH PANEL*/
      
      //******************** Rename buttons to unique names and add the action listener
         JButton calButton = new JButton("Calculate");
         JButton clButton = new JButton("Clear");   
			
			calButton.addActionListener(this);
			clButton.addActionListener(this);
      //********************   
      
         panelThree.setLayout(new GridLayout(1,2));
         panelThree.add(calButton);
         panelThree.add(clButton);	
      
         add(panelOne,BorderLayout.WEST);
         add(panelTwo,BorderLayout.CENTER);
         add(panelThree,BorderLayout.SOUTH);
      /////////////////////////////////////////////////////////////////////////////////////////////
      }
   
   
      public void actionPerformed(ActionEvent e){
      
         String action = e.getActionCommand();
      
         if(e.getSource() instanceof JMenuItem)
         {
            if("Calculate".equals(action))
               performCalculate();
            else if("Clear".equals(action))
               performClear();
            else if("Exit".equals(action))
               performExit();
            else if("About".equals(action))
               performAbout();
            else if("Input Information".equals(action))
               performInputInformation();
         }
         //************* add cases for the buttons themselves
         else if (e.getSource() instanceof JButton)
         {
            if("Calculate".equals(action))
               performCalculate();
            else if("Clear".equals(action))
               performClear();
         }
         //************		
      
      }
   
      public void performCalculate(){
      
         //******************
         line = at.getTextRange(0, at.getCharCount()); //get the string entered in the Text Area
      
         FractionProcess fp = new FractionProcess();
      
         String answer = fp.calculate(line); //get the answer
         outputLabel.setText(answer); //put the answer in the output label
         //********************
      
      }
   
      public void performClear(){
      //******************
         at.delete(0,at.getCharCount()); //clear the TextArea
         outputLabel.setText(""); //clear the label
      //******************  
      }
   
      public void performExit(){
         System.exit(0);
      }
   
      public void performAbout(){
         JFrame frame = new JFrame();
         JOptionPane.showMessageDialog(frame,"Computing Fraction Value","About This Program", JOptionPane.INFORMATION_MESSAGE);
      }
   
      public void performInputInformation(){
         JFrame frame = new JFrame();
         JOptionPane.showMessageDialog(frame,"Example for input\n" + "1/2 + 2/3\n" + "need space between operands and operation","Input Information", JOptionPane.INFORMATION_MESSAGE);
      }  
   }