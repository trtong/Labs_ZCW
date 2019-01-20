package io.zipcoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllBytes;
import static java.util.stream.Collectors.toMap;


public class WordCount {

    public HashMap<String, Integer> countWordsHashMap(Path filePath) throws IOException {

        HashMap<String, Integer> allWords = new HashMap<>();

            for (String word : new String(readAllBytes(filePath), StandardCharsets.UTF_8).split("\\W+")) {
                Integer oldCount = allWords.get(word.toLowerCase());
                if (oldCount == null) {
                    allWords.put(word.toLowerCase(), 1);
                } else {
                    allWords.put(word.toLowerCase(), oldCount + 1);
                }
            }

        return allWords;
    }

    public Path printPath(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        Path path = Paths.get(file.getAbsolutePath());

        return path;
    }

    public HashMap<String, Integer> sortedHashMap(HashMap<String, Integer> map) {

        HashMap<String, Integer> sortDesc = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));

        return sortDesc;
    }

}
