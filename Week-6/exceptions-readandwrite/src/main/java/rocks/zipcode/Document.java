package rocks.zipcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String contentToBeWritten) {
        try {
            BufferedWriter out = Files.newBufferedWriter(Paths.get(getFile().getAbsolutePath()));
            out.write(contentToBeWritten);
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {

        try {
            List<String> lines = toList();
            lines.set(lineNumber, valueToBeWritten);
            String linesString = String.join("\n", lines);
            Files.write(Paths.get(file.getAbsolutePath()), linesString.getBytes());

        } catch (IOException ioExcp) {
            ioExcp.printStackTrace();
        }
    }

    @Override
    public String read(Integer lineNumber) {

        BufferedReader br;
        int lineNum = 0;
        String line;

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if (lineNum++ == lineNumber) {
                    return line;
                }
            }
            br.close();
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        return null;
    }

    @Override
    public String read() throws IOException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        scanner.useDelimiter("\\\\n");

        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }

        return sb.toString();
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
        Path path = Paths.get(file.getAbsolutePath());
        String fileContent;
        try {
            fileContent = new String(Files.readAllBytes(path));
            fileContent = fileContent.replaceAll(stringToReplace, replacementString);
            Files.write(path, fileContent.getBytes());
        } catch (IOException ioExcep) {
            ioExcep.printStackTrace();

        }
    }

    @Override
    public void overWrite(String content) {
        try {
            FileWriter fileOverWriter = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fileOverWriter);
            bw.write(content);
            bw.close();
        } catch (IOException ioExcep) {
            ioExcep.printStackTrace();
        }
    }


    public List<String> toList() {
        try {
            return Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(file.toString());
        sb.append("{");
        for (String s: toList()) {
            sb.append(s);
        }
        sb.append("}");

        return sb.toString();
    }
}
