public class Board {
    private Shape[] parts = new Shape[4];

    public Board() {
    }

    public Shape[] getParts() {
        return parts;
    }

    public void addShape(Shape shape, int part){ // добавит фигуру в указанную часть от 1 до 4
        if (part > 0 && part < 5) {
            if (parts[part - 1] == null) {
                parts[part - 1] = shape;
                System.out.println("В часть доски № " + (part) + " добавлена фигура: " + shape);
            }
            else System.out.println("Нельзя добавить фигуру, требуемая чать доски занята.");
        }
        else System.out.println("Введите верный номер части доски от 1 до 4.");
    }

    public void addShape(Shape shape){ // добавит фигуру на любое свободное место (при наличии)
        boolean add = false;
        for(int i = 0; i < parts.length; i++){
            if(parts[i] == null) {
                parts[i] = shape;
                add = true;
                System.out.println("На доску добавлена фигура: " + shape);
                break;
            }
        }
        if (!add) System.out.println("Свободного места нет, удалите что ни будь.");
    }

    public void delShape(int part){ // удалит фигуру из указанной части от 1 до 4
        if (part > 0 && part < 5) {
            if (parts[part - 1] != null) {
                parts[part - 1] = null;
                System.out.println("часть доски № " + (part) + " очищена.");
            }
            else System.out.println("В указанной части нечего удалять.");
        }
        else System.out.println("Введите верный номер части доски от 1 до 4.");
    }


    public void info() {
        double p = 0;
        for (int i = 0; i < parts.length; i++){
            if(parts[i]!=null){
                p += parts[i].getArea();
                System.out.println("В части доски № " + (i+1) + "лежит фигура: " + parts[i]);
            }
            else System.out.println("часть доски № " + (i+1) + "пуста.");
        }
        System.out.println();
        System.out.println("Суммарная площадь фигур на доске: " + p);
    }
}