package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Добро пожаловать, RUSSIA",
            "Welcome, GERMANY",
            "Welcome, USA",
            "Welcome, BRAZIL",
    })
    void locale(String text, Country country) {
        assertEquals(text, new LocalizationServiceImpl().locale(country));
    }
}
