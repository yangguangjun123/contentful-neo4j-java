package myproject.meetup.contentful.productcatalog.api;

import myproject.meetup.contentful.productcatalog.service.Neo4jContentfulService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contentful")
public class ContentfulAnalyticsController {

    private Neo4jContentfulService neo4jContentfulService;

    @Autowired
    public ContentfulAnalyticsController(Neo4jContentfulService neo4jContentfulService) {
        this.neo4jContentfulService = neo4jContentfulService;
    }

    @RequestMapping(path = "/analytics/orphan", method= RequestMethod.GET)
    public String getContenfulOrphans() {
        JSONArray orphans = neo4jContentfulService.getOrphanNodes();
        JSONObject response = new JSONObject();
        response.put("orphans", orphans);
        return response.toString();
    }

}