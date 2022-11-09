package com.pi4j.mvc.blackoutapp.view.pui;

import com.pi4j.context.Context;
import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.blackoutapp.view.pui.component.WireComponent;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class BlackoutPui extends PuiBase<BlackoutModel, BlackoutController> {
    private WireComponent wireOne;
    private WireComponent wireTwo;

    public BlackoutPui(BlackoutController controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        wireOne = new WireComponent(pi4J, WireComponent.PIN.D23);
        wireTwo = new WireComponent(pi4J, WireComponent.PIN.D24);
    }

    @Override
    public void setupUiToActionBindings(BlackoutController controller) {
        wireOne.onClose(controller::enableSun);
        wireOne.onOpen(controller::disableSun);
        wireTwo.onClose(controller::enableWind);
        wireTwo.onOpen(controller::disableWind);
    }
}
