package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = LottoInputView.askBuyAmount();
        Money money = new Money(amount);

        int buyCount = money.buyCount(Lotto.PRICE);
        List<Lotto> lottos = LottoGenerator.generateLottos(buyCount);
        LottoOutputView.printLottos(lottos);

        String stringNumbers = LottoInputView.askLastWinnerNumbers();
        WinnerNumbers winnerNumbers = new WinnerNumbers(stringNumbers);

        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);
        LottoOutputView.printWinningStats(lottoResults);

        Money reward = lottoResults.totalReward();
        double winningRatio = reward.ratio(money);
        LottoOutputView.printWinningRatio(winningRatio);
    }
}
