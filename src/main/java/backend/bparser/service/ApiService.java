package backend.bparser.service;

import backend.bparser.model.ContestantData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApiService {

    private final List<String> urls = new ArrayList<String>() {{
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=264&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=268&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=272&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=274&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=277&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=280&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=283&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=287&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=288&showLeftMenu=False");
        add("http://new.bacs.cs.istu.ru/Monitor/AcmMonitor?contestId=289&showLeftMenu=False");
    }};

    public List<ContestantData> getContestData(int contestDay) {
        List<ContestantData> result = new ArrayList<>();
        String url = urls.get(contestDay - 1);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = new Elements();
        elements.addAll(doc.getElementsByAttributeValue("class", "even"));
        elements.addAll(doc.getElementsByAttributeValue("class", "odd"));

        for (Element element: elements) {
             Elements childs = element.getAllElements();
             String nickname = childs.get(3).text();
             Integer countOfProblems = Integer.valueOf(childs.get(childs.size()-3).text());
             result.add(new ContestantData(nickname, countOfProblems));
        }

        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }
}
