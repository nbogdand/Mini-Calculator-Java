import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel){
        this.view = calculatorView;
        this.model = calculatorModel;

        this.view.addButtonListener(new AddListener());
        this.view.setNumberButtonListeners(new NumberButtonListener());
        this.view.setButtonEqualsListener(new EqualsButtonListener());
        this.view.setButtonDeleteListener(new ClearButtonListener());
        this.view.setButtonMinusListener(new SubtractButtonListener());
        this.view.setButtonDivideListener(new DivideButtonListener());
        this.view.setButtonMultiplyListener(new MultiplyButtonListener());
    }

    private void performLastOperation(){
        switch (model.getLastAction()) {
            case Constants.ACTION_EQUALS:

                model.setMemoryNumber(view.getNumber());
                view.clearView();

                break;
            case Constants.ACTION_ADD:

                model.setMemoryNumber(model.getMemoryNumber() + view.getNumber());
                view.clearView();

                break;
            case Constants.ACTION_SUBTRACT:

                model.setMemoryNumber(model.getMemoryNumber() - view.getNumber());
                view.clearView();

                break;
            case Constants.ACTION_DIVIDE:

                model.setMemoryNumber(model.getMemoryNumber() / view.getNumber());
                view.clearView();

                break;
            case Constants.ACTION_MULITPLY:

                model.setMemoryNumber(model.getMemoryNumber() * view.getNumber());
                view.clearView();

                break;
            case "":

                model.setMemoryNumber(view.getNumber());
                view.clearView();

                break;
        }

    }

    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            performLastOperation();
            model.setLastAction(Constants.ACTION_ADD);

        }
    }

    class NumberButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            view.setSolution(view.getNumber() * 10 + Double.valueOf( ((JButton)e.getSource()).getText() ) );

        }
    }

    class EqualsButtonListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (model.getLastAction()) {
                case Constants.ACTION_ADD:

                    view.setSolution(model.getMemoryNumber() + view.getNumber());

                    break;
                case Constants.ACTION_SUBTRACT:

                    view.setSolution(model.getMemoryNumber() - view.getNumber());

                    break;
                case Constants.ACTION_DIVIDE:

                    view.setSolution(model.getMemoryNumber() / view.getNumber());

                    break;
                case Constants.ACTION_MULITPLY:

                    view.setSolution(model.getMemoryNumber() * view.getNumber());
                    break;
            }

            model.setMemoryNumber(view.getNumber());

            model.setLastAction(Constants.ACTION_EQUALS);
        }
    }

    class ClearButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearView();
            model.setMemoryNumber(0d);
            model.setLastAction("");
        }
    }

    class SubtractButtonListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            performLastOperation();

            model.setLastAction(Constants.ACTION_SUBTRACT);

        }
    }


    class DivideButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            performLastOperation();

            model.setLastAction(Constants.ACTION_DIVIDE);

        }
    }


    class MultiplyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            performLastOperation();

            model.setLastAction(Constants.ACTION_MULITPLY);
        }
    }

}
