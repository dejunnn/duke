package duke.commands;

import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.tasks.ToDo;
import duke.ui.UI;

public class ToDoCommand extends Command {

    protected String description;

    public ToDoCommand(String command, String description) {
        super(command);
        this.description = description;
    }

    @Override
    public void execute(TaskList tasklist, UI ui, Storage storage) {
        ToDo todo = new ToDo(this.description);
        tasklist.addTask(todo);
        storage.writeFileLine(todo);
        ui.displayAddToDoMessage(todo, tasklist.getTaskList());
    }
}