import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    public JLabel image;

    public ImagePanel(Color color, int x, int y, int width, int height){
        this.image = new JLabel();
        this.image.setBounds(x, y, width, height);
        this.setBackground(color);
        this.add(image);
        this.setLayout(null);
    }
}
