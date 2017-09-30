package descricaolatitude;

import java.text.ParseException;
import javax.swing.JFrame;


public class DescricaoLatitude {

    public static void main(String[] args) throws ParseException {
        JanelaLatitude janela = new JanelaLatitude();
        janela.setSize(750, 800);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

    }

    
}
