package q3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.text.DecimalFormat;
/**
 * <p> * Basically a java class that is called by StopWatchPanel
 * that creates a very very simple StopWatch that runs on
 * on your computer. It shows the time in seconds and tenthes of
 * a second. Has three buttons start, Stop and restart.
 * </p>
 *
 * @author Anmol Grewal
 * @version 1.0
 */
public class StopWatch extends JFrame {
    /** The Number 3.*/
    static final int THREE = 3;
    /**Timer Delay.*/
    static final int DELAY = 1;
    /**Panel Length.*/
    static final int WIDTH = 400;
    /**Panel Height.*/
    static final int HEIGHT = 100;
    /**Changes Output for Further Accuracy.*/
    static final float DELAY_MODIFER = 0.002f;
    /**The Stop Watch Panel.*/
    private final class StopWatchPanel extends JPanel {
        /**Start Button.*/
        private JButton start = new JButton("Start!");
        /**Stop Button.*/
        private JButton stop =  new JButton("Stop!");
        /**Timing Label.*/
        private JLabel time = new JLabel("00.00", JLabel.CENTER);
        /**This is a button for reseting the timer.*/
        private JButton reset = new JButton("Reset!");
        /**Sets format to tenth of Seconds.*/
        private DecimalFormat fmt = new DecimalFormat("0.##");
        /**Button Listener for Buttons.*/
        private ButtonListener listener = new ButtonListener();
        /**Starting Variable which initializes.*/
        private float setTimer;
        /**Timer that keeps track of time using Delay.*/
        private Timer timer = new Timer(DELAY, new TimerListener());
        /**Adds Stop, Reset, Start & Time Along with listeners for buttons.*/
        private StopWatchPanel() {
            setLayout(new GridLayout(THREE, 2));
            start.addActionListener(listener);
            stop.addActionListener(listener);
            reset.addActionListener(listener);
            add(start);
            add(stop);
            add(reset);
            add(time);

        }
        /**Updates Time JLabel.*/
        private class TimerListener implements ActionListener {
            /**.
             * <p>Changes JLabel Time</p>
             * @param event The timer change
             */
            public void actionPerformed(ActionEvent event) {
                setTimer += DELAY * DELAY_MODIFER;
                time.setText(fmt.format(setTimer));      
            }
        }
        /**Button Listener for Start and Stop.*/
        private class ButtonListener implements ActionListener {
            /**This method start and stop the timer.
             * @param event Button Clicks
             */
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == start) {
                    timer.start();
                } else if (event.getSource() == stop) {
                    timer.stop();
                } else {
                    timer.stop();
                    setTimer = 0;
                    time.setText(fmt.format(setTimer));
                }
            }
        }
    }
    /**Panel Constructor.*/
    public StopWatch() {
        // The Name on Top
        super("Anmol Grewal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new StopWatchPanel());
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        new StopWatch();
    }

};

