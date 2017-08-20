package caelum.first;


import com.sun.deploy.uitoolkit.ui.ConsoleWindow;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Minha mensagem!");

        OpenText frame = new OpenText("teste\n ola");
        frame.setVisible(true);
        frame.app(frame);

    }



}
