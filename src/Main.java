import info.homework.space.Shapes;
import info.homework.space.types.Ellipse;
import info.homework.space.types.Parallelogram;
import info.homework.space.types.Rectangle;
import info.homework.space.types.Rhombus;
import info.homework.space.types.Square;
import info.homework.space.types.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    private static final String FILE_NAME = "resources/shapes1.csv";

    static String[] readFileUsingScanner(String fileName) {
        LinkedList<String> data = new LinkedList<>();
        var file = new File(fileName);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean finished = false;
        do {
            try {
                data.add(scanner.nextLine());
            } catch (NoSuchElementException e) {
                finished = true;
            }

        } while (!finished);


        scanner.close();
        return Arrays.copyOf(data.toArray(), data.size(), String[].class);
    }

    public static void main(String[] args) throws IOException {

        List<Shapes> shapesList = new LinkedList<Shapes>();
        String[] data = readFileUsingScanner(FILE_NAME);
        //     System.out.println((Arrays.toString(data)));//temprorary make invivible

        createShapetObjects(data, shapesList);
        Stream<Shapes> stream = shapesList.stream();//creating Object stream for sorting
        System.out.println("SORTING BY FIELD ID:  ");
        stream
                .sorted(Comparator.comparingLong(Shapes::getId))     // sorting by Id field
                .skip(10)                                                             // SortSkip = 10 -> skip id [1-10],
                .limit(20)                                                      // SortOut = 20 -> show id [11;28],
                .forEach(System.out::println);

        Stream<Shapes> stream1 = shapesList.stream();////creating Object stream1 for filtering
        System.out.println("-----------------------------------------------------------");
        System.out.println("FILTERING BY FIELD WIDTH");

        stream1
                // .filter(shapes -> shapes.getName().contains("tri"))//filtering by name
                //.sorted(Comparator.comparingDouble(Shapes::getWidth)) // Sort by field Width
                .filter(shape -> shape.getWidth() > 10) // Filter the field Width by value 10
                .limit(20) // SortOut 20 entries
                .forEach(shape -> System.out.println("Width: " + shape.getWidth()));

// CREATING MAP
        Stream<Shapes> stream2 = shapesList.stream();

        Map<Integer, String> representMap = stream2.collect(Collectors.toMap(
                Shapes::getId,
                Shapes::getName));

        // PRINT THE MAP OUTPUT
        System.out.println("Representation Map:");
        representMap.forEach((key, value) -> System.out.println("ID: " + key + ",Shape Name: " + value));


    }


    private static void createShapetObjects(String[] data, List<Shapes> shapesList) {


        for (int i = 1; i < data.length; i++) {
            var pieces = data[i].split(";");
            Shapes shape = null;
            switch (pieces[1].toLowerCase()) {

                case "square":
                    shape = new Square(Integer.parseInt(pieces[0]), pieces[1],
                            Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;

                case "rectangle":
                    shape = new Rectangle(Integer.parseInt(pieces[0]),
                            pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;

                case "triangle":
                    shape = new Triangle(Integer.parseInt(pieces[0]),
                            pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;

                case "parallelogram":
                    shape = new Parallelogram(Integer.parseInt(pieces[0]),
                            pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;

                case "rhombus":
                    shape = new Rhombus(Integer.parseInt(pieces[0]),
                            pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;

                case "ellipse":
                    shape = new Ellipse(Integer.parseInt(pieces[0]),
                            pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
                            Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
                    break;
            }
            shapesList.add(shape);
            System.out.println("We have the following shape:  " + shape);
        }
    }
}

