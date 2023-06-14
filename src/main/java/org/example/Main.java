package org.example;
import com.eclipsesource.json.JsonObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        post("/rover", (req, res) -> createRoverHandler(req, res));
    }

    private static String createRoverHandler(Request req, Response res) {
        res.status(200);
        res.header("Content-Type", "application/json");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("yo mamma", "fat");
        return jsonObject.toString();
    }
}