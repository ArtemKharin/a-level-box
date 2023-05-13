package ua.kharin.jadv.practice16;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SearchUtils {
    private SearchUtils() {
    }

    private static ThreadLocal<List<Node>> processedNodes = new ThreadLocal<>();

    public static Optional<Node> depthFirstSearch(Node initial, String searchText) {
        if (Objects.equals(initial.getValue(), searchText)) {
            return Optional.of(initial);
        }
        for (Node connectedNode : initial.getConnectedNodes()) {
            if (Objects.equals(connectedNode.getValue(), searchText)) {
                return Optional.of(connectedNode);
            }
            if (isNodeVisited(connectedNode)) {
                continue;
            }
            putNodeToThreadLocal(connectedNode);
            Optional<Node> localResult = depthFirstSearch(connectedNode, searchText);
            if (localResult.isPresent()) {
                processedNodes.remove();
                return localResult;
            }
        }
        return Optional.empty();
    }

    private static void putNodeToThreadLocal(Node node) {
        if (processedNodes.get() == null) {
            processedNodes.set(new ArrayList<>());
        }
        processedNodes.get().add(node);
    }

    private static boolean isNodeVisited(Node node) {
        return processedNodes.get() != null && processedNodes.get().contains(node);
    }
}
