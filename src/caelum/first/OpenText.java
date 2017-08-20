package caelum.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class OpenText extends JFrame {

    private JTextArea textArea;
    private File file;
    private FileInputStream fis;
    private String texto;

    public OpenText(String text) {
        super("Leitura de arquivos!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        setLocationRelativeTo(null);

        textArea = new JTextArea(text);
        textArea.setLineWrap(true); //quebra de linha automática
        /*textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getModifiers() & KeyEvent.CTRL_MASK) != 0 && e.getKeyCode() == KeyEvent.VK_S){
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        out.write(texto.getBytes());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });*/

        JScrollPane scroll = new JScrollPane(textArea);

        //add(textArea);
        getContentPane().add(scroll);
    }

    public void app(OpenText frame){
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Você selecionou " + file.getName());
            try {
                fis = new FileInputStream(file);
                int content;
                texto = "Arquivo: " + file.getName() + " \n\n";
                while ((content = fis.read()) != -1) {
                    texto += (char) content;
                }
                frame.setTextArea(texto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada!?");
        }
    }

    public void setTextArea(String text){
        textArea.setText(text);

        new Thread(() -> {
            try{
                Thread.sleep(2 * 1000);
                int type = JOptionPane.showConfirmDialog(null, "Deseja fechar essa janela e processar outro arquivo?");
                switch(type){
                    case 0:
                        this.app(this);
                        break;
                    case 1:
                        Thread.sleep(3 * 1000);
                        this.setTextArea(text);
                        break;
                    case 2:
                        System.out.println("Ola");
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();

    }

}
