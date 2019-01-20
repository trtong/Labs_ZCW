package rocks.zipcode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leon on 16/11/2018.
 */
public class NumericCharDocument extends Document {
    public NumericCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (isNumeric(contentToBeWritten)) {
            super.write(contentToBeWritten);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isNumeric(String s) {
        Pattern p = Pattern.compile("[\\D]");
        Matcher m = p.matcher(s);
        return !m.find();
    }
}
