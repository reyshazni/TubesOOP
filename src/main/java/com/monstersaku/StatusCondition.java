package com.monstersaku;

public class StatusCondition {
    private boolean burn;
    private boolean poison;
    private boolean sleep;
    private boolean paralyze;

    // Getter
    public boolean getBurn(){
        return this.burn;
    }

    public boolean getPoison(){
        return this.poison;
    }

    public boolean getSleep(){
        return this.sleep;
    }

    public boolean getParalyze(){
        return this.paralyze;
    }

    // Setter
    public void setBurn(boolean burn){
        this.burn = burn;
    }

    public void setPoison(boolean poison){
        this.poison = poison;
    }

    public void setSleep(boolean sleep){
        this.sleep = sleep;
    }

    public void setParalyze(boolean paralyze){
        this.paralyze = paralyze;
    }

    // Status Condition
    public void burn(){
        
    }

    public void poison(){
        
    }

    public void sleep(){
        
    }

    public void paralyze(){
        
    }
}
