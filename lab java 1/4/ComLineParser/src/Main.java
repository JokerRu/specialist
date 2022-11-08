import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        SimpleParser sp = new SimpleParser(new String[] {"r", "w"});
        sp.Parse(args);

//        WordCount wc = new WordCount(null,null);
        WordCount wc = new WordCount( sp.getInFile(), null);
        System.out.println("Имя входного файла для подсчёта: " + sp.getInFile());
        wc.countWords();

        // Получаем набор элементов
        Set<Map.Entry<String, Integer>> set = wc.getWords().entrySet();

        // Отобразим набор
        for (Map.Entry<String, Integer> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}