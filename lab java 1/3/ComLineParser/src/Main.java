import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {
	// Разбор параметров командной строки, Наследование
        SimpleParser sp = new SimpleParser();
        sp.Parse(args);
    }
}
