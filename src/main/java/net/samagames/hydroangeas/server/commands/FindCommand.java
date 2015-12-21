package net.samagames.hydroangeas.server.commands;

import net.samagames.hydroangeas.common.commands.AbstractCommand;
import net.samagames.hydroangeas.server.HydroangeasServer;
import net.samagames.hydroangeas.server.client.MinecraftServerS;

import java.util.List;

/**
 * Created by Silva on 06/12/2015.
 */
public class FindCommand extends AbstractCommand {

    public HydroangeasServer instance;

    public FindCommand(HydroangeasServer hydroangeasServer)
    {
        super("find");
        this.instance = hydroangeasServer;
    }

    @Override
    public boolean execute(String[] args)
    {
        if(args.length > 0)
        {
            String name = args[0];

            List<MinecraftServerS> servers = instance.getClientManager().getServersStartingBy(name);

            if(servers.size() == 0)
            {
                instance.getLogger().info("No server with this name.");
            }else if(servers.size() > 1)
            {
                instance.getLogger().info("Possibles servers: ");
                for(MinecraftServerS server : servers)
                {
                    instance.getLogger().info("- " + server.getServerName());
                }
            }else
            {
                MinecraftServerS server = servers.get(0);
                InfosCommand.showHydroClient(server.getClient(), null);
                InfosCommand.showServer(server, null);
            }
        }

        return true;
    }

    @Override
    public String getHelp() {
        return "- find <servername/prefix>\n" +
                "Display the minecraft server location and specific infos.";
    }


}
