package Main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Comparator;
import java.util.List;

public class PhotoBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("salom aqlli qiz Mani quyonimmisiz? \n" +
                                "\n Unda \n /jonim \n /begim \n /xayotim \n /dadasi \n/maymun \n" +
                                " wunga oxwaw narsalardan keng foydalanishingiz mumkin");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/jonim")) {
                SendPhoto msg = new SendPhoto().setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAAOOYGzoVjW7Zl10mtOXXEM5pw18_GAAAoa1MRsWNGlLBMedFqHFoiHOaDqfLgADAQADAgADeQADPpICAAEeBA")
                        .setCaption("Marxamat sizning joningiz");

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/xayotim")) {
                SendPhoto msg = new SendPhoto().setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAAOEYGzn-Ursbj_-jp8PjtVTmvRTQbsAAoS1MRsWNGlLBlUJgoB_DYWD3S-bLgADAQADAgADeQADCYcFAAEeBA")
                        .setCaption("Bu sizning xayotingizmasmi???");

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/begim")) {
                SendPhoto msg = new SendPhoto().setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAANwYGzkwmcZ1Yyh3UH0DrgTVxJCnlwAAoK1MRsWNGlLBQxhkTfC0yhlT6miLgADAQADAgADeQADJs0AAh4E")
                        .setCaption("Buni begiz qila olasizmi");

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/dadasi")) {
                SendPhoto msg = new SendPhoto().setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAANfYGziuis7l__TJfVLAwMr76EWWlsAAoC1MRsWNGlLV5BlMxBPOEBeT0meLgADAQADAgADeQADU9EEAAEeBA")
                        .setCaption("Shakhzodbek wu nomga ega boliwni xoxlaydi");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message_text.equals("/maymun")) {
                SendPhoto msg = new SendPhoto().setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAAOyYGzrXU2DbQHu1qT0mdicdZUngwIAAoi0MRv-8mlLfSCbOZJy9K_eICKbLgADAQADAgADeQADC_cFAAEeBA")
                        .setCaption("Oma lekin oxwaydi");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

                else{
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Unknown");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            long chat_id = update.getMessage().getChatId();
            List<PhotoSize> photo = update.getMessage().getPhoto();

            String f_id = photo.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();

            int f_width = photo.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getWidth();

            int f_height = photo.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();

            String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);

            SendPhoto msg = new SendPhoto()
                    .setChatId(chat_id)
                    .setPhoto(f_id)
                    .setCaption(caption);

            try {
                execute(msg); // Call method to send the photo with caption
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public String getBotToken() {
        return "1743211468:AAFnp3pPyJYN-TFHOlIVSS6U2-9JYYvfjs0";
    }

    @Override
    public String getBotUsername() {
        return "shakhzodbekShakh_bot";
    }
}
