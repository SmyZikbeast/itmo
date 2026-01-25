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

    // Геттеры и сеттеры
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Character getDriver() {
        return driver;
    }

    public void setDriver(Character driver) {
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Метод опустошения вагонетки
    public void Empty() {
        if (content != null) {
            if (content instanceof Character) {
                System.out.println("Removing a character from the cart.");
            } else {
                System.out.println("Removing content from the cart.");
            }
            content = null;
        } else {
            System.out.println("The cart is already empty.");
        }
    }

    // Метод перемещения
    public void moveTo(String newLocation) {
        System.out.println("Moving cart '" + name + "' to " + newLocation + ".");
        boolean driverPresent = (driver != null);
        boolean contentPresent = (content != null);

        if (driverPresent && contentPresent) {
            System.out.println("Driver '" + driver.getName() + "' and content are moving together to " + newLocation + ".");
        } else if (driverPresent) {
            System.out.println("Driver '" + driver.getName() + "' is moving alone to " + newLocation + ".");
        } else if (contentPresent) {
            System.out.println("Content is moving alone to " + newLocation + ".");
        } else {
            System.out.println("The cart is empty, moving to " + newLocation + ".");
        }

        // Обновляем местоположение
        this.location = newLocation;
    }
}