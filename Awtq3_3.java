import java.awt.*;
public class Awtq3_3 extends Frame {

    public Awtq3_3(){
        setSize(400,500);
        Label l1 = new Label("Enter your Name:");
        l1 .setBounds(30,100,100,30);

        TextField tx = new TextField();
        tx.setBounds(150,110,150,20);

        add(l1);
        add(tx);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Awtq3_3  obj = new Awtq3_3 ();
    }
}