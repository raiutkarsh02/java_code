import java.awt.*;
public class Awtq4_4 {
    public static void main(String[] args) {
        Frame f1 = new Frame();
        f1.setSize(500,500);
        Label l1 = new Label("Choose Your Favorite Language:");
        l1.setBounds(100,150,200,30);
        Choice ch = new Choice();
        ch.setBounds(100,200,50,30);
        ch.add("Java");
        ch.add("Python");
        ch.add("C#");
        ch.add("C/C++");

        f1.add(l1);
        f1.add(ch);

        f1.setLayout(null);
        f1.setVisible(true);

    }
}