package telegram_bots.weather_telegram_bot;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component
public class WeatherVGbot extends TelegramLongPollingBot {

    @org.springframework.beans.factory.annotation.Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;


    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    public WeatherVGbot(InlineKeyboardMarkup inlineKeyboardMarkup) {
        this.inlineKeyboardMarkup = inlineKeyboardMarkup;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        var id = update.getMessage().getChatId().toString();
        var massage = SendMessage.builder()
                .chatId(id)
                .replyMarkup(inlineKeyboardMarkup)
                .text("Hello! What do you want to do?")
                .build();
        execute(massage);
    }
}
