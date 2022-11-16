package com.airblock.commons.biz.chain.base.basic;


import com.airblock.commons.biz.chain.base.Chain;
import com.airblock.commons.biz.chain.base.Command;
import com.airblock.commons.biz.chain.base.Context;

import java.util.Iterator;
import java.util.List;


public class ChainBase<T extends Context, C extends Command<T>> implements Chain<T> {

    public ChainBase(List<C> commands) {

        if (commands == null) {
            throw new IllegalArgumentException();
        }
        Iterator<C> elements = commands.iterator();
        while (elements.hasNext()) {
            addCommand(elements.next());
        }
    }

    protected Command[] commands = new Command[0];

    // ---------------------------------------------------------- Chain Methods

    /**
     * See the {@link Chain} JavaDoc.
     *
     * @param command The {@link CacheableCommand} to be added
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
        if (context == null) {
            throw new IllegalArgumentException();
        }
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
        if (i >= n) {
            i--;
        }
        boolean handled = false;
        boolean result = false;
        for (int j = i; j >= 0; j--) {
            try {
                result = commands[j].postprocess(context, saveException);
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