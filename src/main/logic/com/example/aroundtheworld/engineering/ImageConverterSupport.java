package com.example.aroundtheworld.engineering;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverterSupport {

        private ImageConverterSupport() {
            //Costruttore privato perché ho tutti i metodi statici
        }
        public static Image fromFileToImage(File file) throws IOException {
            BufferedImage bfImage;
            bfImage = ImageIO.read(file);

            WritableImage writableImage = null;
            if (bfImage != null) {
                writableImage = new WritableImage(bfImage.getWidth(), bfImage.getHeight());
                PixelWriter pw = writableImage.getPixelWriter();
                for (int x = 0; x < bfImage.getWidth(); x++) {
                    for (int y = 0; y < bfImage.getHeight(); y++) {
                        pw.setArgb(x, y, bfImage.getRGB(x, y));
                    }
                }
            }
            return new ImageView(writableImage).getImage();
        }



}
