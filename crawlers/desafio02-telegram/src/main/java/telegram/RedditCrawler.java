package telegram;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RedditCrawler {
    final String URL = "https://old.reddit.com/";
    final String SEPARATOR = ";";

    public List<String> craw() {
        List<String> outputSubs = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements score = doc.select("div.score.likes");
            Elements subreddit = doc.select("a.subreddit.hover.may-blank");
            Elements title = doc.select("a.title.may-blank");
            Elements comments = doc.select("a.bylink.comments"); // .attr("href");

            for (int i = 0; i < subreddit.size(); i++) {
                outputSubs.add(score.get(i).text() + " | *" + subreddit.get(i).text() + "* | " + title.get(i).text() + " | ");
                if (title.get(i).attr("href").charAt(0) == '/')
                    outputSubs.set(i, outputSubs.get(i) + "[thread](" + "https://old.reddit.com" + title.get(i).attr("href") + ") | ");
                else
                    outputSubs.set(i, outputSubs.get(i) + "[thread](" + title.get(i).attr("href") + ") | ");
                outputSubs.set(i, outputSubs.get(i) + "[comments](" + comments.get(i).attr("href") + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputSubs;
    }

    public List<String> craw(String argsSubs) {
        List<String> outputSubs = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements score = doc.select("div.score.likes");
            Elements subreddit = doc.select("a.subreddit.hover.may-blank");
            Elements title = doc.select("a.title.may-blank");
            Elements comments = doc.select("a.bylink.comments"); // .attr("href");

            List<String> subs = new ArrayList<>();
            for(int i = 0; i < argsSubs.split(SEPARATOR).length ; i++)
                subs.add(argsSubs.split(SEPARATOR)[i].toLowerCase());

            for (int i = 0; i < subreddit.size(); i++) {
                if (subs.contains(subreddit.get(i).text().split("/")[1].toLowerCase())) {
                    outputSubs.add(score.get(i).text() + " | *" + subreddit.get(i).text() + "* | " + title.get(i).text() + " | ");
                    Integer lastPosition = outputSubs.size()-1;
                    if (title.get(lastPosition).attr("href").charAt(0) == '/')
                        outputSubs.set(lastPosition, outputSubs.get(lastPosition) + "[thread](" + "https://old.reddit.com" + title.get(i).attr("href") + ") | ");
                    else
                        outputSubs.set(lastPosition, outputSubs.get(lastPosition) + "[thread](" + title.get(i).attr("href") + ") | ");
                    outputSubs.set(lastPosition, outputSubs.get(lastPosition) + "[comments](" + comments.get(i).attr("href") + ")");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputSubs;
    }
}
