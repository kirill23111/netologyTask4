import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Карта с ключом "Страна,Город" и значением — цена за 1 кг
        Map<String, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put("Россия,Казань", 200);
        costPerAddress.put("Россия,Москва", 100);
        costPerAddress.put("США,Нью-Йорк", 500);
        costPerAddress.put("Германия,Берлин", 300);

        int total = 0;
        Set<String> uniqueCountries = new HashSet<>(); // Множество уникальных стран

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
                uniqueCountries.add(country.trim().toLowerCase()); // Добавляем страну в множество
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + total + " руб.");
                System.out.println("Уникальных стран с доставками: " + uniqueCountries.size());
            } else {
                System.out.println("Доставки по этому адресу нет.");
            }
        }

        System.out.println("Спасибо! Программа завершена.");
        System.out.println("Итоговая сумма всех доставок: " + total + " руб.");
        System.out.println("Всего доставок в уникальные страны: " + uniqueCountries.size());
    }
}