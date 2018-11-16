package pl.put.poznan.analyzer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.analyzer.commons.Data;
import pl.put.poznan.analyzer.commons.Network;
import pl.put.poznan.analyzer.commons.Node;
import pl.put.poznan.analyzer.commons.Result;
import pl.put.poznan.analyzer.converter.NodeListConverter;
import pl.put.poznan.analyzer.repositories.NetworkJsonRepository;

import java.util.List;
import java.util.Map;

/**
 * This class is a service for REST and is responsible for calling functions
 */
@Service
public class NetworkAnalyzer {
    private static final Logger logger = LoggerFactory.getLogger(NetworkAnalyzer.class);
    /**
     * Instance of BFS class, which is used to find the best path in network using BFS algorithm
     */
    private final BFS bfs;
    /**
     * Instance of DFS class, which is used to find the best path in network using DFS algorithm
     */
    private final DFS dfs;

    private final NetworkJsonRepository networkJsonRepository;

    private final NodeListConverter nodeListConverter;

    /**
     * Class constructor for spring
     *
     * @param bfs instance of BFS to be used in program
     * @param dfs instance of DFS to be used in program
     */
    @Autowired
    public NetworkAnalyzer(BFS bfs, DFS dfs, NetworkJsonRepository networkJsonRepository, NodeListConverter nodeListConverter) {
        this.bfs = bfs;
        this.dfs = dfs;
        this.networkJsonRepository = networkJsonRepository;
        this.nodeListConverter = nodeListConverter;
    }

    /**
     * Find the most profitable path in the network
     *
     * @param nodeList network (list of nodes) in which you want to find the best path
     * @param mode     name of algorithm you want to use for searching for the best path
     * @return the best path as Result (list of nodes and path's value)
     * <br> or NULL if path can't be found
     */
    public Result findTheBestPath(List<Node> nodeList, String mode) {
        if (!Data.checkNetwork(nodeList)) {
            logger.error("Incorrect network");
            throw new IllegalArgumentException("Incorrect network");
        }
        Map<Integer, Node> nodesMap = Data.getNodesMap(nodeList);
        logger.debug("Prepared to run the algorithm");
        return mode.equals("BFS") ? bfs.run(nodeList) : dfs.run(nodesMap).getResult();
    }

    public Network addNetwork(String nodes) {
        Network network = new Network(nodes);
        networkJsonRepository.save(network);
        return network;
    }

    public List<Node> getNetwork(int id) {
        Network network = networkJsonRepository.findOne(id);
        if (network == null) {
            throw new IllegalArgumentException("Incorrect id");
        }
        return nodeListConverter.convert(network.getNetworkJson());
    }
}
