import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneDisplay extends JFrame {
    private JLabel timeLabel;

    public TimeZoneDisplay() {
        setTitle("Timezone Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton button = new JButton("Show Time");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTime();
            }
        });

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(timeLabel, BorderLayout.CENTER);

        add(panel);
    }

    private void displayTime() {
        // Get current time
        Date currentTime = new Date();

        // Create date format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);

        // Display time for different time zones
        TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
        sdf.setTimeZone(newYorkTimeZone);
        String newYorkTime = sdf.format(currentTime);

        TimeZone londonTimeZone = TimeZone.getTimeZone("Europe/London");
        sdf.setTimeZone(londonTimeZone);
        String londonTime = sdf.format(currentTime);

        TimeZone tokyoTimeZone = TimeZone.getTimeZone("Asia/Tokyo");
        sdf.setTimeZone(tokyoTimeZone);
        String tokyoTime = sdf.format(currentTime);

        String displayText = "<html>New York: " + newYorkTime +
                "<br>London: " + londonTime +
                "<br>Tokyo: " + tokyoTime + "</html>";

        timeLabel.setText(displayText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimeZoneDisplay().setVisible(true);
            }
        });
    }
}
