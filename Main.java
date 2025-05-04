import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Map with "Country,City" as key and cost per kg as value
        Map<String, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put("Россия,Казань", 200);
        costPerAddress.put("Россия,Москва", 100);
        costPerAddress.put("США,Нью-Йорк", 500);
        costPerAddress.put("Германия,Берлин", 300);

        int total = 0;

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну (или 'end'): ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) break;

            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            System.out.print("Введите вес (кг): ");
            int weight;
            try {
                weight = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некорректный вес.");
                continue;
            }

            String key = country.trim() + "," + city.trim();
            Integer pricePerKg = costPerAddress.get(key);

            if (pricePerKg != null) {
                int cost = pricePerKg * weight;
                total += cost;
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + total + " руб.");
            } else {
                System.out.println("Доставки по этому адресу нет.");
            }
        }

        System.out.println("Спасибо! Программа завершена.");
    }
}