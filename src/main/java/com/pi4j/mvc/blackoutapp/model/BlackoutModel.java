package com.pi4j.mvc.blackoutapp.model;

import com.pi4j.mvc.util.mvcbase.ObservableValue;

public class BlackoutModel {
    public final ObservableValue<Boolean> sunEnabled = new ObservableValue<>(false);
    public final ObservableValue<Boolean> windEnabled = new ObservableValue<>(false);
}
