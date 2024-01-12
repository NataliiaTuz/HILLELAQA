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
import java.util.Date;
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
        var startImport = System.currentTimeMillis();//creating variable for detecting time import CSV file
        String[] data = readFileUsingScanner(FILE_NAME);
        var resultImport = System.currentTimeMillis() - startImport;
        System.out.println("Time of Import CSV file: " + resultImport + "ms");
        System.out.println("*********************************************************");
        //     System.out.println((Arrays.toString(data)));//temprorary make invivible

// DATA PROCESSING AND OBJECTS CREATIONS
        var startCreateObj = System.currentTimeMillis();// creating variable for detecting time of creating Objects
        createShapetObjects(data, shapesList);

        var resultCreateObj = System.currentTimeMillis() - startCreateObj;
        System.out.println("Time of creating object" + resultCreateObj + "ms");
        System.out.println("*********************************************************");

        // SORTING AND FILTERING & ACTIONS WITH STREAMS
        System.out.println("SORTING BY FIELD ID:  ");
        var startFS = System.currentTimeMillis();// creating variable for detecting time of creating 3 stream obj and actions over them(SORTING&FILTERING)
        Stream<Shapes> stream = shapesList.stream(); //creating Object stream for sorting
        stream
                .sorted(Comparator.comparingLong(Shapes::getId))     // sorting by Id field
                .skip(10)                                                             // SortSkip = 10 -> skip id [1-10],
                .limit(20)                                                      // SortOut = 20 -> show id [11;28],
                .forEach(System.out::println);

        Stream<Shapes> stream1 = shapesList.stream();////creating Object stream1 for filtering
        System.out.println("*****************************************************************");
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
        var resultSF = System.currentTimeMillis() - startFS;
        System.out.println("Time of creating 3 stream objects and sorting/filtering functionality: " + resultSF + "ms");
        System.out.println("*********************************************************");


        //CREATING 2 OBJECT DATE TYPE FOR COMPARING THE DIFFERENCE BETWEEN THESE DAYS

        var dateBefore = new Date(2023 - 1900, 10, 20, 7, 20, 45);// CREATING OBJECT date2 Mon Nov 20 07:20:45 CET 2023
        System.out.println(dateBefore);//
        var dateAfter = new Date(2024 - 1900, 2, 10, 7, 15, 25);//creating object date3 Sun Mar 10 07:15:25 CET 2024
        long differenceInMillis = dateBefore.getTime() - dateAfter.getTime();//calculate the difference in mls
        long differenceIndDays = (differenceInMillis / (24 * 60 * 60 * 1000)); // calculate the difference in days
        System.out.println("Difference between both dates Nov 20 07:20:45 CET 2023 AND Mar 10 07:15:25 CET 2024   = " + differenceIndDays + " days");


//Sorting the duration by ASC
        long[] durations = {resultImport, resultCreateObj, resultSF};
        Arrays.sort(durations);
        System.out.println("*********************************************************");
        System.out.println("Durations in Ascending Order:");
        System.out.println("1. Import CSV file: " + durations[0] + "ms");
        System.out.println("2. Creating Objects: " + durations[1] + "ms");
        System.out.println("3. Sorting/Filtering: " + durations[2] + "ms");
        System.out.println("*********************************************************");

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
    //CREATING METHOD
//    public void date (){
//        var date1=new Date(2023,12,1); //Creating object date type
//        System.out.println(date1);
//    }
}

