package com.pi4j.mvc.blackoutapp.controller;

import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.util.mvcbase.ControllerBase;

public class BlackoutController extends ControllerBase<BlackoutModel> {
    /**
     * Controller needs a Model.
     *
     * @param model Model managed by this Controller
     */
    public BlackoutController(BlackoutModel model) {
        super(model);
    }

    public void enableSun() {
        setValue(model.sunEnabled, true);
    }

    public void disableSun() {
        setValue(model.sunEnabled, false);
    }

    public void enableWind() {
        setValue(model.windEnabled, true);
    }

    public void disableWind() {
        setValue(model.windEnabled, false);
    }

    public void toggleSun() {
        toggle(model.sunEnabled);
    }

    public void toggleWind() {
        toggle(model.windEnabled);
    }
}
