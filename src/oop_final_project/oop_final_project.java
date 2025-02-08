package oop_final_project;

public class oop_final_project {
	
	public static void main(String[] args) {
		
        if (args.length  ==0) {
            System.out.println("No input provided. Please provide input as arguments.");
            return;
        }

        int size;

        try {
            size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid size format: The first value must be an integer.");
            return;
        }

        if (size < 2) {
            System.out.println("The minimum size of array is 2.");
            return;
        }

        if (args.length - 1 < size * 2) {
            System.out.println("Insufficient args: Expected " + size + " shapes but data is incomplete.");
            return;
        }

        Drawable[] drawableObjects = new Drawable[size];
        int index = 1;

        for (int i = 0; i < size; i++) {
            if (index >= args.length) {
                System.out.println("Invalid input: Missing shape information for shape " + (i + 1));
                return;
            }

            String shape = args[index++];

            try {
                if ("circle".equalsIgnoreCase(shape)) {
                    if (index >= args.length) {
                        System.out.println("Invalid input: Missing radius for circle at position " + (i + 1));
                        return;
                    }
                    double radius = Double.parseDouble(args[index++]);
                    if (radius <= 0) {
                        System.out.println("Invalid radius: Must be greater than zero for circle at position " + (i + 1));
                        return;
                    }
                    drawableObjects[i] = new Circle(radius);
                } else if ("cube".equalsIgnoreCase(shape)) {
                    if (index >= args.length) {
                        System.out.println("Invalid input: Missing side length for cube at position " + (i + 1));
                        return;
                    }
                    double side = Double.parseDouble(args[index++]);
                    if (side <= 0) {
                        System.out.println("Invalid side length: Must be greater than zero for cube at position " + (i + 1));
                        return;
                    }
                    drawableObjects[i] = new Cube(side);
                } else {
                    System.out.println("Unknown shape: " + shape + " at position " + (i + 1));
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Numeric value expected for dimensions at position " + (i + 1));
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input: Incomplete shape information for shape at position " + (i + 1));
                return;
            }
        }

        if (index < args.length) {
            System.out.println("Warning: Extra data provided beyond expected shapes. Ignoring extra args.");
        }

        double totalArea = 0;
        for (Drawable currentDrawable : drawableObjects) {
            totalArea += currentDrawable.getArea();
        }

        System.out.println("The sum of area is = " + totalArea);
    }
}
