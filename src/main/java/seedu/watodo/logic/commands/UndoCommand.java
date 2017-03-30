package seedu.watodo.logic.commands;

import seedu.watodo.model.TaskManager;
import seedu.watodo.model.task.UniqueTaskList.TaskNotFoundException;

/**
 * Clears the task manager.
 */
//@@author A0139845R
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_SUCCESS = " reverted.";
    public static final String MESSAGE_EMPTY = "No command left to undo.";
    public static final String MESSAGE_FAILURE = "Failed to undo";



    @Override
    public CommandResult execute() {
        assert model != null;
        Command previousCommand = model.getPreviousCommand();
        if (previousCommand != null) {
            previousCommand.unexecute();
            
            return new CommandResult(previousCommand + " " + MESSAGE_SUCCESS);
        }
        
        return new CommandResult(MESSAGE_EMPTY);
    }
}
