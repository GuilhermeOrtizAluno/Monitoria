/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

/**
 *
 * @author Guilherme Ortiz
 */
public class Functions {
    public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
}
