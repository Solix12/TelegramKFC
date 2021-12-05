package com.salikh;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    SendMessage sendMessage = new SendMessage();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    List<KeyboardRow> keyboardRowList = new ArrayList<>();


    public void shop(Message message) {
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("Royhatdan muvofaqyatli otdingiz !");
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        keyboardButton1.setText("\uD83D\uDED2 Buyurtma qilish");
        keyboardRow1.add(keyboardButton1);
        keyboardRowList.add(keyboardRow1);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    public void fikr(Message message) {
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        keyboardButton2.setText("✍\uD83C\uDFFB Fikr bildirish");
        keyboardRow2.add(keyboardButton2);
        keyboardRowList.add(keyboardRow2);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    public void buurtmalar(Message message){
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        keyboardButton3.setText("\uD83D\uDECD Buyurtmalarim");
        keyboardRow3.add(keyboardButton3);
        keyboardRowList.add(keyboardRow3);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }
    public void sozlamalar(Message message){
        KeyboardRow keyboardRow4 = new KeyboardRow();
        KeyboardButton keyboardButton4 = new KeyboardButton();
        keyboardButton4.setText("⚙️ Sozlamalar");
        keyboardRow4.add(keyboardButton4);
        keyboardRowList.add(keyboardRow4);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    public SendMessage getSendMessage() {
        return sendMessage;
    }
}
