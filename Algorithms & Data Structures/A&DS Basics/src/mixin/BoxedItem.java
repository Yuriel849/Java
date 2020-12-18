package mixin;

/*
    mixin
        Multiple inheritance technique, approximated in Java by using interfaces.
        "mixin" classes in languages other than Java (Java does not permit multiple inheritance for classes)
            are not intended for standalone usage but exist to provide additional functionality
            to other classes that inherit the mixin class.
        Java interfaces that approximate mixin include:
            java.lang.Cloneable
            java.lang.Comparable
            java.util.Observer
 */

// BoxedItem has all the (non-optional) functionality of the Insurable, Sellable, Transportable interfaces.
abstract public class BoxedItem implements Insurable { // Abstract class to avoid implementing the interfaces.
}
