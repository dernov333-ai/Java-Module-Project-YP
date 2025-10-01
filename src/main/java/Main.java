import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int RaceleMan = 24;
        final int CarCount = 3;

        Auto[] cars = new Auto[CarCount];

        for (int i = 0; i < CarCount; i++) {
            System.out.println("Введи название машины " + (i + 1) + ":");
            String name = scanner.nextLine().trim();

            int speed;
            while (true) {
                System.out.println("Введи скорость " + (i + 1) + " (целое число, >0 и ≤250):");
                String input = scanner.nextLine().trim();
                try {
                    speed = Integer.parseInt(input);
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Некорректное значение. Пробуй снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введи целое число.");
                }
            }

            cars[i] = new Auto(name, speed);
        }

        Race race = new Race(cars);
        Auto leader = race.madeLider();

        System.out.println("Самая быстрая машина: " + (leader != null ? leader.getName() : "не найден"));
        scanner.close();
    }
}


class Auto {
    private final String name;
    private final int speed;

    public Auto(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int distanceЗа24Часа() {
        return speed * 24;
    }
}


class Race {
    private final Auto[] cars;
    private final Auto leader;

    public Race(Auto[] cars) {
        this.cars = cars;
        this.leader = determineLeader();
    }

    private Auto determineLeader() {
        Auto maxCar = null;
        int maxDistance = -1;
        for (Auto car : cars) {
            int dist = car.distanceЗа24Часа();
            if (dist > maxDistance) {
                maxDistance = dist;
                maxCar = car;
            }
        }
        return maxCar;
    }

    public Auto madeLider() {
        return leader;
    }
}