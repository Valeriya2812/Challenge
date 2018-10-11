package cisco.java.challenge;

import java.util.HashMap;
import java.util.Map;

public class Word {

    private Map<String, Integer> words;

    public Word() {
        words = new HashMap();
    }

    public void addWord(String w) {
        int count = 1;
        if (words.containsKey(w)) {
            count += words.get(w);
            words.put(w, count);
        } else {
            words.put(w, count);
        }
    }
    public void printWords(){
        for(Map.Entry<String, Integer> e: words.entrySet())
            System.out.println(e.getValue()+" "+e.getKey());
    }
}