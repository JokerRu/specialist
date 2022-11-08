import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCount {

    public static String testString = "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversations? "
            + "So she was considering in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her. "
            + "In another moment down went Alice after it, never once considering how in the world she was to get out again. "
            + "The rabbit-hole went straight on like a tunnel for some way, and then dipped suddenly down, so suddenly that Alice had not a moment to think about stopping herself before she found herself falling down a very deep well. ";

    private String inFile;
    private String outFile;
    Map<String, Integer> words = new HashMap<>();

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public String getInFile() {
        return inFile;
    }
    public String getOutFile() {
        return outFile;
    }
    public Map<String, Integer> getWords() {
        return words;
    }

    public void countWords(){
        Reader reader = null;
        if (inFile == null) {
            reader = new StringReader(testString);
        }
        else if (inFile != null) {
            try {
                reader = new FileReader(inFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        BufferedReader br=new BufferedReader(reader);
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()){
                StringTokenizer st = new StringTokenizer(line, " \t\n\r\f;,.)(\"\'?");
                // проверить условие
                while (st.hasMoreTokens()){
                    String token = st.nextToken();
                    if (this.getWords().containsKey(token)){
                        int value = words.get(token);
                        words.put(token, value+1);
                    }
                    else {
                        words.put(token, 1);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}