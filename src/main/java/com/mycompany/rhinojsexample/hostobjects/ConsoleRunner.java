/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rhinojsexample.hostobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.mozilla.javascript.ScriptableObject;

/**
 *
 * @author ShalithaS
 */
public class ConsoleRunner extends ScriptableObject {
    
    public ConsoleRunner() {}
    
    public void jsConstructor() {}
    
    public String jsFunction_exec(String command) throws IOException {
        StringBuilder out = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        Process pr = runtime.exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String outputLine = null;
        while((outputLine = br.readLine()) != null) {
            out.append(outputLine + '\n');
        }
        br.close();
        return out.toString();
    }

    @Override
    public String getClassName() {
        return "ConsoleRunner";
    }
}
