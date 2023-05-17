package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money PRICE = new Money(1000);

    private final Set<LottoNumber> numbers;

    Lotto(String lottoNumbers) {
        this(parseStringNumbers(lottoNumbers));
    }

    Lotto(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = Collections.unmodifiableSet(lottoNumbers);
    }

    private static Set<LottoNumber> parseStringNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(number -> new LottoNumber(Integer.parseInt(number.trim())))
                .collect(Collectors.toSet());
    }

    public int matchCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public Set<LottoNumber> numbers() {
        return new HashSet<>(numbers);
    }
}
