package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victor
 */
public class Calendario extends JFrame {

    private JLabel labelMesAnio;
    private JPanel panelMes; // Nuevo panel para el nombre del mes y los botones
    private JPanel panelDias;

    private int mesActual;
    private int anioActual;

    private Map<String, StringBuilder> eventos = new HashMap<>();

    public Calendario() {
        super("Calendario");

        getContentPane().setBackground(new Color(0x3D, 0x5A, 0x86));

        Calendar calendario = Calendar.getInstance();
        calendario.setFirstDayOfWeek(Calendar.MONDAY); // Establecer el primer día de la semana como Lunes
        mesActual = calendario.get(Calendar.MONTH);
        anioActual = calendario.get(Calendar.YEAR);

        setLayout(new BorderLayout());

        panelMes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        configurarPanelMes();

        panelDias = new JPanel(new GridLayout(0, 7));
        configurarPanelDias();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarPanelMes() {
        JButton btnAnterior = new JButton("<<");
        btnAnterior.addActionListener(e -> cambiarMes(-1));

        JButton btnSiguiente = new JButton(">>");
        btnSiguiente.addActionListener(e -> cambiarMes(1));

        panelMes.add(btnAnterior);

        labelMesAnio = new JLabel(getNombreMes(mesActual) + " " + anioActual, JLabel.CENTER);
        labelMesAnio.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        labelMesAnio.setForeground(Color.WHITE);

        panelMes.add(labelMesAnio);
        panelMes.add(btnSiguiente);

        add(panelMes, BorderLayout.NORTH);
    }

    private void configurarPanelDias() {
    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    for (String dia : diasSemana) {
        JLabel labelNombreDia = new JLabel(dia, JLabel.CENTER);
        labelNombreDia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        labelNombreDia.setBackground(new Color(61, 90, 134)); // Cambiar el color de fondo
        labelNombreDia.setForeground(Color.WHITE);
        labelNombreDia.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Agregar un borde a cada label
        labelNombreDia.setOpaque(true); // Asegurar que el fondo sea visible
        panelDias.add(labelNombreDia);
    }

    add(panelDias, BorderLayout.CENTER);
    actualizarCalendario();
}

    private void actualizarCalendario() {
    panelDias.removeAll();

    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    for (String dia : diasSemana) {
        JLabel labelDia = new JLabel(dia, JLabel.CENTER);
        labelDia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        labelDia.setBackground(new Color(0, 0, 134));
        labelDia.setForeground(Color.WHITE);
        labelDia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelDia.setOpaque(true);
        panelDias.add(labelDia);
    }

        Calendar calendario = new GregorianCalendar(anioActual, mesActual, 1);
        int primerDiaMes = calendario.get(Calendar.DAY_OF_WEEK);

        int ajuste = (primerDiaMes - Calendar.MONDAY + 7) % 7;
        for (int i = 0; i < ajuste; i++) {
            panelDias.add(new JLabel(""));
        }

        int totalDiasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= totalDiasMes; i++) {
            final int diaSeleccionado = i;
            DiaConEventos btnDia = new DiaConEventos(Integer.toString(i));

            btnDia.setBackground(new Color(61, 90, 134));
            btnDia.setForeground(Color.WHITE);
            btnDia.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            String fechaKey = anioActual + "-" + (mesActual + 1) + "-" + diaSeleccionado;
            if (eventos.containsKey(fechaKey)) {
                btnDia.setEventos(eventos.get(fechaKey).toString());
            }

            btnDia.addActionListener(e -> {
                int mesSeleccionado = mesActual + 1;
                int anioSeleccionado = anioActual;

                String evento = JOptionPane.showInputDialog(
                        "Agregar evento para " + diaSeleccionado + "/" + mesSeleccionado + "/" + anioSeleccionado);

                if (evento != null && !evento.isEmpty()) {
                    String fechaKeyNuevo = anioSeleccionado + "-" + mesSeleccionado + "-" + diaSeleccionado;
                    if (eventos.containsKey(fechaKeyNuevo)) {
                        eventos.get(fechaKeyNuevo).append("\n").append(evento);
                    } 
                    else {
                        eventos.put(fechaKeyNuevo, new StringBuilder(evento));
                    }
                    btnDia.setEventos(eventos.get(fechaKeyNuevo).toString());
                }
            });

            panelDias.add(btnDia);
        }

        labelMesAnio.setText(getNombreMes(mesActual) + " " + anioActual);
        labelMesAnio.setForeground(Color.BLACK);

        panelDias.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Agregar un borde alrededor de los días

        panelDias.revalidate();
        panelDias.repaint();
    }

    private String getNombreMes(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes];
    }

    private void cambiarMes(int incremento) {
        mesActual += incremento;
        if (mesActual < 0) {
            mesActual = 11;
            anioActual--;
        } else if (mesActual > 11) {
            mesActual = 0;
            anioActual++;
        }
        actualizarCalendario();
    }

    private class DiaConEventos extends JButton {
        private StringBuilder eventos;

        public DiaConEventos(String text) {
            super(text);
            setHorizontalAlignment(CENTER);
            setBackground(new Color(0, 255, 0)); // Establecer un fondo verde para cada botón
            setOpaque(true);
            setBorderPainted(false);
            setForeground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Agregar un borde a cada botón
        }

        public void setEventos(String eventos) {
            this.eventos = new StringBuilder(eventos);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (eventos != null && eventos.length() > 0) {
                g.setColor(Color.WHITE);
                FontMetrics fm = g.getFontMetrics();
                String[] lines = eventos.toString().split("\n");
                int y = getHeight() / 3 - (lines.length * fm.getHeight()) / 2;
                for (String line : lines) {
                    g.drawString(line, 5, y);
                    y += fm.getHeight();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calendario::new);
    }
}