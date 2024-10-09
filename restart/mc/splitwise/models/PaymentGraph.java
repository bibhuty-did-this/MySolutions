package restart.mc.splitwise.models;

import java.util.Map;

public class PaymentGraph {
    private final Map<String, BalanceMap> graph;

    public PaymentGraph(Map<String, BalanceMap> graph) {
        this.graph = graph;
    }

    @Override
    public String toString() {
        return "PaymentGraph{" +
                "graph=" + graph +
                '}';
    }
}
