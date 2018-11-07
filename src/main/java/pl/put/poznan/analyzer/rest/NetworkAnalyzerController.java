package pl.put.poznan.analyzer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.analyzer.commons.Connection;
import pl.put.poznan.analyzer.commons.Data;
import pl.put.poznan.analyzer.commons.Node;
import pl.put.poznan.analyzer.logic.BFS;

import java.util.List;


@RestController
@RequestMapping("")
public class NetworkAnalyzerController {

    private static final Logger logger = LoggerFactory.getLogger(NetworkAnalyzerController.class);

    @RequestMapping(path = "/test/nodes/{nodes}", method = RequestMethod.GET, produces = "application/json")
    public List<Node> get(@PathVariable List<Node> nodes) {
        // log the parameters
        logger.debug(String.valueOf(nodes));
        return nodes;
    }

    @RequestMapping(path = "/bfs/nodes/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Connection> postCon(@RequestBody List<Node> nodes) {
        logger.debug(String.valueOf(nodes));
        if (!Data.checkNetwork(nodes)) {
            logger.error("Niepoprawna siec");
            throw (new InternalError());
        }
        return BFS.run(nodes);
    }

}


