import java.util.Objects;

public class Cart {
    private Object content;
    private Character driver;
    private String name;
    private String location;

    // Конструктор
    public Cart(String name, String location) {
        this.name = name;
        this.location = location;
        this.content = null;
        this.driver = null;
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
        if (content == null) {
            System.out.println("Вагонетка '" + name + "' уже пуста.");
            return;
        }

        if (content instanceof Character) {
            System.out.println("Из вагонетки '" + name + "' выгружен персонаж: " + content.toString());
        } else {
            System.out.println("Из вагонетки '" + name + "' выгружен объект: " + content.toString());
        }
        
        content = null;
    }

    // Метод перемещения в другую локацию
    public void moveTo(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            System.out.println("Некорректная локация.");
            return;
        }

        String oldLocation = this.location;
        this.location = newLocation;

        StringBuilder message = new StringBuilder();
        message.append("Вагонетка '").append(name).append("' перемещена из '")
               .append(oldLocation).append("' в '").append(newLocation).append("'");

        if (driver != null) {
            message.append("\n- Водитель ").append(driver).append(" также перемещен в '").append(newLocation).append("'");
        }

        if (content != null) {
            message.append("\n- Груз ").append(content).append(" также перемещен в '").append(newLocation).append("'");
        }

        System.out.println(message.toString());
    }

    // Дополнительный метод для проверки состояния вагонетки
    public void displayStatus() {
        System.out.println("\n=== Статус вагонетки ===");
        System.out.println("Имя: " + name);
        System.out.println("Локация: " + location);
        System.out.println("Водитель: " + (driver != null ? driver : "отсутствует"));
        System.out.println("Груз: " + (content != null ? content.toString() : "отсутствует"));
    }

    @Override
    public String toString() {
        return "Cart{name='" + name + "', location='" + location + 
               "', driver=" + driver + ", content=" + content + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(name, cart.name) &&
               Objects.equals(location, cart.location) &&
               Objects.equals(driver, cart.driver) &&
               Objects.equals(content, cart.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, driver, content);
    }
}