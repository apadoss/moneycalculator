package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.Currency;
import software.ulpgc.moneycalculator.Money;
import software.ulpgc.moneycalculator.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.lang.Double.parseDouble;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amount;
    private SwingCurrencyDialog currencyDialog;

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(createAmountField());
        add(createCurrencySelector(currencies));
        return this;
    }

    private Component createAmountField() {
        JTextField textField = new JTextField();
        textField.setColumns(5);
        this.amount = textField;
        return textField;
    }

    private Component createCurrencySelector(List<Currency> currencies) {
        SwingCurrencyDialog currencyDialog = new SwingCurrencyDialog();
        currencyDialog.define(currencies);
        this.currencyDialog = currencyDialog;
        return currencyDialog;
    }

    @Override
    public Money get() {
        return new Money(toDouble(amount.getText()), currencyDialog.get());
    }

    private double toDouble(String text) {
        return parseDouble(text);
    }
}
