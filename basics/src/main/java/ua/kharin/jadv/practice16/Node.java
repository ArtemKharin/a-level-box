package ua.kharin.jadv.practice16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Node {
    private String key;
    private String value;
    private List<Node> connectedNodes;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        connectedNodes = new ArrayList<>();
    }

    public void addConnectedNode(Node node){
        connectedNodes.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key.equals(node.key) && value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
