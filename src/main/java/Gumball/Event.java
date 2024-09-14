package Gumball;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate eventStart;
    private LocalDate eventEnd;

    /**
     *
     * @param desc The description of the Event to be added including name the start and end times.
     * @throws TaskException
     */
    public Event(String desc) throws TaskException {
        super("", desc);
        try {
            super.description = eventInputFormatter(desc);
            taskType = "[E]";
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TaskException("Sorry, the description you " +
                    "gave does not follow the format for Events.\n" +
                    "\nIt should be ('description' /from time /to time)");
        }
    }

    private String eventInputFormatter(String desc) {
        String[] section = desc.substring(6).split("/from | /to ");
        String output = section[0] + "(from: " + section[1] + " to: " + section[2] + ")";
        return output;
    }
}
