package Main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FotoBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (message_text.equals("/start")){
                SendMessage sendMessage = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Salom");

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (message_text.equals("/pic")){
                SendPhoto senPhoto = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAAMIYG0JQdoiMv6XJ2mAT46JVDRSaRoAAkiwMRvn3mlLBBx4xJCu0axd6jKbLgADAQADAgADeAADjO0FAAEeBA")
                        .setCaption("Rasm");

                try {
                    execute(senPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (message_text.equals("markUp")){
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Here is your keyboard");

                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                keyboardMarkup.setResizeKeyboard(true);
                keyboardMarkup.setSelective(true);

                List<KeyboardRow> keyboardRows = new ArrayList<>();

                KeyboardRow row = new KeyboardRow();

                row.add("Tugmacha 1");
                row.add("Tugmacha 2");
                row.add("Tugmacha 3");

                keyboardRows.add(row);

                row.add("2ci tugma 1");
                row.add("2ci tugma 2");
                row.add("2ci tugma 3");

                keyboardRows.add(row);
                keyboardMarkup.setKeyboard(keyboardRows);
                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }else if (message_text.equals("Tugmacha 1")){
                SendPhoto msg = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgACAgIAAxkBAAMIYG0JQdoiMv6XJ2mAT46JVDRSaRoAAkiwMRvn3mlLBBx4xJCu0axd6jKbLgADAQADAgADeAADjO0FAAEeBA")
                        .setCaption("Buyam rasmde");

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (message_text.equals("/hide")){
                SendMessage mess = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Heyboard hidden");

                ReplyKeyboardRemove remove = new ReplyKeyboardRemove();
                mess.setReplyMarkup(remove);

                try {
                    execute(mess);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else {
                SendMessage messa = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Unknown Button");

                try {
                    execute(messa);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }else if (update.hasMessage() && update.getMessage().hasPhoto()){
            long chat_id = update.getMessage().getChatId();

            List<PhotoSize> photoSizes = update.getMessage().getPhoto();
            String f_id = photoSizes.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            int f_width = photoSizes.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getWidth();
            int f_height = photoSizes.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();

            String  captain = "file_id: " + f_id + "\nwidth: " + f_width + "\n height: " +  Integer.toString(f_height);
            SendPhoto sendPhoto = new SendPhoto()
                    .setChatId(chat_id)
                    .setPhoto(f_id)
                    .setCaption(captain);

            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public String getBotToken() {
        return "1644840393:AAEpZVAnpj_JxUldQL5rlj6CklRPpFeEAfs";
    }

    @Override
    public String getBotUsername() {
        return "PhotoShakhBot";
    }
}
