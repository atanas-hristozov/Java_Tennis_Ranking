import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        Map<String, Node> ranking = new HashMap<>();
        TennisPlayers tennisPlayers = new TennisPlayers();

        String[] playerNames = scanner.nextLine().split(" ");
        for (String tennisPlayer : playerNames) {
            Node node = tennisPlayers.addLast(tennisPlayer);
            ranking.put(tennisPlayer, node);
        }

        for (int i = 0; i < K; i++) {
            String[] rankingChange = scanner.nextLine().split(" ");
            String player1 = rankingChange[0];
            String player2 = rankingChange[1];

            Node currentSeat = ranking.get(player1);
            Node targetRank = ranking.get(player2);
            tennisPlayers.addBefore(currentSeat, targetRank);
        }

        for (String playerName : tennisPlayers) {
            System.out.print(playerName + " ");
        }
    }
}

class Node {
    final String value;
    Node prev;
    Node next;

    Node(String value) {
        this.value = value;
    }
}

class TennisPlayers implements Iterable<String> {
    private Node head;
    private Node tail;
    private int size = 0;

    public Node addLast(String value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return tail;
    }

    public void addBefore(Node currentSeat, Node targetSeat) {
        if (currentSeat.next == targetSeat) {
            return;
        } else if (currentSeat == head) {
            removeFirst();
        } else if (currentSeat == tail) {
            removeLast();
        } else {
            currentSeat.prev.next = currentSeat.next;
            currentSeat.next.prev = currentSeat.prev;
        }

        if (targetSeat == head) {
            insertFirst(currentSeat);
            return;
        }

        targetSeat.prev.next = currentSeat;
        currentSeat.prev = targetSeat.prev;

        currentSeat.next = targetSeat;
        targetSeat.prev = currentSeat;
    }

    private void insertFirst(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void removeFirst() {
        head = head.next;
        head.prev = null;
    }

    private void removeLast() {
        tail = tail.prev;
        tail.next = null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}