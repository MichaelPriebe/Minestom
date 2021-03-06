package net.minestom.server.command.builder;

import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.condition.CommandCondition;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a syntax in {@link Command}
 * which is initialized with {@link Command#addSyntax(CommandExecutor, Argument[])}.
 */
public class CommandSyntax {

    private CommandCondition commandCondition;
    private CommandExecutor executor;
    private final Argument<?>[] args;

    protected CommandSyntax(@Nullable CommandCondition commandCondition,
                            @NotNull CommandExecutor commandExecutor,
                            @NotNull Argument<?>... args) {
        this.commandCondition = commandCondition;
        this.executor = commandExecutor;
        this.args = args;
    }

    /**
     * Gets the condition to use this syntax.
     *
     * @return this command condition, null if none
     */
    @Nullable
    public CommandCondition getCommandCondition() {
        return commandCondition;
    }

    /**
     * Changes the command condition of this syntax.
     * <p>
     * Be aware that changing the command condition will not automatically update players auto-completion.
     * You can create a new packet containing the changes with
     * {@link net.minestom.server.command.CommandManager#createDeclareCommandsPacket(Player)}.
     *
     * @param commandCondition the new command condition, null to remove it
     */
    public void setCommandCondition(@Nullable CommandCondition commandCondition) {
        this.commandCondition = commandCondition;
    }

    /**
     * Gets the {@link CommandExecutor} of this syntax, executed once the syntax is properly written.
     *
     * @return the executor of this syntax
     */
    @NotNull
    public CommandExecutor getExecutor() {
        return executor;
    }

    /**
     * Changes the {@link CommandExecutor} of this syntax.
     *
     * @param executor the new executor
     */
    public void setExecutor(@NotNull CommandExecutor executor) {
        this.executor = executor;
    }

    /**
     * Gets all the required {@link Argument} for this syntax.
     *
     * @return the required arguments
     */
    @NotNull
    public Argument<?>[] getArguments() {
        return args;
    }

}
