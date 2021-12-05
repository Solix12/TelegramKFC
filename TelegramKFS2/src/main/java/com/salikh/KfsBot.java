package com.salikh;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class KfsBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "kfs_salikh_bot";
    }

    @Override
    public String getBotToken() {
        return "5099628948:AAEU_G2uq4p7IalGITlwldqeH0d6ZijDijI";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    System.out.println("Start bosildi");
                    Button button = new Button();
                    button.uzb(update);
                    button.rus(update);
                    button.eng(update);
                    try {
                        execute(button.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha")) {
                    TelNomer telNomer = new TelNomer();
                    telNomer.uzbTel(message);
                    try {
                        execute(telNomer.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("\uD83C\uDDF7\uD83C\uDDFA Русский")) {
                    TelNomer telNomer = new TelNomer();
                    telNomer.rusTel(message);
                    try {
                        execute(telNomer.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("\uD83C\uDDFA\uD83C\uDDF8 English")) {
                    TelNomer telNomer = new TelNomer();
                    telNomer.engTel(message);
                    try {
                        execute(telNomer.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("\uD83D\uDED2 Buyurtma qilish")) {
                    Shop shop = new Shop();
                    shop.geoLocation(message);
                    shop.back(message);
                    try {
                        execute(shop.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("⬅️Ortga")) {
                    System.out.println("Menyuga qaytdi");
                    Menu menu1 = new Menu();
                    menu1.shop(message);
                    menu1.fikr(message);
                    menu1.buurtmalar(message);
                    menu1.sozlamalar(message);
                    try {
                        execute(menu1.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("✍\uD83C\uDFFB Fikr bildirish")) {
                    FikirBildirish fikirBildirish = new FikirBildirish();
                    fikirBildirish.fikr(message);
                    try {
                        execute(fikirBildirish.getSendMessage());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("\uD83D\uDECD Buyurtmalarim")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Siz hali hanuz birorta ham buyurtma bermagansiz.");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("⚙️ Sozlamalar")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Sozlamalar yoq");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if (message.hasContact()) {
                Menu menu = new Menu();
                menu.shop(message);
                menu.fikr(message);
                menu.buurtmalar(message);
                menu.sozlamalar(message);
                try {
                    execute(menu.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}