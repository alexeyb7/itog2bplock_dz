/*
 * создание класса игрушек с тремя полями
 * id игрушки, имя name, частотса выпадения frequency
 */

public class Toy {
    public int id;
    public String name;
    public double frequency;
    // конструктор класса принимает три параметра

    public Toy(int id, String name, double frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    // переопределение вывода
    @Override

    public String toString() {
        return "id=" + id + " название " + name + " частота " + frequency;
    }

}