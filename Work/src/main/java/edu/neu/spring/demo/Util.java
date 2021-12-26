/**
 * 
 */
package edu.neu.spring.demo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author pratiknakave
 *
 */
public class Util {

	private static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Set<String> identifiers = new HashSet<String>();
	public static String nameGenerator() {
		final java.util.Random rand = new java.util.Random();
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public static int ageGenerator() {
		Random rand = new Random(); //instance of random class
	    int upperbound = 50;
	    //generate random values from 0-50
	    int int_random = rand.nextInt(upperbound);
		return int_random;
	}
}
