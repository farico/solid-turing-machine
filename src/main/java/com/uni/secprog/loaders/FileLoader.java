package com.uni.secprog.loaders;

import com.uni.secprog.Main;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class FileLoader implements ILoader {

    @Override
    public Stream<String> load(String file) {
        InputStream fis = Main.class.getResourceAsStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

        return br.lines();
    }

}
