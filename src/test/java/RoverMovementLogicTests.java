import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class RoverMovementLogicTests {
    @Test
    public void correctSingleRoverInputTest() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 5\n0 0 N\nM\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("the output data is incorrect", outputText.contains("0 1 N"));
    }

    @Test
    public void correctMultipleRoversInputTest() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 5\n0 0 N\nM\n1 1 S\nLM\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("the output data is incorrect", outputText.contains("0 1 N"));
        assertTrue("the output data is incorrect", outputText.contains("2 1 E"));
    }

    @Test
    public void incorrectPlateauCoordinateTest() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 -5\n0 0 N\nM\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("Check field size data", outputText.contains("The dimensions of the plateau must be greater than 0"));
    }

    @Test
    public void incorrectStarterRoverPositionTest() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 5\n0 10 N\nM\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("Check field size data", outputText.contains("The rover's starting point should be located within the plateau"));
    }

    @Test
    public void emptyRouteTest() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 5\n0 0 N\n \n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("Check field size data", outputText.contains("0 0 N"));
    }

    @Test
    public void incorrectFinishRoverPosition() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("5 5\n0 0 N\n MMMMMMM\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;
        System.setOut(printStream);

        StartProgram.main(new String[0]);

        System.setIn(inputStream);
        System.setOut(systemOut);

        String outputText = byteArrayOutputStream.toString();
        assertTrue("Check field size data", outputText.contains("The rover has gone beyond the borders of the plateau"));
    }
}
