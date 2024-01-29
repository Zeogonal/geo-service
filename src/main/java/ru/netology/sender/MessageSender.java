package ru.netology.sender;

import java.util.Map;

@FunctionalInterface
public interface MessageSender {

    String send(Map<String, String> headers);
}
