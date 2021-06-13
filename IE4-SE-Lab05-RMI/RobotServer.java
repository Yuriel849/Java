

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

/**
 * RobotServer class to the start the server side of the RMI implementation.
 *
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class RobotServer
{
    private static void startRegistry() throws Exception
    {
        try {
            LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
        } catch (java.rmi.server.ExportException ee) {
            LocateRegistry.getRegistry( Registry.REGISTRY_PORT );
        }
        RemoteServer.setLog( System.err );
    }

    public static void main(String [] args) throws Exception {
        startRegistry();
        IRobotController server = new RobotController();
        Naming.rebind("server", server);
    }
}
