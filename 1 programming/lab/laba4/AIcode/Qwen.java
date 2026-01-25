public class Cart {
    private Object content;
    private Character driver; // Character — это обёртка над char, но если вы имели в виду персонажа (например, класс Person), уточните. Здесь предполагается, что Character — это символ.
    private String name;
    private String location;

    // Конструктор по умолчанию
    public Cart() {}

    // Конструктор со всеми полями
    public Cart(Object content, Character driver, String name, String location) {
        this.content = content;
        this.driver = driver;
        this.name = name;
        this.location = location;
    }

    // Геттеры
    public Object getContent() {
        return content;
    }

    public Character getDriver() {
        return driver;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // Сеттеры
    public void setContent(Object content) {
        this.content = content;
    }

    public void setDriver(Character driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Метод опустошения вагонетки
    public void empty() {
        if (content != null) {
            if (content instanceof Character) {
                System.out.println("Вагонетка " + name + " опустошена: из неё выгружен персонаж (Character).");
            } else {
                System.out.println("Вагонетка " + name + " опустошена: содержимое удалено.");
            }
            content = null;
        } else {
            System.out.println("Вагонетка " + name + " уже пуста.");
        }
    }

    // Метод перемещения
    public void moveTo(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            System.out.println("Неверное место назначения для вагонетки " + name + ".");
            return;
        }

        String oldLocation = this.location;
        this.location = newLocation;

        boolean hasDriver = driver != null;
        boolean hasContent = content != null;

        if (hasDriver && hasContent) {
            System.out.println("Вагонетка " + name + " с водителем '" + driver + "' и содержимым успешно перемещена из " +
                    oldLocation + " в " + newLocation + ".");
        } else if (hasDriver && !hasContent) {
            System.out.println("Пустая вагонетка " + name + " с водителем '" + driver + "' перемещена из " +
                    oldLocation + " в " + newLocation + ".");
        } else if (!hasDriver && hasContent) {
            System.out.println("Вагонетка " + name + " без водителя, но с содержимым, перемещена из " +
                    oldLocation + " в " + newLocation + ". Будьте осторожны!");
        } else {
            System.out.println("Пустая вагонетка " + name + " без водителя перемещена из " +
                    oldLocation + " в " + newLocation + ". Кто её толкал?");
        }
    }
}