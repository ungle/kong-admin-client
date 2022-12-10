package io.github.ungle.kong.client.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author ungle
 *
 */
public class TagQueryBuilder {
    private static final int MAX_TAG = 5;
    private static final String AND_OP = ",";
    private static final String OR_OP = "/";
    private static final Pattern PATTERN = Pattern.compile("[A-Za-z0-9_.\\-~]+");

    private StringBuilder stringBuilder;
    private int tagCounter = 0;

    public TagQueryBuilder() {
        stringBuilder = new StringBuilder();
    }

    public TagQueryBuilder addTag(String tag) {
        if (tagCounter >= MAX_TAG) {
            throw new IllegalArgumentException("A maximum of 5 tags can be queried simultaneously in a single request");
        }
        Matcher matcher = PATTERN.matcher(tag);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("tag should on contain alphanumeric characters and _ - ~ . ");
        }
        stringBuilder.append(tag);
        tagCounter++;
        return this;
    }

    public TagQueryBuilder orTag(String tag) {
        if (stringBuilder.indexOf(AND_OP) > -1) {
            throw new IllegalArgumentException("Mixing operators is not supported");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(OR_OP);
        }
        addTag(tag);
        return this;
    }


    public TagQueryBuilder andTag(String tag) {
        if (stringBuilder.indexOf(OR_OP) > -1) {
            throw new IllegalArgumentException("Mixing operators is not supported");
        }
        //避免出现误用，导致分隔符出现在开头
        if (stringBuilder.length() > 0) {
            stringBuilder.append(AND_OP);
        }
        addTag(tag);
        return this;
    }


    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
