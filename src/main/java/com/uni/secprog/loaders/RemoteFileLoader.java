package com.uni.secprog.loaders;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class RemoteFileLoader extends LocalFileLoader {
    @Override
    public Stream<String> load(String target) throws LoaderException {
        try {
            URL url = new URL(target);
            InputStream is = url.openStream();
            StringBuilder textBuilder = new StringBuilder();

            try (Reader reader = new BufferedReader(new InputStreamReader
                    (is, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }

            return Arrays.stream(textBuilder.toString().split("\n"));
        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }
}
