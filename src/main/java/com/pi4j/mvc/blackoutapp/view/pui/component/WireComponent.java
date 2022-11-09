package com.pi4j.mvc.blackoutapp.view.pui.component;

import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.PullResistance;
import com.pi4j.mvc.util.puicomponentbase.Component;
import com.pi4j.mvc.util.puicomponentbase.events.DigitalEventProvider;
import com.pi4j.mvc.util.puicomponentbase.events.SimpleEventHandler;

public class WireComponent extends Component implements DigitalEventProvider<WireComponent.WireState> {
    private final DigitalInput digitalInput;
    private SimpleEventHandler onOpen;
    private SimpleEventHandler onClose;

    public WireComponent(Context pi4j, PIN address) {
        var config = DigitalInput.newConfigBuilder(pi4j)
                .id("wire-" + address)
                .name("WIRE " + address)
                .address(address.getPin())
                .pull(PullResistance.PULL_DOWN)
                .build();
        digitalInput = pi4j.create(config);
        this.addListener(this::dispatchSimpleEvents);
    }

    @Override
    public DigitalInput getDigitalInput() {
        return digitalInput;
    }

    public boolean isOpen() {
        return digitalInput.isHigh();
    }

    public boolean isClose() {
        return digitalInput.isLow();
    }

    public void onOpen(SimpleEventHandler handler) {
        this.onOpen = handler;
    }

    public void onClose(SimpleEventHandler handler) {
        this.onClose = handler;
    }

    @Override
    public WireState mapDigitalState(DigitalState digitalState) {
        switch (digitalState) {
            case HIGH:
                return WireState.CLOSE;
            case LOW:
                return WireState.OPEN;
            default:
                return WireState.UNKNOWN;
        }
    }

    @Override
    public void dispatchSimpleEvents(WireState state) {
        switch (state) {
            case OPEN:
                triggerSimpleEvent(onOpen);
                break;
            case CLOSE:
                triggerSimpleEvent(onClose);
                break;
        }
    }

    public enum WireState {
        OPEN,
        CLOSE,
        UNKNOWN
    }

    public enum PIN {
        SDA1(2),
        SCL1(2),
        D4(4),
        TXD(14),
        RXD(15),
        D17(17),
        PWM18(18),
        D27(27),
        D22(22),
        D23(23),
        D24(24),
        MOSI(10),
        MISO(9),
        D25(25),
        D11(11),
        CEO(8),
        CE1(7),
        D5(5),
        D6(6),
        D16(16),
        D26(26),
        D20(20),
        D21(21),
        PWM12(12),
        PWM13(13),
        PWM19(19);

        private final int pin;

        PIN(int pin) {
            this.pin = pin;
        }

        public int getPin() {
            return pin;
        }
    }
}
