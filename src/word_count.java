import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class word_count extends Component {


    private JTextArea ta;
    private JButton txtcolor;
    private JButton pad;
    private JLabel cha;
    private JLabel word;
    private JPanel panel;
    private JPanel panel1;
    private JButton reset;
    private JSlider slider;

    word_count(){
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel1);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Font font = new Font("SansSerif",Font.PLAIN,slider.getValue());
                ta.setFont(font);
            }
        });

        ta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                cha.setText("Characters:"+ta.getText().length());
                String words[] = ta.getText().split("\\s");
                word.setText("Words:"+words.length);
            }
        });
        pad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(ta,"Choose the color to use",Color.black);
                ta.setBackground(c);
            }
        });
        txtcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c =JColorChooser.showDialog(ta,"Choose the color to use",Color.black);
                ta.setForeground(c);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
                cha.setText("Characters:");
                word.setText("Words: ");
            }
        });


    }

    public static void main(String[] args) {
        word_count w= new word_count();
    }
}
