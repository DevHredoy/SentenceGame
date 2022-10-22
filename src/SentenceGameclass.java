import java.io.IOException;

// issues: while giving the sentence input in the first frame in the input text field sometimes blank space is created
//by default.If not backspaced manually , gives very unexpected outcome.

// in sentence rearrange problem solving round the given answer is not matched if not added extra space with it.

public class SentenceGameclass {


    public static void main(String[] args) throws IOException {

        UiGame uiGame=new UiGame();
        uiGame.setVisible(true);
    }


}
