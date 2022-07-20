package Test.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestGraphics {

    public static void main(String[] args) throws IOException {

        BufferedImage imagemOriginal = ImageIO.read(new File("img.png"));
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);



        int tamanhoString = graphics.getFontMetrics().stringWidth("frase");
        int centralizado = (largura - tamanhoString) / 2;

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
        graphics.drawString("frase", centralizado, altura + 100);


        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        graphics.drawString("frase", centralizado+1, altura + 100);

        ImageIO.write(novaImagem, "png", new File("" + "figurinha teste.png"));
    }
}
