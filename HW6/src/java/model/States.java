package model;

 
public class States {
    private int stateID;
    private String stateName; 
    private int yearFounded; 
    private int population; 
    private int age; 
    
    
    public States() {
        this.stateID = 0;
        this.stateName = "";
        this.yearFounded = 0;
        this.population = 0;
        this.age = 0;
    }
    

    public States(int stateID, String stateName, int yearFounded, int population, int age) {
        this.stateID = stateID;
        this.stateName = stateName;
        this.yearFounded = yearFounded;
        this.population = population;
        this.age = age;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
    
    
    @Override
    public String toString() {
        return "States{" + "stateID=" + stateID + ", stateName=" + stateName + ", yearFounded=" + yearFounded + ", population=" + population + ", age=" + age + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
