package Test.java;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class GeradorDeFigurinhas {

    public void cria(InputStream entrada, String nomeArquivoSaida, String frase) throws IOException {


        BufferedImage imagemOriginal = ImageIO.read(entrada);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));

        graphics.drawString(frase, 10, altura + 100);

        ImageIO.write(novaImagem, "png", new File("resources/saida/" + nomeArquivoSaida));
    }


}
