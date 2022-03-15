///This is a a simple Java calculator 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator  implements ActionListener {
    JFrame frame;//The frame of our workspace 
    JTextField textField;//The input field
    JButton [] numberButtons = new JButton[10];//Calculator buttons 
    JButton []functionButtons=new JButton[9];//the function of operations 
    JButton addButton , suButton,mulButton,divButton;//op buttons
    JButton decButton , equButton,delButton,clrButton,negButton;//op buttons
    JPanel panel;//Our panel which we add our buttons on 
    Font myFont= new Font("Ink Free",Font.BOLD,30);//the basic font type for the whole calculator 
    double num1=0, num2=0,result=0;// num1 & num2 are the values which we do operations on and result is the result of the operations 
    char op;//the operator 
    Calculator()
    {
        frame=new JFrame("Calculator");//create the frame constructor 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////Exit when we hit the X button
        frame.setSize(420,550);//set the size of the frame 
        frame.setLayout(null);//make the default layout of the frame null
        textField = new JTextField();//create an empty text field 
        textField.setBounds(50,25,300,50);//set it's positon and area
        textField.setFont(myFont);
        textField.setEditable(false);//make the textfield uneditable 

        //These lines declare the operator buttons 
        addButton=new JButton("+");
        suButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Del");
        clrButton=new JButton("Clr");
        negButton=new JButton("(-)");

        //these lines take the operators to add actions on it 
        functionButtons[0]=addButton;
        functionButtons[1]=suButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;


        //here we loop on the all the operator buttons to give them an action when click 
        for(int i=0;i<9;i++)
        {
            functionButtons[i].addActionListener(this);//give each button action 
            functionButtons[i].setFont(myFont);//give the buttons font style 
            functionButtons[i].setFocusable(false);//it get rid of the annoying box around the text 
        }

        // reserve our numbers from 0 to 9
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);//bounds for the negation button 
        delButton.setBounds(150,430,100,50);//bounds for the deletion button 
        clrButton.setBounds(250,430,100,50);//bounds for the clear button 


        panel = new JPanel();//construct the panel
        panel.setBounds(50,100,300,300);

        panel.setLayout(new GridLayout(4,4,10,10));//create the grid raws, clomuns , spaces between rows , spaces between colmuns 

        //add the numbers and operator buttons to the panel in the form of calculator 
       panel.add(numberButtons[1]);
       panel.add(numberButtons[2]);
       panel.add(numberButtons[3]);
       panel.add(addButton);
       panel.add(numberButtons[4]);
       panel.add(numberButtons[5]);
       panel.add(numberButtons[6]);
       panel.add(suButton);
       panel.add(numberButtons[7]);
       panel.add(numberButtons[8]);
       panel.add(numberButtons[9]);
       panel.add(mulButton);
       panel.add(decButton);
       panel.add(numberButtons[0]);
       panel.add(equButton);
       panel.add(divButton);





        frame.add(panel);//add the panel to the frame 
        //add the 3 buttons to the frame 
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
    
        frame.add(textField);//add the text field 

        frame.setVisible(true);//make the frame visible 
    }
    public static void main(String[] args) throws Exception  {
        Calculator calc=new Calculator();//constructor which run the calculator class in main 
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        for (int i=0;i<10;i++){ // loop in the wohle numbers 
        if (e.getSource() == numberButtons[i])//check if the number is clicke (take action)
        {
            
            textField.setText(textField.getText().concat(String.valueOf(i)));//this line purpose is to put the number in the text field 
        }

    }

        if (e.getSource()==decButton) textField.setText(textField.getText().concat("."));//put the decimal point in case of click on dec

        //these lines is get the double value of the first number and the type of the operation
        if (e.getSource()==addButton)
        {
            num1=Double.parseDouble(textField.getText());
            op='+';
            textField.setText("");
        }

        if (e.getSource()==mulButton)
        {
            num1=Double.parseDouble(textField.getText());
            op='*';
            textField.setText("");
        }
        if (e.getSource()==suButton)
        {
            num1=Double.parseDouble(textField.getText());
            op='-';
            textField.setText("");
        }
        if (e.getSource()==divButton)
        {
            num1=Double.parseDouble(textField.getText());
            op='/';
            textField.setText("");
        }



        if (e.getSource()==equButton)
        {
            num2=Double.parseDouble(textField.getText());//get the double value of number2 
            //we here check which operand  performed and store the result of the whole operation in result 
            switch(op)
            {
                case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
            }
            textField.setText(String.valueOf(result));//return the result in the text field 
            num1=result;//this assignment if we want to continue
        }

        if (e.getSource()==clrButton)textField.setText("");//clear button which cleare the whole textfield 

        if (e.getSource()==delButton)//delete button to delete the last value on each click
        {
            String s=textField.getText();//we store the whole text in string 
            textField.setText("");//we set the text field to empty after we take it all to our string 
            for (int i=0;i<s.length()-1;i++)
            //we loop in the whole string except the last value and  put them all int the textfield  except the last which is deleted 
            {
                textField.setText(textField.getText()+s.charAt(i));
            }
        }

        if (e.getSource()==negButton)
        {
            double temp=Double.parseDouble(textField.getText());//get the double val of the text 
            temp*=-1;//negiate it 
            textField.setText(String.valueOf(temp));//put it back to the textfield 
        }
    }
}
