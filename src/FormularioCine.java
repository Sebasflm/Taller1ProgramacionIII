import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        Cine cine=new Cine();
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (cine.numeroEntradasDisponibles(cboPelicula.getSelectedItem().toString()) >= Integer.parseInt(cboCantidad.getSelectedItem().toString())) {

                        cine.encolar(new Asistente(cboPelicula.getSelectedItem().toString(),
                                        Integer.parseInt(cboCantidad.getSelectedItem().toString())),
                                cboPelicula.getSelectedIndex());

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No hay suficientes entradas");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                txtEntradas.setText(cine.toString());
            }
        });
        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"La cantidad de entradas disponibles para XMEN es: "+cine.numeroEntradasDisponibles("XMEN"));
            }
        });

        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"La cantidad de entradas disponibles para Mario es: "+cine.numeroEntradasDisponibles("MARIO"));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
