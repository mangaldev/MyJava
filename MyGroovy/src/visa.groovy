/**
 * Created by mdev on 6/7/17.
 */
@Grab('com.mashape.unirest:unirest-java:1.4.9')
HttpResponse<String> response = Unirest.post("https://egov.uscis.gov/casestatus/mycasestatus.do")
        .header("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
        .header("cache-control", "no-cache")
        .header("postman-token", "c30ce039-22d7-4b7d-5fb7-72515f99992c")
        .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"appReceiptNum\"\r\n\r\nWAC1714153157\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
        .asString()
//while (true){
//    def count = new XmlSlurper().parseText(text).schedules.schedule.size()
//    println "${new Date()} : Count : ${count} Result : ${count == 1000}"
//    sleep(5000)
//}
println response