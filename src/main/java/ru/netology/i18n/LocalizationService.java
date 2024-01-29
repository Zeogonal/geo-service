package ru.netology.i18n;

import ru.netology.entity.Country;

@FunctionalInterface
public interface LocalizationService {

    String locale(Country country);
}
