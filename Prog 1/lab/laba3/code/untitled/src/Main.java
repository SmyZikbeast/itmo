import java.util.Random;

// КлассBottle
public record Bottle(Types type, float volume) {}

// Перечисление типов бутылок
enum Types {    Chernogolovka,    Borjomi,    SaintSpring}


public class Main {
  // Метод для генерации массива бутылок    public static Bottle[] generateRandomBottles() {        Random random = new Random();


        // Массив бутылок длиной 10
        Bottle[] bottles = new Bottle[10];

        // Массив бутылок длиной 10
        Bottle[] bottles = new Bottle[10];

    for (int i = 0; i < bottles.length; i++) {
            // Случайный тип воды
            Types randomType = Types.

            for (int i = 0; i < bottles.length; i++) {
                // Случайный тип воды
                Types randomType = Types.values()[random.nextInt(Types.values().length)];values()[random.nextInt(Types.values().length)];

                // Случайный объем от 0 до 1
                float randomVolume = random.nextFloat(); // nextFloat генерирует число от 0 до 1

                // Заполняем элемент массива новым экземпляром Bottle
                bottles[i] = new Bottle(randomType, randomVolume);

                // Случайный объем от 0 до 1
                float randomVolume = random.nextFloat(); // nextFloat генерирует число от 0 до 1

                // Заполняем элемент массива новым экземпляром Bottle
                bottles[i] = new Bottle(randomType, randomVolume);
            }

            return bottles;
        }

    return bottles;
    }

    // Тестируем наш метод
    public static void main(String[] args) {
        Bottle[] bottles = generateRandomBottles();

        for (Bottle bottle :
    }

    // Тестируем наш метод
    public static void main(String[] args) {
        Bottle[] bottles = generateRandomBottles();

        for (Bottle bottle : bottles) {
            System.out.println("Тип: " + bottle. bottles) {
                System.out.println("Тип: " + bottle.getName() + ", Объем: " + bottle.volume());
            }
        }