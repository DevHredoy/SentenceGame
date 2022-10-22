import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class NewFrame  extends JFrame {


    private Container c;
    private JLabel question,result;
    private Font f,f_2;

    JTextArea studentInput =new JTextArea();

    Font font;
    JButton checkAnswer ;
    int j=0;
    String realAnswerBeforeMessed;


    //this below method tangle a straight sentence and make a question
    public static String makeJumbledSentence(String s)
    {

        ArrayList<String> listOfWords = new ArrayList<String>();


        for(String val:s.split(" "))
        {

            listOfWords.add(val);


        }

        Collections.sort(listOfWords);
        String str=listOfWords.stream().collect(Collectors.joining(" "));
        return str;//we have to convert this arraylist into an String then return the string
    }




    NewFrame()
    {     f=new Font("Monospaced",Font.BOLD,35);
        f_2=new Font("SansSerif",Font.PLAIN,28);
        font=new Font(Font.SERIF, Font.PLAIN,  15);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(420,50,400,400);
        this.setTitle("New Frame");
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);

              
         // this JLabel shows the question as a single sentence
        question=new JLabel("the questions will come here");
        question.setBounds(370+300+150,80,300+100+200+30,50+50);
        question.setFont(f_2);
        question.setForeground(Color.magenta);
        c.add(question);


        //this object retrieves the straight sentences from the first frame
        realAnswerBeforeMessed = UiGame.tempSentences.get(j);
        question.setText(makeJumbledSentence(UiGame.tempSentences.get(j)));//sorted






        // InputField for the Q&A frame
        studentInput.setBounds(370+300+150,100+100,300+100+200+30,50+50);
        studentInput.setBackground(Color.white);
        studentInput.setFont(f_2);
        c.add(studentInput);




        // this shows the result if it is right or wrong
        checkAnswer=new JButton("check");
        checkAnswer.setBounds(370+300+500+320,100+100,300,50+50);
        checkAnswer.setBackground(Color.CYAN);
        checkAnswer.setFont(f_2);
        c.add(checkAnswer);




        result=new JLabel("  your result");
        result.setBounds(370+300+150,100+300,300+100+200+200,50+100);
        result.setBackground(Color.cyan);
        result.setOpaque(true);
        result.setFont(f_2);
        c.add(result);





        checkAnswer.addActionListener(new ActionListener() {//this will include the m1 package
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(real_Answer_beforesorting.equals(students_Input.getText()))
                if(studentInput.getText().equals(realAnswerBeforeMessed))
                {   studentInput.setText("");
                    result.setText("  you are correct");

                    j = j + 1;

                    if(j>=3)
                    {
                        result.setText("  you have done all correctly");
                        checkAnswer.setVisible(false);
                    }

                        if(j<3)
                        { question.setText(makeJumbledSentence(UiGame.tempSentences.get(j)));
                    realAnswerBeforeMessed = UiGame.tempSentences.get(j);

                        }
                } else {
                    result.setText(" you are wrong ");
                    // result.setText(the real answer is : "+ realAnswerBeforesorting +"but you have written : "+ studentInput.getText();
                }





            }
        });



    }



}
