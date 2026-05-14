package models;

public class PostRequest {

    private String title;
    private String body;
    private int userId;

    public PostRequest() {
    }

    public PostRequest(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
    //İçerisinde title, body ve userId değişkenlerini barındırır.
    //Rest Assured bu sınıfı kullanarak Java nesnesini otomatik olarak JSON formatına dönüştürür.
    //Bu yöntem, manuel olarak string yazmaktan çok daha güvenli ve profesyoneldir.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
