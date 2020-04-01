package chapter04.qiantao4_1_4;


public class Button720 implements ViewInter {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) {

    }

    public class ButtonState implements State {

    }
}
