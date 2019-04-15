public class CalculatorModel {

    private double memoryNumber = 0;

    private double addValue;
    private double subValue;

    private String lastAction = "";

    public void addTwoNumbers(double a, double b){
        addValue = a + b;
        memoryNumber = addValue;
    }

    public void subTwoNumbers(double a, double b){
        subValue = a - b;
        memoryNumber = subValue;
    }

    public double getAddValue(){
        return addValue;
    }

    public double getSubValue(){
        return subValue;
    }

    public void setMemoryNumber(double x){
        this.memoryNumber = x;
    }

    public double getMemoryNumber(){
        return memoryNumber;
    }

    public void setLastAction(String lastAction){
        this.lastAction = lastAction;
    }

    public String getLastAction() {
        return lastAction;
    }
}
