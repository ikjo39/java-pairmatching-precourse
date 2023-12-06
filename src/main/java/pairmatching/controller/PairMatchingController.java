package pairmatching.controller;

import pairmatching.model.FunctionType;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        FunctionType functionType = new FunctionType(inputView.readFunctionType());

    }
}
