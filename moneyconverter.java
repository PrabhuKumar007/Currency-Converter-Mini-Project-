import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class moneyconverter extends JFrame{
    private JLabel currencyLabel,flabel, toLabel, resultLabel;
    private JTextField currencyField;
    private JButton convertButton;
    private JComboBox<String> incomboBox,tocomboBox;
    private DecimalFormat decimalFormat=new DecimalFormat("#,##0.00");

    private final String[] currencies ={"USD","EUR","INR","BHD","CAD","GBP","CHF","AUD","JPY","CNY"};
    private Double[] exchange={1.00,0.92,84.04,0.38,1.38,0.77,0.86,1.50,149.73,7.12};

    public moneyconverter(){
        setTitle("money converter");
        setLayout(new GridLayout(10,4));

        currencyLabel=new JLabel("cash");
        add(currencyLabel);
        
        currencyField=new JTextField();
        add(currencyField);

        flabel=new JLabel("In:");
        add(flabel);

        incomboBox = new JComboBox<>(currencies);
        add(incomboBox);

        toLabel=new JLabel("To");
        add(toLabel);

        tocomboBox = new JComboBox<>(currencies);
        add(tocomboBox);

        convertButton= new JButton("SUBMIT");
        add(convertButton);

        resultLabel =new JLabel();
        add(resultLabel);

        convertButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double currency =Double.parseDouble(currencyField.getText());
                    String incurrency=(String) incomboBox.getSelectedItem();
                    String tocurrency=(String) tocomboBox.getSelectedItem();
                    double exchangeRate=exchange[getIndex(tocurrency)]/ exchange[getIndex(incurrency)];
                    double result=currency* exchangeRate;
                    resultLabel.setText(decimalFormat.format(result)+" "+tocurrency);
                }catch(Exception ex){
                    resultLabel.setText("no money");
                }

            }
         
        });
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private int getIndex(String currency){
        for(int i=0;i<currencies.length;i++){
            if(currency.equals(currencies[i])){
                return i;
            }
        }
        return -1;  
    }

    public static void main(String[]args){

        new moneyconverter();
        }
}