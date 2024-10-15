import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("HP", "Windows 10", "Gray", 1024, 8));
        laptops.add(new Laptop("HP", "Windows 11", "Gray", 1024, 8));
        laptops.add(new Laptop("HP", "Windows 10", "Black", 1024, 8));
        laptops.add(new Laptop("HP", "Windows 10", "Gray", 1024, 8));
        laptops.add(new Laptop("HP", "Windows 11", "Black", 1024, 8));
        laptops.add(new Laptop("HP", "Windows 10", "Gray", 1024, 8));
        laptops.add(new Laptop("Apple", "MacOS", "Grey", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Grey", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Grey", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Black", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Grey", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Grey", 512, 16));
        laptops.add(new Laptop("Apple", "MacOS", "Black", 512, 16));
        laptops.add(new Laptop("Lenovo", "Windows 10", "Black", 2048, 12));
        laptops.add(new Laptop("Lenovo", "Windows 10", "Black", 2048, 12));
        laptops.add(new Laptop("Lenovo", "Windows 10", "Black", 2048, 12));
        laptops.add(new Laptop("Lenovo", "Windows 10", "Silver", 2048, 12));
        laptops.add(new Laptop("Lenovo", "Windows 10", "Black", 2048, 12));
        laptops.add(new Laptop("Lenovo", "Windows 10", "White", 2048, 12));
        laptops.add(new Laptop("Dell", "Windows 11", "Silver", 256, 8));
        laptops.add(new Laptop("Dell", "Windows 11", "Black", 256, 8));
        laptops.add(new Laptop("Dell", "Windows 11", "Black", 256, 8));
        laptops.add(new Laptop("Dell", "Windows 11", "Silver", 256, 8));
        laptops.add(new Laptop("Dell", "Windows 11", "Black", 256, 8));
        laptops.add(new Laptop("Asus", "Windows 10", "Black", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Silver", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Black", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Black", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Silver", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Black", 1024, 16));
        laptops.add(new Laptop("Asus", "Windows 10", "Black", 1024, 16));
        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put("1", "ОЗУ");
        criteria.put("2", "Объем ЖД");
        criteria.put("3", "Операционная система");
        criteria.put("4", "Цвет");
        criteria.put("5", "Список ноутбуков");
        criteria.put("6", "Выйти из магазина");

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Список ноутбуков");
            System.out.println("6 - Выйти из магазина");

            String userInput = scanner.nextLine();

            if (criteria.containsKey(userInput)) {
                String selectedCriteria = criteria.get(userInput);

                if (selectedCriteria.equals("Список ноутбуков")) {
                    for (Laptop laptop : laptops) {
                        System.out.println(laptop);
                    }
                } else if (selectedCriteria.equals("Выйти из магазина")) {
                    flag = false;
                    System.out.println("Вы вышли из магазина");
                } else {
                    System.out.println("Введите минимальное значение для " + selectedCriteria + ":");
                    String minValue = scanner.nextLine();

                    Set<Laptop> filteredLaptops = new HashSet<>();
                    switch (selectedCriteria) {
                        case "ОЗУ" -> {
                            int minRam = Integer.parseInt(minValue);
                            for (Laptop laptop : laptops) {
                                if (laptop.getRam() >= minRam) {
                                    filteredLaptops.add(laptop);
                                }
                            }
                        }
                        case "Объем ЖД" -> {
                            int minHddSize = Integer.parseInt(minValue);
                            for (Laptop laptop : laptops) {
                                if (laptop.getHddSize() >= minHddSize) {
                                    filteredLaptops.add(laptop);
                                }
                            }
                        }
                        case "Операционная система" -> {
                            for (Laptop laptop : laptops) {
                                if (laptop.getOs().equalsIgnoreCase(minValue)) {
                                    filteredLaptops.add(laptop);
                                }
                            }
                        }
                        case "Цвет" -> {
                            for (Laptop laptop : laptops) {
                                if (laptop.getColor().equalsIgnoreCase(minValue)) {
                                    filteredLaptops.add(laptop);
                                }
                            }
                        }
                        default -> System.out.println("Некорректный ввод критерия!");
                    }

                    if (filteredLaptops.isEmpty()) {
                        System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации, не найдены.");
                    } else {
                        for (Laptop laptop : filteredLaptops) {
                            System.out.println(laptop);
                        }
                    }
                }
            } else {
                System.out.println("Некорректный ввод критерия!");
            }
        }
    }
}