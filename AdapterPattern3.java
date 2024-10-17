//Handling data from different sources that return data in various formats.

// Interface for our application to fetch data
interface DataFetcher {
    String fetchData();
}

// JSON data source
class JsonDataSource {
    public String getJsonData() {
        return "{\"name\": \"John\", \"age\": 30}";
    }
}

// Adapter to convert JSON data to the application format
class JsonAdapter implements DataFetcher {
    private JsonDataSource jsonDataSource;

    public JsonAdapter(JsonDataSource jsonDataSource) {
        this.jsonDataSource = jsonDataSource;
    }

    @Override
    public String fetchData() {
        return jsonDataSource.getJsonData(); // Adapting the call
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        JsonDataSource jsonSource = new JsonDataSource();
        DataFetcher fetcher = new JsonAdapter(jsonSource);
        String data = fetcher.fetchData();
        System.out.println("Fetched Data: " + data);
    }
}
