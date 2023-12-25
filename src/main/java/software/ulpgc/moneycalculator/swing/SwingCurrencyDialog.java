package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.Currency;
import software.ulpgc.moneycalculator.CurrencyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private JComboBox<Currency> currencyComboBox;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        add(createCurrencySelector(currencies));
        return this;
    }

    private Component createCurrencySelector(List<Currency> currencies) {
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies) comboBox.addItem(currency);
        this.currencyComboBox = comboBox;
        return comboBox;
    }

    @Override
    public Currency get() {
        return currencyComboBox.getItemAt(currencyComboBox.getSelectedIndex());
    }
}
