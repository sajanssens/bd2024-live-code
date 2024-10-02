package com.infosupport.h13.designyourself;

public class Demo {
    public static void main(String[] args) {
        BoxInteger boxInteger = new BoxInteger();
        boxInteger.setContent(42);
        System.out.println(boxInteger.getContent());

        BoxString boxString = new BoxString();
        boxString.setContent("42");
        System.out.println(boxString.getContent());

        Box<Integer> boxIntGeneric = new Box<>(Integer.class);
        boxIntGeneric.setContent(42);
        System.out.println(boxIntGeneric.getContent());
        boxIntGeneric.process();

        Box<Double> boxStringGeneric = new Box<>(Double.class);
        boxStringGeneric.setContent(1.23);
        boxStringGeneric.process();
    }
}

class BoxInteger {
    private Integer content;

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }
}

class BoxString {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Box<T extends Number> {

    private T content;

    // if you need to do really do something with T, you have to pass the class of T as instance:
    private Class<T> theType;

    public Box(Class<T> theType) {
        this.theType = theType;
    }

    public Box() { }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void process() {
        int x = content.intValue() + 6;
        System.out.println(x);
    }
}
