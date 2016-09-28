package test.com.yang.refactoring;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yang on 2016. 9. 28..
 */
public class FileReaderTest extends TestCase {
    private FileReader _input;

    public FileReaderTest (String name) {
        super(name);
    }

    protected void setUp() {
        try {
            _input = new FileReader("resources/data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open the file");
        }
    }

    protected void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("Error on file closing");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++)
            ch = (char) _input.read();
        assert('d' == ch);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTest("testRead"));
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}