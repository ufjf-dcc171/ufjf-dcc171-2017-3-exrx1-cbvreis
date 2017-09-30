package descricaolatitude;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaLatitude extends JFrame {

    private final List<Eventos> eventos;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    private final JList<Eventos> lstEventos = new JList<>(new DefaultListModel<>());
    private final JLabel lblLatitude = new JLabel("Latitude");
    private final JLabel lblLongitude = new JLabel("Longitude");
    private final JLabel lblData = new JLabel("Data");
    private final JLabel lblDescricao = new JLabel("Descrição");

    private final JTextField txtLatitude = new JTextField(4);
    private final JTextField txtLongitude = new JTextField(4);
    private final JTextField txtData = new JTextField(12);
    private final JTextField txtDescricao = new JTextField(20);

    private final JButton btnAdicionar = new JButton("Adicionar");
    private final JButton btnRemover = new JButton("Remover");

    public JanelaLatitude() throws ParseException {
        Eventos eventoa = new Eventos("1595", "0000", formato.parse("05/06/2017"), "Abalo México");
        ArrayList<Eventos> listaDeTeste = new ArrayList<>();
        listaDeTeste.add(eventoa);
        this.eventos = listaDeTeste;
        lstEventos.setModel(new EventosListModel(listaDeTeste));
        add(new JScrollPane(lstEventos), BorderLayout.BEFORE_FIRST_LINE);

        JPanel telaEventos = new JPanel(new GridLayout(5, 3));
        telaEventos.add(lblLatitude);
        telaEventos.add(txtLatitude);
        telaEventos.add(lblLongitude);
        telaEventos.add(txtLongitude);
        telaEventos.add(lblData);
        telaEventos.add(txtData);
        telaEventos.add(lblDescricao);
        telaEventos.add(txtDescricao);
        add(telaEventos, BorderLayout.CENTER);

        JPanel pnObjetos = new JPanel(new FlowLayout());
        pnObjetos.add(btnAdicionar);
        pnObjetos.add(btnRemover);
        add(pnObjetos, BorderLayout.SOUTH);

        lstEventos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Eventos evento = lstEventos.getSelectedValue();
                if (evento != null) {
                    txtLatitude.setText(evento.getLatitude());
                    txtLongitude.setText(evento.getLongitude());
                    txtDescricao.setText(evento.getDescricao());
                }
            }
        });
        
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lstEventos.isSelectionEmpty()) {
                    eventos.remove(lstEventos.getSelectedValue());
                    lstEventos.clearSelection();
                    lstEventos.updateUI();
                }
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtLongitude.getText().isEmpty()&&!txtData.getText().isEmpty() &&!txtLatitude.getText().isEmpty() &&  !txtDescricao.getText().isEmpty()) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    try {
                        Date date = sdf.parse(txtData.getText());
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Data no formado invalido", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                    Eventos evento = new Eventos();
                    evento.setLatitude(txtLatitude.getText());
                    evento.setLongitude(txtLongitude.getText());
                    try {
                        evento.setData(formato.parse(txtData.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaLatitude.class.getName()).log(Level.SEVERE, null, ex);

                    }
                    evento.setDescricao(txtDescricao.getText());
                    eventos.add(evento);
                    lstEventos.clearSelection();
                    lstEventos.updateUI();

                }
            }
        });


    }
}
