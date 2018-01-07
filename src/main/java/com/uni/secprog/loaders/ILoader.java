package com.uni.secprog.loaders;

import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public interface ILoader
{
    Stream<String> load(String target) throws LoaderException;
}
