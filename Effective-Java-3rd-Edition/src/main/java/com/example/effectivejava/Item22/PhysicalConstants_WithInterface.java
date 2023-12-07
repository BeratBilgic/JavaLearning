package com.example.effectivejava.Item22;

// Constant interface antipattern - do not use!
public interface PhysicalConstants_WithInterface {
    // Avogadro's number (1/mol)
    double AVOGADROS_NUMBER   = 6.022_140_857e23;
    // Boltzmann constant (J/K)
    double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    // Mass of the electron (kg)
    double ELECTRON_MASS      = 9.109_383_56e-31;

    //All the fields of an interface are public, static and, final by default
}
