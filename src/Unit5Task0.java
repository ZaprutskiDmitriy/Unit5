import java.util.Random;
import java.util.Scanner;

public class Unit5Task0 {
    public static void main(String[] args) {
        Computer computer = new Computer(2.5, 8, 250, 2);
        System.out.println(computer.description());
        computer.turnOn();
    }

    public static class Computer {
        double processor;
        int ram;
        int hdd;
        int resource;
        int count = 0;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        public Computer(double processor, int ram, int hdd, int resource) {
            this.processor = processor;
            this.ram = ram;
            this.hdd = hdd;
            this.resource = resource;
        }

        public String description() {
            return "Computer:\n" +
                    "  processor: " + processor + " GHz\n" +
                    "  RAM: " + ram + " GB\n" +
                    "  HDD: " + hdd + " GB\n" +
                    "  resource of full work cycles: " + resource;
        }

        public void turnOn() {
            System.out.println("Введите 0 или 1");
            int n = scan.nextInt();
            int s = rand.nextInt(2);
            if (n == s && count < resource) {
                System.out.println(s);
                System.out.println("Компьютер включился");
                turnOff();
            } else if (n != s) {
                System.out.println(s);
                System.out.println("Компьютер сгорел");
            } else {
                System.out.println("Компьютер сгорел (Превышен лимит ресурса!)");
            }
        }

        public void turnOff() {
            System.out.println("Введите 0 или 1");
            int n = scan.nextInt();
            int s = rand.nextInt(2);
            if (n == s) {
                System.out.println(s);
                System.out.println("Компьютер выключился");
                count++;
                System.out.println("Количество полных циклов работы: " + count);
                turnOn();
            } else {
                System.out.println(s);
                System.out.println("Компьютер сгорел");
            }

        }
    }
}
