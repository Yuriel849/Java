

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

/**
 * Write a description of class RobotServer here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
