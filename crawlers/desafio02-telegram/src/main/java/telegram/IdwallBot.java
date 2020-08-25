package telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class IdwallBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        switch (update.getMessage().getText().split(" ")[0].toUpperCase()) {
            case "/NADAPRAFAZER":
                if (update.getMessage().getText().split(" ").length > 1)
                    NadaPraFazer(update, update.getMessage().getText().split(" ")[1]);
                else
                    NadaPraFazer(update);
                break;
            case "/ABOUTME":
                aboutMessage(update);
                break;
            default:
                usageMessage(update);
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    public void NadaPraFazer(Update update) {
        List<String> subs;
        RedditCrawler redditCrawler = new RedditCrawler();
        subs = redditCrawler.craw();

        for (String sub : subs)
            this.sendMessage(update.getMessage().getChatId(), sub);
    }

    public void NadaPraFazer(Update update, String argsSub) {
        List<String> subs;
        RedditCrawler redditCrawler = new RedditCrawler();
        subs = redditCrawler.craw(argsSub);

        for (String sub : subs)
            this.sendMessage(update.getMessage().getChatId(), sub);
    }

    public void usageMessage(Update update) {
        this.sendMessage(update.getMessage().getChatId(),
                "Olá, eu sou um robô e fui criado porque minha criadora está participando do processo seletivo da Idwall e parte do processo inclui a implementação destes *comandos*:\n\n" +
                "/NadaPraFazer\n" +
                "/NadaPraFazer _subreddit_\n" +
                "/NadaPraFazer _subreddit1;subreddit2_\n" +
                "/AboutMe");
    }

    public void aboutMessage(Update update) {
        this.sendMessage(update.getMessage().getChatId(),
                "[LinkedIn](https://www.linkedin.com/in/renata89abreu/)\n" +
                "[GitHub](https://github.com/rabreu/)");
    }

    public void sendMessage(Long chatId, String msg) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(msg)
                .setParseMode("Markdown");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}