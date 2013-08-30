package client;


public class WebserviceImpl {
    public WebserviceImpl() {
        super();
    }

    @Webservice(webId = 1, serviceName = "insert")
    public String getInsertServiceName() {
        return "insert";
    }

    @Webservice(webId = 2, serviceName = "upsert")
    public String getUpsertServiceName() {
        return "upsert";
    }

    @Webservice(webId = 3, serviceName = "update")
    public String getUpdateServiceName() {
        return "update";
    }

    @Webservice(webId = 4, serviceName = "delete")
    public String getDeleteServiceName() {
        return "delete";
    }
}
