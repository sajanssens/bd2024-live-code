package com.infosupport.unittesting;

public abstract class BinaryTree<T extends Comparable<T>> {
    public static <U extends Comparable<U>> BinaryTree<U> empty() {
      return new Empty<>();
    }
    public static <U extends Comparable<U>> BinaryTree<U> single(U item) {
        return BinaryTree.<U>empty().add(item);
    }
    public abstract BinaryTree<T> add(T item);
    public abstract boolean contains(T item);
    public abstract int length();
}

class Node<T extends Comparable<T>> extends BinaryTree<T> {
    private final T item;
    private final BinaryTree<T> left;
    private final BinaryTree<T> right;

    Node(T item, BinaryTree<T> left, BinaryTree<T> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    @Override
    public BinaryTree<T> add(T item) {
        var compare = this.item.compareTo(item);
        if (compare == 0) {
            return this;
        } else if (compare > 0) {
            return new Node<T>(this.item, this.left, this.right.add(item));
        } else {
            return new Node<T>(this.item, this.left.add(item), this.right);
        }
    }

    @Override
    public boolean contains(T item) {
        var compare = this.item.compareTo(item);
        if (compare == 0) {
            return true;
        } else if (compare > 0) {
            return this.right.contains(item);
        } else {
            return this.left.contains(item);
        }
    }

    @Override
    public int length() {
        return 1 + this.left.length() + this.right.length();
    }

}

class Empty<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public BinaryTree<T> add(T item) {
        return new Node<T>(item, this, this);
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }
}
