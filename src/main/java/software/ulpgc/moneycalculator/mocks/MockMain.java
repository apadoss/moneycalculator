package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.*;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        List<Currency> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MockMoneyDisplay moneyDisplay = new MockMoneyDisplay();
        MockExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();

        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);

        moneyDisplay.show(result);
    }
}
