public class Main {

    public static void main(String[] args) {
       CalculatorView view = new CalculatorView();

       CalculatorModel model = new CalculatorModel();

       CalculatorController controller = new CalculatorController(view,model);

    }

}
