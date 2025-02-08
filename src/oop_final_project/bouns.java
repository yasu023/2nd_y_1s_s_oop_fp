package oop_final_project;
import java.io.*;
public class bouns {
	public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line = reader.readLine(); // قراءة الخط الأول
            if (line == null || line.trim().isEmpty()) {
                writer.println("Input file is empty or invalid.");
                return;
            }

            String[] data = line.split("\\s+");
            int size;

            try {
                size = Integer.parseInt(data[0]);
            } catch (NumberFormatException e) {
                writer.println("Invalid size format: The first value must be an integer.");
                return;
            }

            if (size < 2) {
                writer.println("The minimum size of array is 2.");
                return;
            }

            if (data.length - 1 < size * 2) {
                writer.println("Insufficient data: Expected " + size + " shapes but data is incomplete.");
                return;
            }

            Drawable[] drawableObjects = new Drawable[size];
            int index = 1;

            for (int i = 0; i < size; i++) {
                if (index >= data.length) {
                    writer.println("Invalid input: Missing shape information for shape " + (i + 1));
                    return;
                }

                String shape = data[index++];

                try {
                    if ("circle".equalsIgnoreCase(shape)) {
                        if (index >= data.length) {
                            writer.println("Invalid input: Missing radius for circle at position " + (i + 1));
                            return;
                        }
                        double radius = Double.parseDouble(data[index++]);
                        if (radius <= 0) {
                            writer.println("Invalid radius: Must be greater than zero for circle at position " + (i + 1));
                            return;
                        }
                        drawableObjects[i] = new Circle(radius);
                    } else if ("cube".equalsIgnoreCase(shape)) {
                        if (index >= data.length) {
                            writer.println("Invalid input: Missing side length for cube at position " + (i + 1));
                            return;
                        }
                        double side = Double.parseDouble(data[index++]);
                        if (side <= 0) {
                            writer.println("Invalid side length: Must be greater than zero for cube at position " + (i + 1));
                            return;
                        }
                        drawableObjects[i] = new Cube(side);
                    } else {
                        writer.println("Unknown shape: " + shape + " at position " + (i + 1));
                        return;
                    }
                } catch (NumberFormatException e) {
                    writer.println("Invalid input: Numeric value expected for dimensions at position " + (i + 1));
                    return;
                } catch (ArrayIndexOutOfBoundsException e) {
                    writer.println("Invalid input: Incomplete shape information for shape at position " + (i + 1));
                    return;
                }
            }

            if (index < data.length) {
                writer.println("Warning: Extra data provided beyond expected shapes. Ignoring extra data.");
            }

            double totalArea = 0;
            for (Drawable currentDrawable : drawableObjects) {
                totalArea += currentDrawable.getArea();
            }

            writer.println("The sum of area is = " + totalArea);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

}
