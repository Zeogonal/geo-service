package ru.netology.sender;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

public class MessageSenderImpl implements MessageSender {
    public static final String IP_ADDRESS_HEADER = "x-real-ip";

    private final GeoService geoService;
    private final LocalizationService localizationService;

    public MessageSenderImpl(GeoService geoService, LocalizationService localizationService) {
        this.geoService = geoService;
        this.localizationService = localizationService;
    }

    @Override
    public @NotNull String send(@NotNull Map<String, String> headers) {
        String ipAddress = headers.get(IP_ADDRESS_HEADER);
        if (ipAddress != null && !ipAddress.isEmpty()) {
            Location location = geoService.byIp(ipAddress);
            System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));
            return localizationService.locale(location.getCountry());
        }
        System.out.printf("Отправлено сообщение: %s", localizationService.locale(Country.USA));
        return localizationService.locale(Country.USA);
    }
}