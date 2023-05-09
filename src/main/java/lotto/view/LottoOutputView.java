package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;

import java.text.DecimalFormat;

public class LottoOutputView {

    public static void printBuyCount(int buyCount) {
        System.out.printf("%d개를 구매했습니다.%n", buyCount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResults(LottoResults lottoResults) {
        System.out.printf("당첨 통계\n---------%s", lottoResults);
        System.out.printf("총 수익률은 %s입니다.", new DecimalFormat("#.##").format(lottoResults.winningRatio()));
    }
}
