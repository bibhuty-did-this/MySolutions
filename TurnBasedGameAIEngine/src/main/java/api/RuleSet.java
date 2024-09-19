package api;

import boards.Board;

import java.util.*;
import java.util.function.Consumer;

public class RuleSet<T extends Board> implements Iterable<Rule>{
    Set<Rule> ruleList=new HashSet<>();

    public void add(Rule boardRule) {
        ruleList.add(boardRule);
    }

    @Override
    public Iterator<Rule> iterator() {
        return ruleList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Rule> action) {
        ruleList.forEach(action);
    }

    @Override
    public Spliterator<Rule> spliterator() {
        return ruleList.spliterator();
    }
}
