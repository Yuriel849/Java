/**
 * ICommandFactory interface.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public interface ICommandFactory {
    /**
     * TO be implemented by all classes implementing this interface
     */
    void createICommand(Status status);
}
