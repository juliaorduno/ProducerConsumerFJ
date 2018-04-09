/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author juliaorduno
 */
public class Operation {
    
    private int a, b;
    private char symbol;
    private double result;
    
    public Operation(int operator1,int operator2, char symbol){
        this.a = operator1;
        this.b = operator2;
        this.symbol = symbol;
    }
    
    public double getResult(){
        switch(this.symbol){
            case '+': 
                this.result = this.a+this.b;
                break;
                
            case '-': 
                this.result = this.a-this.b;
                break;
            
            case '*':
                this.result = this.a*this.b;
                break;
                
            case '/':
                this.result = this.a/this.b;
                break;
        }
        return this.result;
    }
    
    public String operationString(){
        return "( " + this.symbol + " " + this.a + " " + this.b + " )";
    }
    
}
