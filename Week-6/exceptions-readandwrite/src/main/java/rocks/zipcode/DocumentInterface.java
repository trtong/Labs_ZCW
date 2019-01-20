package rocks.zipcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author leon on 16/11/2018.
 */
public interface DocumentInterface {
    void write(String contentToBeWritten);

    void write(Integer lineNumber, String valueToBeWritten);

    String read(Integer lineNumber);

    String read() throws IOException;

    void replaceAll(String stringToReplace, String replacementString);

    void overWrite(String content);

    List<String> toList();

    File getFile();

    @Override
    String toString();
}
