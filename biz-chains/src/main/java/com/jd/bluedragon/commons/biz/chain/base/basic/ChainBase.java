package com.jd.bluedragon.commons.biz.chain.base.basic;


import com.jd.bluedragon.commons.biz.chain.base.Chain;
import com.jd.bluedragon.commons.biz.chain.base.CacheableCommand;
import com.jd.bluedragon.commons.biz.chain.base.Context;

import java.util.Iterator;
import java.util.List;


public class ChainBase<T extends Context> implements Chain<T> {

    public ChainBase(List<CacheableCommand> commands) {

        if (commands == null) {
            throw new IllegalArgumentException();
        }
        Iterator<CacheableCommand> elements = commands.iterator();
        while (elements.hasNext()) {
            addCommand(elements.next());
        }
    }

    protected CacheableCommand[] commands = new CacheableCommand[0];

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
    public void addCommand(CacheableCommand command) {

        if (command == null) {
            throw new IllegalArgumentException();
        }

        CacheableCommand[] results = new CacheableCommand[commands.length + 1];
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

