import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField result = new JTextField();
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonEquals = new JButton("=");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonDelete = new JButton("C");

    private Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    CalculatorView(){

        JPanel calculatorPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int)screenDimension.getWidth()* 20/100,(int)screenDimension.getHeight() * 40/100);

        calculatorPanel.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        GridLayout buttonsLayout = new GridLayout(4,4);
        buttonsPanel.setLayout(buttonsLayout);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        buttonsPanel.add(buttonDelete);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(buttonDivide);
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(buttonMultiply);
        buttonsPanel.add(button0);
        buttonsPanel.add(buttonMinus);
        buttonsPanel.add(buttonPlus);
        buttonsPanel.add(buttonEquals);

        result.setEditable(false);
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(result.getFont().deriveFont(32.0f));

        calculatorPanel.add(result,BorderLayout.NORTH);
        calculatorPanel.add(buttonsPanel,BorderLayout.CENTER);

        this.add(calculatorPanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Calculator");
    }

    public void setNumberButtonListeners(ActionListener actionListener){
        button0.addActionListener(actionListener);
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
        button9.addActionListener(actionListener);

    }

    public void addButtonListener(ActionListener actionListener){
        buttonPlus.addActionListener(actionListener);
    }

    public void setButtonEqualsListener(ActionListener actionListener){
        buttonEquals.addActionListener(actionListener);
    }

    public void setButtonDeleteListener(ActionListener actionListener){
        buttonDelete.addActionListener(actionListener);
    }

    public void setButtonMinusListener(ActionListener actionListener){
        buttonMinus.addActionListener(actionListener);
    }

    public void setButtonDivideListener(ActionListener actionListener){
        buttonDivide.addActionListener(actionListener);
    }

    public void setButtonMultiplyListener(ActionListener actionListener){
        buttonMultiply.addActionListener(actionListener);
    }

    public double getNumber(){

        if(result.getText().equals("")) {
            return 0;
        }else {
            return Double.parseDouble(result.getText());
        }

    }

    public void setSolution(Double d){
        result.setText(d.toString());
    }

    public void clearView(){
        result.setText("");
    }

}
