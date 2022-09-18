import javax.swing.*;

public class AppFrame extends JFrame {
    public final int SCREEN_WIDTH = 1000;
    public final int SCREEN_HEIGHT = 600;
    public final int PANEL_WIDTH = SCREEN_WIDTH / 3;
    public final int ELEMENT_WIDTH = 150;
    public final int ELEMENT_HEIGHT = 50;

    public AppFrame() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        this.setTitle("IMAGE PROCESSING");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.add(new AppPanels());
        this.pack();
        this.setVisible(true);
    }


}
