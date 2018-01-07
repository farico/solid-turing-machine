package com.uni.secprog.builders;

import com.uni.secprog.TuringMachine;
import com.uni.secprog.machine.Head;
import com.uni.secprog.machine.Rule;
import com.uni.secprog.machine.Tape;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class JsonBuilder implements TuringMachineBuilder {
    @Override
    public TuringMachine build(Stream<String> lines) throws BuilderException {
        JSONParser parser = new JSONParser();
        JSONObject parsedJson = null;
        try {
            parsedJson = (JSONObject)parser.parse(lines.collect(Collectors.joining("\n")));
        } catch (ParseException e) {
            throw new BuilderException(e);
        }
        String headPosition = (String)parsedJson.get("head-start-position");
        String tapeString = (String)parsedJson.get("tape");
        Tape tape = new Tape(new Head(Integer.parseInt(headPosition)), tapeString.toCharArray());
        ArrayList<Rule> rules = new ArrayList<Rule>();

        JSONArray parsedRules = (JSONArray)parsedJson.get("rules");
        parsedRules.forEach(rule -> {
            String move = (String)((JSONObject)rule).get("move");
            String read = (String)((JSONObject)rule).get("read");
            String nextState = (String)((JSONObject)rule).get("next-state");
            String state = (String)((JSONObject)rule).get("state");
            String write = (String)((JSONObject)rule).get("write");

            rules.add(new Rule(state.charAt(0), read.charAt(0), write.charAt(0), move.charAt(0), nextState.charAt(0)));
        });

        return new TuringMachine('0', tape, rules);
    }
}
