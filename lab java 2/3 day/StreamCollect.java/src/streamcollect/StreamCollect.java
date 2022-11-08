package streamcollect;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import static streamcollect.Book.*;


class Book {
    public int    id;
    public double price;
    public String title;
    public String author;
    public String genre;

    public Book(int id, double price, String author, String title, String genre) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "id="+id+" "+genre+" price="+price+"$  "+author+": "+title;
    }

    private static Book[] data;
    static {
        data = new Book[] {
                new Book(1, 32, "Seemann", "Dependency Injection in .NET", "net "),
                new Book(2, 42, "Richter", "CLR via C#", "lang"),
                new Book(3, 21, "Munro", "ASP.NET MVC 5", "tech"),
                new Book(5, 30, "Esposito", "Architecting Applications for the Enterprise", "tech"),
                new Book(6, 23, "Watson", "Writing High-Performance .NET Code", "net "),
                new Book(7, 37, "Sharp", "Microsoft Visual C# 2013", "lang"),
                new Book(9, 11, "Stubblebine", "Regular Expression", "tech"),
                new Book(10,27, "Liberty", "Learning Visual Basic .Net", "lang"),
                new Book(11,62, "Cwalina", "Framework Design Guidelines", "tech"),
                new Book(12,55, "Blewett", "Pro Asynchronous Programming with .NET", "net "),
                new Book(15,47, "Nathan", "Windows Presentation Foundation Unleashed", "tech")
        };
    }
    public static Book[]       Books()    { return data;  }
    public static Stream<Book> BooksStr() { return Arrays.stream(Books()); }  //.parallel()
}

public class StreamCollect {
    public static void main(String [] args) {

        Stream<Book> books = BooksStr();

        Queue<String> queue = (books.isParallel())
                ? books.filter(x->x.price>50).map(x-> x.title)
                .collect(Collectors.toCollection(MyConcurrentLinkedQueue::new))

                : books.filter(x->x.price>50).map(x-> x.title)
                .collect(Collectors.toCollection(MyArrayDeque::new));

        System.out.println(queue.getClass().getName());
        System.out.println(queue);

        var col1 = Collectors.toList();

        var col2 = Collectors.toCollection(ConcurrentLinkedQueue<String>::new);

        System.out.println(col2.characteristics());

        Map<String, Double> grBooks = BooksStr()
                .collect(Collectors.toMap(x->x.genre, x->x.price, (p1,p2)-> (p1>p2)?p1:p2));

        for(var item : grBooks.entrySet())  System.out.println(item);
    }
}
class MyConcurrentLinkedQueue extends ConcurrentLinkedQueue<String> {
    public MyConcurrentLinkedQueue() { System.out.println("My"); }
}
class MyArrayDeque extends ArrayDeque<String> {
    public MyArrayDeque() { System.out.println("MyAD"); }
}
