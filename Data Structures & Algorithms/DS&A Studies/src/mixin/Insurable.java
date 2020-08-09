package mixin;

// Interface for objects that can be insured; inherits both Sellable & Transportable interfaces.
public interface Insurable extends Sellable, Transportable {
    // Returns insured value in cents.
    int insuredValue();
}
