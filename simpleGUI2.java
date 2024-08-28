import javax.swing.*;
import java.awt.*;
public class simpleGUI2 {

    public static void main(String[] args) {

        Funcoes2 funcoes = new Funcoes2();
        // Cria o frame principal
        JFrame frame = new JFrame("Atividade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Define o layout do frame
        frame.setLayout(new BorderLayout());

        // Cria a área de texto à esquerda
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Cria o painel à direita para os botões
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adiciona os botões ao painel
        String[] buttonLabels = {"A-Z", "Z-A", "Inverter", "Remover duplicados", "Remover Vazios", 
                                 "Aplicar Trim()", "Converter MAIUSCULO", "Converter minusculo", "Converter Capitalizar"};
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e ->{
                switch (label) {
                    case "A-Z": textArea.setText(funcoes.A_Z(textArea.getText())); break;
                    case "Z-A" : textArea.setText(funcoes.organizaZ_A(textArea.getText())); break;
                    case "Inverter": textArea.setText(funcoes.Inverter(textArea.getText())); break;
                    case "Remover duplicados": textArea.setText(funcoes.removerDuplicados(textArea.getText())); break;
                    case "Remover Vazios": textArea.setText(funcoes.removerVazios(textArea.getText())); break;
                    case "Aplicar Trim()": textArea.setText(funcoes.aplicaTrim(textArea.getText())); break;
                    case "Converter MAIUSCULO": textArea.setText(funcoes.maiusculo(textArea.getText())); break;
                    case "Converter minusculo": textArea.setText(funcoes.minusculo(textArea.getText())); break;
                    case "Converter Capitalizar": textArea.setText(funcoes.capitalizar(textArea.getText())); break;
        }});
            button.setBackground(Color.WHITE);           // Fundo branco
            button.setForeground(Color.BLACK);           // Texto preto
            button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),  // Borda preta
                BorderFactory.createEmptyBorder(5, 30, 5, 30) // Padding interno: top, left, bottom, right
            ));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            panel.add(button);
            panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento de 10 pixels
        }

        frame.add(panel, BorderLayout.EAST);

        // Torna o frame visível
        frame.setVisible(true);
    }
}



