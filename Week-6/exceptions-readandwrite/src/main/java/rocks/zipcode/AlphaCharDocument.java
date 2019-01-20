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
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (isAlpha(contentToBeWritten)) {
            super.write(contentToBeWritten);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isAlpha(String s) {
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Matcher m = p.matcher(s);
        return !m.find();
    }
}
