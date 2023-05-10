package ua.kharin.jadv.practice16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchUtilsTest {
    private static final String ID = "ID";
    private static final String VALUE_1 = "VALUE_1";
    private static final String VALUE_2 = "VALUE_2";
    private static final String VALUE_3 = "VALUE_3";
    private static final String VALUE_4 = "VALUE_4";
    private Node rootNode;
    private Node nodeOne;
    private Node nodeTwo;
    private Node nodeThree;

    @BeforeEach
    void setUp() {
        rootNode = new Node(ID, VALUE_1);
        nodeOne = new Node(ID, VALUE_2);
        nodeTwo = new Node(ID, VALUE_3);
        nodeThree = new Node(ID, VALUE_4);
    }

    @Test
    void searchInDepthSingleNodeNotFound() {
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, VALUE_2);
        assertTrue(result.isEmpty());
    }

    @Test
    void searchInDepthSingleNodeSuccess() {
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, VALUE_1);
        assertTrue(result.isPresent());
        assertEquals(rootNode, result.get());
    }

    @Test
    void searchInDepthResultOnFirstLevel() {
        prepareGraphConnections();
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, VALUE_2);
        assertTrue(result.isPresent());
        assertEquals(nodeOne, result.get());
    }

    @Test
    void searchInDepthResultOnLastLevel() {
        prepareGraphConnections();
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, VALUE_4);
        assertTrue(result.isPresent());
        assertEquals(nodeThree, result.get());
    }

    @Test
    void searchInDepthResultOnLastLevelWithCycles() {
        prepareGraphConnections();
        nodeThree.addConnectedNode(nodeOne);
        rootNode.addConnectedNode(nodeThree);
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, VALUE_4);
        assertTrue(result.isPresent());
        assertEquals(nodeThree, result.get());
    }

    @Test
    void searchInDepthResultOnLastLevelWithCyclesNotFound() {
        prepareGraphConnections();
        nodeThree.addConnectedNode(nodeOne);
        rootNode.addConnectedNode(nodeThree);
        Optional<Node> result = SearchUtils.depthFirstSearch(rootNode, "");
        assertTrue(result.isEmpty());
    }

    private void prepareGraphConnections() {
        rootNode.addConnectedNode(nodeOne);
        nodeOne.addConnectedNode(nodeTwo);
        nodeOne.addConnectedNode(nodeThree);
    }
}