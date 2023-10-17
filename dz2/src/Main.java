import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // создание трех массивов для хранения данных
        // ids - id, names - названия, frequencies - частоты выпадения
        int[] ids = { 1, 2, 3, 4, 5 };
        String[] names = { "Кукла", "Мяч", "Машинка", "Пазл", "Конструктор" };
        double[] frequencies = { 0.2, 0.3, 0.1, 0.2, 0.2 };
        // создание и добавление элементов в очередь PriorityQueue в порядке частоты их
        // выпадения.
        // при более высокой частоте выпадения -элемент с высокм приоритетом
        PriorityQueue toysQueue = new PriorityQueue(
                (t1, t2) -> Double.compare(((Toy) t2).getFrequency(), ((Toy) t1).getFrequency()));
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }
        // Получение 10 элементов из PriorityQueue
        // Элемент с самым высоким приоритетом будет удален из очереди и возвращен
        List resultList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Toy currentToy = (Toy) toysQueue.poll();
            resultList.add(currentToy);
        }
        System.out.println(resultList);

        // вывод в файл
        /*
         * String fileName = "result.txt";
         * try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
         * for (int i = 0; i < resultList.size(); i++) {
         * writer.write(String.format("Id: %d, Название: %s, Частота выпадения: %.2fn",
         * ((Toy) resultList).getId(),
         * ((Toy) resultList).getName(),
         * ((Toy) resultList).getFrequency()));
         * }
         * } catch (IOException e) {
         * System.err.format("IOException: %s%n", e);
         * }
         */
    }
}