/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jisop.test.fake_controllers;

/**
 *
 * @author mathieu
 */
public class WithIndexController {

    public class Param {

        public String param1;
        public String param2;
        public int param3;
        public double param4;
    }

    public WithIndexController() {
    }

    public String index(Param p) {
        //    return OnIndex(param1, param2, param3, param4); 
        return null;
    }
}
