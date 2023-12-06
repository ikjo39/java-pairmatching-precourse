package pairmatching.controller;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
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
        List<String> matchingResult = Collections.emptyList();
        FunctionType functionType = retryUntilSuccess(() -> new FunctionType(inputView.readFunctionType()));
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
