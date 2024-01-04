import info.homework.space.Shapes;
import info.homework.space.properties.CircleBuilder;
import info.homework.space.types.Circle;
import info.homework.space.types.Ellipse;
import info.homework.space.types.Parallelogram;
import info.homework.space.types.Rectangle;
import info.homework.space.types.Rhombus;
import info.homework.space.types.Square;
import info.homework.space.types.Triangle;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// READ DATA USING FILEREADER CLASS
public class Main {

    private static final String FILE_NAME = "resources/shapes1.csv";

    static String[] readfileusingFileReader(String fileName) {


        var newline = System.lineSeparator();
        var strB = new StringBuffer();
        FileReader reader;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int i;
        try {
            while ((i = reader.read()) != -1)
                System.out.print((char) i);
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return strB.toString().split(newline);
    }

    public static void main(String[] args) {

        extractedM();
    }

    private static void extractedM() {
        List<Shapes> shapesList = new LinkedList<>();
        String[] data = readfileusingFileReader(FILE_NAME);
        System.out.println(data);

        for (int i = 1; i < data.length; i++) {
            var pieces = data[i].split(";");
            Shapes shape = null;
            switch (pieces[5].toLowerCase()) {
                case "Square":
                    shape = new Square(Integer.parseInt(pieces[0]),pieces[1],Double.parseDouble(pieces[2]),Double.parseDouble(pieces[3]),Double.parseDouble(pieces[4]),pieces[5],Boolean.parseBoolean(pieces[6]));
                break;

                case "Rectangle":
                    shape = new Rectangle(Integer.parseInt(pieces[0]),pieces[1],Double.parseDouble(pieces[2]),Double.parseDouble(pieces[3]),Double.parseDouble(pieces[4]),pieces[5],Boolean.parseBoolean(pieces[6]));
                    break;
//                case "Triangle":
//                    shape = new Triangle(Integer.parseInt(pieces[0]),pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
//                    break;
//                case "Parallelogram":
//                    shape = new Parallelogram(Integer.parseInt(pieces[0]),pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), Double.parseDouble(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
//                    break;
//                case "ParallelogramAngle":
//                    shape = new Parallelogram(Integer.parseInt(pieces[0]),pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]),
//                            Integer.parseInt(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
//                    break;
//                case "Rhombus":
//                    shape = new Rhombus(Integer.parseInt(pieces[0]),pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), Integer.parseInt(pieces[4]), pieces[5], Boolean.parseBoolean(pieces[6]));
//                    break;
//                case "Ellipse":
//                    shape = new Ellipse(Integer.parseInt(pieces[0]),pieces[1], Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), (pieces[4]), Boolean.parseBoolean(pieces[6]));
//                    break;
            }
           // System.out.println("Shape"+shape);
//        }


//        Stream<Shapes>stream=shapesList.stream();
//int SortSkip=20;// пропускаю 20 значень
//        int SortOut=50;//виводжу 50 значень
//        System.out.println(stream.max((d1, d2) -> (int) (d1.getWidth() *100 - d2.getWidth()*100)));
//        shapesList.stream()// конвертую нашу колекцію в Stream
//                .sorted((d1, d2) -> (int) (d1.getWidth() *100 - d2.getWidth()*100))
//                //.sorted(Comparator.comparingDouble(Shapes::getWidth))//сортую нашу мапу за полем
//                .skip(SortSkip)
//                .limit(SortOut)
//               .collect(Collectors.toMap(Shapes::getId, Shapes::getName))//створюю мапу із ключом id та стрінговим полем Name
//        .forEach((key,value)->System.out.println("Key+"+key+"Value"+value));//виводжу на екран нашу мапу




    }
}}