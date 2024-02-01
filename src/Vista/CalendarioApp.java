
package Vista;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarioApp extends JFrame {

    private JLabel monthLabel;
    private JPanel calendarPanel;
    private JComboBox<Integer> yearComboBox;
    private int currentMonth, currentYear;
    private Map<String, ArrayList<String>> remindersMap; // Mapa para almacenar recordatorios por día, mes y año

    public CalendarioApp() {
        setTitle("CALENDARIO DOCENTE");
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        currentYear = Calendar.getInstance().get(Calendar.YEAR);

        remindersMap = new HashMap<>();

        createGUI();
        updateCalendar();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createGUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBackground(new Color(61, 90, 134));  // Fondo del panel de control

        JButton prevButton = new JButton("<< ANTERIOR");
        JButton nextButton = new JButton("SIGUIENTE >>");

        prevButton.setBackground(new Color(83, 109, 136));
        prevButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        prevButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(83, 109, 136));
        nextButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        nextButton.setForeground(Color.WHITE);

        monthLabel = new JLabel();
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monthLabel.setBackground(new Color(100, 100, 100));
        monthLabel.setForeground(Color.WHITE);
        monthLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

        controlPanel.setBackground(new Color(61, 90, 134));  // Fondo del panel de control

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            VistaDocenteCalendario otraInterfaz = new VistaDocenteCalendario();
            otraInterfaz.setLocationRelativeTo(this);
            otraInterfaz.setVisible(true);
            dispose();
        });

        controlPanel.add(botonRegresar, BorderLayout.WEST);

        prevButton.addActionListener(e -> {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear--;
            } 
            else {
                currentMonth--;
            }
            updateCalendar();
        });

        nextButton.addActionListener(e -> {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear++;
            } 
            else {
                currentMonth++;
            }
            updateCalendar();
        });

        controlPanel.add(prevButton);
        controlPanel.add(monthLabel);
        controlPanel.add(nextButton);

        yearComboBox = new JComboBox<>(generateYearRange());
        yearComboBox.setSelectedItem(currentYear);

        yearComboBox.addActionListener(e -> {
            currentYear = (int) yearComboBox.getSelectedItem();
            updateCalendar();
        });

        JPanel centralPanel = new JPanel(new FlowLayout()); // Panel para el resto de los componentes centrados
        centralPanel.add(prevButton);
        centralPanel.add(monthLabel);
        centralPanel.add(nextButton);
        centralPanel.add(new JLabel("     Año:      "));
        centralPanel.add(yearComboBox);

        centralPanel.setBackground(new Color(61, 90, 134));

        controlPanel.add(centralPanel, BorderLayout.CENTER);

        container.add(controlPanel, BorderLayout.NORTH);

        calendarPanel = new JPanel(new GridLayout(6, 7));
        container.add(calendarPanel, BorderLayout.CENTER);
    }

    private void updateCalendar() {
        monthLabel.setText(new SimpleDateFormat("          MMMM          ").format(new GregorianCalendar(currentYear, currentMonth, 1).getTime()));

        calendarPanel.removeAll();

        String[] dayNames = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        for (String day : dayNames) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            dayLabel.setPreferredSize(new Dimension(0, 50));
            dayLabel.setForeground(Color.BLACK);  // Color del texto
            dayLabel.setBackground(new Color(150, 150, 150));
            dayLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
            dayLabel.setOpaque(true);

            calendarPanel.add(dayLabel);
        }

        Calendar calendar = new GregorianCalendar(currentYear, currentMonth, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int i = 1; i <= daysInMonth; i++) {
            JButton dayButton = new JButton(String.valueOf(i));
            int finalI = i;
            dayButton.setPreferredSize(new Dimension(50, 50));
            dayButton.setFont(new Font("Arial", Font.PLAIN, 20));
            dayButton.setBackground(new Color(200, 200, 200));  // Fondo del botón
            dayButton.setForeground(Color.BLACK);  // Color inicial del texto del día (negro)

            String key = currentYear + "-" + currentMonth + "-" + i; // Clave compuesta: año-mes-día
            ArrayList<String> reminders = remindersMap.getOrDefault(key, new ArrayList<>());

            if (!reminders.isEmpty()) {
                dayButton.setForeground(Color.RED);
                StringBuilder buttonText = new StringBuilder("<html><center><font color='red'>" + i + "<br>");  // Número del día en rojo
                for (String reminder : reminders) {
                    buttonText.append("<font size='-1' color='black'>").append(reminder).append("<br></font>");  // Tamaño más pequeño para el evento
                }
                buttonText.append("</font></center></html>");
                dayButton.setText(buttonText.toString());
            }

            dayButton.addActionListener(e -> {
                String reminder = JOptionPane.showInputDialog(null, "AGREGAR HORARIO EN " + finalI + " DE " + new SimpleDateFormat("MMMM yyyy").format(new GregorianCalendar(currentYear, currentMonth, finalI).getTime()), "INGRESAR EVENTO", JOptionPane.PLAIN_MESSAGE);

                if (reminder != null && !reminder.isEmpty()) {
                    dayButton.setForeground(Color.RED);
                    reminders.add(reminder);
                    remindersMap.put(key, reminders);
                    updateCalendar();
                }
            });

            calendarPanel.add(dayButton);
        }

        revalidate();
        repaint();
    }

    private Integer[] generateYearRange() {
        int startYear = 1950;
        int endYear = 2100;

        Integer[] years = new Integer[endYear - startYear + 1];
        for (int i = 0; i < years.length; i++) {
            years[i] = startYear + i;
        }
        return years;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalendarioApp());
    }
}
