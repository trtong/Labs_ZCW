package rocks.zipcode;

import sun.nio.cs.UTF_32;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_16;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (isSpecialCharacters(contentToBeWritten)) {
            super.write(contentToBeWritten);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isSpecialCharacters(String s) {
        Pattern p = Pattern.compile("[\\w&&[^_]]");
        Matcher m = p.matcher(s);
        return !m.find();
    }
}
