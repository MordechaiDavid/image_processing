import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ButtonsPanel extends JPanel {
    protected AppPanels panels;
    protected ChromeDriver driver;
    protected JButton searchButton;
    protected BufferedImage scanImage;
    protected static BufferedImage scanImage2;
    protected static URL imageUrl;

    public ButtonsPanel(AppPanels panels, Color color, int x){
        this.panels = panels;

        JLabel enterProfile = new JLabel("ENTER PROFILE");
        this.searchButton = new JButton("SEND");
        JTextField textField = new JTextField();

        this.searchButton.setBackground(new Color(3, 168, 36));
        this.searchButton.addActionListener((event) -> {
            String profileName = textField.getText();
            try {
                //download the image
                downloadImage(profileName);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        this.add(enterProfile).setBounds(x ,  10, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(textField).setBounds(enterProfile.getX(), enterProfile.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(this.searchButton).setBounds(textField.getX(), textField.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);

        this.setLayout(null);
        this.setBackground(color);

    }



    private void downloadImage(String profileName) throws IOException {
        this.driver = new ChromeDriver();
        this.driver.get("https://facebook.com/" + profileName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // find the element of the profile photo and display it
        WebElement element = driver.findElement(By.tagName("image"));
        String src = element.getAttribute("xlink:href");
        imageUrl = new URL(src);
        this.scanImage = ImageIO.read(imageUrl);
        this.scanImage2 = ImageIO.read(imageUrl);

        driver.quit();
        addButtons();

    }

    public void addButtons() {
        ImageIcon myPicture = new ImageIcon(scanImage);
        ImageIcon copyOfPicture = new ImageIcon(scanImage2);
        panels.origImgPanel.image.setIcon(myPicture);
        panels.origImgPanel.image.setBounds(panels.origImgPanel.image.getX(), panels.origImgPanel.image.getY(), myPicture.getIconWidth(), myPicture.getIconHeight());
        panels.procImgPanel.image.setIcon(copyOfPicture);
        panels.procImgPanel.image.setBounds(panels.procImgPanel.image.getX(), panels.procImgPanel.image.getY(), copyOfPicture.getIconWidth(), copyOfPicture.getIconHeight());
        repaint();

        FilterButton button1 = new FilterButton("Grayscale", 1, this);
        FilterButton button2 = new FilterButton("Color shift right", 2, this);
        FilterButton button3 = new FilterButton("Color shift left", 3, this);
        FilterButton button4 = new FilterButton("Mirror", 4, this);
        FilterButton button5 = new FilterButton("EliminateRed", 5, this);
        FilterButton button6 = new FilterButton("negative", 6, this);
        FilterButton button7 = new FilterButton("contract", 7, this);
        FilterButton button8 = new FilterButton("sepia", 8, this);
        FilterButton button9 = new FilterButton("lighter", 9, this);
        FilterButton button10 = new FilterButton("darker", 10, this);

        this.add(button1).setBounds(this.searchButton.getX(), this.searchButton.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button2).setBounds(button1.getX(), button1.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button3).setBounds(button2.getX(), button2.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button4).setBounds(button3.getX(), button3.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button5).setBounds(button4.getX(), button4.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button6).setBounds(button4.getX(), button4.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button7).setBounds(button6.getX(), button6.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button8).setBounds(button7.getX(), button7.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button9).setBounds(button8.getX(), button8.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);
        this.add(button10).setBounds(button9.getX(), button9.getY() + panels.ELEMENT_HEIGHT, panels.ELEMENT_WIDTH, panels.ELEMENT_HEIGHT);

    }


    public static URL getImageUrl() {
        return imageUrl;
    }

    public static void setScanImage2(URL imageUrl) {
        try {
            scanImage2= ImageIO.read(ButtonsPanel.getImageUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}





