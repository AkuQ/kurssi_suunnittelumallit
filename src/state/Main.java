/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author akseli
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pokemon pokemon = new Charmander();
        
        System.out.println(pokemon.getSpecies() + " attacks with " + pokemon.getAttack());
        pokemon.makeSound();
        Thread.sleep(500);
        
        pokemon.evolve();
        System.out.println(pokemon.getSpecies() + " attacks with " + pokemon.getAttack());
        pokemon.makeSound();
        Thread.sleep(500);
        
        pokemon.evolve();
        System.out.println(pokemon.getSpecies() + " attacks with " + pokemon.getAttack());
        pokemon.makeSound();
    }
}
