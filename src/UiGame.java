import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// this frame is the UI of the first frame
//
// The sentence holding arraylist and associated varible I have to create outside of the actionListener method

// now we have to create the buttons and add more sentences, at first lets arrange the texts and fonts
public class UiGame extends JFrame {

     JLabel uiHeading, inputRequest;
    private JTextField input_sentence;
    private JButton submit_button;
    private Container c;
    private Font f,f_2,f3;


    static ArrayList<String> tempSentences= new ArrayList<String>();


    UiGame()
    {       f=new Font("Monospaced",Font.BOLD,35);
        f_2=new Font("SansSerif",Font.PLAIN,28);
        f3=new Font("SansSerif",Font.PLAIN,25);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,50,420,350);
        this.setTitle("JumbledGame");

        Color color=new Color(255,0,255);
        Color greyColor=new Color(192,192,192);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);

        uiHeading=new JLabel("Frame 1");
        uiHeading.setBounds(250+400+410 ,22,480,50);
        uiHeading.setForeground(Color.white);
        uiHeading.setFont(f);
        c.add(uiHeading);


         //  ---------------sizing the below JLabel-----------------
        inputRequest =new JLabel("each time write one sentence and press 'submit':");
        inputRequest.setBounds(50,100+40+20,300+400,50);
        inputRequest.setFont(f_2);
        inputRequest.setForeground(Color.magenta);
        c.add(inputRequest);


       // -------------- making instruction how to give input by JLabel ---------------
          /* instruction:make sure there is no extra space before after of in between
                        any words,If any manually backspace the white space
        */

        input_sentence=new JTextField("please write a sentence and make sure to backspace the white space in the beginning if any ");

        input_sentence.setBounds(370+300+150,100+40,300+100+200+200+240+120,50+50);
        input_sentence.setForeground(greyColor);
        input_sentence.setFont(f3);
        c.add(input_sentence);




        submit_button =new JButton("submit");
        submit_button.setBackground(Color.gray);
        submit_button.setBounds(660+300+300+190+200+200+135,100+40,100+70,50+50);
        submit_button.setFont(f_2);
        c.add(submit_button);



        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String value ;

                value=input_sentence.getText();
                if(value.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"you didn't put any number ");

                }
                else
                {
                   tempSentences.add(value);
                   input_sentence.setText(" ");//can be removed


                   if(tempSentences.size()==3)
                   {
                       JOptionPane.showMessageDialog(null,"you have given 3 sentences");
                       NewFrame frame = new NewFrame();//this line is for making a new frame
                       frame.setVisible(true);


                   }




                }


            }
        });




    }



}
