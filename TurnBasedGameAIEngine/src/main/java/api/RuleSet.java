package api;

import game.Board;

import java.util.*;
import java.util.function.Consumer;

public class RuleSet<T extends Board> implements Iterable<Rule<T>>{
    Set<Rule<T>> ruleList=new HashSet<>();

    public void add(Rule<T> boardRule) {
        ruleList.add(boardRule);
    }

    @Override
    public Iterator<Rule<T>> iterator() {
        return ruleList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Rule<T>> action) {
        ruleList.forEach(action);
    }

    @Override
    public Spliterator<Rule<T>> spliterator() {
        return ruleList.spliterator();
    }
}
