package com.jd.bluedragon.commons.biz.chain.base;


import com.jd.bluedragon.commons.biz.chain.base.basic.wrapper.CommandWrapper;

import java.util.Iterator;
import java.util.List;


public class ChainBase<T extends KeyedContext> implements Chain<T> {

    public ChainBase(List<CommandWrapper<T>> commands) {

        if (commands == null) {
            throw new IllegalArgumentException();
        }
        Iterator<CommandWrapper<T>> elements = commands.iterator();
        while (elements.hasNext()) {
            addCommand(elements.next());
        }
    }

    protected Command[] commands = new Command[0];

    // ---------------------------------------------------------- Chain Methods

    /**
     * See the {@link Chain} JavaDoc.
     *
     * @param command The {@link Command} to be added
     * @throws IllegalArgumentException if <code>command</code>
     *                                  is <code>null</code>
     * @throws IllegalStateException    if no further configuration is allowed
     */
    @Override
    public void addCommand(Command command) {

        if (command == null) {
            throw new IllegalArgumentException();
        }

        Command[] results = new Command[commands.length + 1];
        System.arraycopy(commands, 0, results, 0, commands.length);
        results[commands.length] = command;
        commands = results;

    }

    public boolean execute(T context) throws Exception {

        // Verify our parameters
        if (context == null) {
            throw new IllegalArgumentException();
        }

        // Execute the commands in this list until one returns true
        // or throws an exception
        boolean saveResult = false;
        Exception saveException = null;
        int i = 0;
        int n = commands.length;
        for (i = 0; i < n; i++) {
            try {
                saveResult = commands[i].execute(context);
                if (!saveResult) {
                    break;
                }
            } catch (Exception e) {
                saveException = e;
                break;
            }
        }

        // Call postprocess methods on Filters in reverse order
        if (i >= n) { // Fell off the end of the chain
            i--;
        }
        boolean handled = false;
        boolean result = false;
        for (int j = i; j >= 0; j--) {

                try {
                    result =
                            commands[j].postprocess(context,
                                    saveException);
                    if (!result) {
                        handled = true;
                    }
                } catch (Exception e) {
                    // Silently ignore
                }
        }

        // Return the exception or result state from the last execute()
        if ((saveException != null) && !handled) {
            throw saveException;
        } else {
            return (saveResult);
        }

    }


}

