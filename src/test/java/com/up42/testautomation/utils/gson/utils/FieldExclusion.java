package com.up42.testautomation.utils.gson.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FieldExclusion implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(ExcludeFromSerialization.class) != null ;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
