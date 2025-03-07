import java.util.Scanner;
public class TaxesCheck {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static void bestTaxSystem(int earnings, int spendings) {
        int tax6pc = taxEarnings(earnings);
        int tax15pc = taxEarningsMinusSpendings(earnings, spendings);

        System.out.println("Налоги при УСН доходы: " + tax6pc + " руб.");
        System.out.println("Налоги при УСН доходы минус расходы: " + tax15pc + " руб.");

        if (tax6pc < tax15pc) {
            System.out.println("Лучше выбрать УСН доходы. Экономия: " + (tax15pc - tax6pc) + " руб.");
        } else if (tax15pc < tax6pc) {
            System.out.println("Лучше выбрать УСН доходы минус расходы. Экономия: " + (tax6pc - tax15pc) + " руб.");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String spendigsStr = scanner.nextLine();
                    int spent = Integer.parseInt(spendigsStr);
                    spendings += spent;
                    break;
                case 3:
                    bestTaxSystem(earnings, spendings);
                  //  earnings = 0;
                   // spendings = 0;
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}
