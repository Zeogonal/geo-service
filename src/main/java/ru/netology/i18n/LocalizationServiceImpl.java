package ru.netology.i18n;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.netology.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

    @Override
    public @NotNull String locale(@Nullable Country country) {
        if (country == Country.RUSSIA) {
            return "Добро пожаловать";
        }
        return "Welcome";
    }
}
