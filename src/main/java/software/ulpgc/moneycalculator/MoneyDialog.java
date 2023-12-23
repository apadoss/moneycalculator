package software.ulpgc.moneycalculator;

import java.util.Currency;
import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
