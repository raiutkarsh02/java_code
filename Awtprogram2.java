import java.awt.*;
public class Awtprogram2 extends Frame {
    public Awtprogram2() {
        Label l1 = new Label("Hello VIT");
        l1.setBounds(100, 120, 50, 20);
        setSize(500, 500);
        add(l1);

        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        Awtprogram2 a1 = new Awtprogram2();
    }
}