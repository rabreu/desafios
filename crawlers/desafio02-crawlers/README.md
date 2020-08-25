## RedditCrawler


### Métodos

``craw(String argsSubs)``\
``craw()``

### Uso

Método .craw([Lista de subreddits]):
```
RedditCrawler redditCrawler = new RedditCrawler();
List<String> subs = redditCrawler.craw("news;pics;nba");

for (String sub : subs)
    System.out.println(sub);
```

Usar o método .craw() sem argumentos também é permitido para retornar uma lista de subreddits sem filtro:
```
List<String> subs = redditCrawler.craw();
```
