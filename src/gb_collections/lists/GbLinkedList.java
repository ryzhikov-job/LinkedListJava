package gb_collections.lists;

import gb_collections.GbList;
import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public GbLinkedList() {
        last = new Node<>(first, null, null);
        first = new Node<>(null, null, last);
    }

    private class Node<E> {
        public E element;
        public Node<E> nextE;
        public Node<E> prevE;

        public Node(Node<E> prevE, E element, Node<E> nextE) {
            this.element = element;
            this.nextE = nextE;
            this.prevE = prevE;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextE() {
            return nextE;
        }

        public void setNextE(Node<E> nextE) {
            this.nextE = nextE;
        }

        public Node<E> getPrevE() {
            return prevE;
        }

        public void setPrevE(Node<E> prevE) {
            this.prevE = prevE;
        }
    }

    @Override
    public void addLast(E e) {
        Node<E> l = last;
        l.setElement(e);
        last = new Node<>(l, null, null);
        l.setNextE(last);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> f = first.getNextE();
        Node<E> newNode = new Node<>(null, e, f);
        first.setNextE(newNode);
        f.setPrevE(newNode);
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<E> newNode = new Node<>(null, value, null);
        if (index == size) {
            addLast(value);
        } else if (index == 0) {
            addFirst(value);
        } else {
            Node<E> current = first.getNextE();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextE();
            }
            newNode.setNextE(current.getNextE());
            current.getNextE().setPrevE(newNode);
            current.setNextE(newNode);
            newNode.setPrevE(current);
            size++;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).getElement();
    }

    @Override
    public void remove(E value) {
        Node<E> current = first.getNextE();
        while (current != last) {
            if (current.getElement().equals(value)) {
                Node<E> prevNode = current.getPrevE();
                Node<E> nextNode = current.getNextE();
                if (prevNode != null) {
                    prevNode.setNextE(nextNode);
                } else {
                    first = nextNode;
                }
                if (nextNode != null) {
                    nextNode.setPrevE(prevNode);
                } else {
                    last = prevNode;
                }
                size--;
                return;
            }
            current = current.getNextE();
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }

        Node<E> current = first.getNextE();
        for (int i = 0; i < index; i++) {
            current = current.getNextE();
        }

        Node<E> prevNode = current.getPrevE();
        Node<E> nextNode = current.getNextE();

        if (prevNode != null) {
            prevNode.setNextE(nextNode);
        } else {
            first = nextNode;
        }

        if (nextNode != null) {
            nextNode.setPrevE(prevNode);
        } else {
            last = prevNode;
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> get = first.getNextE();
        for (int i = 0; i < index; i++) {
            get = getNextElement(get);
        }
        return get.getElement();
    }

    private Node<E> getNode(int index) {
        Node<E> node = first.getNextE();
        for (int i = 0; i < index; i++) {
            node = node.getNextE();
        }
        return node;
    }

    private Node<E> getNextElement(Node<E> element) {
        return element.getNextE();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GbLinkedList[");
        Node<E> current = first.getNextE();

        while (current != null && current != last) {
            sb.append(current.getElement());
            if (current.getNextE() != null && current.getNextE() != last) {
                sb.append(", ");
            }
            current = current.getNextE();
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                return getElementByIndex(count++);
            }
        };
    }
}
