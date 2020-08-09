package mixin;

// Interface for objects that can be transported.
public interface Transportable {
    // Returns the weight in grams.
    int weight();

    // Returns whether the object is hazardous.
    boolean isHazardous();
}
