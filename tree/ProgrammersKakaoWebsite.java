package tree;

import java.util.*;

public class ProgrammersKakaoWebsite {
    public static void main(String[] args) {
        new ProgrammersKakaoWebsite().solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" });
    }

    public int solution(String word, String[] pages) {
        Page[] pageLists = new Page[pages.length];
        Map<String, Page> pageMap = new HashMap<>();
        word = word.toLowerCase();
        int pageNum = 0;
        for (String page : pages) {
            page = page.toLowerCase();
            String[] lines = page.split("\n");
            String pageUrl = "";
            int basicScore = 0;
            Set<String> linkPages = new HashSet<>();
            for (String line : lines) {
                if (line.contains("<meta")) {
                    int urlpos = line.indexOf("https://");
                    if (urlpos != -1) {
                        int endPos = line.indexOf("\"", urlpos);
                        pageUrl = line.substring(urlpos, endPos);
                    }
                } else if (line.contains("<a href")) {
                    int urlpos = line.indexOf("https://");
                    if (urlpos != -1) {
                        int endPos = line.indexOf("\"", urlpos);
                        linkPages.add(line.substring(urlpos, endPos));
                    }
                }
                int startPos = -1;
                int endPos = line.length() - 1;
                int endStrPos = startPos + word.length() - 1;
                while (startPos < endPos && endStrPos <= endPos) {
                    startPos = line.indexOf(word, startPos + 1);
                    endStrPos = startPos + word.length() - 1;
                    if (startPos != -1) {
                        if (0 < startPos && endStrPos < endPos) {
                            if (!Character.isLetter(line.charAt(startPos - 1))
                                    && !Character.isLetter(line.charAt(endStrPos + 1))) {
                                basicScore++;
                            }
                        } else if (startPos == 0) {
                            if (!Character.isLetter(line.charAt(endStrPos + 1))) basicScore++;
                        } else if (endStrPos == endPos) {
                            if (!Character.isLetter(line.charAt(startPos - 1))) basicScore++;
                        }
                    } else break;
                }

            }
            Page page1 = new Page(pageNum, basicScore, pageUrl, linkPages);
            pageLists[pageNum++] = page1;
            pageMap.put(page1.url, page1);
        }

        for (Page p : pageLists) {
            for (String s : p.listTo) {
                if (pageMap.get(s) != null)
                    pageMap.get(s).listFrom.add(p.url);
            }
        }
        for (Page p : pageLists) {
            for (String s : p.listFrom) {
                Page fromPage = pageMap.get(s);
                p.linkScore = (double) fromPage.basicScore / fromPage.listTo.size();
            }
            p.print();
        }
        Arrays.sort(pageLists, new Comp());
        System.out.println(pageLists[0].idx);
        return pageLists[0].idx;
    }

    class Comp implements Comparator<Page> {
        @Override
        public int compare(Page o1, Page o2) {
            if (o1.basicScore + o1.linkScore < o2.basicScore + o2.linkScore) return 1;
            else if (o1.basicScore + o1.linkScore == o2.basicScore + o2.linkScore) {
                if (o1.idx > o2.idx) return 1;
            }
            return -1;
        }
    }

    class Page {
        int idx;
        int basicScore;
        Set<String> listTo = new HashSet<>();
        Set<String> listFrom = new HashSet<>();
        String url;
        double linkScore;

        public Page(int idx, int basicScore, String url, Set<String> listTo) {
            this.idx = idx;
            this.basicScore = basicScore;
            this.url = url;
            this.listTo = listTo;
        }

        public void print() {
            System.out.println("idx: " + idx + " basicscore: " + basicScore
                    + " url: " + url + " link Score: " + linkScore + " 링크 개수: " + listTo.size()
                    + "참조 개수: " + listFrom.size()
            );
        }

    }
}
