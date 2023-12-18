import info.homework.space.Shapes;
import info.homework.space.properties.CircleBuilder;
import info.homework.space.types.Circle;
import info.homework.space.types.Ellipse;
import info.homework.space.types.Parallelogram;
import info.homework.space.types.Rectangle;
import info.homework.space.types.Rhombus;
import info.homework.space.types.Square;
import info.homework.space.types.Triangle;
import info.homework.space.properties.CircleBuilder;
import info.homework.space.types.Circle;
import info.homework.space.types.Rectangle;
import info.homework.space.types.Square;
import info.homework.space.types.Triangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
// READ DATA USING FILEREADER CLASS
public class Main {

    private static final String FILE_NAME = "resources/shapes.csv";

    static String[] readfileusingFileReader(String fileName) {
        // ArrayList<String> data = new ArrayList<String>();

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
        String[] data = readfileusingFileReader(FILE_NAME);
        System.out.println(Arrays.toString(data));

        for (int i = 1; i < data.length; i++) {
            var pieces = data[i].split(";");
            Shapes shape = null;
            switch (pieces[2].toLowerCase()) {
                case "Square":
                    shape = new Square(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]),pieces[3], Boolean.parseBoolean(pieces[5]));
                    break;
                case "Rectangle":
                    shape = new Rectangle(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]), pieces[3], Boolean.parseBoolean(pieces[5]));
                    break;
                case "Triangle":
                    shape = new Triangle(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), pieces[4], Boolean.parseBoolean(pieces[5]));
                    break;
                case "Parallelogram":
                    shape = new Parallelogram(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]), Double.parseDouble(pieces[3]), pieces[4], Boolean.parseBoolean(pieces[5]));
                    break;
                case "ParallelogramAngle":
                    shape = new Parallelogram(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]),
                            Integer.parseInt(pieces[3]), pieces[4], Boolean.parseBoolean(pieces[5]));
                    break;
                case "Rhombus":
                    shape = new Rhombus(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]),Integer.parseInt(pieces[3]),pieces[4],Boolean.parseBoolean(pieces[5]));
                    break;
                case "Ellipse":
                    shape = new Ellipse(pieces[0], Double.parseDouble(pieces[1]), Double.parseDouble(pieces[2]),(pieces[3]),Boolean.parseBoolean(pieces[5]));
                    break;
            }
System.out.println(shape);
        }
    }
}