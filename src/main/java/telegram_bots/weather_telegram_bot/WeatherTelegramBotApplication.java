package telegram_bots.weather_telegram_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@SpringBootApplication
public class WeatherTelegramBotApplication {

    public static void main(String[] args) {

        SpringApplication.run(WeatherTelegramBotApplication.class, args);
    }

    @Bean
    public InlineKeyboardMarkup inlineKeyboardMarkup(){
        return new InlineKeyboardMarkup(List.of(List.of(
                InlineKeyboardButton.builder().text("Create new note").build(),
                InlineKeyboardButton.builder().text("Show my notes").build(),
                InlineKeyboardButton.builder().text("Edit note").build(),
                InlineKeyboardButton.builder().text("Delete note").build()
        )));
    }
}
