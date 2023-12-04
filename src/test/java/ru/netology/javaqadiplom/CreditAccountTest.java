package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldSetNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(3_000, -5_000, 15);
        });
    }

    @Test
    public void shouldSetNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-3_000, 5_000, 15);
        });
    }

    @Test
    public void shouldSetNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(3_000, 5_000, -15);
        });
    }

    @Test
    public void shouldAddToBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldPay() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculateYearChangeZeroBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );
        account.pay(2000);
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldGetCreditLimit() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        Assertions.assertEquals(5_000, account.getCreditLimit());
    }
    @Test
    public void shouldPayAboveCreditLimit() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );
        account.pay(10_000);

        Assertions.assertEquals(0, account.getBalance());
    }
}
