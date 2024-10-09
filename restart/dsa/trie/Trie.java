package restart.dsa.trie;

import java.util.HashMap;
import java.util.Objects;

public class Trie {
    public boolean endOfWord;
    public HashMap<Character, Trie> nextAlphabets;

    public Trie(boolean endOfWord, HashMap<Character, Trie> nextAlphabets) {
        this.endOfWord = endOfWord;
        this.nextAlphabets = nextAlphabets;
    }

    public Trie construct(Trie node,String[] strings){
        return null;
    }

    public Trie construct(Trie node, String string){
        if(Objects.isNull(string) || string.isBlank() || string.isEmpty()) return node;
        Trie current=node;
        for(int i=0;i<string.length();++i){

        }
        return  null;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public HashMap<Character, Trie> getNextAlphabets() {
        return nextAlphabets;
    }

    public void setNextAlphabets(HashMap<Character, Trie> nextAlphabets) {
        this.nextAlphabets = nextAlphabets;
    }
}
