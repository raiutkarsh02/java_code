import java.awt.*;
public class Awtq2 {
    public static void main(String[] args) {
        Frame f1 = new Frame();
        TextField t1 = new TextField();
        t1.setBounds(30,50,50,20);
        TextField t2 = new TextField();
        t2.setBounds(30,70,50,20);
        Button b1 = new Button("Click");
        b1.setBounds(30,100,50,30);

        f1.add(t1);
        f1.add(t2);
        f1.add(b1);
        f1.setSize(400,400);
        f1.setLayout(null);
        f1.setVisible(true);

    }
}