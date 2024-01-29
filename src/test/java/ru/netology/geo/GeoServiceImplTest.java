package ru.netology.geo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GeoServiceImplTest {

    @ParameterizedTest
    @MethodSource(value = "checkLocation")
    void byIp(@Nullable Location location, @Nullable String ip) {
        assertEquals(location, new GeoServiceImpl().byIp(ip));
    }

    static @NotNull Stream<Arguments> checkLocation() {
        return Stream.of(
                arguments(new Location(null, null, null, 0), "127.0.0.1"),
                arguments(new Location("Moscow", Country.RUSSIA, "Lenina", 15), "172.0.32.11"),
                arguments(new Location("New York", Country.USA, " 10th Avenue", 32), "96.44.183.149"),
                arguments(new Location("Moscow", Country.RUSSIA, null, 0), "172.0.32.111"),
                arguments(new Location("New York", Country.USA, null, 0), "96.44.183.49"),
                arguments(null, "192.168.1.1"),
                arguments(null, null));
    }
}
