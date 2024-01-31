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
        setTitle("Calendario con Recordatorios");
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

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBackground(new Color(200, 200, 200));  // Fondo del panel de control

        JButton prevButton = new JButton("<< ANTERIOR");
        JButton nextButton = new JButton("SIGUIENTE >>");

        prevButton.setBackground(new Color(150, 150, 150));
        prevButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(150, 150, 150));
        nextButton.setForeground(Color.WHITE);

        monthLabel = new JLabel();
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monthLabel.setBackground(new Color(100, 100, 100));
        monthLabel.setForeground(Color.WHITE);

        prevButton.addActionListener(e -> {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear--;
            } else {
                currentMonth--;
            }
            updateCalendar();
        });

        nextButton.addActionListener(e -> {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear++;
            } else {
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

        controlPanel.add(new JLabel("           Año:                            "));
        controlPanel.add(yearComboBox);

        container.add(controlPanel, BorderLayout.NORTH);

        calendarPanel = new JPanel(new GridLayout(6, 7));
        container.add(calendarPanel, BorderLayout.CENTER);
    }

    private void updateCalendar() {
        monthLabel.setText(new SimpleDateFormat("                                                        MMMM                                                        ").format(new GregorianCalendar(currentYear, currentMonth, 1).getTime()));

        calendarPanel.removeAll();

        String[] dayNames = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sababado"};
        for (String day : dayNames) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            dayLabel.setBackground(new Color(61, 90, 134));
            dayLabel.setForeground(Color.BLACK);  // Color del texto
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

            // Ajusta el tamaño del botón y el estilo para que el número del día sea más grande
            dayButton.setPreferredSize(new Dimension(50, 50));
            dayButton.setFont(new Font("Arial", Font.PLAIN, 20));
            dayButton.setBackground(new Color(200, 200, 200));  // Fondo del botón
            dayButton.setForeground(Color.BLACK);  // Color del texto

            String key = currentYear + "-" + currentMonth + "-" + i; // Clave compuesta: año-mes-día
            ArrayList<String> reminders = remindersMap.getOrDefault(key, new ArrayList<>());

            if (!reminders.isEmpty()) {
                StringBuilder buttonText = new StringBuilder("<html><center><font color='red'>" + i + "<br>");  // Cambia 'red' al color que prefieras
                for (String reminder : reminders) {
                    buttonText.append(reminder).append("<br>");
                }
                buttonText.append("</font></center></html>");
                dayButton.setText(buttonText.toString());
            }

            dayButton.addActionListener(e -> {
                String reminder = JOptionPane.showInputDialog("Agregar recordatorio para el día " + finalI + " de " +
                        new SimpleDateFormat("MMMM yyyy").format(new GregorianCalendar(currentYear, currentMonth, finalI).getTime()));

                if (reminder != null && !reminder.isEmpty()) {
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
