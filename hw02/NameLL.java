public class NameLL {
    private class Node {
        Name data;
        Node next;
        Node prev;
        Node(Name data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    private int[] yearlyTotals;
    private int globalTotal;
    public NameLL() {
        head = null;
        tail = null;
        size = 0;
        yearlyTotals = new int[28];
        globalTotal = 0;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
    public Name first() {
        return head == null ? null : head.data;
    }
    public Name last() {
        return tail == null ? null : tail.data;
    }
    public void insertFirst(Name name) {
        Node newNode = new Node(name);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void insertBack(Name name) {
        Node newNode = new Node(name);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void insertSortedAlpha(Name name) {
        if(isEmpty() || name.getName().compareToIgnoreCase(head.data.getName()) < 0) {
            insertFirst(name);
            return;
        }
        Node current = head;
        while(current != null && name.getName().compareToIgnoreCase(current.data.getName()) >= 0) {
            current = current.next;
        }
        if(current == null) {
            insertBack(name);
        } else {
            Node newNode = new Node(name);
            Node prev = current.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }
    public void insertOrUpdate(String nameStr, int year, int rank, int count) {
        int yearIndex = year - 1990;
        if(yearIndex < 0 || yearIndex >= 28) return;
        yearlyTotals[yearIndex] += count;
        globalTotal += count;
        Node current = head;
        while(current != null) {
            int cmp = nameStr.compareToIgnoreCase(current.data.getName());
            if(cmp == 0) {
                current.data.updateYearData(year, rank, count);
                return;
            } else if(cmp < 0) {
                break;
            }
            current = current.next;
        }
        Name newName = new Name(nameStr);
        newName.updateYearData(year, rank, count);
        Node newNode = new Node(newName);
        if(head == null) {
            head = tail = newNode;
        } else if(nameStr.compareToIgnoreCase(head.data.getName()) < 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null && nameStr.compareToIgnoreCase(temp.next.data.getName()) > 0) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            if(temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        size++;
    }
    public int index(String nameStr) {
        Node current = head;
        int pos = 1;
        while(current != null) {
            if(current.data.getName().equalsIgnoreCase(nameStr)) return pos;
            pos++;
            current = current.next;
        }
        return -1;
    }
    public double[] yearStats(String nameStr, int year) {
        Node current = head;
        while(current != null) {
            if(current.data.getName().equalsIgnoreCase(nameStr)) {
                Name.YearData yd = current.data.getYearData(year);
                if(yd == null) return null;
                int totalForYear = yearlyTotals[year - 1990];
                double perc = totalForYear > 0 ? (double)yd.getCount() / totalForYear : 0;
                return new double[]{yd.getRank(), yd.getCount(), perc};
            }
            current = current.next;
        }
        return null;
    }
    public double[] totalStats(String nameStr) {
        Node target = null;
        Node current = head;
        while(current != null) {
            if(current.data.getName().equalsIgnoreCase(nameStr)) {
                target = current;
                break;
            }
            current = current.next;
        }
        if(target == null) return null;
        int targetTotal = target.data.getTotalCount();
        int rank = 1;
        current = head;
        while(current != null) {
            if(current != target && current.data.getTotalCount() > targetTotal) rank++;
            current = current.next;
        }
        double totalPerc = globalTotal > 0 ? (double)targetTotal / globalTotal : 0;
        return new double[]{rank, targetTotal, totalPerc};
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null) {
            if(sb.length() > 0) sb.append(", ");
            sb.append(current.data.toString());
            current = current.next;
        }
        return sb.toString();
    }
    public void printList() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data.getName() + " ");
            current = current.next;
        }
        System.out.println();
    }
}
