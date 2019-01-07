/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rhinojsexample;

import com.mycompany.rhinojsexample.hostobjects.ConsoleRunner;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 *
 * @author ShalithaS
 */
public class RhinoExample {
    public static void main(String[] args) {
        String code =  "var cr = new ConsoleRunner();"
                + " cr.exec('python --version');";
        try {
            Context cx = Context.enter();
            Scriptable scope = cx.initStandardObjects();
            ScriptableObject.defineClass(scope, ConsoleRunner.class);
            Object ob = cx.evaluateString(scope, code, "rhinodemojs", 1, null);
            System.out.println(Context.toObject(ob, scope));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}


