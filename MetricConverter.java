import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Metric Converter!");
        System.out.println("Enter your conversion query (e.g., 1 km = mile). Type 'exit' or '-1' to quit.");
        
        while (true) {
            System.out.print("Enter conversion: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Exiting the converter. Goodbye!");
                break;
            }

            String[] parts = input.split("\\s+");

            if (parts.length != 4 || !parts[2].equals("=")) {
                System.out.println("Invalid format. Please use the format: <value> <unit> = <target unit>");
                continue;
            }

            try {
                double value = Double.parseDouble(parts[0]);
                String fromUnit = parts[1];
                String toUnit = parts[3];

                convert(value, fromUnit, toUnit);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again.");
            }
        }
        scanner.close();
    }

    public static void convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "kg":
                if (toUnit.equals("lb")) {
                    System.out.printf("%.2f kg = %.2f lb%n", value, value * 2.20462);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "lb":
                if (toUnit.equals("kg")) {
                    System.out.printf("%.2f lb = %.2f kg%n", value, value * 0.453592);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "km":
                if (toUnit.equals("mile")) {
                    System.out.printf("%.2f km = %.2f miles%n", value, value * 0.621371);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "mile":
                if (toUnit.equals("km")) {
                    System.out.printf("%.2f miles = %.2f km%n", value, value * 1.60934);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "mm":
                if (toUnit.equals("inch")) {
                    System.out.printf("%.2f mm = %.2f inches%n", value, value * 0.0393701);
                } else if (toUnit.equals("mm")) {
                    System.out.printf("%.2f inches = %.2f mm%n", value, value * 25.4);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "inch":
                if (toUnit.equals("mm")) {
                    System.out.printf("%.2f inches = %.2f mm%n", value, value * 25.4);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "gram":
                if (toUnit.equals("ounce")) {
                    System.out.printf("%.2f grams = %.2f ounces%n", value, value * 0.035274);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "ounce":
                if (toUnit.equals("gram")) {
                    System.out.printf("%.2f ounces = %.2f grams%n", value, value * 28.3495);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "fahrenheit":
                if (toUnit.equals("celsius")) {
                    System.out.printf("%.2f Fahrenheit = %.2f Celsius%n", value, (value - 32) * 5/9);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            case "celsius":
                if (toUnit.equals("fahrenheit")) {
                    System.out.printf("%.2f Celsius = %.2f Fahrenheit%n", value, (value * 9/5) + 32);
                } else {
                    System.out.println("Invalid conversion unit.");
                }
                break;
            default:
                System.out.println("Conversion not handled. Please try another conversion.");
        }
    }
}
